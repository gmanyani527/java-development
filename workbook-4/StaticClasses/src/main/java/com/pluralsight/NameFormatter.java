package com.pluralsight;

public class NameFormatter {

    // Private constructor to prevent instantiation
    private NameFormatter() {}

    // Format with just first and last name
    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    // Format with all components (prefix, first, middle, last, suffix)
    public static String format(String prefix, String firstName, String middleName,
                                String lastName, String suffix) {

        StringBuilder formattedName = new StringBuilder();
        formattedName.append(lastName).append(", ");

        if (prefix != null && !prefix.isEmpty()) {
            formattedName.append(prefix).append(" ");
        }

        formattedName.append(firstName);

        if (middleName != null && !middleName.isEmpty()) {
            formattedName.append(" ").append(middleName);
        }

        if (suffix != null && !suffix.isEmpty()) {
            formattedName.append(", ").append(suffix);
        }

        return formattedName.toString();
    }

    // Parse full name in input format: Prefix FirstName MiddleName LastName, Suffix
    public static String format(String fullName) {
        String[] parts = fullName.split(",\\s*");
        String namePart = parts[0]; // Everything before the comma
        String suffix = parts.length > 1 ? parts[1] : "";

        String[] nameTokens = namePart.trim().split("\\s+");

        String prefix = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";

        if (nameTokens.length == 4) {
            prefix = nameTokens[0];
            firstName = nameTokens[1];
            middleName = nameTokens[2];
            lastName = nameTokens[3];
        } else if (nameTokens.length == 3) {
            firstName = nameTokens[0];
            middleName = nameTokens[1];
            lastName = nameTokens[2];
        } else if (nameTokens.length == 2) {
            firstName = nameTokens[0];
            lastName = nameTokens[1];
        }

        return format(prefix, firstName, middleName, lastName, suffix);
    }

    // Test the methods
    public static void main(String[] args) {
        System.out.println(format("Mel", "Johnson"));  // Johnson, Mel
        System.out.println(format("Dr.", "Mel", "B", "Johnson", "PhD")); // Johnson, Dr. Mel B, PhD
        System.out.println(format("Mel B Johnson, PhD")); // Johnson, Mel B, PhD
        System.out.println(format("Dr. Mel B Johnson, PhD")); // Johnson, Dr. Mel B, PhD
        System.out.println(format("Mel Johnson")); // Johnson, Mel
    }
}
