package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.ReimbursementTicket;

public interface ReimbursementTicketDAO {
    //basic requirements for Reimbursement ticket
    ReimbursementTicket getTicketByEmployId(int employ_id);
}
