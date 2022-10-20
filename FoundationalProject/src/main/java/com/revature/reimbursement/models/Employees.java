package com.revature.reimbursement.models;

import java.util.Objects;

public class Employees {

    private int employ_id;
    private String fname;
    private String lname;
    private String email;
    private String username;
    private String password;
    private String department;

    public Employees(int employ_id, String fname, String lname, String email, String username, String password, String department) {
        this.employ_id = employ_id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.department = department;
    }

    public Employees(String fname, String lname, String email, String username, String password, String department) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.department = department;
    }

    public Employees(String username, String password) {
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    //construct overrides here once I figure out what I need to override

    @Override
    public String toString() {
        return "Employees{" +
                "employ_id=" + employ_id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return employ_id == employees.employ_id && fname.equals(employees.fname) && lname.equals(employees.lname) && email.equals(employees.email) && username.equals(employees.username) && password.equals(employees.password) && department.equals(employees.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employ_id, fname, lname, email, username, password, department);
    }
}
