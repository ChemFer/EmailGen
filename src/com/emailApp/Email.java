package com.emailApp;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Email {
    private String firstName;
    private String surname;
    private String department;
    private String email;
    private int mailboxCapacity = 1000;
    private String alternativeEmail;
    private int passwordLength = 10;
    private String companyEmailSuffix = "company.com";

    Password password = new Password();
    public Email(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;

        this.department = setDepartment();
        email = this.firstName.toLowerCase() + "." + this.surname.toLowerCase() + "@" + this.department + "." + companyEmailSuffix;
    }




    private String setDepartment(){
        System.out.println("Enter department: \n1: HelpDesk \n2: Development \n3: Accounting \n4: Sales \n5: Marketing");
        Scanner scanner = new Scanner(System.in);
        int departmentInt = scanner.nextInt();
        switch (departmentInt){
            case 1:
                return "helpdesk";
            case 2:
                return "dev";
            case 3:
                return "acct";
            case 4:
                return "sales";

            case 5:
                return "marketing";
            default:
                return "wrong_department";
        }
    }


    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }


    public String showInfo(){
        String info = "NAME: " + firstName + " " + surname
                + "\nCREATED EMAIL: " + email  + "\nPASSWORD: " + password.getPassword() + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
        return info;
    }
}
