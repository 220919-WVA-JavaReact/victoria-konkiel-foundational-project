package com.revature.reimbursement.service;

import com.revature.reimbursement.dao.ManagerDAO;
import com.revature.reimbursement.dao.ManagerDAOImpl;
import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.Managers;

import java.util.Scanner;

public class ManagerService {
    Scanner sc = new Scanner(System.in);
    static ManagerDAO  md = new ManagerDAOImpl();

    public Managers login() {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("Please enter your username below:");
        String username = sc.nextLine();
        System.out.println("Please enter your password below:");
        String password = sc.nextLine();

        Managers manager = md.managerLogin(username);
        if (manager.getMan_id() == 0) {
            System.out.println("Sorry, there was no user associated with this username. Please try again.");
        } else {
            if(manager.getPassword().equals(password)) {
                System.out.println("Congrats, you have successfully logged in!");
                return manager;
            }
        }
        return null;
    }

    public Managers login(String username, String password) {
        Managers manager = md.managerLogin(username);
        if (password.equals(manager.getPassword())) {
            return manager;
        } else {
            return null;
        }
    }

    public Managers register() {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("Let's get you an account!");
        System.out.println("Please enter your first name:");
        String firstName = sc.nextLine();
        System.out.println("Please enter your last name:");
        String lastName = sc.nextLine();
        System.out.println("Please enter your email:");
        String email = sc.nextLine();
        System.out.println("Please enter your the username: (minimum of 10 characters)");
        String username = sc.nextLine();
        System.out.println("Please enter your password:");
        String password = sc.nextLine();
        System.out.println("Please enter your department:");
        String department = sc.nextLine();

        Managers manager = md.registerManager(firstName, lastName, email, username, password, department);
        if(manager.getMan_id() != 0) {
            System.out.println("Congrats, you've successfully registered your manager account!");
            return manager;
        }
        return null;
    }

}
