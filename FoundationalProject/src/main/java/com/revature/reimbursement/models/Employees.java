package com.revature.reimbursement.models;

public class Employees {
    private int employ_id;
    private String fname;
    private String lname;
    private String email;
    private String department;
    private int manager;

    public Employees(int employ_id, String fname, String lname, String email, String department, int manager) {
        this.employ_id = employ_id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.department = department;
        this.manager = manager;
    }

    public Employees(int employ_id) {
        this.employ_id = employ_id;
    }

    public Employees() {
    }

    public int getEmploy_id() {
        return employ_id;
    }

    public void setEmploy_id(int employ_id) {
        this.employ_id = employ_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
        /*
        have a conditional saying something like if department equals management to set manager, that way only managers
        can change who is managing what employees
         */
    }

    //construct overrides here once I figure out what I need to override
}
