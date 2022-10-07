package com.revature.reimbursement.service;

import com.revature.reimbursement.dao.ReimbursementTicketDAO;
import com.revature.reimbursement.dao.ReimbursementTicketDAOImpl;
import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.ReimbursementTicket;
import java.util.Scanner;

public class ReimbursementTicketService {
    Scanner sc = new Scanner(System.in);
    ReimbursementTicketDAO rtd = new ReimbursementTicketDAOImpl();

    public void createTicket(Employees employee) {
        System.out.println("Let's see if we can get you some money back, yeah?");
        System.out.println("Please type in the amount you would like to be reimbursed for:");
        int amount = sc.nextInt();
        System.out.println("Please give us a description on what the expense was for:");
        String description = sc.next();

        if (description == null ) {
            System.out.println("The description must be filled out");
        } else {
            ReimbursementTicket rt = new ReimbursementTicket(employee, amount, description);
            boolean success = rtd.createTicket(employee, amount, description);
            if (success) {
                System.out.println("You've successfully submitted your ticket. Thank you!");
            } else {
                System.out.println("Uh oh... Looks like something went wrong. Please try submitting your ticket again.");
            }
        }
    }
}
