package com.revature.reimbursement.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.Managers;
import com.revature.reimbursement.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    private final ObjectMapper mapper;
    public LoginServlet(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG] - LoginServlet Instantiated");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> employeeSearch = mapper.readValue(req.getInputStream(), HashMap.class);

        String providedUsername = (String) employeeSearch.get("username");
        String providedPassword = (String) employeeSearch.get("pw");

        Employees employee = employeeService.login(providedUsername, providedPassword);
        String payload = mapper.writeValueAsString(employee);

        if(payload.equals("null")) {
            resp.getWriter().write("Invalid credentials");
            return;
        } else {

            resp.getWriter().write(payload);
        }
    }
}
