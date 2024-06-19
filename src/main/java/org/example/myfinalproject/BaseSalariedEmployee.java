package org.example.myfinalproject;

import java.io.Serializable;
import java.time.LocalDate;

import static java.time.LocalDate.now;

public class BaseSalariedEmployee extends Employee implements Serializable, CalculateSalary{
    private double baseSalary;
    private double earning;

    public BaseSalariedEmployee(String firstName, String lastName, String nationalID, String phoneNumber, double managerBonus, LocalDate startDate, LocalDate birthdate, Department department, double baseSalary) {
        super(firstName, lastName, nationalID, phoneNumber, managerBonus, startDate, birthdate, department);
        this.baseSalary = baseSalary;
        this.earning = calculateSalary();
    }

    public BaseSalariedEmployee(String firstName, String lastName, String nationalID, String phoneNumber, LocalDate startDate, LocalDate birthdate, Department department, double baseSalary) {
        super(firstName, lastName, nationalID, phoneNumber, startDate, birthdate, department);
        this.baseSalary = baseSalary;
        this.earning = calculateSalary();
    }

    @Override
    public double calculateSalary() {
        return (getManagerBonus() + getBaseSalary());
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getEarning() {
        return earning;
    }

    public void setEarning(double earning) {
        this.earning = earning;
    }
}
