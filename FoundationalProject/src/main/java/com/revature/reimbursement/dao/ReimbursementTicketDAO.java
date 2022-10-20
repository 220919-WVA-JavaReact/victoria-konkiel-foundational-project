package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.ReimbursementTicket;

import java.util.ArrayList;
import java.util.List;

public interface ReimbursementTicketDAO {
    //basic requirements for Reimbursement ticket
    ReimbursementTicket createTicket(Employees employee, double amount, String description);
    ArrayList<ReimbursementTicket> getPendingTickets(Employees employee);
    List<ReimbursementTicket> getAllTickets();

}
