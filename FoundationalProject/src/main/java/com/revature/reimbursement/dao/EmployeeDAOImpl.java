package com.revature.reimbursement.dao;

import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.Managers;
import com.revature.reimbursement.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {

    //Need to create field Managers in this file to access the managers table to retrieve receivedManager object
    private Class<? extends com.revature.reimbursement.models.Managers> Managers;

    @Override
    public Employees employeeLogin (String username) {
        Employees employee = new Employees();

        //Establish connection with database
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from employees where username = ?";
            PreparedStatement prepState = conn.prepareStatement(sql);
            prepState.setString(1, username);

            ResultSet rs;
            if((rs = prepState.executeQuery()) != null) {
                rs.next();
                int receivedEmployeeId = rs.getInt("employee_id");
                String receivedFirstName = rs.getString("first");
                String receivedLastName = rs.getString("last");
                String receivedEmail = rs.getString("email");
                String receivedUsername = rs.getString("username");
                String receivedPassword = rs.getString("pw");
                String receivedDepartment = rs.getString("department");
                Managers receivedManager = rs.getObject("man_id", Managers);

                employee = new Employees(receivedEmployeeId, receivedFirstName, receivedLastName, receivedEmail, receivedUsername, receivedPassword, receivedDepartment, receivedManager);
            }
        } catch(SQLException e) {
            System.out.println("Sorry, we are unable to retrieve your account at this time...");
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employees registerEmployee(String firstName, String lastName, String email, String username, String password, String department, Managers manager) {
        Employees employee = new Employees();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "insert into employees (first, last, email, username, pw, department, manager) values (?,?,?,?,?,?,?) returning *";
            PreparedStatement prepState = conn.prepareStatement(sql);
            prepState.setString(1, firstName);
            prepState.setString(2, lastName);
            prepState.setString(3, email);
            prepState.setString(4, username);
            prepState.setString(5, password);
            prepState.setString(6, department);
            prepState.setObject(7, Managers);

            ResultSet rs;
            if((rs = prepState.executeQuery()) != null) {
                rs.next();
                int receivedEmployeeId = rs.getInt("employ_id");
                String receivedFirstName = rs.getString("first");
                String receivedLastName = rs.getString("last");
                String receivedEmail = rs.getString("email");
                String receivedUsername = rs.getString("username");
                String receivedPassword = rs.getString("pw");
                String receivedDepartment = rs.getString("department");
                Managers receivedManager = rs.getObject("man_id", Managers);

                employee = new Employees(receivedEmployeeId, receivedFirstName, receivedLastName, receivedEmail, receivedUsername, receivedPassword, receivedDepartment, receivedManager);
            }
        } catch (SQLException e) {
            System.out.println("Sorry, we are unable to register your user at this time...");
            e.printStackTrace();
        }
        return employee;
    }
}
