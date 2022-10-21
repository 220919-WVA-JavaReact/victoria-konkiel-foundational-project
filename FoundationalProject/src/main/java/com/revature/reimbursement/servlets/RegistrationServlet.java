package com.revature.reimbursement.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.dao.EmployeeDAO;
import com.revature.reimbursement.dao.EmployeeDAOImpl;
import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.service.EmployeeService;
import com.revature.reimbursement.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class RegistrationServlet extends HttpServlet {
    EmployeeService es = new EmployeeService();
    private final ObjectMapper mapper;
    public RegistrationServlet(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG] - RegistrationServlet Instantiated");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("type").equals("employee")) {
            Employees employee = mapper.readValue(req.getInputStream(), Employees.class);

            Employees newEmployee = es.register(employee.getFname(), employee.getLname(), employee.getEmail(), employee.getUsername(), employee.getPassword(), employee.getDepartment());
            String payload = mapper.writeValueAsString(newEmployee);
            if(payload.equals("null")) {
                resp.setStatus(400);
                resp.getWriter().write("The username you have selected is already in use. Please try again.");
            } else {
                resp.setStatus(201);
                resp.getWriter().write(payload);
                HttpSession session = req.getSession();
                session.setAttribute("employee-logged-in", newEmployee);
            }
        }
    }
}
