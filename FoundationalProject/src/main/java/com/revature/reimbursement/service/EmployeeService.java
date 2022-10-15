package com.revature.reimbursement.service;

import com.revature.reimbursement.dao.EmployeeDAO;
import com.revature.reimbursement.dao.EmployeeDAOImpl;
import com.revature.reimbursement.dao.UserAuthorizationDAO;
import com.revature.reimbursement.dao.UserAuthorizationDAOImpl;
import com.revature.reimbursement.models.Employees;
import java.util.Scanner;

public class EmployeeService {
    static EmployeeDAO ed = new EmployeeDAOImpl();
    static UserAuthorizationDAO uad = new UserAuthorizationDAOImpl();
    Scanner sc = new Scanner(System.in);

    public Employees login() {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("Please enter your username below:");
        String username = sc.nextLine();
        boolean takenUsername = uad.isUsernameTaken(username);
        while(takenUsername) {
            System.out.println("Sorry that username is taken... Please try again.");
        }
        System.out.println("Please enter your password below:");
        String password = sc.nextLine();

        Employees employee = ed.employeeLogin(username);
        if (employee.getEmploy_id() == 0) {
            System.out.println("I'm sorry, there is no user by that username.");
        } else {
            if (employee.getPassword().equals(password)) {
                System.out.println("You have successfully logged in!");
            }
        }
        return employee;
    }

    public Employees register() {
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

        Employees employee = ed.registerEmployee(firstName, lastName, email, username, password,department);
        if(employee.getEmploy_id() != 0) {
            System.out.println("You have successfully registered! Congrats!");
        }
        return null;
    }

}
