package com.revature.reimbursement.models;

public class Managers {
    private int man_id;
    private String fname;
    private String lname;
    private String email;
    private String department;

    public Managers(int man_id, String fname, String lname, String email, String department) {
        this.man_id = man_id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.department = department;
    }

    public Managers(int man_id) {
        this.man_id = man_id;
    }

    public Managers() {
    }

    public int getMan_id() {
        return man_id;
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
}
