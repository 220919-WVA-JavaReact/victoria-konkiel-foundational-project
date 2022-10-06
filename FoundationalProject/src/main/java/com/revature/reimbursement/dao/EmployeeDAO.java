package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.Managers;

public interface EmployeeDAO {
    //Here is where the basic requirements for the Employee section for our system goes
    Employees employeeLogin (String username);
    Employees registerEmployee(String firstName, String lastName, String email, String username, String password, String department, Managers manager);
}
