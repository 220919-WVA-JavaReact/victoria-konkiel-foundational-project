package com.revature.reimbursement.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.servlets.*;

import javax.servlet.*;
import java.time.LocalDateTime;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[LOG] - The Servlet context was initialized at " + LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();
        EmployeeServlet employeeServlet = new EmployeeServlet(mapper);
        ManagerServlet managerServlet = new ManagerServlet(mapper);
        LoginServlet loginServlet = new LoginServlet(mapper);
        RegistrationServlet registrationServlet = new RegistrationServlet(mapper);
        ReimbursementServlet reimbursementServlet = new ReimbursementServlet(mapper);

        ServletContext context = sce.getServletContext();

        ServletRegistration.Dynamic registeredServlet3 = context.addServlet("LoginServlet", loginServlet);
        registeredServlet3.addMapping("/login");
        registeredServlet3.setLoadOnStartup(1);
        registeredServlet3.setInitParameter("login-servlet-key", "login-servlet-value");
        registeredServlet3.setInitParameter("another-param", "another-value");

        ServletRegistration.Dynamic registeredServlet = context.addServlet("EmployeeServlet", employeeServlet);
        registeredServlet.addMapping("/employee");
        registeredServlet.setLoadOnStartup(2);
        registeredServlet.setInitParameter("employee-servlet-key", "employee-servlet-value");
        registeredServlet.setInitParameter("another-param", "another-value");

        ServletRegistration.Dynamic registeredServlet2 = context.addServlet("ManagerServlet", managerServlet);
        registeredServlet2.addMapping("/manager");
        registeredServlet2.setLoadOnStartup(3);
        registeredServlet2.setInitParameter("manager-servlet-key", "manager-servlet-value");
        registeredServlet2.setInitParameter("another-param", "another-value");

        ServletRegistration.Dynamic registeredServlet4 = context.addServlet("RegistrationServlet", registrationServlet);
        registeredServlet4.addMapping("/registration");
        registeredServlet4.setLoadOnStartup(4);
        registeredServlet4.setInitParameter("registration-servlet-key", "registration-servlet-value");
        registeredServlet4.setInitParameter("another-param", "another-value");

        ServletRegistration.Dynamic registeredServlet5 = context.addServlet("ReimbursementServlet", reimbursementServlet);
        registeredServlet5.addMapping("/reimbursement");
        registeredServlet5.setLoadOnStartup(5);
        registeredServlet5.setInitParameter("reimbursement-servlet-key", "reimbursement-servlet-value");
        registeredServlet5.setInitParameter("another-param", "another-value");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[LOG] - The Servlet context was destroyed at " + LocalDateTime.now());
    }
}
