package com.pluralsight;


import java.util.Scanner;
public class CellPhoneApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CellPhone cellphone123 =
                new CellPhone(123, "Iphone X",
                        "Verizon", "929-324-214",
                        "Ash");

        System.out.println("Whats your serial number? ");
        int serialNumber = scanner.nextInt();
        cellphone123.setSerialNumber(serialNumber);
        scanner.nextLine();

        System.out.print("What model is your phone? ");
        String model = scanner.nextLine();
        cellphone123.setModel(model);

        System.out.println("Who is the carrier? ");
        String carrier = scanner.nextLine();
        cellphone123.setCarrier(carrier);

        System.out.println("What is your phone number? ");
        String phoneNumber = scanner.nextLine();
        cellphone123.setPhoneNumber(phoneNumber);

        System.out.println("Who is the owner of the phone");
        String owner = scanner.nextLine();
        cellphone123.setOwner(owner);

        scanner.close();
    }
}
