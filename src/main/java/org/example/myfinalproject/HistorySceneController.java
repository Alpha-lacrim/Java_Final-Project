package org.example.myfinalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class HistorySceneController implements Initializable {
    //file and variables for base salaried.
    File baseSalariedFile = new File("BaseSalaried.txt");
    ArrayList<BaseSalariedEmployee> baseSalariedArrayList = new ArrayList<>();
    ArrayList<BaseSalariedEmployee> employeeBaseSalariedArrayList = new ArrayList<>();
    ArrayList<BaseSalariedEmployee> managerBaseSalariedArraylist = new ArrayList<>();

    ArrayList<BaseSalariedEmployee> nonFilteredManagerBaseSalariedArraylist = new ArrayList<>();
    ArrayList<BaseSalariedEmployee> nonFilteredEmployeeBaseSalariedArraylist = new ArrayList<>();

    ArrayList<BaseSalariedEmployee> dateFilteredManagerBaseSalariedArraylist = new ArrayList<>();
    ArrayList<BaseSalariedEmployee> dateFilteredEmployeeBaseSalariedArraylist = new ArrayList<>();

    ArrayList<BaseSalariedEmployee> departmentFilteredManagerBaseSalariedArraylist = new ArrayList<>();
    ArrayList<BaseSalariedEmployee> departmentFilteredEmployeeBaseSalariedArraylist = new ArrayList<>();

    ObservableList<BaseSalariedEmployee> managerBaseSalariedObservableList;
    ObservableList<BaseSalariedEmployee> employeeBaseSalariedObservableList;


    @FXML
    private TableView<BaseSalariedEmployee> employeeBaseSalaryTable;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> employeeBaseSalaryBirthColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Status> employeeBaseSalaryStatusColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> employeeBaseSalaryEndDateColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> employeeBaseSalaryStartDateColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Double> employeeBaseSalaryColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Department> employeeBaseSalaryDepartmentColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Double> employeeBaseSalaryEarningColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> employeeBaseSalaryFamilyColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Integer> employeeBaseSalaryIdColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> employeeBaseSalaryNameColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> employeeBaseSalaryNationalColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> employeeBaseSalaryPhoneColumn;


    @FXML
    private TableView<BaseSalariedEmployee> managerBaseSalaryTable;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalaryBirthColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalaryStartDateColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Status> managerBaseSalaryStatusColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalaryEndDateColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Double> managerBaseSalaryBonusColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Double> managerBaseSalaryColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Department> managerBaseSalaryDepartmentColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Double> managerBaseSalaryEarningColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalaryFamilyColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Integer> managerBaseSalaryIdColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalaryNameColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalaryNationalColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalaryPhoneColumn;




    //file and variables for hourly salaried.
    File hourlySalaryFile = new File("HourlySalaried.txt");
    ArrayList<HourlySalariedEmployee> hourlySalariedArrayList = new ArrayList<>();
    ArrayList<HourlySalariedEmployee> employeeHourlySalariedArrayList = new ArrayList<>();
    ArrayList<HourlySalariedEmployee> managerHourlySalariedArraylist = new ArrayList<>();

    ArrayList<HourlySalariedEmployee> nonFilteredManagerHourlySalariedArraylist = new ArrayList<>();
    ArrayList<HourlySalariedEmployee> nonFilteredEmployeeHourlySalariedArraylist = new ArrayList<>();

    ArrayList<HourlySalariedEmployee> dateFilteredManagerHourlySalariedArraylist = new ArrayList<>();
    ArrayList<HourlySalariedEmployee> dateFilteredEmployeeHourlySalariedArraylist = new ArrayList<>();

    ArrayList<HourlySalariedEmployee> departmentFilteredManagerHourlySalariedArraylist = new ArrayList<>();
    ArrayList<HourlySalariedEmployee> departmentFilteredEmployeeHourlySalariedArraylist = new ArrayList<>();

    ObservableList<HourlySalariedEmployee> managerHourlySalariedObservableList;
    ObservableList<HourlySalariedEmployee> employeeHourlySalariedObservableList;

    @FXML
    private TableView<HourlySalariedEmployee> employeeHourlySalaryTable;

    @FXML
    private TableColumn<HourlySalariedEmployee, Double> employeeHourlySalaryAmountOfHoursColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> employeeHourlySalaryBirthColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> employeeHourlySalaryStartDateColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String > employeeHourlySalaryStatusColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> employeeHourlySalaryEndDateColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, Department> employeeHourlySalaryDepartmentColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, Double> employeeHourlySalaryEarningColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> employeeHourlySalaryFamilyColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, Integer> employeeHourlySalaryIdColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> employeeHourlySalaryNameColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> employeeHourlySalaryNationalColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, Double> employeeHourlySalaryPayColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> employeeHourlySalaryPhoneColumn;



    @FXML
    private TableColumn<HourlySalariedEmployee, Double> managerHourlySalaryAmountOfHoursColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> managerHourlySalaryBirthColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> managerHourlySalaryEndDateColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> managerHourlySalaryStartDateColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, Status> managerHourlySalaryStatusColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, Double> managerHourlySalaryBonusColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, Department> managerHourlySalaryDepartmentColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, Double> managerHourlySalaryEarningColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> managerHourlySalaryFamilyColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, Integer> managerHourlySalaryIdColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> managerHourlySalaryNameColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> managerHourlySalaryNationalColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, Double> managerHourlySalaryPayColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> managerHourlySalaryPhoneColumn;

    @FXML
    private TableView<HourlySalariedEmployee> managerHourlySalaryTable;

    // file and variables for commission salaried.
    File commissionSalaryFile = new File("CommissionSalaried.txt");
    ArrayList<CommissionSalariedEmployee> commissionSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionSalariedEmployee> employeeCommissionSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionSalariedEmployee> managerCommissionSalariedArrayList = new ArrayList<>();

    ArrayList<CommissionSalariedEmployee> nonFilteredManagerCommissionSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionSalariedEmployee> nonFilteredEmployeeCommissionSalariedArrayList = new ArrayList<>();

    ArrayList<CommissionSalariedEmployee> dateFilteredManagerCommissionSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionSalariedEmployee> dateFilteredEmployeeCommissionSalariedArrayList = new ArrayList<>();

    ArrayList<CommissionSalariedEmployee> departmentFilteredManagerCommissionSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionSalariedEmployee> departmentFilteredEmployeeCommissionSalariedArrayList = new ArrayList<>();

    ObservableList<CommissionSalariedEmployee> managerCommissionSalariedObservableList;
    ObservableList<CommissionSalariedEmployee> employeeCommissionSalariedObservableList;


    @FXML
    private TableView<CommissionSalariedEmployee> employeeCommissionSalaryTable;

    @FXML
    private TableColumn<CommissionSalariedEmployee,String> employeeCommissionSalaryBirthColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee, String> employeeCommissionSalaryStartDateColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee, Status> employeeCommissionSalaryStatusColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee, String> employeeCommissionSalaryEndDateColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,Department> employeeCommissionSalaryDepartmentColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,Double> employeeCommissionSalaryEarningColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,String> employeeCommissionSalaryFamilyColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,Integer> employeeCommissionSalaryIdColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,String> employeeCommissionSalaryNameColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,String> employeeCommissionSalaryNationalColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,String> employeeCommissionSalaryPhoneColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,Double> employeeCommissionSalaryRateColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,Integer> employeeCommissionSalarySalesColumn;


    @FXML
    private TableView<CommissionSalariedEmployee> managerCommissionSalaryTable;

    @FXML
    private TableColumn<CommissionSalariedEmployee,String> managerCommissionSalaryBirthColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee, String> managerCommissionSalaryStartDateColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee, Status> managerCommissionSalaryStatusColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee, String> managerCommissionSalaryEndDateColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,Double> managerCommissionSalaryBonusColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,Department> managerCommissionSalaryDepartmentColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,Double> managerCommissionSalaryEarningColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,String> managerCommissionSalaryFamilyColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,Integer> managerCommissionSalaryIdColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,String> managerCommissionSalaryNameColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,String> managerCommissionSalaryNationalColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,String> managerCommissionSalaryPhoneColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,Double> managerCommissionSalaryRateColumn;

    @FXML
    private TableColumn<CommissionSalariedEmployee,Integer> managerCommissionSalarySalesColumn;

    //file and variables for commission base salaried.
    File commissionBaseSalaryFile = new File("CommissionBaseSalaried.txt");
    ArrayList<CommissionBaseSalariedEmployee> commissionBaseSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionBaseSalariedEmployee> employeeCommissionBaseSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionBaseSalariedEmployee> managerCommissionBaseSalariedArraylist = new ArrayList<>();

    ArrayList<CommissionBaseSalariedEmployee> nonFilteredEmployeeCommissionBaseSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionBaseSalariedEmployee> nonFilteredManagerCommissionBaseSalariedArrayList = new ArrayList<>();

    ArrayList<CommissionBaseSalariedEmployee> dateFilteredEmployeeCommissionBaseSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionBaseSalariedEmployee> dateFilteredManagerCommissionBaseSalariedArrayList = new ArrayList<>();

    ArrayList<CommissionBaseSalariedEmployee> departmentFilteredEmployeeCommissionBaseSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionBaseSalariedEmployee> departmentFilteredManagerCommissionBaseSalariedArrayList = new ArrayList<>();

    ObservableList<CommissionBaseSalariedEmployee> managerCommissionBaseSalariedObservableList;
    ObservableList<CommissionBaseSalariedEmployee> employeeCommissionBaseSalariedObservableList;

    @FXML
    private TableView<CommissionBaseSalariedEmployee> employeeCommissionBaseTable;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> employeeCommissionBaseBirthColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, String> employeeCommissionBaseEndDateColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, String> employeeCommissionBaseStartDateColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, Status> employeeCommissionBaseStatusColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,Department> employeeCommissionBaseDepartmentColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,Double> employeeCommissionBaseEarningColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> employeeCommissionBaseFamilyColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,Integer> employeeCommissionBaseIdColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> employeeCommissionBaseNameColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> employeeCommissionBaseNationalColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, Integer> employeeCommissionBaseNumberOfSalesColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, String> employeeCommissionBasePhoneColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, Double> employeeCommissionBaseRateColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, Double> employeeCommissionBaseSalaryColumn;



    @FXML
    private TableView<CommissionBaseSalariedEmployee> managerCommissionBaseTable;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> managerCommissionBaseBirthColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, String> managerCommissionBaseStartDateColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, Status> managerCommissionBaseStatusColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, String> managerCommissionBaseEndDateColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,Double> managerCommissionBaseBonusColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,Department> managerCommissionBaseDepartmentColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,Double> managerCommissionBaseEarningColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> managerCommissionBaseFamilyColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,Integer> managerCommissionBaseIdColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> managerCommissionBaseNameColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> managerCommissionBaseNationalColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, Integer> managerCommissionBaseNumberOfSalesColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, String> managerCommissionBasePhoneColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, Double> managerCommissionBaseRateColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, Double> managerCommissionBaseSalaryColumn;

    //variables for searching.
    @FXML
    private TextField nameField;

    @FXML
    private TextField familyNameField;

    @FXML
    private TextField nationalIdField;

    @FXML
    private DatePicker inputStartDatePicker;

    @FXML
    private DatePicker inputEndDatePicker;

    @FXML
    private CheckBox dateFilterCheckBox;

    @FXML
    private CheckBox showAllFilterCheckBox;

    @FXML
    private CheckBox departmentFilterCheckBox;

    @FXML
    private TextField departmentNameField;

    @FXML
    private ComboBox<String> pickTypeCombo;

    ObservableList<String> typeOfEmployee = FXCollections.observableArrayList("Manager Hourly Salaried","Manager Base Salaried",
            "Manager Commission Salaried","Manager Base-Commission Salaried","Base Salaried","Hourly Salaried",
            "Commission Salaried","Base-Commission Salaried");

    //-----------------------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        baseSalaryReadFromFile();
        hourlySalaryReadFromFile();
        commissionSalaryReadFromFile();
        commissionBaseSalaryReadFromFile();

        pickTypeCombo.setItems(typeOfEmployee);
        inputEndDatePicker.setVisible(false);
        inputStartDatePicker.setVisible(false);

        //initialize manager base salary table.
        managerBaseSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        managerBaseSalaryEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        managerBaseSalaryBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        managerBaseSalaryStartDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        managerBaseSalaryEndDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        managerBaseSalaryStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        managerBaseSalaryBonusColumn.setCellValueFactory(new PropertyValueFactory<>("managerBonus"));
        managerBaseSalaryFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        managerBaseSalaryIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        managerBaseSalaryNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        managerBaseSalaryNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        managerBaseSalaryPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        managerBaseSalaryDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

        //initialize employee base salary table.
        employeeBaseSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        employeeBaseSalaryEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        employeeBaseSalaryBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        employeeBaseSalaryStartDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        employeeBaseSalaryEndDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        employeeBaseSalaryStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        employeeBaseSalaryFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        employeeBaseSalaryIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        employeeBaseSalaryNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        employeeBaseSalaryNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        employeeBaseSalaryPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        employeeBaseSalaryDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

        //initialize manager hourly salary table.
        managerHourlySalaryAmountOfHoursColumn.setCellValueFactory(new PropertyValueFactory<>("amountOfHours"));
        managerHourlySalaryBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        managerHourlySalaryStartDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        managerHourlySalaryEndDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        managerHourlySalaryStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        managerHourlySalaryBonusColumn.setCellValueFactory(new PropertyValueFactory<>("managerBonus"));
        managerHourlySalaryDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        managerHourlySalaryEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        managerHourlySalaryFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        managerHourlySalaryIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        managerHourlySalaryNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        managerHourlySalaryNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        managerHourlySalaryPayColumn.setCellValueFactory(new PropertyValueFactory<>("payPerHour"));
        managerHourlySalaryPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        //initialize employee hourly salary table.
        employeeHourlySalaryAmountOfHoursColumn.setCellValueFactory(new PropertyValueFactory<>("amountOfHours"));
        employeeHourlySalaryBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        employeeHourlySalaryStartDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        employeeHourlySalaryEndDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        employeeHourlySalaryStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        employeeHourlySalaryDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        employeeHourlySalaryEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        employeeHourlySalaryFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        employeeHourlySalaryIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        employeeHourlySalaryNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        employeeHourlySalaryNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        employeeHourlySalaryPayColumn.setCellValueFactory(new PropertyValueFactory<>("payPerHour"));
        employeeHourlySalaryPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        //initialize manager commission salary table.
        managerCommissionSalaryBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        managerCommissionSalaryStartDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        managerCommissionSalaryEndDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        managerCommissionSalaryStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        managerCommissionSalaryBonusColumn.setCellValueFactory(new PropertyValueFactory<>("managerBonus"));
        managerCommissionSalaryDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        managerCommissionSalaryEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        managerCommissionSalaryFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        managerCommissionSalaryIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        managerCommissionSalaryNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        managerCommissionSalaryNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        managerCommissionSalaryPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        managerCommissionSalaryRateColumn.setCellValueFactory(new PropertyValueFactory<>("commissionRate"));
        managerCommissionSalarySalesColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfSales"));

        //initialize employee commission salary table.
        employeeCommissionSalaryBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        employeeCommissionSalaryStartDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        employeeCommissionSalaryEndDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        employeeCommissionSalaryStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        employeeCommissionSalaryDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        employeeCommissionSalaryEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        employeeCommissionSalaryFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        employeeCommissionSalaryIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        employeeCommissionSalaryNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        employeeCommissionSalaryNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        employeeCommissionSalaryPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        employeeCommissionSalaryRateColumn.setCellValueFactory(new PropertyValueFactory<>("commissionRate"));
        employeeCommissionSalarySalesColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfSales"));

        //initialize manager commission Base salary table.
        managerCommissionBaseBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        managerCommissionBaseStartDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        managerCommissionBaseEndDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        managerCommissionBaseStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        managerCommissionBaseBonusColumn.setCellValueFactory(new PropertyValueFactory<>("managerBonus"));
        managerCommissionBaseDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        managerCommissionBaseEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        managerCommissionBaseFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        managerCommissionBaseIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        managerCommissionBaseNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        managerCommissionBaseNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        managerCommissionBaseNumberOfSalesColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfSales"));
        managerCommissionBasePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        managerCommissionBaseRateColumn.setCellValueFactory(new PropertyValueFactory<>("commissionRate"));
        managerCommissionBaseSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));

        //initialize employee commission base salary table.
        employeeCommissionBaseBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        employeeCommissionBaseStartDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        employeeCommissionBaseEndDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        employeeCommissionBaseStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        employeeCommissionBaseDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        employeeCommissionBaseEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        employeeCommissionBaseFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        employeeCommissionBaseIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        employeeCommissionBaseNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        employeeCommissionBaseNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        employeeCommissionBaseNumberOfSalesColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfSales"));
        employeeCommissionBasePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        employeeCommissionBaseRateColumn.setCellValueFactory(new PropertyValueFactory<>("commissionRate"));
        employeeCommissionBaseSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
    }

    @FXML
    void onDateFilterCheckBox(ActionEvent event) throws IOException {
        if (dateFilterCheckBox.isSelected()) {
            departmentFilterCheckBox.setDisable(true);
            inputEndDatePicker.setVisible(true);
            inputStartDatePicker.setVisible(true);
            inputEndDatePicker.setValue(null);
            inputStartDatePicker.setValue(null);
        }
        else {
            inputEndDatePicker.setVisible(false);
            inputStartDatePicker.setVisible(false);
            departmentFilterCheckBox.setDisable(false);
        }
    }

    @FXML
    void onDepartmentFilterCheckBox(ActionEvent event) {
        if (departmentFilterCheckBox.isSelected()) {
            dateFilterCheckBox.setDisable(true);
            inputEndDatePicker.setVisible(false);
            inputStartDatePicker.setVisible(false);
            departmentNameField.setVisible(true);
        }
        else {
            dateFilterCheckBox.setDisable(false);
            departmentNameField.setVisible(false);
            departmentNameField.setText("");
        }
    }

    @FXML
    void onShowAllFilterCheckBox(ActionEvent event) {
        if (showAllFilterCheckBox.isSelected()) {
            dateFilterCheckBox.setDisable(true);
            departmentFilterCheckBox.setDisable(true);
        }
        else {
            dateFilterCheckBox.setDisable(false);
            departmentFilterCheckBox.setDisable(false);
        }
    }

