package com.pluralsight;
import java.sql.*;

import java.util.Scanner;

public class Main {

    private static final String DB_URL  = "jdbc:mysql://localhost:3306/northwind";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "P@ssw0rd";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1) Display all products");
            System.out.println("2) Display all customers");
            System.out.println("0) Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> displayProducts();
                case "2" -> displayCustomers();
                case "0" -> running = false;
                default  -> System.out.println(" Invalid option, try again.");
            }
        }
        scanner.close();
        System.out.println(" Goodbye!");
    }

    /* ---------- Helper to open a connection ---------- */
    private static Connection openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    /* ---------- Option 1: display every product ---------- */
    private static void displayProducts() {
        String sql = """
                SELECT ProductID, ProductName, UnitPrice
                FROM   Products
                ORDER  BY ProductName
                """;

        Connection conn = null;
        Statement  stmt = null;
        ResultSet  rs   = null;

        try {
            conn = openConnection();
            stmt = conn.createStatement();
            rs   = stmt.executeQuery(sql);

            System.out.printf("%-5s %-45s %-10s%n",
                    "ID", "Product Name", "Price");
            System.out.println("=".repeat(65));

            while (rs.next()) {
                System.out.printf("%-5d %-45s $%-9.2f%n",
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getDouble("UnitPrice"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error fetching products: " + ex.getMessage());
        } finally {
            closeQuietly(rs, stmt, conn);
        }
    }

    /* ---------- Option 2: display every customer ---------- */
    private static void displayCustomers() {
        String sql = """
                SELECT ContactName,
                       CompanyName,
                       City,
                       Country,
                       Phone
                FROM   Customers
                ORDER  BY Country
                """;

        Connection conn = null;
        Statement  stmt = null;
        ResultSet  rs   = null;

        try {
            conn = openConnection();
            stmt = conn.createStatement();
            rs   = stmt.executeQuery(sql);

            System.out.printf("%-30s %-35s %-18s %-15s %-18s%n",
                    "Contact Name", "Company Name", "City", "Country", "Phone");
            System.out.println("=".repeat(122));

            while (rs.next()) {
                System.out.printf("%-30s %-35s %-18s %-15s %-18s%n",
                        rs.getString("ContactName"),
                        rs.getString("CompanyName"),
                        rs.getString("City"),
                        rs.getString("Country"),
                        rs.getString("Phone"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(" Error fetching customers: " + ex.getMessage());
        } finally {
            closeQuietly(rs, stmt, conn);
        }
    }

    /* ---------- Utility: close everything in reverse order ---------- */
    private static void closeQuietly(ResultSet rs, Statement stmt, Connection conn) {
        try { if (rs   != null) rs.close();   } catch (SQLException ignored) {}
        try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
        try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
    }
}
