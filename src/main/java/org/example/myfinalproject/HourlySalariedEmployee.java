package org.example.myfinalproject;

import java.io.Serializable;
import java.time.LocalDate;

public class HourlySalariedEmployee extends Employee implements Serializable, CalculateSalary {
    private double payPerHour;
    private double amountOfHours;

    public HourlySalariedEmployee(String firstName, String lastName, String nationalID, String phoneNumber, double managerBonus, LocalDate startDate, LocalDate birthdate, Department department, double payPerHour, double amountOfHours) {
        super(firstName, lastName, nationalID, phoneNumber, managerBonus, startDate, birthdate, department);
        this.payPerHour = payPerHour;
        this.amountOfHours = amountOfHours;
    }

    public HourlySalariedEmployee(String firstName, String lastName, String nationalID, String phoneNumber, LocalDate startDate, LocalDate birthdate, Department department, double payPerHour, double amountOfHours) {
        super(firstName, lastName, nationalID, phoneNumber, startDate, birthdate, department);
        this.payPerHour = payPerHour;
        this.amountOfHours = amountOfHours;
    }

    public double getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }

    public double getAmountOfHours() {
        return amountOfHours;
    }

    public void setAmountOfHours(double amountOfHours) {
        this.amountOfHours = amountOfHours;
    }

    @Override
    public double calculateSalary() {
        return getManagerBonus() + (amountOfHours * payPerHour);
    }
}
