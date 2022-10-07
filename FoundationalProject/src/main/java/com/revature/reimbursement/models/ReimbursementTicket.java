package com.revature.reimbursement.models;

import java.util.Objects;

public class ReimbursementTicket {
    private Employees employee;
    private double amount;
    private String description;
    private String status;

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

    @Override
    public String toString() {
        return "ReimbursementTicket{" +
                "employee=" + employee +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementTicket that = (ReimbursementTicket) o;
        return employee == that.employee && Double.compare(that.amount, amount) == 0 && description.equals(that.description) && status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, amount, description, status);
    }
}
