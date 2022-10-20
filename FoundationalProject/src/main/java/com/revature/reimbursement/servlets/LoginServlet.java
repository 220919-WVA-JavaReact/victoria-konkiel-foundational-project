package com.revature.reimbursement.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.Managers;
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

public class LoginServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    ManagerService managerService = new ManagerService();
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
        if(req.getParameter("type").equals("employee")) {
            HashMap<String, Object> employeeSearch = mapper.readValue(req.getInputStream(), HashMap.class);

            String providedUsername = (String) employeeSearch.get("username");
            String providedPassword = (String) employeeSearch.get("pw");

            Employees employee = employeeService.login(providedUsername, providedPassword);
            String payload = mapper.writeValueAsString(employee);

            if (payload.equals("null")) {
                resp.setStatus(400);
                resp.getWriter().write("Invalid credentials");
            } else {
                resp.getWriter().write(payload);
                HttpSession session = req.getSession();
                session.setAttribute("employee-logged-in", employee);
            }
        } else if (req.getParameter("type").equals("manager")) {
            HashMap<String, Object> managerSearch = mapper.readValue(req.getInputStream(), HashMap.class);

            String providedUsername = (String) managerSearch.get("username");
            String providedPassword = (String) managerSearch.get("pw");

            Managers manager = managerService.login(providedUsername, providedPassword);
            String payload = mapper.writeValueAsString(manager);

            if (payload.equals("null")) {
                resp.setStatus(400);
                resp.getWriter().write("Invalid credentials");
            } else {
                resp.getWriter().write(payload);
                HttpSession session = req.getSession();
                session.setAttribute("manager-logged-in", manager);
            }
        }
    }
}
