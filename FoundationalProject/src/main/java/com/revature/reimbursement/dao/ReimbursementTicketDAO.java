package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.ReimbursementTicket;

public interface ReimbursementTicketDAO {
    //basic requirements for Reimbursement ticket
    boolean createTicket(Employees employee, int amount, String description);

}
