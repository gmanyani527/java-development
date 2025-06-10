package pluralsight;
import java.util. *;
public class Main {
    public static void main(String[] args) {



        /* ---------- 1.  Update the home‑screen loop ---------- */
        boolean running;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1) Display all products");
            System.out.println("2) Display all customers");
            System.out.println("3) Display all categories");   // NEW OPTION
            System.out.println("0) Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> displayProducts();
                case "2" -> displayCustomers();
                case "3" -> displayCategories();               // NEW HANDLER
                case "0" -> running = false;
                default -> System.out.println("❌  Invalid option, try again.");
            }
        }

        /* ---------- 2.  List every category, then prompt for one ---------- */
        private static void displayCategories () {
            String sql = """
                    SELECT CategoryID, CategoryName
                    FROM   Categories
                    ORDER  BY CategoryID
                    """;

            try (Connection conn = openConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                System.out.printf("%-5s %-30s%n", "ID", "Category Name");
                System.out.println("=".repeat(38));

                while (rs.next()) {
                    System.out.printf("%-5d %-30s%n",
                            rs.getInt("CategoryID"),
                            rs.getString("CategoryName"));
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("⚠️  Error fetching categories: " + ex.getMessage());
                return;
            }

            /* --- Ask the user which category to drill into --- */
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter a category ID to view its products (or press Enter to cancel): ");
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                try {
                    int categoryId = Integer.parseInt(input);
                    displayProductsByCategory(categoryId);
                } catch (NumberFormatException nfe) {
                    System.out.println("❌  Invalid number.");
                }
            }
        }

        /* ---------- 3.  Show products for a specific category ---------- */
        private static void displayProductsByCategory ( int categoryId){
            String sql = """
                    SELECT ProductID,
                           ProductName,
                           UnitPrice,
                           UnitsInStock
                    FROM   Products
                    WHERE  CategoryID = ?
                    ORDER  BY ProductName
                    """;

            try (Connection conn = openConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, categoryId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.isBeforeFirst()) {           // empty result set
                        System.out.println("⚠️  No products found for that category.");
                        return;
                    }

                    System.out.printf("%-5s %-45s %-10s %-12s%n",
                            "ID", "Product Name", "Price", "In Stock");
                    System.out.println("=".repeat(78));

                    while (rs.next()) {
                        System.out.printf("%-5d %-45s $%-9.2f %-12d%n",
                                rs.getInt("ProductID"),
                                rs.getString("ProductName"),
                                rs.getDouble("UnitPrice"),
                                rs.getInt("UnitsInStock"));
                    }
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("⚠️  Error fetching products: " + ex.getMessage());
            }
        }
    }
}
