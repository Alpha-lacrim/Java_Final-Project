package org.example.myfinalproject;

import java.time.LocalDate;

public abstract class Employee {
    private final String firstName;
    private final String lastName;
    private int ID;
    private final String nationalID;
    private String phoneNumber;
    private boolean isManger;
    private double managerBonus;
    private final String startDate;
    private String endDate;
    private final String birthDate;
    private Department department;

    public Employee(String firstName,String lastName,String nationalID,String phoneNumber,double managerBonus,LocalDate startDate,LocalDate birthdate,Department department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = department.numberOfEmployees + 1;
        this.nationalID = nationalID;
        this.phoneNumber = phoneNumber;
        this.isManger = true;
        this.managerBonus = managerBonus;
        this.department = department;
        this.startDate = startDate.toString();
        this.endDate = null;
        this.birthDate = birthdate.toString();
        department.hasManager = true;
        department.numberOfEmployees++;
    }
    public Employee(String firstName,String lastName,String nationalID,String phoneNumber,LocalDate startDate,LocalDate birthdate,Department department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = department.numberOfEmployees+1;
        this.nationalID = nationalID;
        this.phoneNumber = phoneNumber;
        this.managerBonus = 0;
        this.department = department;
        this.startDate = startDate.toString();
        this.endDate = null;
        this.birthDate = birthdate.toString();
        department.numberOfEmployees++;
    }

    public abstract double calculateSalary();
    public abstract double calculateMonthlySalary();

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isManger() {
        return isManger;
    }

    public void setManger(boolean manger) {
        isManger = manger;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getManagerBonus() {
        return managerBonus;
    }

    public void setManagerBonus(double managerBonus) {
        this.managerBonus = managerBonus;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
