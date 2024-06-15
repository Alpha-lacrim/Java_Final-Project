package org.example.myfinalproject;

import java.io.Serializable;
import java.time.LocalDate;

public class CommissionSalariedEmployee extends Employee implements Serializable, CalculateSalary, MonthlyEarning {
    private double commissionRate;
    private double numberOfSales;

    public CommissionSalariedEmployee(String firstName, String lastName, String nationalID, String phoneNumber, double managerBonus, LocalDate startDate, LocalDate birthdate, Department department, double commissionRate, double numberOfSales) {
        super(firstName, lastName, nationalID, phoneNumber, managerBonus, startDate, birthdate, department);
        this.commissionRate = commissionRate;
        this.numberOfSales = numberOfSales;
    }

    public CommissionSalariedEmployee(String firstName, String lastName, String nationalID, String phoneNumber, LocalDate startDate, LocalDate birthdate, Department department, double commissionRate, double numberOfSales) {
        super(firstName, lastName, nationalID, phoneNumber, startDate, birthdate, department);
        this.commissionRate = commissionRate;
        this.numberOfSales = numberOfSales;
    }

    //set and get methods.
    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(double numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    @Override
    public double calculateSalary() {
        return getManagerBonus() + (getNumberOfSales() * getCommissionRate());
    }

    @Override
    public double monthlyEarning() {
        return calculateSalary() * 30;
    }
}
