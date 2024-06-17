package org.example.myfinalproject;

import java.io.Serializable;
import java.time.LocalDate;

public class CommissionBaseSalariedEmployee extends CommissionSalariedEmployee implements Serializable, CalculateSalary, MonthlyEarning {
    private double baseSalary;

    public CommissionBaseSalariedEmployee(String firstName, String lastName, String nationalID,
                                          String phoneNumber, double managerBonus, LocalDate startDate,
                                          LocalDate birthdate, Department department, double baseSalary,
                                          double commissionRate, int numberOfSales) {

        super(firstName, lastName, nationalID, phoneNumber, managerBonus, startDate, birthdate, department, commissionRate, numberOfSales);
        this.baseSalary = baseSalary;
    }

    public CommissionBaseSalariedEmployee(String firstName, String lastName, String nationalID,
                                          String phoneNumber, LocalDate startDate, LocalDate birthdate,
                                          Department department, double baseSalary, double commissionRate, int numberOfSales) {

        super(firstName, lastName, nationalID, phoneNumber, startDate, birthdate, department, commissionRate, numberOfSales);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
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
