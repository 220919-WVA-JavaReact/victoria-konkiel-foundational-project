package com.revature.reimbursement.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.models.Managers;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(
        urlPatterns = "/manager",
        loadOnStartup = 2,
        initParams = {
                @WebInitParam(name = "manager-servlet-key", value = "manager-servlet-value"),
                @WebInitParam(name = "another-param", value = "another-value")
        })
public class ManagerServlet extends HttpServlet {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG] - ManagerServlet Instantiated");
        System.out.println("[LOG] - Init param manager-servlet-key: " + this.getServletConfig().getInitParameter("manager-servlet-key"));
        System.out.println("[LOG] - Init param test-init-key: " + this.getServletConfig().getInitParameter("test-init-key"));
        System.out.println("[LOG] - Context param test-init-key: " + this.getServletContext().getInitParameter("test-context-key"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG] - ManagerServlet received a GET request at " + LocalDateTime.now());
        Managers newManager = new Managers("Ben", "Wyatt", "bwyatt@pnr.com", "bwyatt", "Password156", "Parks and Recreation");
        String respPayload = mapper.writeValueAsString(newManager);

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getWriter().write(respPayload);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG] - ManagerServlet received a POST request at " + LocalDateTime.now());

        Managers newManager = mapper.readValue(req.getInputStream(), Managers.class);
        System.out.println(newManager);

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
