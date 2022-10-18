package com.revature.reimbursement.dao;

import com.revature.reimbursement.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuthorizationDAOImpl implements UserAuthorizationDAO {

    @Override
    public boolean isUsernameTaken(String username) {
        //Employees employee = new Employees();
        boolean result = true;

        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select count(*) from employees where username = ?";
            PreparedStatement prepState = conn.prepareStatement(sql);
            prepState.setString(1, username);

            ResultSet rs;
            rs = prepState.executeQuery();
            rs.next();
            System.out.println(rs.getInt("count"));
            if ((rs.getInt("count")) == 0) {
                result = false;
            }
        } catch (SQLException e) {
            System.out.println("There was an issue verifying the username you entered");
            e.printStackTrace();
        }
        return result;
    }
}
