package com.revature.reimbursement.models;

import java.util.Objects;

public class Managers {
    private int man_id;
    private String fname;
    private String lname;
    private String email;
    private String username;
    private String password;
    private String department;

    public Managers(int man_id, String fname, String lname, String email, String username, String password, String department) {
        this.man_id = man_id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.department = department;
    }

    public Managers(String fname, String lname, String email, String username, String password, String department) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.department = department;
    }

    public Managers() {
    }

    public int getMan_id() {
        return man_id;
    }

    public void setMan_id(int man_id) {
        this.man_id = man_id;
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

    @Override
    public String toString() {
        return "Managers{" +
                "man_id=" + man_id +
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
        Managers managers = (Managers) o;
        return man_id == managers.man_id && fname.equals(managers.fname) && lname.equals(managers.lname) && email.equals(managers.email) && username.equals(managers.username) && password.equals(managers.password) && department.equals(managers.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(man_id, fname, lname, email, username, password, department);
    }
}