//    @FXML
//    void onSalaryHistoryCheckBox(ActionEvent event) throws IOException {
//        if (salaryHistoryCheckBox.isSelected()) {
//            salaryHistoryLineChart.setVisible(true);
//
//            if (salaryHistoryLineChart.getData() != null) {
//                salaryHistoryLineChart.getData().clear();
//            }
//        }
//
//        else {
//            salaryHistoryLineChart.setVisible(false);
//        }
//    }

    @FXML
    void onBackButton(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Are you sure you want to go back?");
        alert.showAndWait();
        if(alert.getResult().equals(ButtonType.OK)){
            Stage stage;
            Scene scene;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
        }
    }

    @FXML
    void onPickTypeComboBox(ActionEvent event) {
        switch (pickTypeCombo.getValue()){
            case "Manager Hourly Salaried":
                managerHourlySalaryTable.setVisible(true);
                managerBaseSalaryTable.setVisible(false);
                managerCommissionSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(false);
                employeeHourlySalaryTable.setVisible(false);
                employeeBaseSalaryTable.setVisible(false);
                employeeCommissionSalaryTable.setVisible(false);
                employeeCommissionBaseTable.setVisible(false);
                break;
            case "Manager Base Salaried":
                managerHourlySalaryTable.setVisible(false);
                managerBaseSalaryTable.setVisible(true);
                managerCommissionSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(false);
                employeeHourlySalaryTable.setVisible(false);
                employeeBaseSalaryTable.setVisible(false);
                employeeCommissionSalaryTable.setVisible(false);
                employeeCommissionBaseTable.setVisible(false);
                break;
            case "Manager Commission Salaried":
                managerHourlySalaryTable.setVisible(false);
                managerBaseSalaryTable.setVisible(false);
                managerCommissionSalaryTable.setVisible(true);
                managerCommissionBaseTable.setVisible(false);
                employeeHourlySalaryTable.setVisible(false);
                employeeBaseSalaryTable.setVisible(false);
                employeeCommissionSalaryTable.setVisible(false);
                employeeCommissionBaseTable.setVisible(false);
                break;
            case "Manager Base-Commission Salaried":
                managerHourlySalaryTable.setVisible(false);
                managerBaseSalaryTable.setVisible(false);
                managerCommissionSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(true);
                employeeHourlySalaryTable.setVisible(false);
                employeeBaseSalaryTable.setVisible(false);
                employeeCommissionSalaryTable.setVisible(false);
                employeeCommissionBaseTable.setVisible(false);
                break;
            case "Base Salaried":
                managerHourlySalaryTable.setVisible(false);
                managerBaseSalaryTable.setVisible(false);
                managerCommissionSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(false);
                employeeHourlySalaryTable.setVisible(false);
                employeeBaseSalaryTable.setVisible(true);
                employeeCommissionSalaryTable.setVisible(false);
                employeeCommissionBaseTable.setVisible(false);
                break;
            case "Hourly Salaried":
                managerHourlySalaryTable.setVisible(false);
                managerBaseSalaryTable.setVisible(false);
                managerCommissionSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(false);
                employeeHourlySalaryTable.setVisible(true);
                employeeBaseSalaryTable.setVisible(false);
                employeeCommissionSalaryTable.setVisible(false);
                employeeCommissionBaseTable.setVisible(false);
                break;
            case "Commission Salaried":
                managerHourlySalaryTable.setVisible(false);
                managerBaseSalaryTable.setVisible(false);
                managerCommissionSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(false);
                employeeHourlySalaryTable.setVisible(false);
                employeeBaseSalaryTable.setVisible(false);
                employeeCommissionSalaryTable.setVisible(true);
                employeeCommissionBaseTable.setVisible(false);
                break;
            case "Base-Commission Salaried":
                managerHourlySalaryTable.setVisible(false);
                managerBaseSalaryTable.setVisible(false);
                managerCommissionSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(false);
                employeeHourlySalaryTable.setVisible(false);
                employeeBaseSalaryTable.setVisible(false);
                employeeCommissionSalaryTable.setVisible(false);
                employeeCommissionBaseTable.setVisible(true);
                break;
        }
    }

    @FXML
    void onSearchButton(ActionEvent event) {
        //first resetting table views.
        managerHourlySalaryTable.getItems().clear();
        managerBaseSalaryTable.getItems().clear();
        managerCommissionSalaryTable.getItems().clear();
        managerCommissionBaseTable.getItems().clear();
        employeeHourlySalaryTable.getItems().clear();
        employeeBaseSalaryTable.getItems().clear();
        employeeCommissionSalaryTable.getItems().clear();
        employeeCommissionBaseTable.getItems().clear();

        nonFilteredEmployeeBaseSalariedArraylist.clear();
        nonFilteredManagerBaseSalariedArraylist.clear();
        nonFilteredEmployeeHourlySalariedArraylist.clear();
        nonFilteredManagerHourlySalariedArraylist.clear();
        nonFilteredEmployeeCommissionSalariedArrayList.clear();
        nonFilteredManagerCommissionSalariedArrayList.clear();
        nonFilteredEmployeeCommissionBaseSalariedArrayList.clear();
        nonFilteredManagerCommissionBaseSalariedArrayList.clear();

        dateFilteredEmployeeBaseSalariedArraylist.clear();
        dateFilteredManagerBaseSalariedArraylist.clear();
        dateFilteredEmployeeHourlySalariedArraylist.clear();
        dateFilteredManagerHourlySalariedArraylist.clear();
        dateFilteredEmployeeCommissionSalariedArrayList.clear();
        dateFilteredManagerCommissionSalariedArrayList.clear();
        dateFilteredEmployeeCommissionBaseSalariedArrayList.clear();
        dateFilteredManagerCommissionBaseSalariedArrayList.clear();

        departmentFilteredEmployeeBaseSalariedArraylist.clear();
        departmentFilteredManagerBaseSalariedArraylist.clear();
        departmentFilteredEmployeeHourlySalariedArraylist.clear();
        departmentFilteredManagerHourlySalariedArraylist.clear();
        departmentFilteredEmployeeCommissionSalariedArrayList.clear();
        departmentFilteredManagerCommissionSalariedArrayList.clear();
        departmentFilteredEmployeeCommissionBaseSalariedArrayList.clear();
        departmentFilteredManagerCommissionBaseSalariedArrayList.clear();

        // initialize table views.
        if(!nameField.getText().equals("") && !familyNameField.getText().equals("") && !nationalIdField.getText().equals("")) {
            if (showAllFilterCheckBox.isSelected()) {
                if (baseSalariedFile.isFile()) {
                    for (BaseSalariedEmployee emp : employeeBaseSalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())) {
                            nonFilteredEmployeeBaseSalariedArraylist.add(emp);
                        }
                    }
                    for (BaseSalariedEmployee emp : managerBaseSalariedArraylist) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())) {
                            nonFilteredManagerBaseSalariedArraylist.add(emp);
                        }
                    }
                    managerBaseSalariedObservableList = managerBaseSalaryTable.getItems();
                    employeeBaseSalariedObservableList = employeeBaseSalaryTable.getItems();

                    managerBaseSalariedObservableList = FXCollections.observableArrayList(nonFilteredManagerBaseSalariedArraylist);
                    employeeBaseSalariedObservableList = FXCollections.observableArrayList(nonFilteredEmployeeBaseSalariedArraylist);

                    managerBaseSalaryTable.setItems(managerBaseSalariedObservableList);
                    employeeBaseSalaryTable.setItems(employeeBaseSalariedObservableList);
                }

                if (hourlySalaryFile.isFile()) {
                    for (HourlySalariedEmployee emp : employeeHourlySalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())) {
                            nonFilteredEmployeeHourlySalariedArraylist.add(emp);
                        }
                    }
                    for (HourlySalariedEmployee emp : managerHourlySalariedArraylist) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())) {
                            nonFilteredManagerHourlySalariedArraylist.add(emp);
                        }
                    }

                    managerHourlySalariedObservableList = managerHourlySalaryTable.getItems();
                    employeeHourlySalariedObservableList = employeeHourlySalaryTable.getItems();

                    managerHourlySalariedObservableList = FXCollections.observableArrayList(nonFilteredManagerHourlySalariedArraylist);
                    employeeHourlySalariedObservableList = FXCollections.observableArrayList(nonFilteredEmployeeHourlySalariedArraylist);

                    managerHourlySalaryTable.setItems(managerHourlySalariedObservableList);
                    employeeHourlySalaryTable.setItems(employeeHourlySalariedObservableList);
                }

                if (commissionSalaryFile.isFile()) {
                    for (CommissionSalariedEmployee emp : employeeCommissionSalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())) {
                            nonFilteredEmployeeCommissionSalariedArrayList.add(emp);
                        }
                    }
                    for (CommissionSalariedEmployee emp : managerCommissionSalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())) {
                            nonFilteredManagerCommissionSalariedArrayList.add(emp);
                        }
                    }

                    managerCommissionSalariedObservableList = managerCommissionSalaryTable.getItems();
                    employeeCommissionSalariedObservableList = employeeCommissionSalaryTable.getItems();

                    managerCommissionSalariedObservableList = FXCollections.observableArrayList(nonFilteredManagerCommissionSalariedArrayList);
                    managerCommissionSalaryTable.setItems(managerCommissionSalariedObservableList);

                    employeeCommissionSalariedObservableList = FXCollections.observableArrayList(nonFilteredEmployeeCommissionSalariedArrayList);
                    employeeCommissionSalaryTable.setItems(employeeCommissionSalariedObservableList);

                }

                if (commissionBaseSalaryFile.isFile()) {
                    for (CommissionBaseSalariedEmployee emp : employeeCommissionBaseSalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())) {
                            nonFilteredEmployeeCommissionBaseSalariedArrayList.add(emp);
                        }
                    }
                    for (CommissionBaseSalariedEmployee emp : managerCommissionBaseSalariedArraylist) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())) {
                            nonFilteredManagerCommissionBaseSalariedArrayList.add(emp);
                        }
                    }

                    managerCommissionBaseSalariedObservableList = managerCommissionBaseTable.getItems();
                    employeeCommissionBaseSalariedObservableList = employeeCommissionBaseTable.getItems();

                    managerCommissionBaseSalariedObservableList = FXCollections.observableArrayList(nonFilteredManagerCommissionBaseSalariedArrayList);
                    employeeCommissionBaseSalariedObservableList = FXCollections.observableArrayList(nonFilteredEmployeeCommissionBaseSalariedArrayList);

                    managerCommissionBaseTable.setItems(managerCommissionBaseSalariedObservableList);
                    employeeCommissionBaseTable.setItems(employeeCommissionBaseSalariedObservableList);
                }
            } else if (dateFilterCheckBox.isSelected()) {
                if (baseSalariedFile.isFile()) {
                    for (BaseSalariedEmployee emp : employeeBaseSalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && LocalDate.parse(emp.getStartDate()).isAfter(inputStartDatePicker.getValue())
                                && LocalDate.parse(emp.getEndDate()).isBefore(inputEndDatePicker.getValue())) {
                            dateFilteredEmployeeBaseSalariedArraylist.add(emp);
                        }
                    }
                    for (BaseSalariedEmployee emp : managerBaseSalariedArraylist) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && LocalDate.parse(emp.getStartDate()).isAfter(inputStartDatePicker.getValue())
                                && LocalDate.parse(emp.getEndDate()).isBefore(inputEndDatePicker.getValue())) {
                            dateFilteredManagerBaseSalariedArraylist.add(emp);
                        }
                    }
                    managerBaseSalariedObservableList = managerBaseSalaryTable.getItems();
                    employeeBaseSalariedObservableList = employeeBaseSalaryTable.getItems();

                    managerBaseSalariedObservableList = FXCollections.observableArrayList(dateFilteredManagerBaseSalariedArraylist);
                    employeeBaseSalariedObservableList = FXCollections.observableArrayList(dateFilteredEmployeeBaseSalariedArraylist);

                    managerBaseSalaryTable.setItems(managerBaseSalariedObservableList);
                    employeeBaseSalaryTable.setItems(employeeBaseSalariedObservableList);
                }

                if (hourlySalaryFile.isFile()) {
                    for (HourlySalariedEmployee emp : employeeHourlySalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && LocalDate.parse(emp.getStartDate()).isAfter(inputStartDatePicker.getValue())
                                && LocalDate.parse(emp.getEndDate()).isBefore(inputEndDatePicker.getValue())) {
                            dateFilteredEmployeeHourlySalariedArraylist.add(emp);
                        }
                    }
                    for (HourlySalariedEmployee emp : managerHourlySalariedArraylist) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && LocalDate.parse(emp.getStartDate()).isAfter(inputStartDatePicker.getValue())
                                && LocalDate.parse(emp.getEndDate()).isBefore(inputEndDatePicker.getValue())) {
                            dateFilteredManagerHourlySalariedArraylist.add(emp);
                        }
                    }

                    managerHourlySalariedObservableList = managerHourlySalaryTable.getItems();
                    employeeHourlySalariedObservableList = employeeHourlySalaryTable.getItems();

                    managerHourlySalariedObservableList = FXCollections.observableArrayList(dateFilteredManagerHourlySalariedArraylist);
                    employeeHourlySalariedObservableList = FXCollections.observableArrayList(dateFilteredEmployeeHourlySalariedArraylist);

                    managerHourlySalaryTable.setItems(managerHourlySalariedObservableList);
                    employeeHourlySalaryTable.setItems(employeeHourlySalariedObservableList);
                }

                if (commissionSalaryFile.isFile()) {
                    for (CommissionSalariedEmployee emp : employeeCommissionSalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && LocalDate.parse(emp.getStartDate()).isAfter(inputStartDatePicker.getValue())
                                && LocalDate.parse(emp.getEndDate()).isBefore(inputEndDatePicker.getValue())) {
                            dateFilteredEmployeeCommissionSalariedArrayList.add(emp);
                        }
                    }
                    for (CommissionSalariedEmployee emp : managerCommissionSalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && LocalDate.parse(emp.getStartDate()).isAfter(inputStartDatePicker.getValue())
                                && LocalDate.parse(emp.getEndDate()).isBefore(inputEndDatePicker.getValue())) {
                            dateFilteredManagerCommissionSalariedArrayList.add(emp);
                        }
                    }

                    managerCommissionSalariedObservableList = managerCommissionSalaryTable.getItems();
                    employeeCommissionSalariedObservableList = employeeCommissionSalaryTable.getItems();

                    managerCommissionSalariedObservableList = FXCollections.observableArrayList(dateFilteredManagerCommissionSalariedArrayList);
                    managerCommissionSalaryTable.setItems(managerCommissionSalariedObservableList);

                    employeeCommissionSalariedObservableList = FXCollections.observableArrayList(dateFilteredEmployeeCommissionSalariedArrayList);
                    employeeCommissionSalaryTable.setItems(employeeCommissionSalariedObservableList);

                }

                if (commissionBaseSalaryFile.isFile()) {
                    for (CommissionBaseSalariedEmployee emp : employeeCommissionBaseSalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && LocalDate.parse(emp.getStartDate()).isAfter(inputStartDatePicker.getValue())
                                && LocalDate.parse(emp.getEndDate()).isBefore(inputEndDatePicker.getValue())) {
                            dateFilteredEmployeeCommissionBaseSalariedArrayList.add(emp);
                        }
                    }
                    for (CommissionBaseSalariedEmployee emp : managerCommissionBaseSalariedArraylist) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && LocalDate.parse(emp.getStartDate()).isAfter(inputStartDatePicker.getValue())
                                && LocalDate.parse(emp.getEndDate()).isBefore(inputEndDatePicker.getValue())) {
                            dateFilteredManagerCommissionBaseSalariedArrayList.add(emp);
                        }
                    }

                    managerCommissionBaseSalariedObservableList = managerCommissionBaseTable.getItems();
                    employeeCommissionBaseSalariedObservableList = employeeCommissionBaseTable.getItems();

                    managerCommissionBaseSalariedObservableList = FXCollections.observableArrayList(dateFilteredManagerCommissionBaseSalariedArrayList);
                    employeeCommissionBaseSalariedObservableList = FXCollections.observableArrayList(dateFilteredEmployeeCommissionBaseSalariedArrayList);

                    managerCommissionBaseTable.setItems(managerCommissionBaseSalariedObservableList);
                    employeeCommissionBaseTable.setItems(employeeCommissionBaseSalariedObservableList);
                }
            } else if (departmentFilterCheckBox.isSelected()) {
                if (baseSalariedFile.isFile()) {
                    for (BaseSalariedEmployee emp : employeeBaseSalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && emp.getDepartment().getName().equals(departmentNameField.getText())) {
                            departmentFilteredEmployeeBaseSalariedArraylist.add(emp);
                        }
                    }
                    for (BaseSalariedEmployee emp : managerBaseSalariedArraylist) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && emp.getDepartment().getName().equals(departmentNameField.getText())) {
                            departmentFilteredManagerBaseSalariedArraylist.add(emp);
                        }
                    }
                    managerBaseSalariedObservableList = managerBaseSalaryTable.getItems();
                    employeeBaseSalariedObservableList = employeeBaseSalaryTable.getItems();

                    managerBaseSalariedObservableList = FXCollections.observableArrayList(departmentFilteredManagerBaseSalariedArraylist);
                    employeeBaseSalariedObservableList = FXCollections.observableArrayList(departmentFilteredEmployeeBaseSalariedArraylist);

                    managerBaseSalaryTable.setItems(managerBaseSalariedObservableList);
                    employeeBaseSalaryTable.setItems(employeeBaseSalariedObservableList);
                }

                if (hourlySalaryFile.isFile()) {
                    for (HourlySalariedEmployee emp : employeeHourlySalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && emp.getDepartment().getName().equals(departmentNameField.getText())) {
                            departmentFilteredEmployeeHourlySalariedArraylist.add(emp);
                        }
                    }
                    for (HourlySalariedEmployee emp : managerHourlySalariedArraylist) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && emp.getDepartment().getName().equals(departmentNameField.getText())) {
                            departmentFilteredManagerHourlySalariedArraylist.add(emp);
                        }
                    }

                    managerHourlySalariedObservableList = managerHourlySalaryTable.getItems();
                    employeeHourlySalariedObservableList = employeeHourlySalaryTable.getItems();

                    managerHourlySalariedObservableList = FXCollections.observableArrayList(departmentFilteredManagerHourlySalariedArraylist);
                    employeeHourlySalariedObservableList = FXCollections.observableArrayList(departmentFilteredEmployeeHourlySalariedArraylist);

                    managerHourlySalaryTable.setItems(managerHourlySalariedObservableList);
                    employeeHourlySalaryTable.setItems(employeeHourlySalariedObservableList);
                }

                if (commissionSalaryFile.isFile()) {
                    for (CommissionSalariedEmployee emp : employeeCommissionSalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && emp.getDepartment().getName().equals(departmentNameField.getText())) {
                            departmentFilteredEmployeeCommissionSalariedArrayList.add(emp);
                        }
                    }
                    for (CommissionSalariedEmployee emp : managerCommissionSalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && emp.getDepartment().getName().equals(departmentNameField.getText())) {
                            departmentFilteredManagerCommissionSalariedArrayList.add(emp);
                        }
                    }

                    managerCommissionSalariedObservableList = managerCommissionSalaryTable.getItems();
                    employeeCommissionSalariedObservableList = employeeCommissionSalaryTable.getItems();

                    managerCommissionSalariedObservableList = FXCollections.observableArrayList(departmentFilteredManagerCommissionSalariedArrayList);
                    managerCommissionSalaryTable.setItems(managerCommissionSalariedObservableList);

                    employeeCommissionSalariedObservableList = FXCollections.observableArrayList(departmentFilteredEmployeeCommissionSalariedArrayList);
                    employeeCommissionSalaryTable.setItems(employeeCommissionSalariedObservableList);

                }

                if (commissionBaseSalaryFile.isFile()) {
                    for (CommissionBaseSalariedEmployee emp : employeeCommissionBaseSalariedArrayList) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && emp.getDepartment().getName().equals(departmentNameField.getText())) {
                            departmentFilteredEmployeeCommissionBaseSalariedArrayList.add(emp);
                        }
                    }
                    for (CommissionBaseSalariedEmployee emp : managerCommissionBaseSalariedArraylist) {
                        if (emp.getFirstName().equals(nameField.getText()) && emp.getLastName().equals(familyNameField.getText())
                                && emp.getNationalID().matches(nationalIdField.getText())
                                && emp.getDepartment().getName().equals(departmentNameField.getText())) {
                            departmentFilteredManagerCommissionBaseSalariedArrayList.add(emp);
                        }
                    }

                    managerCommissionBaseSalariedObservableList = managerCommissionBaseTable.getItems();
                    employeeCommissionBaseSalariedObservableList = employeeCommissionBaseTable.getItems();

                    managerCommissionBaseSalariedObservableList = FXCollections.observableArrayList(departmentFilteredManagerCommissionBaseSalariedArrayList);
                    employeeCommissionBaseSalariedObservableList = FXCollections.observableArrayList(departmentFilteredEmployeeCommissionBaseSalariedArrayList);

                    managerCommissionBaseTable.setItems(managerCommissionBaseSalariedObservableList);
                    employeeCommissionBaseTable.setItems(employeeCommissionBaseSalariedObservableList);
                }
            } else if (!showAllFilterCheckBox.isSelected() && !dateFilterCheckBox.isSelected() && !departmentFilterCheckBox.isSelected()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Please choose one option to filter");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please fill the fields for searching");
            alert.showAndWait();
        }

    }


    //methods for reading from file.
    private void baseSalaryReadFromFile() {

        if(baseSalariedFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(baseSalariedFile));
                baseSalariedArrayList = (ArrayList<BaseSalariedEmployee>) ois.readObject();
                for (BaseSalariedEmployee emp : baseSalariedArrayList) {
                    if (!emp.isManager() && !emp.isActive() && !employeeBaseSalariedArrayList.contains(emp)) {
                        employeeBaseSalariedArrayList.add(emp);
                    } else if (emp.isManager() && !emp.isActive() && !employeeBaseSalariedArrayList.contains(emp) ) {
                        managerBaseSalariedArraylist.add(emp);
                    }
                }
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nothing to show !");
                alert.setContentText("There is no base Salaried Employee in this department ...");
                alert.showAndWait();
            }
        }
    }

    private void hourlySalaryReadFromFile(){
        if(hourlySalaryFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(hourlySalaryFile));
                hourlySalariedArrayList = (ArrayList<HourlySalariedEmployee>) ois.readObject();
                for (HourlySalariedEmployee emp : hourlySalariedArrayList) {
                    if (!emp.isManager() && !emp.isActive() && !employeeHourlySalariedArrayList.contains(emp)) {
                        employeeHourlySalariedArrayList.add(emp);
                    } else if (emp.isManager() && !emp.isActive() && !employeeHourlySalariedArrayList.contains(emp)) {
                        managerHourlySalariedArraylist.add(emp);
                    }
                }
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nothing to show !");
                alert.setContentText("There is no hourly Salaried Employee in this department ...");
                alert.showAndWait();
            }
        }
    }

    private void commissionSalaryReadFromFile(){
        if(commissionSalaryFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(commissionSalaryFile));
                commissionSalariedArrayList = (ArrayList<CommissionSalariedEmployee>) ois.readObject();
                for (CommissionSalariedEmployee emp : commissionSalariedArrayList) {
                    if (!emp.isManager() && !emp.isActive() && !employeeCommissionSalariedArrayList.contains(emp)) {
                        employeeCommissionSalariedArrayList.add(emp);
                    } else if(emp.isManager() && !emp.isActive() && !employeeCommissionSalariedArrayList.contains(emp)){
                        managerCommissionSalariedArrayList.add(emp);
                    }
                }
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nothing to show !");
                alert.setContentText("There is no commission Salaried Employee in this department ...");
                alert.showAndWait();
            }
        }
    }

    private void commissionBaseSalaryReadFromFile(){
        if(commissionBaseSalaryFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(commissionBaseSalaryFile));
                commissionBaseSalariedArrayList = (ArrayList<CommissionBaseSalariedEmployee>) ois.readObject();
                for (CommissionBaseSalariedEmployee emp : commissionBaseSalariedArrayList) {
                    if (!emp.isManager() && !emp.isActive() && !employeeCommissionBaseSalariedArrayList.contains(emp)) {
                        employeeCommissionBaseSalariedArrayList.add(emp);
                    } else if(emp.isManager() && !emp.isActive() && !employeeCommissionBaseSalariedArrayList.contains(emp)){
                        managerCommissionBaseSalariedArraylist.add(emp);
                    }
                }
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nothing to show !");
                alert.setContentText("There is no Commission Base Salaried Employee in this department ...");
                alert.showAndWait();
            }
        }
    }

//    private void refreshLineChart() {
//        salaryHistoryLineChart.getData().clear();
//        salaryHistoryLineChart.setAnimated(false);
//
//        XYChart.Series<String, Integer> series1 = new XYChart.Series();
//
//        for (int i = 0; i < arr.size(); i++) {
//            series1.getData().add(new XYChart.Data(.get(i).getName(), departmentArrayList.get(i).getNumberOfActiveEmployees()));
//        }
//        series1.setName("Salaries");
//
//        salaryHistoryLineChart.getData().addAll(series1);
//    }
}
