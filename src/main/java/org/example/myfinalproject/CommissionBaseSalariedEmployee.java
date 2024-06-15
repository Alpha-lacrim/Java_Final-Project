package org.example.myfinalproject;

import java.io.Serializable;
import java.time.LocalDate;

public class CommissionBaseSalariedEmployee extends CommissionSalariedEmployee implements Serializable, Salary {
    private double baseSalary;
    private double CommissionRate;
    private double numberOfSales;

    public CommissionBaseSalariedEmployee(String firstName, String lastName, String nationalID, String phoneNumber, double managerBonus, LocalDate startDate, LocalDate birthdate, Department department, double baseSalary, double commissionRate, double numberOfSales) {
        super(firstName, lastName, nationalID, phoneNumber, managerBonus, startDate, birthdate, department, commissionRate, numberOfSales);
        this.baseSalary = baseSalary;
        CommissionRate = commissionRate;
        this.numberOfSales = numberOfSales;
    }

    public CommissionBaseSalariedEmployee(String firstName, String lastName, String nationalID, String phoneNumber, LocalDate startDate, LocalDate birthdate, Department department, double baseSalary, double commissionRate, double numberOfSales) {
        super(firstName, lastName, nationalID, phoneNumber, startDate, birthdate, department, commissionRate, numberOfSales);
        this.baseSalary = baseSalary;
        CommissionRate = commissionRate;
        this.numberOfSales = numberOfSales;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getCommissionRate() {
        return CommissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        CommissionRate = commissionRate;
    }

    public double getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(double numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    @Override
    public double calculateSalary() {
        return getManagerBonus() + getBaseSalary() + (getCommissionRate() * getNumberOfSales());
    }

    @Override
    public double monthlyEarning() {
        return calculateSalary() * 30;
    }
}
