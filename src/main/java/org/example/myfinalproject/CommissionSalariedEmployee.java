package org.example.myfinalproject;

import java.io.Serializable;
import java.time.LocalDate;

public class CommissionSalariedEmployee extends Employee implements Serializable, CalculateSalary, MonthlyEarning {
    private double commissionRate;
    private int numberOfSales;
    private double earning;

    public CommissionSalariedEmployee(String firstName, String lastName, String nationalID,
                                      String phoneNumber, double managerBonus, LocalDate startDate,
                                      LocalDate birthdate, Department department, double commissionRate, int numberOfSales) {

        super(firstName, lastName, nationalID, phoneNumber, managerBonus, startDate, birthdate, department);
        this.commissionRate = commissionRate;
        this.numberOfSales = numberOfSales;
        this.earning = monthlyEarning();
    }

    public CommissionSalariedEmployee(String firstName, String lastName, String nationalID,
                                      String phoneNumber, LocalDate startDate, LocalDate birthdate,
                                      Department department, double commissionRate, int numberOfSales) {

        super(firstName, lastName, nationalID, phoneNumber, startDate, birthdate, department);
        this.commissionRate = commissionRate;
        this.numberOfSales = numberOfSales;
        this.earning = monthlyEarning();
    }

    //set and get methods.
    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    public double getEarning() {
        return earning;
    }

    public void setEarning(double earning) {
        this.earning = earning;
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
