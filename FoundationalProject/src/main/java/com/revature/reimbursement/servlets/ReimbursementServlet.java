package com.revature.reimbursement.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.models.Employees;
import com.revature.reimbursement.models.Managers;
import com.revature.reimbursement.models.ReimbursementTicket;
import com.revature.reimbursement.service.ReimbursementTicketService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReimbursementServlet extends HttpServlet {
    ReimbursementTicketService rts = new ReimbursementTicketService();
    private final ObjectMapper mapper;
    public ReimbursementServlet(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG] - ReimbursementServlet Instantiated");
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
            List<ReimbursementTicket> currentPendingTickets = rts.getPendingTickets();
            System.out.println(currentPendingTickets);

//            if(currentPendingTickets != null) {
                resp.setStatus(200);
                resp.getWriter().write(mapper.writeValueAsString(currentPendingTickets));
//            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(400);
            resp.setContentType("application/json");

            HashMap<String, Object> errorMessage = new HashMap<>();
            errorMessage.put("Status code", 400);
            errorMessage.put("Message", "You must be logged in to access reimbursement site.");
            errorMessage.put("Timestamp", LocalDateTime.now().toString());

            resp.getWriter().write(mapper.writeValueAsString(errorMessage));
            return;
        } else {
            if (req.getParameter("type").equals("employee")) {
                ReimbursementTicket reimbursementTicket = mapper.readValue(req.getInputStream(), ReimbursementTicket.class);
                String description = reimbursementTicket.getDescription();
                double amount = reimbursementTicket.getAmount();
//                HttpSession sess = req.getSession();
                HttpSession sess = req.getSession(false);
                if (session == null) {
                    resp.setStatus(400);
                    resp.setContentType("application/json");

                    HashMap<String, Object> errorMessage = new HashMap<>();
                    errorMessage.put("Status code", 400);
                    errorMessage.put("Message", "You must be logged in to access reimbursement site.");
                    errorMessage.put("Timestamp", LocalDateTime.now().toString());

                    resp.getWriter().write(mapper.writeValueAsString(errorMessage));
                    return;
                } else {
                    Employees loggedIn = (Employees) sess.getAttribute("employee-logged-in");
                    System.out.println(loggedIn);

                    ReimbursementTicket rt = rts.createTicket(loggedIn, amount, description);
                    if (rt != null) {
                        if (rt.getAmount() == 0) {
                            resp.getWriter().write("You must enter an amount.");
                        } else if (rt.getDescription().equals("")) {
                            resp.getWriter().write("You must have a description.");
                        } else {
                            resp.setStatus(201);
                            resp.getWriter().write(String.valueOf(rt));
                        }
                    } else {
                        resp.setStatus(400);
                        resp.getWriter().write("Something went wrong, you're ticket couldn't be created.");
                    }
                }
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("application/json");
            HttpSession session = req.getSession(false);
            if (session != null) {
                Managers manager = (Managers) session.getAttribute("auth-users");
                ReimbursementTicket rt = mapper.readValue(req.getInputStream(), ReimbursementTicket.class);
                if (req.getParameter("action").equals("approve")) {
                    if (rt.getStatus().equals("pending")) {
                        String payload = mapper.writeValueAsString(rt);
                        String output = String.valueOf(rts.updateTicketStatus(manager, rt.getTicket_id(), "approved"));
                        resp.getWriter().write("Awesome, you approved the ticket.");
                        resp.setStatus(200);
                    } else {
                        resp.setStatus(401);
                        resp.getWriter().write("This ticket has already been approved.");
                    }
                } else if (req.getParameter("action").equals("deny")) {
                    if (rt.getStatus().equals("pending")) {
                        String payload = mapper.writeValueAsString(rt);
                        String output = String.valueOf(rts.updateTicketStatus(manager, rt.getTicket_id(), "denied"));
                        resp.getWriter().write("Awesome, you denied the ticket.");
                        resp.setStatus(200);
                    } else {
                        resp.setStatus(401);
                        resp.getWriter().write("This ticket has already been approved silly.");
                    }
                }
            } else {
                if (req.getParameter("type").equals("employee")) {
                    resp.setStatus(403);
                    resp.getWriter().write("Employees are not authorized to update tickets.");
                }
            }
        }
    }

