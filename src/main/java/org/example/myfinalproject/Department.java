package org.example.myfinalproject;

import java.io.Serializable;
import java.time.LocalDate;

public class Department implements Serializable {
    private String name;
    private final String date;
    protected int numberOfEmployees;
    protected boolean hasManager;


    public Department(String name, LocalDate date) {
        this.name = name;
        this.date = date.toString();
        this.hasManager = false;
    }

    //get and set methods.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public boolean isHasManager() {
        return hasManager;
    }

    public void setHasManager(boolean hasManager) {
        this.hasManager = hasManager;
    }
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return getName();
    }
}
