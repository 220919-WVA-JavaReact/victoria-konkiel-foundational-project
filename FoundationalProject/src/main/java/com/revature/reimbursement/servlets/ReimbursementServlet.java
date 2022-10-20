package com.revature.reimbursement.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.dao.ReimbursementTicketDAOImpl;
import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.ReimbursementTicket;
import com.revature.reimbursement.service.EmployeeService;
import com.revature.reimbursement.service.ReimbursementTicketService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class ReimbursementServlet extends HttpServlet {
    private final ObjectMapper mapper;
    public ReimbursementServlet(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG] - ReimbursementServlet Instantiated");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session == null) {
            resp.setStatus(400);
            resp.setContentType("application/json");

            HashMap<String, Object> errorMessage = new HashMap<>();
            errorMessage.put("Status code", 400);
            errorMessage.put("Message", "You must be logged in to access reimbursement site.");
            errorMessage.put("Timestamp", LocalDateTime.now().toString());

            resp.getWriter().write(mapper.writeValueAsString(errorMessage));
            return;
        } else {
            if(req.getParameter("type").equals("employee")) {
                ReimbursementTicket reimbursementTicket = mapper.readValue(req.getInputStream(), ReimbursementTicket.class);
                String description = reimbursementTicket.getDescription();
                double amount = reimbursementTicket.getAmount();
                Employees loggedIn = (Employees) session.getAttribute("type");



            }
        }
    }
}
