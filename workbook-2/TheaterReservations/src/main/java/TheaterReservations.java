import java.util.Scanner;
public class TheaterReservations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String answer, date;
        int ticket;
        System.out.println("Enter your name: ");

        answer = scan.nextLine();

        System.out.println("What date will you be coming (MM/dd/yyyy): ");
        date = scan.nextLine();

        System.out.println("How many tickets would you like to buy ");
        ticket = scan.nextInt();
        String[] nameParts = answer.trim().split("\\s+");
        String firstName = nameParts[0];
        String lastName = nameParts[nameParts.length - 1];

        String[] dateParts = date.split("/");
        String formattedDate = String.format("%s-%02d-%02d", dateParts[2],
                Integer.parseInt(dateParts[0]),
                Integer.parseInt(dateParts[1]));

        // Display confirmation message
        if (ticket == 1) {
            System.out.printf("1 ticket reserved for %s under %s, %s\n",
                    formattedDate, lastName, firstName);
        } else {
            System.out.printf("%d tickets reserved for %s under %s, %s\n",
                    ticket, formattedDate, lastName, firstName);
        }

        scan.close();



    }
}
