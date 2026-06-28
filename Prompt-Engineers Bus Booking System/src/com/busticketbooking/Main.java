package com.busticketbooking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Auth auth = new Auth();
        while (!auth.authenticate(sc)) {
        }
        BookingSystem system = new BookingSystem();
        while (true) {
            System.out.println("\n1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Show Buses");
            System.out.println("4. Book Ticket");
            System.out.println("5. View Tickets");
            System.out.println("6. Cancel Ticket");
            System.out.println("7. Bus Summary");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    system.signUp(sc);
                    break;
                case 2:
                    system.login(sc);
                    break;
                case 3:
                    system.showAvailableBuses();
                    break;
                case 4:
                    system.bookTicket(sc);
                    break;
                case 5:
                    system.viewTickets();
                    break;
                case 6:
                    system.cancelTicket(sc);
                    break;
                case 7:
                    system.showBusSummary();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}