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
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 1000;
    private String alternativeEmail;
    private int passwordLength = 10;
    private String companyEmailSuffix = "company.com";

    public Email(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;

        this.department = setDepartment();
        this.password = passwordGenerator(passwordLength);
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

    private static String passwordGenerator(int length){
        String password = "";
        for (int i = 0; i < length; i++){
            password += randomCharacter();
        }
        return password;
    }

    private static char randomCharacter(){
        int ascii = 0;
        int rand = (int) (Math.random() * 62); //10 digits, 26 uppercase letters, 26 lowercase letters
        if (rand <= 9){
            ascii = rand + 48; //number between 0-9, ASCII: 48-57
            return (char) ascii;
        }
        else if (rand > 9 && rand <= 35){
            //uppercase letters: 10-35, ASCII: 65-90, 65-10=55
            ascii = rand + 55;
            return (char) ascii;
        }
        else {
            //lowercase letters 36-61, ASCII: 97-122, 97-36=61
            ascii = rand + 61;
            return (char) ascii;
        }

    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        String info = "NAME: " + firstName + " " + surname
                + "\nCREATED EMAIL: " + email + "\nPASSWORD: " + password + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
        return info;
    }
}
