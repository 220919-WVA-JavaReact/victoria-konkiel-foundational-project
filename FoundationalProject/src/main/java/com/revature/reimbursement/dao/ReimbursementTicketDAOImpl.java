package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.Managers;
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
    public List<ReimbursementTicket> getPendingTickets() {
        List<ReimbursementTicket> currentPendingTickets = new ArrayList<>();
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from rem_ticket where status = ?";
            PreparedStatement prepState = conn.prepareStatement(sql);
            prepState.setString(1, "pending");
            ResultSet rs;
            if((rs = prepState.executeQuery()) != null) {
                while (rs.next()) {
                    int receivedTicketId = rs.getInt("ticket_id");
                    int receivedEmployee = rs.getInt("employee_id");
                    double receivedAmount = rs.getDouble("amount");
                    String receivedDescription = rs.getString("description");
                    String receivedStatus = rs.getString("status");

                    ReimbursementTicket ticket = new ReimbursementTicket(receivedTicketId, receivedEmployee, receivedAmount, receivedDescription, receivedStatus);
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
    public ReimbursementTicket updateTicketStatus(Managers manager, int ticket_id, String status) {
        ReimbursementTicket rt = new ReimbursementTicket();
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "update rem_ticket set status = ? where ticket_id = ? RETURNING *";
            PreparedStatement prepState = conn.prepareStatement(sql);
            prepState.setString(1, status);
            prepState.setInt(2, ticket_id);
            ResultSet rs;
            if((rs = prepState.executeQuery()) != null) {
                while(rs.next()) {
                    int receivedTickId = rs.getInt("ticket_id");
                    int receivedEmployId = rs.getInt("employee_id");
                    double receivedAmount = rs.getDouble("amount");
                    String receivedDescription = rs.getString("description");
                    String receivedStatus = rs.getString("status");

                    rt = new ReimbursementTicket(receivedTickId, receivedEmployId, receivedAmount, receivedDescription, receivedStatus);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rt;
    }

    @Override
    public List<ReimbursementTicket> getPreviousTickets(Employees employee) {
        List<ReimbursementTicket> previousTickets = new ArrayList<>();
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from rem_ticket where employee_id = ?";
            PreparedStatement prepState = conn.prepareStatement(sql);
            prepState.setInt(1, employee.getEmploy_id());
            ResultSet rs;
            if((rs = prepState.executeQuery()) != null) {
                while (rs.next()) {
                    int receivedTicketId = rs.getInt("ticket_id");
                    int receivedEmployee = rs.getInt("employee_id");
                    double receivedAmount = rs.getDouble("amount");
                    String receivedDescription = rs.getString("description");
                    String receivedStatus = rs.getString("status");

                    ReimbursementTicket ticket = new ReimbursementTicket(receivedTicketId, receivedEmployee, receivedAmount, receivedDescription, receivedStatus);
                    previousTickets.add(ticket);
                }
            }
        } catch(SQLException e) {
            System.out.println("Database error printing tickets");
            e.printStackTrace();
        }
        return previousTickets;
    }


}
