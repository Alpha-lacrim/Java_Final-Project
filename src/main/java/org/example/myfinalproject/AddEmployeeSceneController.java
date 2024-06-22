package org.example.myfinalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddEmployeeSceneController implements Initializable {
    //Department variables.
    File departmentFile = new File("Department.txt");
    ObservableList<Department> departmentObservableList;
    ArrayList<Department> departmentArrayList = new ArrayList<>();

    // Status combobox
    ObservableList<Status> statusObservableList;
    ArrayList<Status> statusArrayList = new ArrayList<>();


    // Employee base salary variables.
    @FXML
    private TableView<BaseSalariedEmployee> employeeBaseSalaryTable;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> employeeBaseSalaryBirthColumn;

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

    File baseSalariedFile = new File("BaseSalaried.txt");
    ObservableList<BaseSalariedEmployee> employeeBaseSalariedEmployeeObservableList;
    ArrayList<BaseSalariedEmployee> baseSalariedArrayList = new ArrayList<>();
    ArrayList<BaseSalariedEmployee> employeeBaseSalariedArrayList = new ArrayList<>();

    // Employee hourly salaried variables.
    @FXML
    private TableColumn<HourlySalariedEmployee, Double> employeeHourlySalaryAmountOfHoursColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> employeeHourlySalaryBirthColumn;

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
    private TableView<HourlySalariedEmployee> employeeHourlySalaryTable;

    File hourlySalaryFile = new File("HourlySalaried.txt");
    ObservableList<HourlySalariedEmployee> employeeHourlySalariedEmployeeObservableList;
    ArrayList<HourlySalariedEmployee> hourlySalariedArrayList = new ArrayList<>();
    ArrayList<HourlySalariedEmployee> employeeHourlySalariedArrayList = new ArrayList<>();

    // Employee commission salaried variables.
    @FXML
    private TableView<CommissionSalariedEmployee> employeeCommissionSalaryTable;

    @FXML
    private TableColumn<CommissionSalariedEmployee,String> employeeCommissionSalaryBirthColumn;

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

    File commissionSalaryFile = new File("CommissionSalaried.txt");
    ObservableList<CommissionSalariedEmployee> employeeCommissionSalariedEmployeeObservableList;
    ArrayList<CommissionSalariedEmployee> commissionSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionSalariedEmployee> employeeCommissionSalariedArrayList = new ArrayList<>();

    // Employee commission base salaried variables.
    @FXML
    private TableView<CommissionBaseSalariedEmployee> employeeCommissionBaseTable;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> employeeCommissionBaseBirthColumn;

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

    File commissionBaseSalaryFile = new File("CommissionBaseSalaried.txt");
    ObservableList<CommissionBaseSalariedEmployee> employeeCommissionBaseSalariedEmployeeObservableList;
    ArrayList<CommissionBaseSalariedEmployee> commissionBaseSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionBaseSalariedEmployee> employeeCommissionBaseSalariedArrayList = new ArrayList<>();

    // constant textFields in add employee Scene.

    @FXML
    private TextField nameField;

    @FXML
    private TextField familyField;

    @FXML
    private TextField nationalIdField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField baseSalaryField;

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private ComboBox<Department> DepartmentCombo;

    @FXML
    private ComboBox<Status> statusCombo;

    @FXML
    private TextField PayPerHourField;

    @FXML
    private TextField amountOfHoursField;

    @FXML
    private TextField commissionRateField;

    @FXML
    private TextField numberOfSalesField;

    @FXML
    private TextField commissionRateField2;

    @FXML
    private TextField numberOfSalesField2;

    @FXML
    private ComboBox<String> employeePickTypeCombo;

    @FXML
    private Button employeeApplyButton;



    ObservableList<String> typeOfEmployee = FXCollections.observableArrayList("base-salaried","hourly-salaried",
            "commission-salaried","base-commission salaried");

    @FXML
    void onAddEmployeeButton(ActionEvent event) {
        var type = (String) employeePickTypeCombo.getSelectionModel().getSelectedItem();

        try {
            var department = (Department) DepartmentCombo.getSelectionModel().getSelectedItem();

            switch (type) {
                case "base-salaried":
                    // Creating an instance of Base Salaried employee
                        var baseSalariedEmp = new BaseSalariedEmployee(
                                nameField.getText(), familyField.getText(),
                                nationalIdField.getText(), phoneField.getText(),
                                LocalDate.now(), birthDatePicker.getValue(),
                                department, Double.parseDouble(baseSalaryField.getText())
                        );
                        departmentWriteToFile();
                        baseSalariedArrayList.add(baseSalariedEmp);
                        employeeBaseSalariedArrayList.add(baseSalariedEmp);
                        employeeBaseSalariedEmployeeObservableList = employeeBaseSalaryTable.getItems();
                        employeeBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(employeeBaseSalariedArrayList);
                        employeeBaseSalaryTable.setItems(employeeBaseSalariedEmployeeObservableList);
                        baseSalaryWriteToFile();
                        // Preset value of text boxes.
                        nameField.setText("");
                        familyField.setText("");
                        nationalIdField.setText("");
                        phoneField.setText("");
                        birthDatePicker.setValue(null);
                        baseSalaryField.setText("");
                    break;

                case "hourly-salaried":
                    // Creating an instance of Hourly Salaried employee
                        var hourlySalariedEmp = new HourlySalariedEmployee(
                                nameField.getText(), familyField.getText(),
                                nationalIdField.getText(), phoneField.getText(),
                                LocalDate.now(), birthDatePicker.getValue(), department,
                                Double.parseDouble(PayPerHourField.getText()),
                                Double.parseDouble(amountOfHoursField.getText())
                        );
                        departmentWriteToFile();
                        hourlySalariedArrayList.add(hourlySalariedEmp);
                        employeeHourlySalariedArrayList.add(hourlySalariedEmp);
                        employeeHourlySalariedEmployeeObservableList = employeeHourlySalaryTable.getItems();
                        employeeHourlySalariedEmployeeObservableList = FXCollections.observableArrayList(employeeHourlySalariedArrayList);
                        employeeHourlySalaryTable.setItems(employeeHourlySalariedEmployeeObservableList);
                        hourlySalaryWriteToFile();
                        // Preset value of text boxes.
                        nameField.setText("");
                        familyField.setText("");
                        nationalIdField.setText("");
                        phoneField.setText("");
                        birthDatePicker.setValue(null);
                        PayPerHourField.setText("");
                        amountOfHoursField.setText("");
                    break;

                case "commission-salaried":
                    // Creating an instance of Commission Salaried employee
                        var commissionSalariedEmp = new CommissionSalariedEmployee(
                                nameField.getText(),familyField.getText(), nationalIdField.getText(),
                                phoneField.getText(), LocalDate.now(),birthDatePicker.getValue(),
                                department, Double.parseDouble(commissionRateField.getText()),
                                Integer.parseInt(numberOfSalesField.getText())
                        );
                        departmentWriteToFile();
                        commissionSalariedArrayList.add(commissionSalariedEmp);
                        employeeCommissionSalariedArrayList.add(commissionSalariedEmp);
                        employeeCommissionSalariedEmployeeObservableList = employeeCommissionSalaryTable.getItems();
                        employeeCommissionSalariedEmployeeObservableList = FXCollections.observableArrayList(employeeCommissionSalariedArrayList);
                        employeeCommissionSalaryTable.setItems(employeeCommissionSalariedEmployeeObservableList);
                        commissionSalaryWriteToFile();
                        // Preset value of text boxes.
                        nameField.setText("");
                        familyField.setText("");
                        nationalIdField.setText("");
                        phoneField.setText("");
                        birthDatePicker.setValue(null);
                        commissionRateField.setText("");
                        numberOfSalesField.setText("");
                    break;

                case "base-commission salaried":
                    // Creating an instance of Base Plus Commission Salaried employee
                        var commissionBaseSalariedEmp = new CommissionBaseSalariedEmployee(nameField.getText(),familyField.getText(),
                                nationalIdField.getText(), phoneField.getText(), LocalDate.now(),
                                birthDatePicker.getValue(), department,
                                Double.parseDouble(baseSalaryField.getText()),
                                Double.parseDouble(commissionRateField2.getText()),
                                Integer.parseInt(numberOfSalesField2.getText())
                        );
                        departmentWriteToFile();
                        commissionBaseSalariedArrayList.add(commissionBaseSalariedEmp);
                        employeeCommissionBaseSalariedArrayList.add(commissionBaseSalariedEmp);
                        employeeCommissionBaseSalariedEmployeeObservableList = employeeCommissionBaseTable.getItems();
                        employeeCommissionBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(employeeCommissionBaseSalariedArrayList);
                        employeeCommissionBaseTable.setItems(employeeCommissionBaseSalariedEmployeeObservableList);
                        commissionBaseSalaryWriteToFile();
                        // Preset value of text boxes.
                        nameField.setText("");
                        familyField.setText("");
                        nationalIdField.setText("");
                        phoneField.setText("");
                        birthDatePicker.setValue(null);
                        baseSalaryField.setText("");
                        commissionRateField2.setText("");
                        numberOfSalesField2.setText("");
                    break;

                default:
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ComboBox ERROR !");
                    alert.setContentText("Something went wrong while using the Type of Employee combobox ...");
                    alert.showAndWait();
            }
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("SELECTION ERROR!");
            alert.setContentText("Select a Salary Type and a Department for the Employee ...");
            alert.showAndWait();
        }
    }

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
            stage.show();
        }
    }

    @FXML
    void onEditButton(ActionEvent event) throws IOException {
        statusCombo.setVisible(true);
        employeeApplyButton.setVisible(true);
    }

    @FXML
    void onEmployeePickTypeCombo(ActionEvent event) {
        switch (employeePickTypeCombo.getValue()) {
            case "base-salaried":
                employeeBaseSalaryTable.setVisible(true);
                baseSalaryField.setVisible(true);
                employeeHourlySalaryTable.setVisible(false);
                PayPerHourField.setVisible(false);
                amountOfHoursField.setVisible(false);
                commissionRateField.setVisible(false);
                numberOfSalesField.setVisible(false);
                employeeCommissionSalaryTable.setVisible(false);
                employeeCommissionBaseTable.setVisible(false);
                numberOfSalesField2.setVisible(false);
                commissionRateField2.setVisible(false);
                break;

            case "base-commission salaried":
                employeeBaseSalaryTable.setVisible(false);
                baseSalaryField.setVisible(true);
                employeeHourlySalaryTable.setVisible(false);
                PayPerHourField.setVisible(false);
                amountOfHoursField.setVisible(false);
                commissionRateField.setVisible(false);
                numberOfSalesField.setVisible(false);
                employeeCommissionSalaryTable.setVisible(false);
                employeeCommissionBaseTable.setVisible(true);
                numberOfSalesField2.setVisible(true);
                commissionRateField2.setVisible(true);
                break;

            case "hourly-salaried":
                employeeBaseSalaryTable.setVisible(false);
                baseSalaryField.setVisible(false);
                employeeHourlySalaryTable.setVisible(true);
                PayPerHourField.setVisible(true);
                amountOfHoursField.setVisible(true);
                commissionRateField.setVisible(false);
                numberOfSalesField.setVisible(false);
                employeeCommissionSalaryTable.setVisible(false);
                employeeCommissionBaseTable.setVisible(false);
                numberOfSalesField2.setVisible(false);
                commissionRateField2.setVisible(false);
                break;

            case "commission-salaried":
                employeeBaseSalaryTable.setVisible(false);
                baseSalaryField.setVisible(false);
                employeeHourlySalaryTable.setVisible(false);
                PayPerHourField.setVisible(false);
                amountOfHoursField.setVisible(false);
                commissionRateField.setVisible(true);
                numberOfSalesField.setVisible(true);
                employeeCommissionSalaryTable.setVisible(true);
                employeeCommissionBaseTable.setVisible(false);
                numberOfSalesField2.setVisible(false);
                commissionRateField2.setVisible(false);
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Setting Base Salaried Employee tableview.
        employeeBaseSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        employeeBaseSalaryEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        employeeBaseSalaryBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        employeeBaseSalaryFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        employeeBaseSalaryIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        employeeBaseSalaryNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        employeeBaseSalaryNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        employeeBaseSalaryPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        employeeBaseSalaryDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        baseSalaryReadFromFile();

        // Setting Base Salaried Employee tableview.
        employeeHourlySalaryAmountOfHoursColumn.setCellValueFactory(new PropertyValueFactory<>("amountOfHours"));
        employeeHourlySalaryBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        employeeHourlySalaryDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        employeeHourlySalaryEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        employeeHourlySalaryFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        employeeHourlySalaryIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        employeeHourlySalaryNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        employeeHourlySalaryNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        employeeHourlySalaryPayColumn.setCellValueFactory(new PropertyValueFactory<>("payPerHour"));
        employeeHourlySalaryPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        hourlySalaryReadFromFile();

        // Setting Commission Salaried Employee tableview.
        employeeCommissionSalaryBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        employeeCommissionSalaryDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        employeeCommissionSalaryEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        employeeCommissionSalaryFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        employeeCommissionSalaryIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        employeeCommissionSalaryNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        employeeCommissionSalaryNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        employeeCommissionSalaryPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        employeeCommissionSalaryRateColumn.setCellValueFactory(new PropertyValueFactory<>("commissionRate"));
        employeeCommissionSalarySalesColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfSales"));
        commissionSalaryReadFromFile();

        // Setting Base + Commission Salaried Employee tableview.
        employeeCommissionBaseBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
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
        commissionBaseSalaryReadFromFile();

        // Initializing Department comboBox and type selection comboBox.
        departmentReadFromFile();
        employeePickTypeCombo.setItems(typeOfEmployee);
        DepartmentCombo.setItems(departmentObservableList);

        // Initializing Status Combobox
        statusArrayList.add(Status.NO_PAY_DISMISSAL);
        statusArrayList.add(Status.FIRED);
        statusArrayList.add(Status.RETIRED);
        statusArrayList.add(Status.END_OF_CONTRACT);
        statusArrayList.add(Status.HAS_CHANGED);
        statusObservableList = FXCollections.observableArrayList(statusArrayList);
        statusCombo.setItems(statusObservableList);

        statusCombo.setVisible(false);
        employeeApplyButton.setVisible(false);
    }

    // Department read and write to file methods.
    private void departmentReadFromFile() {
        if(departmentFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(departmentFile));
                departmentArrayList = (ArrayList<Department>) ois.readObject();
                ois.close();
                departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nothing to show !");
                alert.setContentText("There is no department to show ...");
                alert.showAndWait();
            }
        }
    }

    private void departmentWriteToFile() {
        try {
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream(departmentFile));
            oos.writeObject(departmentArrayList);
            oos.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR !");
            alert.setContentText("Something went wrong while trying to write in Department file ...");
            alert.showAndWait();
        }
    }

    // Base Salary read and write to file methods.
    private void baseSalaryReadFromFile() {

        if(baseSalariedFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(baseSalariedFile));
                baseSalariedArrayList = (ArrayList<BaseSalariedEmployee>) ois.readObject();
                for (BaseSalariedEmployee emp : baseSalariedArrayList) {
                    if (!emp.isManager() && !employeeBaseSalariedArrayList.contains(emp)) {
                        employeeBaseSalariedArrayList.add(emp);
                    }
                }
                ois.close();
                employeeBaseSalariedEmployeeObservableList = employeeBaseSalaryTable.getItems();
                employeeBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(employeeBaseSalariedArrayList);
                employeeBaseSalaryTable.setItems(employeeBaseSalariedEmployeeObservableList);
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nothing to show !");
                alert.setContentText("There is no base Salaried Employee in this department ...");
                alert.showAndWait();
            }
        }
    }

    private void baseSalaryWriteToFile(){
        try {
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream(baseSalariedFile));
            oos.writeObject(baseSalariedArrayList);
            oos.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR !");
            alert.setContentText("Something went wrong while trying to write in Base Salary file ...");
            alert.showAndWait();
        }
    }

    // hourly salary read and write to file.
    private void hourlySalaryReadFromFile(){
        if(hourlySalaryFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(hourlySalaryFile));
                hourlySalariedArrayList = (ArrayList<HourlySalariedEmployee>) ois.readObject();
                for (HourlySalariedEmployee emp : hourlySalariedArrayList) {
                    if (!emp.isManager() && !employeeHourlySalariedArrayList.contains(emp)) {
                        employeeHourlySalariedArrayList.add(emp);
                    }
                }
                ois.close();
                employeeHourlySalariedEmployeeObservableList = employeeHourlySalaryTable.getItems();
                employeeHourlySalariedEmployeeObservableList = FXCollections.observableArrayList(employeeHourlySalariedArrayList);
                employeeHourlySalaryTable.setItems(employeeHourlySalariedEmployeeObservableList);
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nothing to show !");
                alert.setContentText("There is no hourly Salaried Employee in this department ...");
                alert.showAndWait();
            }
        }
    }

    private void hourlySalaryWriteToFile(){
        try {
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream(hourlySalaryFile));
            oos.writeObject(hourlySalariedArrayList);
            oos.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR !");
            alert.setContentText("Something went wrong while trying to write in hourly Salary file ...");
            alert.showAndWait();
        }
    }

    // Commission Salary read and write to file.
    private void commissionSalaryReadFromFile(){
        if(commissionSalaryFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(commissionSalaryFile));
                commissionSalariedArrayList = (ArrayList<CommissionSalariedEmployee>) ois.readObject();
                for (CommissionSalariedEmployee emp : commissionSalariedArrayList) {
                    if (!emp.isManager() && !employeeCommissionSalariedArrayList.contains(emp)) {
                        employeeCommissionSalariedArrayList.add(emp);
                    }
                }
                ois.close();
                employeeCommissionSalariedEmployeeObservableList = employeeCommissionSalaryTable.getItems();
                employeeCommissionSalariedEmployeeObservableList = FXCollections.observableArrayList(employeeCommissionSalariedArrayList);
                employeeCommissionSalaryTable.setItems(employeeCommissionSalariedEmployeeObservableList);
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nothing to show !");
                alert.setContentText("There is no commission Salaried Employee in this department ...");
                alert.showAndWait();
            }
        }
    }

    private void commissionSalaryWriteToFile(){
        try {
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream(commissionSalaryFile));
            oos.writeObject(commissionSalariedArrayList);
            oos.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR !");
            alert.setContentText("Something went wrong while trying to write in commission Salary file ...");
            alert.showAndWait();
        }
    }

    //Commission base salary read and write to file.
    private void commissionBaseSalaryReadFromFile(){
        if(commissionBaseSalaryFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(commissionBaseSalaryFile));
                commissionBaseSalariedArrayList = (ArrayList<CommissionBaseSalariedEmployee>) ois.readObject();
                for (CommissionBaseSalariedEmployee emp : commissionBaseSalariedArrayList) {
                    if (!emp.isManager() && !employeeCommissionBaseSalariedArrayList.contains(emp)) {
                        employeeCommissionBaseSalariedArrayList.add(emp);
                    }
                }
                ois.close();
                employeeCommissionBaseSalariedEmployeeObservableList = employeeCommissionBaseTable.getItems();
                employeeCommissionBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(employeeCommissionBaseSalariedArrayList);
                employeeCommissionBaseTable.setItems(employeeCommissionBaseSalariedEmployeeObservableList);
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nothing to show !");
                alert.setContentText("There is no Commission Base Salaried Employee in this department ...");
                alert.showAndWait();
            }
        }
    }

    private void commissionBaseSalaryWriteToFile(){
        try {
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream(commissionBaseSalaryFile));
            oos.writeObject(commissionBaseSalariedArrayList);
            oos.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR !");
            alert.setContentText("Something went wrong while trying to write in Commission Base Salary file ...");
            alert.showAndWait();
        }
    }
}
