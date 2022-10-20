package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.ReimbursementTicket;
import com.revature.reimbursement.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementTicketDAOImpl implements ReimbursementTicketDAO {

    @Override
    public ReimbursementTicket createTicket(Employees employee, double amount, String description) {
        System.out.println(employee);
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "insert into rem_ticket(employee_id, amount, description, status) values (?,?,?,'pending') RETURNING *";
            PreparedStatement prepState = conn.prepareStatement(sql);
            prepState.setInt(1, employee.getEmploy_id());
            prepState.setDouble(2, amount);
            prepState.setString(3, description);

            ResultSet rs;
            if((rs = prepState.executeQuery()) != null) {
                if (rs.next()) {
                    double receivedAmount = rs.getDouble("amount");
                    String receivedDescription = rs.getString("description");
                    String receivedStatus = rs.getString("status");

                    ReimbursementTicket reimbursementTicket = new ReimbursementTicket(employee, receivedAmount, receivedDescription, receivedStatus);
                    return reimbursementTicket;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println("We ran into an issue trying to create your ticket. Please try again later");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ReimbursementTicket> getPendingTickets(Employees employee) {
        ArrayList<ReimbursementTicket> currentPendingTickets = new ArrayList<>();
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from rem_ticket where status = pending";
            PreparedStatement prepState = conn.prepareStatement(sql);
            ResultSet rs;
            if((rs = prepState.executeQuery()) != null) {
                while (rs.next()) {
                    Employees receivedEmployee = (Employees) rs.getObject("employee_id");
                    double receivedAmount = rs.getDouble("amount");
                    String receivedDescription = rs.getString("description");
                    String receivedStatus = rs.getString("status");

                    ReimbursementTicket ticket = new ReimbursementTicket(receivedEmployee, receivedAmount, receivedDescription, receivedStatus);
                    currentPendingTickets.add(ticket);
                }
            }
        } catch(SQLException e) {
            System.out.println("Database error printing pending tickets");
            e.printStackTrace();
        }
        return currentPendingTickets;
    }

    @Override
    public List<ReimbursementTicket> getAllTickets() {
        return null;
    }


}
