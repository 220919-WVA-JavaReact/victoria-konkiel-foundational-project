package com.revature.reimbursement;

import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.service.EmployeeService;
import com.revature.reimbursement.service.ManagerService;
import com.revature.reimbursement.service.ReimbursementTicketService;

import java.util.Scanner;

public class App {
    static EmployeeService es = new EmployeeService();
    static ManagerService ms = new ManagerService();
    static ReimbursementTicketService rts = new ReimbursementTicketService();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Employees loggedIn = null;
        boolean programRunning = true;

        while (programRunning) {
            if (loggedIn == null) {
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Welcome to the Employee Reimbursement Login!");
                System.out.println("This is where you can submit reimbursement tickets for work expenses.");
                System.out.println("With that, what would you like to do? You can type:");
                System.out.println(" -'employee login' to log into the employee account,");
                System.out.println(" -'manager login' to log into the management account");
                System.out.println(" -'register employee' to register a new employee account,");
                System.out.println(" -'register manager' to register a new manager account");
                System.out.println(" - or perhaps you made a mistake and would like to type 'quit' to quit");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                String response = sc.nextLine();

                switch(response) {
                    case "employee login" :
                        es.login();
                        break;
                    case "manager login" :
                        ms.login();
                        break;
                    case "register employee" :
                        es.register();
                        break;
                    case "register manager" :
                        ms.register();
                        break;
                    case "quit" :
                        programRunning = false;
                        break;
                    default:
                        System.out.println("Sorry, something went wrong. Please try again.");
                }
            } else {
                System.out.println("Ready to create a reimbursement ticket?");
                System.out.println(" - To create a ticket type 'create'");
                System.out.println(" - To quit type 'quit'");
                String ticketResponse = sc.nextLine();

                switch (ticketResponse) {
                    case "create" :
                        rts.createTicket(loggedIn);
                        break;
                    case "quit" :
                        programRunning = false;
                        break;
                    default :
                        System.out.println("Sorry, I did not understand that. Please try again.");
                }
            }
        }
    }
}
