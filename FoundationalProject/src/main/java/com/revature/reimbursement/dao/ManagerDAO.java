package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.Managers;
import com.revature.reimbursement.models.ReimbursementTicket;

import java.util.List;

public interface ManagerDAO {
    //Basic requirements needed for Managers
    Managers managerLogin(String username);
    Managers registerManager(String firstName, String lastName, String email, String username, String password, String department);


}
