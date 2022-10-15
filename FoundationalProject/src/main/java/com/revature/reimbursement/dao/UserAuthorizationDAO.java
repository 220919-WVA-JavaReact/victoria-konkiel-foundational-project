package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.Employees;

public interface UserAuthorizationDAO {
    boolean isUsernameTaken(String username);
}
