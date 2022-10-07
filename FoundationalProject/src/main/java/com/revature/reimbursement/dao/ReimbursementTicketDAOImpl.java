package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReimbursementTicketDAOImpl implements ReimbursementTicketDAO {

    @Override
    public boolean createTicket(Employees employee, int amount, String description) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "insert into rem_ticket(employ_id, amount, description, status) values (?,?,?,'pending')";
            PreparedStatement prepState = conn.prepareStatement(sql);
            prepState.setInt(1, employee.getEmploy_id());
            prepState.setInt(2, amount);
            prepState.setString(3, description);

            int result = prepState.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("We ran into an issue trying to create your ticket. Please try again later");
            e.printStackTrace();
        }
        return false;
    }
}
