package com.emailApp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter first name: ");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();
        Email email = new Email(firstName, surname);
        email.setMailboxCapacity(400);
        email.setAlternativeEmail("aa@aa.aa");
        System.out.println("Alternative email: " + email.getAlternativeEmail());
        System.out.println(email.showInfo());
    }
}
