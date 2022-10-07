package com.revature.reimbursement.models;

import java.util.Objects;

public class ReimbursementTicket {
    private int employ_id;
    private double amount;
    private String description;
    private String status;

    public ReimbursementTicket(int employ_id, double amount, String description) {
        this.employ_id = employ_id;
        this.amount = amount;
        this.description = description;
    }

    public ReimbursementTicket(int employ_id, double amount, String description, String status) {
        this.employ_id = employ_id;
        this.amount = amount;
        this.description = description;
        this.status = status;
    }

    public ReimbursementTicket(String status) {
        this.status = status;
    }

    public ReimbursementTicket(int employ_id) {
        this.employ_id = employ_id;
    }

    public ReimbursementTicket() {
    }

    public int getEmploy_id() {
        return employ_id;
    }

    public void setEmploy_id(int employ_id) {
        this.employ_id = employ_id;
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
                "employ_id=" + employ_id +
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
        return employ_id == that.employ_id && Double.compare(that.amount, amount) == 0 && description.equals(that.description) && status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employ_id, amount, description, status);
    }
}
