package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.Managers;

public interface ManagerDAO {
    //Basic requirements needed for Managers
    Managers getManagerByUsername(String username);
    Managers registerManager(String firstName, String lastName, String email, String username, String password, String department);
}
