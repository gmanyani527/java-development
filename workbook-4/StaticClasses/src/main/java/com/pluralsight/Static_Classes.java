package com.pluralsight;

public class Static_Classes{

    public static String formatName(String firstName, String lastName,
                                    String prefix, String middleName, String suffix) {
        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("First and Last names are required.");
        }

        StringBuilder formattedName = new StringBuilder();
        formattedName.append(lastName).append(", ");

        // Add prefix if it exists
        if (prefix != null && !prefix.isEmpty()) {
            formattedName.append(prefix).append(" ");
        }

        formattedName.append(firstName);

        // Add middle name if it exists
        if (middleName != null && !middleName.isEmpty()) {
            formattedName.append(" ").append(middleName);
        }

        // Add suffix if it exists
        if (suffix != null && !suffix.isEmpty()) {
            formattedName.append(", ").append(suffix);
        }

        return formattedName.toString();
    }

    public static void main(String[] args) {
        System.out.println(formatName("Mel", "Johnson", "Dr.", "B", "PhD"));  // Johnson, Dr. Mel B, PhD
        System.out.println(formatName("Mel", "Johnson", null, "B", "PhD"));   // Johnson, Mel B, PhD
        System.out.println(formatName("Mel", "Johnson", null, null, null));  // Johnson, Mel
    }
}

