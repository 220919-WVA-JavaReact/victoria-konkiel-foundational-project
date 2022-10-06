package com.revature.reimbursement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singleton Connection Instance
public class ConnectionUtil {
    //Private static instance of a connection
    private static Connection conn = null;
    //private constructor
    private ConnectionUtil() {

    }
    //Public static getInstance() method
    public static Connection getConnection() {
        //Check to see if there is a connection instance already
        //if there is return it
        try {
            if(conn != null && !conn.isClosed()) {
                System.out.println("use a previously made connection");
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        String url = System.getenv("url");
        String username = System.getenv("username");
        String password = System.getenv("password");

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Established Connection to Database!");
        } catch ( SQLException e ) {
            System.out.println("Could not establish connection!");
            e.printStackTrace();
        }
        return conn;
    }
}
