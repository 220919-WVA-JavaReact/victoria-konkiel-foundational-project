package com.revature.reimbursement.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.ReimbursementTicket;
import com.revature.reimbursement.service.ReimbursementTicketService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    ReimbursementTicketService rts = new ReimbursementTicketService();
    private final ObjectMapper mapper;

    public EmployeeServlet(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG] - EmployeeServlet Instantiated");
        System.out.println("[LOG] - Init param employee-servlet-key: " + this.getServletConfig().getInitParameter("employee-servlet-key"));
        System.out.println("[LOG] - Init param test-init-key: " + this.getServletConfig().getInitParameter("test-init-key"));
        System.out.println("[LOG] - Context param test-init-key: " + this.getServletContext().getInitParameter("test-context-key"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            Employees loggedIn = (Employees) session.getAttribute("employee-logged-in");
            List<ReimbursementTicket> previousTickets = rts.getPreviousTickets(loggedIn);
            System.out.println(previousTickets);

//            if(currentPendingTickets != null) {
            resp.setStatus(200);
            resp.getWriter().write(mapper.writeValueAsString(previousTickets));
//            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG] - EmployeeServlet received a POST request at " + LocalDateTime.now());

        Employees newEmployee = mapper.readValue(req.getInputStream(), Employees.class);
        System.out.println(newEmployee);

        resp.setStatus(204);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
