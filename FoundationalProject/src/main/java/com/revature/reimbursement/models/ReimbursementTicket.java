package com.revature.reimbursement.models;

import java.util.Objects;

public class ReimbursementTicket {
    private int ticket_id;
    private int employee_id;
    private Employees employee;
    private double amount;
    private String description;
    private String status;

    public ReimbursementTicket(int ticket_id, int employee_id, double amount, String description, String status) {
        this.ticket_id = ticket_id;
        this.employee_id = employee_id;
        this.amount = amount;
        this.description = description;
        this.status = status;
    }

    public ReimbursementTicket(Employees employee, double amount, String description) {
        this.employee = employee;
        this.amount = amount;
        this.description = description;
    }

    public ReimbursementTicket(Employees employee, double amount, String description, String status) {
        this.employee = employee;
        this.amount = amount;
        this.description = description;
        this.status = status;
    }

    public ReimbursementTicket(String status) {
        this.status = status;
    }

    public ReimbursementTicket(Employees employee) {
        this.employee = employee;
    }

    public ReimbursementTicket() {
    }

    public ReimbursementTicket(int employee_id, double amount, String description, String status) {
        this.employee_id = employee_id;
        this.amount = amount;
        this.description = description;
        this.status = status;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public Employees getEmploy_id() {
        return employee;
    }

    public void setEmploy_id(Employees employee) {
        this.employee = employee;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "ReimbursementTicket{" +
                "ticket_id=" + ticket_id +
                ", employee_id=" + employee_id +
                ", employee=" + employee +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
