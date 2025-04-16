import java.util.Scanner;
public class FullNameApplication {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for required parts
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Enter your middle name (press Enter to skip): ");
        String middleName = scanner.nextLine().trim();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Enter your suffix (press Enter to skip): ");
        String suffix = scanner.nextLine().trim();

        // Build full name using simple string concatenation
        String fullName = firstName;

        if (!middleName.isEmpty()) {
            fullName += " " + middleName;
        }

        fullName += " " + lastName;

        if (!suffix.isEmpty()) {
            fullName += ", " + suffix;
        }

        System.out.println("Your full name is: " + fullName);
    }
}
