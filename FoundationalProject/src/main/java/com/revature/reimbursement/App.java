package com.revature.reimbursement;
import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.Managers;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Managers manager = new Managers("Ron", "Swanson", "rswan@example.com", "rswanson", "password", "Management");
        Employees employ = new Employees("Leslie", "Knope", "lknope@example.com", "lknope", "pass123", "Sales", manager);
        String employee = employ.toString();
        System.out.println(employ);

//        Scanner sc = new Scanner(System.in);
//        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
//        System.out.println("Welcome to the Employee Reimbursement Login!");
//        System.out.println("This is where you can submit reimbursement tickets for work expenses.");
//        System.out.println("With that, what would you like to do? You can type:");
//        System.out.println(" -'login' to log into your account,");
//        System.out.println(" -'register' to register a new account,");
//        System.out.println(" - or perhaps you made a mistake and would like to type 'quit' to quit");
//        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
//        String response = sc.nextLine();
//
//        if (response.equals("login")) {
//            System.out.println("Awesome, let's get you logged in... Would you like to log in as a manager or an employee?");
//            String input = sc.nextLine();
//
//        } else if (response.equals("register")) {
//            System.out.println("You are choosing to register an account");
//        } else if (response.equals("quit")) {
//            System.out.println("Exiting the program... Goodbye.");
//        } else {
//            System.out.println("I'm sorry, I did not understand that response... Please try again.");
//        }
    }
}
