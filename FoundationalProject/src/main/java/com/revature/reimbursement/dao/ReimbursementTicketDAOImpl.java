package com.revature.reimbursement.dao;

import com.revature.reimbursement.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class ReimbursementTicketDAOImpl implements ReimbursementTicketDAO {

    @Override
    public boolean createTicket(int employ_id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "insert into ";
        } catch (SQLException e) {
            System.out.println("We ran into an issue trying to create your ticket. Please try again later");
            e.printStackTrace();
        }
        return false;
    }
}
