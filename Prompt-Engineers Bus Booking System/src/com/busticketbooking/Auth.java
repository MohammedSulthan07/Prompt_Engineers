package com.busticketbooking;

import java.util.Scanner;

public class Auth {
    private final String username = "Aiadmin";
    private final String password = "45510";
    public boolean authenticate(Scanner sc) {
        System.out.println("===== Authentication =====");
        System.out.print("Enter Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Authentication Successful\n");
            return true;
        } else {
            System.out.println("Authentication Failed. Try Again.\n");
            return false;
        }
    }
}