package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.Managers;
import com.revature.reimbursement.models.ReimbursementTicket;

import java.util.ArrayList;
import java.util.List;

public interface ReimbursementTicketDAO {
    //basic requirements for Reimbursement ticket
    ReimbursementTicket createTicket(Employees employee, double amount, String description);
    List<ReimbursementTicket> getPendingTickets();

    ReimbursementTicket updateTicketStatus(Managers manager, int ticket_id, String status);
}
