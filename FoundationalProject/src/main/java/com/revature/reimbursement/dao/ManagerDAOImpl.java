package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.Managers;
import com.revature.reimbursement.models.ReimbursementTicket;
import com.revature.reimbursement.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAOImpl implements ManagerDAO {
    @Override
    public Managers managerLogin(String username) {
        Managers manager = new Managers();

        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from managers where username = ?";
            PreparedStatement prepState = conn.prepareStatement(sql);
            prepState.setString(1, username);

            ResultSet rs;
            if((rs = prepState.executeQuery()) != null) {
                if (rs.next()) {
                    int receivedManId = rs.getInt("man_id");
                    String receivedFirstName = rs.getString("first");
                    String receivedLastName = rs.getString("last");
                    String receivedEmail = rs.getString("email");
                    String receivedUsername = rs.getString("username");
                    String receivedPassword = rs.getString("pw");
                    String receivedDepartment = rs.getString("department");

                    manager = new Managers(receivedManId, receivedFirstName, receivedLastName, receivedEmail, receivedUsername, receivedPassword, receivedDepartment);
                }
            }
        } catch(SQLException e) {
            System.out.println("There seems to be an issue retrieving your account...");
            e.printStackTrace();
            return null;
        }
        return manager;
    }

    @Override
    public Managers registerManager(String firstName, String lastName, String email, String username, String password, String department) {
        Managers manager = new Managers();
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "insert into managers(first, last, email, username, pw, department) values (?,?,?,?,?,?) returning *";
            PreparedStatement prepState = conn.prepareStatement(sql);
            prepState.setString(1, firstName);
            prepState.setString(2, lastName);
            prepState.setString(3, email);
            prepState.setString(4, username);
            prepState.setString(5, password);
            prepState.setString(6, department);

            ResultSet rs;
            if((rs = prepState.executeQuery()) != null) {
                rs.next();
                int receivedManId = rs.getInt("man_id");
                String receivedFirstName = rs.getString("first");
                String receivedLastName = rs.getString("last");
                String receivedEmail = rs.getString("email");
                String receivedUsername = rs.getString("username");
                String receivedPassword = rs.getString("pw");
                String receivedDepartment = rs.getString("department");

                manager = new Managers(receivedManId, receivedFirstName, receivedLastName, receivedEmail, receivedUsername, receivedPassword, receivedDepartment);
            }

        } catch (SQLException e) {
            System.out.println("Sorry, we were unable to register your account. Please try again later.");
            e.printStackTrace();
        }
        return manager;
    }

}
