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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

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
    private TextField managerBonusField;

    @FXML
    private TextField managerBonusField1;

    @FXML
    private TextField managerBonusField2;

    @FXML
    private ComboBox<String> employeePickTypeCombo;

    @FXML
    private Button applyButton;

    @FXML
    private Button applyButton2;

    @FXML
    private Button cancelButton;

    @FXML
    private Button cancelButton2;

    @FXML
    private Button deactiveButton;

    @FXML
    private Button editButton;

    @FXML
    private Button addEmployeeButton;

    @FXML
    private RadioButton employeeRadioButton;

    @FXML
    private RadioButton managerRadioButton;


    ObservableList<String> typeOfEmployee = FXCollections.observableArrayList("base-salaried", "hourly-salaried",
            "commission-salaried", "base-commission salaried");

    @FXML
    void onAddEmployeeButton(ActionEvent event) {
        var type = (String) employeePickTypeCombo.getSelectionModel().getSelectedItem();

        try {
            if (numericOnlyEmployeeTextFieldsChecker() && charOnlyTextFieldsChecker()) {
                var department = (Department) DepartmentCombo.getSelectionModel().getSelectedItem();

                switch (type) {
                    case "base-salaried":
                        if (isNumeric(baseSalaryField.getText())) {
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
                        }
                        else {
                            throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                        }
                        break;

                    case "hourly-salaried":
                        if (isNumeric(PayPerHourField.getText()) && isNumeric(amountOfHoursField.getText())) {
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
                        }
                        else {
                            throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                        }
                        break;

                    case "commission-salaried":
                        if (isNumeric(commissionRateField.getText()) && isNumeric(numberOfSalesField.getText())) {
                            // Creating an instance of Commission Salaried employee
                            var commissionSalariedEmp = new CommissionSalariedEmployee(
                                    nameField.getText(), familyField.getText(), nationalIdField.getText(),
                                    phoneField.getText(), LocalDate.now(), birthDatePicker.getValue(),
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
                        }
                        else {
                            throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                        }
                        break;

                    case "base-commission salaried":
                        if (isNumeric(baseSalaryField.getText()) && isNumeric(commissionRateField2.getText()) && isNumeric(numberOfSalesField2.getText())) {
                            // Creating an instance of Base Plus Commission Salaried employee
                            var commissionBaseSalariedEmp = new CommissionBaseSalariedEmployee(nameField.getText(), familyField.getText(),
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
                        }
                        else {
                            throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                        }
                        break;

                    default:
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("ComboBox ERROR !");
                        alert.setContentText("Something went wrong while using the Type of Employee combobox ...");
                        alert.showAndWait();
                }
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
    void onAddRandomEmployeeButton(ActionEvent event) {
        try {
            TextInputDialog tid = new TextInputDialog();
            tid.setTitle("number of random employees");
            tid.setHeaderText("Input Confirmation");
            tid.setContentText("Input number of employees");
            Optional<String> result = tid.showAndWait();
            if (result.isPresent()) {
                Random random = new Random();
                //int numberOfRandomEmployees = Integer.parseInt(tid.getEditor().getText());
                for (int i = 0; i < Integer.parseInt(result.get()); i++) {
                    int randForTypeOfEmployee = random.nextInt(4) + 1;
                    switch (randForTypeOfEmployee) {
                        case 1:
                            var baseSalariedEmp = new BaseSalariedEmployee(
                                    RandomEmployeeStorage.name[random.nextInt(10)], RandomEmployeeStorage.family[random.nextInt(10)],
                                    RandomEmployeeStorage.nationalId[random.nextInt(10)], RandomEmployeeStorage.phone[random.nextInt(10)],
                                    LocalDate.now(), RandomEmployeeStorage.birthDate[random.nextInt(10)],
                                    departmentArrayList.get(random.nextInt(departmentArrayList.size())), RandomEmployeeStorage.baseSalary[random.nextInt(10)]);

                            departmentWriteToFile();
                            baseSalariedArrayList.add(baseSalariedEmp);
                            employeeBaseSalariedArrayList.add(baseSalariedEmp);
                            employeeBaseSalariedEmployeeObservableList = employeeBaseSalaryTable.getItems();
                            employeeBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(employeeBaseSalariedArrayList);
                            employeeBaseSalaryTable.setItems(employeeBaseSalariedEmployeeObservableList);
                            baseSalaryWriteToFile();

                            break;
                        case 2:
                            var hourlySalariedEmp = new HourlySalariedEmployee(
                                    RandomEmployeeStorage.name[random.nextInt(10)], RandomEmployeeStorage.family[random.nextInt(10)],
                                    RandomEmployeeStorage.nationalId[random.nextInt(10)], RandomEmployeeStorage.phone[random.nextInt(10)],
                                    LocalDate.now(), RandomEmployeeStorage.birthDate[random.nextInt(10)],
                                    departmentArrayList.get(random.nextInt(departmentArrayList.size())),
                                    RandomEmployeeStorage.hourlyRate[random.nextInt(10)],
                                    RandomEmployeeStorage.amountOfHours[random.nextInt(10)]
                            );
                            departmentWriteToFile();
                            hourlySalariedArrayList.add(hourlySalariedEmp);
                            employeeHourlySalariedArrayList.add(hourlySalariedEmp);
                            employeeHourlySalariedEmployeeObservableList = employeeHourlySalaryTable.getItems();
                            employeeHourlySalariedEmployeeObservableList = FXCollections.observableArrayList(employeeHourlySalariedArrayList);
                            employeeHourlySalaryTable.setItems(employeeHourlySalariedEmployeeObservableList);
                            hourlySalaryWriteToFile();

                            break;
                        case 3:
                            var commissionSalariedEmp = new CommissionSalariedEmployee(
                                    RandomEmployeeStorage.name[random.nextInt(10)], RandomEmployeeStorage.family[random.nextInt(10)],
                                    RandomEmployeeStorage.nationalId[random.nextInt(10)],
                                    RandomEmployeeStorage.phone[random.nextInt(10)], LocalDate.now(),
                                    RandomEmployeeStorage.birthDate[random.nextInt(10)],
                                    departmentArrayList.get(random.nextInt(departmentArrayList.size())),
                                    RandomEmployeeStorage.commissionRate[random.nextInt(10)],
                                    RandomEmployeeStorage.numberOfSales[random.nextInt(10)]
                            );
                            departmentWriteToFile();
                            commissionSalariedArrayList.add(commissionSalariedEmp);
                            employeeCommissionSalariedArrayList.add(commissionSalariedEmp);
                            employeeCommissionSalariedEmployeeObservableList = employeeCommissionSalaryTable.getItems();
                            employeeCommissionSalariedEmployeeObservableList = FXCollections.observableArrayList(employeeCommissionSalariedArrayList);
                            employeeCommissionSalaryTable.setItems(employeeCommissionSalariedEmployeeObservableList);
                            commissionSalaryWriteToFile();

                            break;
                        case 4:
                            var commissionBaseSalariedEmp = new CommissionBaseSalariedEmployee(
                                    RandomEmployeeStorage.name[random.nextInt(10)], RandomEmployeeStorage.family[random.nextInt(10)],
                                    RandomEmployeeStorage.nationalId[random.nextInt(10)],
                                    RandomEmployeeStorage.phone[random.nextInt(10)], LocalDate.now(),
                                    RandomEmployeeStorage.birthDate[random.nextInt(10)],
                                    departmentArrayList.get(random.nextInt(departmentArrayList.size())),
                                    RandomEmployeeStorage.baseSalary[random.nextInt(10)],
                                    RandomEmployeeStorage.commissionRate[random.nextInt(10)],
                                    RandomEmployeeStorage.numberOfSales[random.nextInt(10)]
                            );
                            departmentWriteToFile();
                            commissionBaseSalariedArrayList.add(commissionBaseSalariedEmp);
                            employeeCommissionBaseSalariedArrayList.add(commissionBaseSalariedEmp);
                            employeeCommissionBaseSalariedEmployeeObservableList = employeeCommissionBaseTable.getItems();
                            employeeCommissionBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(employeeCommissionBaseSalariedArrayList);
                            employeeCommissionBaseTable.setItems(employeeCommissionBaseSalariedEmployeeObservableList);
                            commissionBaseSalaryWriteToFile();

                            break;
                    }
                }
            }
        }

        catch (InputMismatchException e) {
            throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
        }

        catch (Exception e) {
            throwAlert("There is no department or the input is wro", "ERROR!", "Please create a department first ...");
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
            stage.centerOnScreen();
            stage.show();
        }
    }

    @FXML
    void onEditButton(ActionEvent event) throws IOException {
        statusCombo.setVisible(false);
        applyButton.setVisible(true);
        cancelButton.setVisible(true);
        employeeRadioButton.setVisible(true);
        managerRadioButton.setVisible(true);
        managerRadioButton.setDisable(true);
        managerRadioButton.setSelected(false);
        employeeRadioButton.setSelected(true);
        employeeRadioButton.setDisable(false);

        switch (employeePickTypeCombo.getValue()) {
            case "base-salaried":
                employeePickTypeCombo.setEditable(false);
                nameField.setEditable(false);
                familyField.setEditable(false);
                nationalIdField.setEditable(false);
                phoneField.setEditable(false);
                birthDatePicker.setEditable(false);
                birthDatePicker.setDisable(true);
                baseSalaryField.setEditable(true);
                DepartmentCombo.setEditable(false);
                DepartmentCombo.setDisable(false);
                break;

            case "base-commission salaried":
                employeePickTypeCombo.setEditable(false);
                nameField.setEditable(false);
                familyField.setEditable(false);
                nationalIdField.setEditable(false);
                phoneField.setEditable(false);
                birthDatePicker.setEditable(false);
                birthDatePicker.setDisable(true);
                numberOfSalesField2.setEditable(true);
                baseSalaryField.setEditable(true);
                commissionRateField2.setEditable(true);
                DepartmentCombo.setEditable(false);
                DepartmentCombo.setDisable(false);
                break;

            case "hourly-salaried":
                employeePickTypeCombo.setEditable(false);
                nameField.setEditable(false);
                familyField.setEditable(false);
                nationalIdField.setEditable(false);
                phoneField.setEditable(false);
                birthDatePicker.setEditable(false);
                birthDatePicker.setDisable(true);
                PayPerHourField.setEditable(true);
                amountOfHoursField.setEditable(true);
                DepartmentCombo.setEditable(false);
                DepartmentCombo.setDisable(false);
                break;

            case "commission-salaried":
                employeePickTypeCombo.setEditable(false);
                nameField.setEditable(false);
                familyField.setEditable(false);
                nationalIdField.setEditable(false);
                phoneField.setEditable(false);
                birthDatePicker.setEditable(false);
                birthDatePicker.setDisable(true);
                numberOfSalesField.setEditable(true);
                commissionRateField.setEditable(true);
                DepartmentCombo.setEditable(false);
                DepartmentCombo.setDisable(false);
                break;
        }
    }

    @FXML
    void onEmployeeRadio(ActionEvent event) throws  IOException {
        if (employeeRadioButton.isSelected()) {
            managerRadioButton.setDisable(true);

            managerBonusField.setVisible(false);
            managerBonusField1.setVisible(false);
            managerBonusField2.setVisible(false);
        }
        else {
            managerRadioButton.setDisable(false);
            managerBonusField.setVisible(false);
            managerBonusField1.setVisible(false);
            managerBonusField2.setVisible(false);
        }
    }

    @FXML
    void onManagerRadio(ActionEvent event) throws  IOException {

        if (managerRadioButton.isSelected()) {
            employeeRadioButton.setDisable(true);

            switch (employeePickTypeCombo.getValue()) {
                case "base-salaried":
                    managerBonusField.setVisible(true);
                    break;

                case "commission-salaried", "hourly-salaried":
                    managerBonusField1.setVisible(true);
                    break;

                case "base-commission salaried":
                    managerBonusField2.setVisible(true);

                default:
                    managerBonusField.setVisible(false);
                    managerBonusField1.setVisible(false);
                    managerBonusField2.setVisible(false);
            }

        }
        else {
            managerBonusField.setVisible(false);
            managerBonusField1.setVisible(false);
            managerBonusField2.setVisible(false);
            employeeRadioButton.setDisable(false);
        }
    }

    @FXML
    void onCancelButton(ActionEvent event) throws  IOException {
        statusCombo.setVisible(false);
        applyButton.setVisible(false);
        cancelButton.setVisible(false);
        employeeRadioButton.setVisible(false);
        managerRadioButton.setVisible(false);
        managerBonusField.setVisible(false);
        managerBonusField1.setVisible(false);
        managerBonusField2.setVisible(false);

        switch (employeePickTypeCombo.getValue()) {
            case "base-salaried":
                employeePickTypeCombo.setEditable(false);
                nameField.setEditable(false);
                familyField.setEditable(false);
                nationalIdField.setEditable(false);
                phoneField.setEditable(false);
                birthDatePicker.setEditable(false);
                birthDatePicker.setDisable(true);
                baseSalaryField.setEditable(false);
                DepartmentCombo.setEditable(false);
                DepartmentCombo.setDisable(true);

                break;

            case "base-commission salaried":
                employeePickTypeCombo.setEditable(false);
                nameField.setEditable(false);
                familyField.setEditable(false);
                nationalIdField.setEditable(false);
                phoneField.setEditable(false);
                birthDatePicker.setEditable(false);
                birthDatePicker.setDisable(true);
                baseSalaryField.setEditable(false);
                numberOfSalesField2.setEditable(false);
                commissionRateField2.setEditable(false);
                DepartmentCombo.setEditable(false);
                DepartmentCombo.setDisable(true);

                break;

            case "hourly-salaried":
                employeePickTypeCombo.setEditable(false);
                nameField.setEditable(false);
                familyField.setEditable(false);
                nationalIdField.setEditable(false);
                phoneField.setEditable(false);
                birthDatePicker.setEditable(false);
                birthDatePicker.setDisable(true);
                PayPerHourField.setEditable(false);
                amountOfHoursField.setEditable(false);
                DepartmentCombo.setEditable(false);
                DepartmentCombo.setDisable(true);

                break;

            case "commission-salaried":
                employeePickTypeCombo.setEditable(false);
                nameField.setEditable(false);
                familyField.setEditable(false);
                nationalIdField.setEditable(false);
                phoneField.setEditable(false);
                birthDatePicker.setEditable(false);
                birthDatePicker.setDisable(true);
                numberOfSalesField.setEditable(false);
                commissionRateField.setEditable(false);
                DepartmentCombo.setEditable(false);
                DepartmentCombo.setDisable(true);

                if (managerRadioButton.isSelected()) {
                    managerBonusField.setVisible(false);
                    managerBonusField2.setVisible(false);
                    managerBonusField1.setVisible(true);
                }
                break;
        }

        resetFields();
    }

    @FXML
    void onApplyButton(ActionEvent event) throws IOException {
        if (!managerRadioButton.isSelected() && !employeeRadioButton.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Employee or Manager ?");
            alert.setTitle("ERROR !");
            alert.setContentText("You must select the new role of your selection.");
            alert.showAndWait();
        }

        else if(employeeRadioButton.isSelected()){
            Employee emp = null;

            if(employeeBaseSalaryTable.getSelectionModel().getSelectedItem() instanceof BaseSalariedEmployee){
                emp = employeeBaseSalaryTable.getSelectionModel().getSelectedItem();
            }
            else if (employeeCommissionBaseTable.getSelectionModel().getSelectedItem() instanceof CommissionBaseSalariedEmployee) {
                emp = employeeCommissionBaseTable.getSelectionModel().getSelectedItem();
            }
            else if(employeeCommissionSalaryTable.getSelectionModel().getSelectedItem() instanceof CommissionSalariedEmployee){
                emp = employeeCommissionSalaryTable.getSelectionModel().getSelectedItem();
            }
            else if(employeeHourlySalaryTable.getSelectionModel().getSelectedItem() instanceof HourlySalariedEmployee){
                emp = employeeHourlySalaryTable.getSelectionModel().getSelectedItem();
            }

            var type = (String) employeePickTypeCombo.getSelectionModel().getSelectedItem();
            boolean isAcceptable = false;

            try {
                if (charOnlyTextFieldsChecker() && numericOnlyEmployeeTextFieldsChecker()) {
                    var department = (Department) DepartmentCombo.getSelectionModel().getSelectedItem();

                    // This block of code is for creating another object with the new info
                    switch (type) {
                        case "base-salaried":
                            if (isNumeric(baseSalaryField.getText())) {
                                var baseSalariedEmp = new BaseSalariedEmployee(
                                        nameField.getText(), familyField.getText(),
                                        nationalIdField.getText(), phoneField.getText(),
                                        LocalDate.now(), birthDatePicker.getValue(), department,
                                        Double.parseDouble(baseSalaryField.getText())
                                );
                                departmentWriteToFile();
                                baseSalariedArrayList.add(baseSalariedEmp);
                                employeeBaseSalariedArrayList.add(baseSalariedEmp);
                                employeeBaseSalariedEmployeeObservableList = employeeBaseSalaryTable.getItems();
                                employeeBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(employeeBaseSalariedArrayList);
                                employeeBaseSalaryTable.setItems(employeeBaseSalariedEmployeeObservableList);
                                baseSalaryWriteToFile();
                                isAcceptable = true;
                                //reset value of text boxes.
                                nameField.setText("");
                                familyField.setText("");
                                nationalIdField.setText("");
                                phoneField.setText("");
                                birthDatePicker.setValue(null);
                                baseSalaryField.setText("");
                            }
                            else {
                                throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                            }
                            break;

                        case "hourly-salaried":
                            if (isNumeric(PayPerHourField.getText()) && isNumeric(amountOfHoursField.getText())) {
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
                                isAcceptable = true;
                                // reset value of text boxes.
                                nameField.setText("");
                                familyField.setText("");
                                nationalIdField.setText("");
                                phoneField.setText("");
                                birthDatePicker.setValue(null);
                                PayPerHourField.setText("");
                                amountOfHoursField.setText("");
                            }
                            else {
                                throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                            }

                            break;

                        case "commission-salaried":
                            if (isNumeric(numberOfSalesField.getText()) && isNumeric(commissionRateField.getText())) {
                                var commissionSalariedEmp = new CommissionSalariedEmployee(
                                        nameField.getText(), familyField.getText(),
                                        nationalIdField.getText(), phoneField.getText(),
                                        LocalDate.now(), birthDatePicker.getValue(), department,
                                        Double.parseDouble(commissionRateField.getText()),
                                        Integer.parseInt(numberOfSalesField.getText())
                                );
                                departmentWriteToFile();
                                commissionSalariedArrayList.add(commissionSalariedEmp);
                                employeeCommissionSalariedArrayList.add(commissionSalariedEmp);
                                employeeCommissionSalariedEmployeeObservableList = employeeCommissionSalaryTable.getItems();
                                employeeCommissionSalariedEmployeeObservableList = FXCollections.observableArrayList(employeeCommissionSalariedArrayList);
                                employeeCommissionSalaryTable.setItems(employeeCommissionSalariedEmployeeObservableList);
                                commissionSalaryWriteToFile();
                                isAcceptable = true;
                                //reset value of text boxes.
                                nameField.setText("");
                                familyField.setText("");
                                nationalIdField.setText("");
                                phoneField.setText("");
                                birthDatePicker.setValue(null);
                                commissionRateField.setText("");
                                numberOfSalesField.setText("");
                            }
                            else {
                                throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                            }
                            break;

                        case "base-commission salaried":
                            if (isNumeric(commissionRateField2.getText()) && isNumeric(numberOfSalesField2.getText()) && isNumeric(baseSalaryField.getText())) {
                                var commissionBaseSalariedEmp = new CommissionBaseSalariedEmployee(
                                        nameField.getText(), familyField.getText(),
                                        nationalIdField.getText(), phoneField.getText(),
                                        LocalDate.now(), birthDatePicker.getValue(),
                                        department, Double.parseDouble(baseSalaryField.getText()),
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
                                isAcceptable = true;
                                //reset value of text boxes.
                                nameField.setText("");
                                familyField.setText("");
                                nationalIdField.setText("");
                                phoneField.setText("");
                                birthDatePicker.setValue(null);
                                baseSalaryField.setText("");
                                commissionRateField2.setText("");
                                numberOfSalesField2.setText("");
                            }
                            else {
                                throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                            }
                            break;
                    }
                }
                else {
                    throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                }
            }
            catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("SELECTION ERROR!");
                alert.setContentText("Select a Salary Type and a Department for the Employee ...");
                alert.showAndWait();
            }

            // This block of code is for archiving the previous info
            if (isAcceptable) {
                int index = 0;
                String departmentName;
                if (emp instanceof BaseSalariedEmployee) {
                    departmentName = emp.getDepartment().getName();

                    for (Department department : departmentArrayList) {
                        if (department.getName().equals(departmentName)) {
                            index = departmentArrayList.indexOf(department);
                        }
                    }

                    emp.setActive(false);
                    emp.setEndDate(LocalDate.now().toString());
                    emp.setStatus(Status.HAS_CHANGED);
                    Department department = emp.getDepartment();
                    department.setNumberOfActiveEmployees(department.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department);
                    baseSalaryWriteToFile();
                    departmentWriteToFile();
                    employeeBaseSalaryTable.getItems().remove(emp);
                    employeeBaseSalariedArrayList.remove(emp);
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);

                } else if (emp instanceof CommissionBaseSalariedEmployee) {
                    departmentName = emp.getDepartment().getName();

                    for (Department department1 : departmentArrayList) {
                        if (department1.getName().equals(departmentName)) {
                            index = departmentArrayList.indexOf(department1);
                        }
                    }
                    emp.setActive(false);
                    emp.setEndDate(LocalDate.now().toString());
                    emp.setStatus(Status.HAS_CHANGED);
                    Department department1 = emp.getDepartment();
                    department1.setNumberOfActiveEmployees(department1.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department1);
                    commissionBaseSalaryWriteToFile();
                    departmentWriteToFile();
                    employeeCommissionBaseTable.getItems().remove(emp);
                    employeeCommissionBaseSalariedArrayList.remove(emp);
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);

                } else if (emp instanceof HourlySalariedEmployee) {
                    departmentName = emp.getDepartment().getName();

                    for (Department department2 : departmentArrayList) {
                        if (department2.getName().equals(departmentName)) {
                            index = departmentArrayList.indexOf(department2);
                        }
                    }
                    emp.setActive(false);
                    emp.setEndDate(LocalDate.now().toString());
                    emp.setStatus(Status.HAS_CHANGED);
                    Department department2 = emp.getDepartment();
                    department2.setNumberOfActiveEmployees(department2.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department2);
                    hourlySalaryWriteToFile();
                    departmentWriteToFile();
                    employeeHourlySalaryTable.getItems().remove(emp);
                    employeeHourlySalariedArrayList.remove(emp);
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);

                } else if (emp instanceof CommissionSalariedEmployee) {
                    departmentName = emp.getDepartment().getName();

                    for (Department department3 : departmentArrayList) {
                        if (department3.getName().equals(departmentName)) {
                            index = departmentArrayList.indexOf(department3);
                        }
                    }
                    emp.setActive(false);
                    emp.setEndDate(LocalDate.now().toString());
                    emp.setStatus(Status.HAS_CHANGED);
                    Department department3 = emp.getDepartment();
                    department3.setNumberOfActiveEmployees(department3.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department3);
                    commissionSalaryWriteToFile();
                    departmentWriteToFile();
                    employeeCommissionSalaryTable.getItems().remove(emp);
                    employeeCommissionSalariedArrayList.remove(emp);
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);
                }
                addEmployeeButton.setDisable(false);
                statusCombo.setVisible(false);
                applyButton2.setVisible(false);
                cancelButton2.setVisible(false);
                switch (employeePickTypeCombo.getValue()) {
                    case "base-salaried":
                        employeePickTypeCombo.setEditable(false);
                        nameField.setEditable(true);
                        familyField.setEditable(true);
                        nationalIdField.setEditable(true);
                        phoneField.setEditable(true);
                        birthDatePicker.setEditable(false);
                        birthDatePicker.setDisable(false);
                        baseSalaryField.setEditable(true);
                        DepartmentCombo.setDisable(false);

                        nameField.setText("");
                        familyField.setText("");
                        nationalIdField.setText("");
                        phoneField.setText("");
                        birthDatePicker.setValue(null);
                        DepartmentCombo.setValue(null);
                        baseSalaryField.setText("");

                        break;

                    case "base-commission salaried":
                        employeePickTypeCombo.setEditable(false);
                        nameField.setEditable(true);
                        familyField.setEditable(true);
                        nationalIdField.setEditable(true);
                        phoneField.setEditable(true);
                        birthDatePicker.setEditable(false);
                        birthDatePicker.setDisable(false);
                        numberOfSalesField2.setEditable(true);
                        baseSalaryField.setEditable(true);
                        commissionRateField2.setEditable(true);
                        DepartmentCombo.setDisable(false);

                        nameField.setText("");
                        familyField.setText("");
                        nationalIdField.setText("");
                        phoneField.setText("");
                        birthDatePicker.setValue(null);
                        DepartmentCombo.setValue(null);
                        baseSalaryField.setText("");
                        commissionRateField2.setText("");
                        numberOfSalesField2.setText("");
                        break;

                    case "hourly-salaried":
                        employeePickTypeCombo.setEditable(false);
                        nameField.setEditable(true);
                        familyField.setEditable(true);
                        nationalIdField.setEditable(true);
                        phoneField.setEditable(true);
                        birthDatePicker.setEditable(false);
                        birthDatePicker.setDisable(false);
                        PayPerHourField.setEditable(true);
                        amountOfHoursField.setEditable(true);
                        DepartmentCombo.setDisable(false);

                        nameField.setText("");
                        familyField.setText("");
                        nationalIdField.setText("");
                        phoneField.setText("");
                        birthDatePicker.setValue(null);
                        DepartmentCombo.setValue(null);
                        PayPerHourField.setText("");
                        amountOfHoursField.setText("");
                        break;

                    case "commission-salaried":
                        employeePickTypeCombo.setEditable(false);
                        nameField.setEditable(true);
                        familyField.setEditable(true);
                        nationalIdField.setEditable(true);
                        phoneField.setEditable(true);
                        birthDatePicker.setEditable(false);
                        birthDatePicker.setDisable(false);
                        numberOfSalesField.setEditable(true);
                        commissionRateField.setEditable(true);
                        DepartmentCombo.setDisable(false);

                        nameField.setText("");
                        familyField.setText("");
                        nationalIdField.setText("");
                        phoneField.setText("");
                        birthDatePicker.setValue(null);
                        DepartmentCombo.setValue(null);
                        baseSalaryField.setText("");
                        commissionRateField.setText("");
                        numberOfSalesField.setText("");
                        break;
                }

                resetFields();
            }
        }

        else if (managerRadioButton.isSelected()) {
            Employee emp = null;

            if(employeeBaseSalaryTable.getSelectionModel().getSelectedItem() instanceof BaseSalariedEmployee){
                emp = employeeBaseSalaryTable.getSelectionModel().getSelectedItem();
            }
            else if (employeeCommissionBaseTable.getSelectionModel().getSelectedItem() instanceof CommissionBaseSalariedEmployee) {
                emp = employeeCommissionBaseTable.getSelectionModel().getSelectedItem();
            }
            else if(employeeCommissionSalaryTable.getSelectionModel().getSelectedItem() instanceof CommissionSalariedEmployee){
                emp = employeeCommissionSalaryTable.getSelectionModel().getSelectedItem();
            }
            else if(employeeHourlySalaryTable.getSelectionModel().getSelectedItem() instanceof HourlySalariedEmployee){
                emp = employeeHourlySalaryTable.getSelectionModel().getSelectedItem();
            }

            var type = (String) employeePickTypeCombo.getSelectionModel().getSelectedItem();
            boolean isAcceptable = false;

            try {
                if (numericOnlyManagerTextFieldsChecker() && charOnlyTextFieldsChecker()) {
                    var department = (Department) DepartmentCombo.getSelectionModel().getSelectedItem();

                    // This block of code is for creating another object with the new info
                    switch (type) {
                        case "base-salaried":
                            if (!department.isHasManager()) {
                                if (isNumeric(baseSalaryField.getText())) {
                                    var baseSalariedEmp = new BaseSalariedEmployee(
                                            nameField.getText(), familyField.getText(),
                                            nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                            LocalDate.now(), birthDatePicker.getValue(), department,
                                            Double.parseDouble(baseSalaryField.getText())
                                    );
                                    departmentWriteToFile();
                                    baseSalariedArrayList.add(baseSalariedEmp);
                                    employeeBaseSalaryTable.setItems(employeeBaseSalariedEmployeeObservableList);
                                    baseSalaryWriteToFile();
                                    isAcceptable = true;
                                    //reset value of text boxes.
                                    nameField.setText("");
                                    familyField.setText("");
                                    nationalIdField.setText("");
                                    phoneField.setText("");
                                    birthDatePicker.setValue(null);
                                    baseSalaryField.setText("");
                                    managerBonusField.setText("");
                                    managerBonusField.setVisible(false);
                                }
                                else {
                                    throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                                }
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("ERROR!");
                                alert.setContentText("This Department already has a manager");
                                alert.showAndWait();
                            }
                            break;

                        case "hourly-salaried":
                            if (!department.isHasManager()) {
                                if (isNumeric(amountOfHoursField.getText()) && isNumeric(PayPerHourField.getText())) {
                                    var hourlySalariedEmp = new HourlySalariedEmployee(
                                            nameField.getText(), familyField.getText(),
                                            nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField1.getText()),
                                            LocalDate.now(), birthDatePicker.getValue(), department,
                                            Double.parseDouble(PayPerHourField.getText()),
                                            Double.parseDouble(amountOfHoursField.getText())
                                    );
                                    departmentWriteToFile();
                                    hourlySalariedArrayList.add(hourlySalariedEmp);
                                    employeeHourlySalaryTable.setItems(employeeHourlySalariedEmployeeObservableList);
                                    hourlySalaryWriteToFile();
                                    isAcceptable = true;
                                    // reset value of text boxes.
                                    nameField.setText("");
                                    familyField.setText("");
                                    nationalIdField.setText("");
                                    phoneField.setText("");
                                    birthDatePicker.setValue(null);
                                    PayPerHourField.setText("");
                                    amountOfHoursField.setText("");
                                    managerBonusField1.setText("");
                                    managerBonusField1.setVisible(false);
                                }
                                else {
                                    throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                                }
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("ERROR!");
                                alert.setContentText("This Department already has a manager");
                                alert.showAndWait();
                            }
                            break;

                        case "commission-salaried":
                            if (!department.isHasManager()) {
                                if (isNumeric(commissionRateField.getText()) && isNumeric(numberOfSalesField.getText())) {
                                    var commissionSalariedEmp = new CommissionSalariedEmployee(
                                            nameField.getText(), familyField.getText(),
                                            nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField1.getText()),
                                            LocalDate.now(), birthDatePicker.getValue(), department,
                                            Double.parseDouble(commissionRateField.getText()),
                                            Integer.parseInt(numberOfSalesField.getText())
                                    );
                                    departmentWriteToFile();
                                    commissionSalariedArrayList.add(commissionSalariedEmp);
                                    employeeCommissionSalaryTable.setItems(employeeCommissionSalariedEmployeeObservableList);
                                    commissionSalaryWriteToFile();
                                    isAcceptable = true;
                                    //reset value of text boxes.
                                    nameField.setText("");
                                    familyField.setText("");
                                    nationalIdField.setText("");
                                    phoneField.setText("");
                                    birthDatePicker.setValue(null);
                                    commissionRateField.setText("");
                                    numberOfSalesField.setText("");
                                    managerBonusField1.setText("");
                                    managerBonusField1.setVisible(false);
                                }
                                else {
                                    throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                                }
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("ERROR!");
                                alert.setContentText("This Department already has a manager");
                                alert.showAndWait();
                            }
                            break;

                        case "base-commission salaried":
                            if (!department.isHasManager()) {
                                if (isNumeric(commissionRateField2.getText()) && isNumeric(baseSalaryField.getText()) && isNumeric(numberOfSalesField2.getText())) {
                                    var commissionBaseSalariedEmp = new CommissionBaseSalariedEmployee(
                                            nameField.getText(), familyField.getText(),
                                            nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField2.getText()),
                                            LocalDate.now(), birthDatePicker.getValue(),
                                            department, Double.parseDouble(baseSalaryField.getText()),
                                            Double.parseDouble(commissionRateField2.getText()),
                                            Integer.parseInt(numberOfSalesField2.getText())
                                    );
                                    departmentWriteToFile();
                                    commissionBaseSalariedArrayList.add(commissionBaseSalariedEmp);
                                    employeeCommissionBaseTable.setItems(employeeCommissionBaseSalariedEmployeeObservableList);
                                    commissionBaseSalaryWriteToFile();
                                    isAcceptable = true;
                                    //reset value of text boxes.
                                    nameField.setText("");
                                    familyField.setText("");
                                    nationalIdField.setText("");
                                    phoneField.setText("");
                                    birthDatePicker.setValue(null);
                                    baseSalaryField.setText("");
                                    commissionRateField2.setText("");
                                    numberOfSalesField2.setText("");
                                    managerBonusField2.setText("");
                                    managerBonusField2.setVisible(false);
                                }
                                else {
                                    throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                                }
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("ERROR!");
                                alert.setContentText("This Department already has a manager");
                                alert.showAndWait();
                            }
                            break;
                    }
                }
            }

            catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("SELECTION ERROR!");
                alert.setContentText("Select a Salary Type and a Department for the Employee ...");
                alert.showAndWait();
            }

            // This block of code is for archiving the previous info
            if (isAcceptable) {
                int index = 0;
                String departmentName;
                if (emp instanceof BaseSalariedEmployee) {
                    departmentName = emp.getDepartment().getName();

                    for (Department department : departmentArrayList) {
                        if (department.getName().equals(departmentName)) {
                            index = departmentArrayList.indexOf(department);
                        }
                    }

                    emp.setActive(false);
                    emp.setEndDate(LocalDate.now().toString());
                    emp.setStatus(Status.HAS_CHANGED);
                    Department department = emp.getDepartment();
                    department.setNumberOfActiveEmployees(department.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department);
                    baseSalaryWriteToFile();
                    departmentWriteToFile();
                    employeeBaseSalaryTable.getItems().remove(emp);
                    employeeBaseSalariedArrayList.remove(emp);
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);

                } else if (emp instanceof CommissionBaseSalariedEmployee) {
                    departmentName = emp.getDepartment().getName();

                    for (Department department1 : departmentArrayList) {
                        if (department1.getName().equals(departmentName)) {
                            index = departmentArrayList.indexOf(department1);
                        }
                    }
                    emp.setActive(false);
                    emp.setEndDate(LocalDate.now().toString());
                    emp.setStatus(Status.HAS_CHANGED);
                    Department department1 = emp.getDepartment();
                    department1.setNumberOfActiveEmployees(department1.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department1);
                    commissionBaseSalaryWriteToFile();
                    departmentWriteToFile();
                    employeeCommissionBaseTable.getItems().remove(emp);
                    employeeCommissionBaseSalariedArrayList.remove(emp);
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);

                } else if (emp instanceof HourlySalariedEmployee) {
                    departmentName = emp.getDepartment().getName();

                    for (Department department2 : departmentArrayList) {
                        if (department2.getName().equals(departmentName)) {
                            index = departmentArrayList.indexOf(department2);
                        }
                    }
                    emp.setActive(false);
                    emp.setEndDate(LocalDate.now().toString());
                    emp.setStatus(Status.HAS_CHANGED);
                    Department department2 = emp.getDepartment();
                    department2.setNumberOfActiveEmployees(department2.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department2);
                    hourlySalaryWriteToFile();
                    departmentWriteToFile();
                    employeeHourlySalaryTable.getItems().remove(emp);
                    employeeHourlySalariedArrayList.remove(emp);
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);

                } else if (emp instanceof CommissionSalariedEmployee) {
                    departmentName = emp.getDepartment().getName();

                    for (Department department3 : departmentArrayList) {
                        if (department3.getName().equals(departmentName)) {
                            index = departmentArrayList.indexOf(department3);
                        }
                    }
                    emp.setActive(false);
                    emp.setEndDate(LocalDate.now().toString());
                    emp.setStatus(Status.HAS_CHANGED);
                    Department department3 = emp.getDepartment();
                    department3.setNumberOfActiveEmployees(department3.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department3);
                    commissionSalaryWriteToFile();
                    departmentWriteToFile();
                    employeeCommissionSalaryTable.getItems().remove(emp);
                    employeeCommissionSalariedArrayList.remove(emp);
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);
                }
                addEmployeeButton.setDisable(false);
                statusCombo.setVisible(false);
                applyButton2.setVisible(false);
                cancelButton2.setVisible(false);
                switch (employeePickTypeCombo.getValue()) {
                    case "base-salaried":
                        employeePickTypeCombo.setEditable(false);
                        nameField.setEditable(true);
                        familyField.setEditable(true);
                        nationalIdField.setEditable(true);
                        phoneField.setEditable(true);
                        birthDatePicker.setEditable(false);
                        birthDatePicker.setDisable(false);
                        baseSalaryField.setEditable(true);
                        DepartmentCombo.setDisable(false);

                        nameField.setText("");
                        familyField.setText("");
                        nationalIdField.setText("");
                        phoneField.setText("");
                        birthDatePicker.setValue(null);
                        DepartmentCombo.setValue(null);
                        baseSalaryField.setText("");

                        break;

                    case "base-commission salaried":
                        employeePickTypeCombo.setEditable(false);
                        nameField.setEditable(true);
                        familyField.setEditable(true);
                        nationalIdField.setEditable(true);
                        phoneField.setEditable(true);
                        birthDatePicker.setEditable(false);
                        birthDatePicker.setDisable(false);
                        numberOfSalesField2.setEditable(true);
                        baseSalaryField.setEditable(true);
                        commissionRateField2.setEditable(true);
                        DepartmentCombo.setDisable(false);

                        nameField.setText("");
                        familyField.setText("");
                        nationalIdField.setText("");
                        phoneField.setText("");
                        birthDatePicker.setValue(null);
                        DepartmentCombo.setValue(null);
                        baseSalaryField.setText("");
                        commissionRateField2.setText("");
                        numberOfSalesField2.setText("");
                        break;

                    case "hourly-salaried":
                        employeePickTypeCombo.setEditable(false);
                        nameField.setEditable(true);
                        familyField.setEditable(true);
                        nationalIdField.setEditable(true);
                        phoneField.setEditable(true);
                        birthDatePicker.setEditable(false);
                        birthDatePicker.setDisable(false);
                        PayPerHourField.setEditable(true);
                        amountOfHoursField.setEditable(true);
                        DepartmentCombo.setDisable(false);

                        nameField.setText("");
                        familyField.setText("");
                        nationalIdField.setText("");
                        phoneField.setText("");
                        birthDatePicker.setValue(null);
                        DepartmentCombo.setValue(null);
                        PayPerHourField.setText("");
                        amountOfHoursField.setText("");
                        break;

                    case "commission-salaried":
                        employeePickTypeCombo.setEditable(false);
                        nameField.setEditable(true);
                        familyField.setEditable(true);
                        nationalIdField.setEditable(true);
                        phoneField.setEditable(true);
                        birthDatePicker.setEditable(false);
                        birthDatePicker.setDisable(false);
                        numberOfSalesField.setEditable(true);
                        commissionRateField.setEditable(true);
                        DepartmentCombo.setDisable(false);

                        nameField.setText("");
                        familyField.setText("");
                        nationalIdField.setText("");
                        phoneField.setText("");
                        birthDatePicker.setValue(null);
                        DepartmentCombo.setValue(null);
                        baseSalaryField.setText("");
                        commissionRateField.setText("");
                        numberOfSalesField.setText("");
                        break;
                }

                managerRadioButton.setSelected(false);
                employeeRadioButton.setSelected(true);
                managerRadioButton.setDisable(true);
                employeeRadioButton.setDisable(false);

                employeeRadioButton.setVisible(false);
                managerRadioButton.setVisible(false);
                managerBonusField.setVisible(false);
                managerBonusField1.setVisible(false);
                managerBonusField2.setVisible(false);
                deactiveButton.setVisible(false);
                cancelButton.setVisible(false);
                applyButton.setVisible(false);

                resetFields();
            }
        }
    }

    @FXML
    void onApplyButton2(ActionEvent event) {
        int index=0;
        String departmentName;
        switch (employeePickTypeCombo.getValue()) {
            case "base-salaried":
                BaseSalariedEmployee emp = employeeBaseSalaryTable.getSelectionModel().getSelectedItem();
                departmentName = emp.getDepartment().getName();

                for( Department department : departmentArrayList){
                    if(department.getName().equals(departmentName)){
                        index = departmentArrayList.indexOf(department);
                    }
                }
                emp.setActive(false);
                emp.setEndDate(LocalDate.now().toString());
                emp.setStatus(statusCombo.getValue());
                Department department = emp.getDepartment();
                department.setHasManager(false);
                department.setNumberOfActiveEmployees(department.getNumberOfActiveEmployees()-1);
                departmentArrayList.set(index,department);
                baseSalaryWriteToFile();
                departmentWriteToFile();
                departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                DepartmentCombo.setItems(departmentObservableList);
                employeeBaseSalaryTable.getItems().remove(emp);
                employeeBaseSalariedArrayList.remove(emp);
                break;

            case "base-commission salaried":
                CommissionBaseSalariedEmployee emp1 = employeeCommissionBaseTable.getSelectionModel().getSelectedItem();
                departmentName = emp1.getDepartment().getName();

                for(Department department1 : departmentArrayList){
                    if(department1.getName().equals(departmentName)){
                        index = departmentArrayList.indexOf(department1);
                    }
                }
                emp1.setActive(false);
                emp1.setEndDate(LocalDate.now().toString());
                emp1.setStatus(statusCombo.getValue());
                Department department1 = emp1.getDepartment();
                department1.setHasManager(false);
                department1.setNumberOfActiveEmployees(department1.getNumberOfActiveEmployees()-1);
                departmentArrayList.set(index,department1);
                commissionBaseSalaryWriteToFile();
                departmentWriteToFile();
                departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                DepartmentCombo.setItems(departmentObservableList);
                employeeCommissionBaseTable.getItems().remove(emp1);
                employeeCommissionBaseSalariedArrayList.remove(emp1);
                break;

            case "hourly-salaried":
                HourlySalariedEmployee emp2 = employeeHourlySalaryTable.getSelectionModel().getSelectedItem();
                departmentName = emp2.getDepartment().getName();

                for(Department department2 : departmentArrayList){
                    if(department2.getName().equals(departmentName)){
                        index = departmentArrayList.indexOf(department2);
                    }
                }
                emp2.setActive(false);
                emp2.setEndDate(LocalDate.now().toString());
                emp2.setStatus(statusCombo.getValue());
                Department department2 = emp2.getDepartment();
                department2.setHasManager(false);
                department2.setNumberOfActiveEmployees(department2.getNumberOfActiveEmployees()-1);
                departmentArrayList.set(index,department2);
                hourlySalaryWriteToFile();
                departmentWriteToFile();
                departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                DepartmentCombo.setItems(departmentObservableList);
                employeeHourlySalaryTable.getItems().remove(emp2);
                employeeHourlySalariedArrayList.remove(emp2);
                break;

            case "commission-salaried":
                CommissionSalariedEmployee emp3 = employeeCommissionSalaryTable.getSelectionModel().getSelectedItem();
                departmentName = emp3.getDepartment().getName();

                for(Department department3 : departmentArrayList){
                    if(department3.getName().equals(departmentName)){
                        index = departmentArrayList.indexOf(department3);
                    }
                }
                emp3.setActive(false);
                emp3.setEndDate(LocalDate.now().toString());
                emp3.setStatus(statusCombo.getValue());
                Department department3 = emp3.getDepartment();
                department3.setHasManager(false);
                department3.setNumberOfActiveEmployees(department3.getNumberOfActiveEmployees()-1);
                departmentArrayList.set(index,department3);
                commissionSalaryWriteToFile();
                departmentWriteToFile();
                departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                DepartmentCombo.setItems(departmentObservableList);
                employeeCommissionSalaryTable.getItems().remove(emp3);
                employeeCommissionSalariedArrayList.remove(emp3);
                break;
        }

        addEmployeeButton.setDisable(false);
        statusCombo.setVisible(false);
        applyButton2.setVisible(false);
        cancelButton2.setVisible(false);
        switch (employeePickTypeCombo.getValue()) {
            case "base-salaried":
                employeePickTypeCombo.setEditable(false);
                nameField.setEditable(true);
                familyField.setEditable(true);
                nationalIdField.setEditable(true);
                phoneField.setEditable(true);
                birthDatePicker.setEditable(false);
                birthDatePicker.setDisable(false);
                baseSalaryField.setEditable(true);
                DepartmentCombo.setDisable(false);

                nameField.setText("");
                familyField.setText("");
                nationalIdField.setText("");
                phoneField.setText("");
                birthDatePicker.setValue(null);
                DepartmentCombo.setValue(null);
                baseSalaryField.setText("");

                break;

            case "base-commission salaried":
                employeePickTypeCombo.setEditable(false);
                nameField.setEditable(true);
                familyField.setEditable(true);
                nationalIdField.setEditable(true);
                phoneField.setEditable(true);
                birthDatePicker.setEditable(false);
                birthDatePicker.setDisable(false);
                numberOfSalesField2.setEditable(true);
                baseSalaryField.setEditable(true);
                commissionRateField2.setEditable(true);
                DepartmentCombo.setDisable(false);

                nameField.setText("");
                familyField.setText("");
                nationalIdField.setText("");
                phoneField.setText("");
                birthDatePicker.setValue(null);
                DepartmentCombo.setValue(null);
                baseSalaryField.setText("");
                commissionRateField2.setText("");
                numberOfSalesField2.setText("");
                break;

            case "hourly-salaried":
                employeePickTypeCombo.setEditable(false);
                nameField.setEditable(true);
                familyField.setEditable(true);
                nationalIdField.setEditable(true);
                phoneField.setEditable(true);
                birthDatePicker.setEditable(false);
                birthDatePicker.setDisable(false);
                PayPerHourField.setEditable(true);
                amountOfHoursField.setEditable(true);
                DepartmentCombo.setDisable(false);

                nameField.setText("");
                familyField.setText("");
                nationalIdField.setText("");
                phoneField.setText("");
                birthDatePicker.setValue(null);
                DepartmentCombo.setValue(null);
                PayPerHourField.setText("");
                amountOfHoursField.setText("");
                break;

            case "commission-salaried":
                employeePickTypeCombo.setEditable(false);
                nameField.setEditable(true);
                familyField.setEditable(true);
                nationalIdField.setEditable(true);
                phoneField.setEditable(true);
                birthDatePicker.setEditable(false);
                birthDatePicker.setDisable(false);
                numberOfSalesField.setEditable(true);
                commissionRateField.setEditable(true);
                DepartmentCombo.setDisable(false);

                nameField.setText("");
                familyField.setText("");
                nationalIdField.setText("");
                phoneField.setText("");
                birthDatePicker.setValue(null);
                DepartmentCombo.setValue(null);
                baseSalaryField.setText("");
                commissionRateField.setText("");
                numberOfSalesField.setText("");
                break;
        }

        resetFields();
    }

    @FXML
    void onCancelButton2(ActionEvent event) {
        statusCombo.setVisible(false);
        applyButton2.setVisible(false);
        cancelButton2.setVisible(false);
        managerBonusField.setVisible(false);
        managerBonusField1.setVisible(false);
        managerBonusField2.setVisible(false);

        resetFields();
    }
    @FXML
    void onDeActiveButton(ActionEvent event) {
        try {
            statusCombo.setVisible(true);
            applyButton2.setVisible(true);
            cancelButton2.setVisible(true);
        }

        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR ");
            alert.setHeaderText("No Item is Selected !");
            alert.setContentText("You must select an item first or add an item.");
            alert.showAndWait();
        }
    }

    @FXML
    void employeeBaseSalaryTableGetItem(MouseEvent event) {
        int index = employeeBaseSalaryTable.getSelectionModel().getSelectedIndex();

        if(index <= -1){
            return;
        }

        employeePickTypeCombo.setValue("base-salaried");
        nameField.setText(employeeBaseSalaryNameColumn.getCellData(index));
        familyField.setText(employeeBaseSalaryFamilyColumn.getCellData(index));
        nationalIdField.setText(employeeBaseSalaryNationalColumn.getCellData(index));
        phoneField.setText(employeeBaseSalaryPhoneColumn.getCellData(index));
        birthDatePicker.setValue(LocalDate.parse(employeeBaseSalaryBirthColumn.getCellData(index)));
        baseSalaryField.setText(String.valueOf(employeeBaseSalaryColumn.getCellData(index)));
        DepartmentCombo.setValue(employeeBaseSalaryDepartmentColumn.getCellData(index));

        employeePickTypeCombo.setEditable(false);
        nameField.setEditable(false);
        familyField.setEditable(false);
        nationalIdField.setEditable(false);
        phoneField.setEditable(false);
        birthDatePicker.setEditable(false);
        birthDatePicker.setDisable(true);
        baseSalaryField.setEditable(false);
        DepartmentCombo.setEditable(false);
        DepartmentCombo.setDisable(true);
        addEmployeeButton.setDisable(true);
        deactiveButton.setVisible(true);
        editButton.setVisible(true);
    }

    @FXML
    void employeeCommissionBaseSalaryTableGetItem(MouseEvent event) {
        int index = employeeCommissionBaseTable.getSelectionModel().getSelectedIndex();

        if(index <= -1){
            return;
        }

        employeePickTypeCombo.setValue("base-commission salaried");
        nameField.setText(employeeCommissionBaseNameColumn.getCellData(index));
        familyField.setText(employeeCommissionBaseFamilyColumn.getCellData(index));
        nationalIdField.setText(employeeCommissionBaseNationalColumn.getCellData(index));
        phoneField.setText(employeeCommissionBasePhoneColumn.getCellData(index));
        birthDatePicker.setValue(LocalDate.parse(employeeCommissionBaseBirthColumn.getCellData(index)));
        DepartmentCombo.setValue(employeeCommissionBaseDepartmentColumn.getCellData(index));
        baseSalaryField.setText(String.valueOf(employeeCommissionBaseSalaryColumn.getCellData(index)));
        numberOfSalesField2.setText(String.valueOf(employeeCommissionBaseNumberOfSalesColumn.getCellData(index)));
        commissionRateField2.setText(String.valueOf(employeeCommissionBaseRateColumn.getCellData(index)));

        employeePickTypeCombo.setEditable(false);
        nameField.setEditable(false);
        familyField.setEditable(false);
        nationalIdField.setEditable(false);
        phoneField.setEditable(false);
        birthDatePicker.setEditable(false);
        birthDatePicker.setDisable(true);
        baseSalaryField.setEditable(false);
        numberOfSalesField2.setEditable(false);
        commissionRateField2.setEditable(false);
        DepartmentCombo.setEditable(false);
        DepartmentCombo.setDisable(true);
        addEmployeeButton.setDisable(true);
        deactiveButton.setVisible(true);
        editButton.setVisible(true);
    }

    @FXML
    void employeeCommissionSalaryTableGetItem(MouseEvent event) {
        int index = employeeCommissionSalaryTable.getSelectionModel().getSelectedIndex();

        if(index <= -1){
            return;
        }

        employeePickTypeCombo.setValue("commission-salaried");
        nameField.setText(employeeCommissionSalaryNameColumn.getCellData(index));
        familyField.setText(employeeCommissionSalaryFamilyColumn.getCellData(index));
        nationalIdField.setText(employeeCommissionSalaryNationalColumn.getCellData(index));
        phoneField.setText(employeeCommissionSalaryPhoneColumn.getCellData(index));
        birthDatePicker.setValue(LocalDate.parse(employeeCommissionSalaryBirthColumn.getCellData(index)));
        DepartmentCombo.setValue(employeeCommissionSalaryDepartmentColumn.getCellData(index));
        numberOfSalesField.setText(String.valueOf(employeeCommissionSalarySalesColumn.getCellData(index)));
        commissionRateField.setText(String.valueOf(employeeCommissionSalaryRateColumn.getCellData(index)));

        employeePickTypeCombo.setEditable(false);
        nameField.setEditable(false);
        familyField.setEditable(false);
        nationalIdField.setEditable(false);
        phoneField.setEditable(false);
        birthDatePicker.setEditable(false);
        birthDatePicker.setDisable(true);
        numberOfSalesField.setEditable(false);
        commissionRateField.setEditable(false);
        DepartmentCombo.setEditable(false);
        DepartmentCombo.setDisable(true);
        addEmployeeButton.setDisable(true);
        deactiveButton.setVisible(true);
        editButton.setVisible(true);
    }

    @FXML
    void employeeHourlySalaryTableGetItem(MouseEvent event) {
        int index = employeeHourlySalaryTable.getSelectionModel().getSelectedIndex();

        if(index <= -1){
            return;
        }

        employeePickTypeCombo.setValue("hourly-salaried");
        nameField.setText(employeeHourlySalaryNameColumn.getCellData(index));
        familyField.setText(employeeHourlySalaryFamilyColumn.getCellData(index));
        nationalIdField.setText(employeeHourlySalaryNationalColumn.getCellData(index));
        phoneField.setText(employeeHourlySalaryPhoneColumn.getCellData(index));
        birthDatePicker.setValue(LocalDate.parse(employeeHourlySalaryBirthColumn.getCellData(index)));
        DepartmentCombo.setValue(employeeHourlySalaryDepartmentColumn.getCellData(index));
        PayPerHourField.setText(String.valueOf(employeeHourlySalaryPayColumn.getCellData(index)));
        amountOfHoursField.setText(String.valueOf(employeeHourlySalaryAmountOfHoursColumn.getCellData(index)));

        employeePickTypeCombo.setEditable(false);
        nameField.setEditable(false);
        familyField.setEditable(false);
        nationalIdField.setEditable(false);
        phoneField.setEditable(false);
        birthDatePicker.setEditable(false);
        birthDatePicker.setDisable(true);
        PayPerHourField.setEditable(false);
        amountOfHoursField.setEditable(false);
        DepartmentCombo.setEditable(false);
        DepartmentCombo.setDisable(true);
        addEmployeeButton.setDisable(true);
        deactiveButton.setVisible(true);
        editButton.setVisible(true);
    }

    @FXML
    void unlockFields(MouseEvent event) {
        if(event.getClickCount() == 2) {
            statusCombo.setVisible(false);
            applyButton.setVisible(false);
            cancelButton.setVisible(false);
            employeeRadioButton.setVisible(false);
            managerRadioButton.setVisible(false);
            addEmployeeButton.setDisable(false);
            deactiveButton.setVisible(false);
            editButton.setVisible(false);
            switch (employeePickTypeCombo.getValue()) {
                case "base-salaried":
                    employeePickTypeCombo.setEditable(false);
                    nameField.setEditable(true);
                    familyField.setEditable(true);
                    nationalIdField.setEditable(true);
                    phoneField.setEditable(true);
                    birthDatePicker.setEditable(false);
                    birthDatePicker.setDisable(false);
                    baseSalaryField.setEditable(true);
                    DepartmentCombo.setDisable(false);

                    nameField.setText("");
                    familyField.setText("");
                    nationalIdField.setText("");
                    phoneField.setText("");
                    birthDatePicker.setValue(null);
                    DepartmentCombo.setValue(null);
                    baseSalaryField.setText("");

                    break;

                case "base-commission salaried":
                    employeePickTypeCombo.setEditable(false);
                    nameField.setEditable(true);
                    familyField.setEditable(true);
                    nationalIdField.setEditable(true);
                    phoneField.setEditable(true);
                    birthDatePicker.setEditable(false);
                    birthDatePicker.setDisable(false);
                    numberOfSalesField2.setEditable(true);
                    baseSalaryField.setEditable(true);
                    commissionRateField2.setEditable(true);
                    DepartmentCombo.setDisable(false);

                    nameField.setText("");
                    familyField.setText("");
                    nationalIdField.setText("");
                    phoneField.setText("");
                    birthDatePicker.setValue(null);
                    DepartmentCombo.setValue(null);
                    baseSalaryField.setText("");
                    commissionRateField2.setText("");
                    numberOfSalesField2.setText("");
                    break;

                case "hourly-salaried":
                    employeePickTypeCombo.setEditable(false);
                    nameField.setEditable(true);
                    familyField.setEditable(true);
                    nationalIdField.setEditable(true);
                    phoneField.setEditable(true);
                    birthDatePicker.setEditable(false);
                    birthDatePicker.setDisable(false);
                    PayPerHourField.setEditable(true);
                    amountOfHoursField.setEditable(true);
                    DepartmentCombo.setDisable(false);

                    nameField.setText("");
                    familyField.setText("");
                    nationalIdField.setText("");
                    phoneField.setText("");
                    birthDatePicker.setValue(null);
                    DepartmentCombo.setValue(null);
                    PayPerHourField.setText("");
                    amountOfHoursField.setText("");
                    break;

                case "commission-salaried":
                    employeePickTypeCombo.setEditable(false);
                    nameField.setEditable(true);
                    familyField.setEditable(true);
                    nationalIdField.setEditable(true);
                    phoneField.setEditable(true);
                    birthDatePicker.setEditable(false);
                    birthDatePicker.setDisable(false);
                    numberOfSalesField.setEditable(true);
                    commissionRateField.setEditable(true);
                    DepartmentCombo.setDisable(false);

                    nameField.setText("");
                    familyField.setText("");
                    nationalIdField.setText("");
                    phoneField.setText("");
                    birthDatePicker.setValue(null);
                    DepartmentCombo.setValue(null);
                    baseSalaryField.setText("");
                    commissionRateField.setText("");
                    numberOfSalesField.setText("");
                    break;
            }
        }
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

                if (managerRadioButton.isSelected()) {
                    managerBonusField.setVisible(true);
                    managerBonusField1.setVisible(false);
                    managerBonusField2.setVisible(false);
                }

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

                if (managerRadioButton.isSelected()) {
                    managerBonusField2.setVisible(true);
                    managerBonusField.setVisible(false);
                    managerBonusField1.setVisible(false);
                }

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

                if (managerRadioButton.isSelected()) {
                    managerBonusField1.setVisible(true);
                    managerBonusField.setVisible(false);
                    managerBonusField2.setVisible(false);
                }
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

                if (managerRadioButton.isSelected()) {
                    managerBonusField1.setVisible(true);
                    managerBonusField.setVisible(false);
                    managerBonusField2.setVisible(false);
                }
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
        statusObservableList = FXCollections.observableArrayList(statusArrayList);
        statusCombo.setItems(statusObservableList);

        employeeRadioButton.setSelected(true);
        managerRadioButton.setDisable(true);
//        Remember to add these lines later:
//        if (managerRadioButton.isSelected()) {
//            managerBonusTextField.setVisible(true);
//        }
//        else {
//            managerBonusTextField.setVisible(false);
//        }
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
                    if (!emp.isManager() && emp.isActive() && !employeeBaseSalariedArrayList.contains(emp)) {
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
                    if (!emp.isManager() && emp.isActive() && !employeeHourlySalariedArrayList.contains(emp)) {
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
                    if (!emp.isManager() && emp.isActive() && !employeeCommissionSalariedArrayList.contains(emp)) {
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
                    if (!emp.isManager() && emp.isActive() && !employeeCommissionBaseSalariedArrayList.contains(emp)) {
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

    private void throwAlert(String header, String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

    private void resetFields() {
        addEmployeeButton.setDisable(false);
        baseSalaryField.setDisable(false);
        statusCombo.setVisible(false);
        applyButton2.setVisible(false);
        cancelButton2.setVisible(false);
        deactiveButton.setVisible(false);
        editButton.setVisible(false);
        statusCombo.setVisible(false);
        applyButton.setVisible(false);
        cancelButton.setVisible(false);
        employeeRadioButton.setVisible(false);
        managerRadioButton.setVisible(false);

        employeePickTypeCombo.setEditable(false);
        nameField.setEditable(true);
        familyField.setEditable(true);
        nationalIdField.setEditable(true);
        phoneField.setEditable(true);
        birthDatePicker.setEditable(false);
        birthDatePicker.setDisable(false);
        baseSalaryField.setEditable(true);
        managerBonusField.setEditable(true);
        managerBonusField.setDisable(false);
        DepartmentCombo.setDisable(false);
        numberOfSalesField2.setEditable(true);
        commissionRateField2.setEditable(true);
        PayPerHourField.setEditable(true);
        amountOfHoursField.setEditable(true);
        numberOfSalesField.setEditable(true);
        commissionRateField.setEditable(true);

        nameField.setText("");
        familyField.setText("");
        nationalIdField.setText("");
        phoneField.setText("");
        managerBonusField.setText("");
        birthDatePicker.setValue(null);
        DepartmentCombo.setValue(null);
        baseSalaryField.setText("");
        commissionRateField2.setText("");
        numberOfSalesField2.setText("");
        PayPerHourField.setText("");
        amountOfHoursField.setText("");
        commissionRateField.setText("");
        numberOfSalesField.setText("");
    }

    public boolean isNumeric(String inputStr) {
        if (inputStr == null) {
            return false;
        }

        try {
            double num = Double.parseDouble(inputStr);
        }

        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isChar(String inputStr) {
        if (inputStr == null) {
            return false;
        }

        if (inputStr.matches("^[a-zA-Z_]+$")) {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean charOnlyTextFieldsChecker() {
        if (isChar(nameField.getText()) && isChar(familyField.getText())) {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean numericOnlyManagerTextFieldsChecker() {
        if (isNumeric(phoneField.getText()) && isNumeric(nationalIdField.getText()) && isNumeric(managerBonusField.getText())) {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean numericOnlyEmployeeTextFieldsChecker() {
        if (isNumeric(phoneField.getText()) && isNumeric(nationalIdField.getText())) {
            return true;
        }

        else {
            return false;
        }
    }
}
