package com.revature.reimbursement.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.servlets.EmployeeServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import java.time.LocalDateTime;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[LOG] - The Servlet context was initialized at " + LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();
        EmployeeServlet employeeServlet = new EmployeeServlet(mapper);
        ServletContext context = sce.getServletContext();
        ServletRegistration.Dynamic registeredServlet = context.addServlet("EmployeeServlet", employeeServlet);
        registeredServlet.addMapping("/employee");
        registeredServlet.setLoadOnStartup(3);
        registeredServlet.setInitParameter("employee-servlet-key", "employee-servlet-value");
        registeredServlet.setInitParameter("another-param", "another-value");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[LOG] - The Servlet context was destroyed at " + LocalDateTime.now());
    }
}
