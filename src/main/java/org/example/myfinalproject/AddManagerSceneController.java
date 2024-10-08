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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddManagerSceneController implements Initializable {
    //Department variables.
    File departmentFile = new File("Department.txt");
    ObservableList<Department> departmentObservableList;
    ArrayList<Department> departmentArrayList = new ArrayList<>();

    // Status combobox
    ObservableList<Status> statusObservableList;
    ArrayList<Status> statusArrayList = new ArrayList<>();

    // manager base salary variables.
    @FXML
    private TableView<BaseSalariedEmployee> managerBaseSalaryTable;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalaryBirthColumn;

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

    File baseSalariedFile = new File("BaseSalaried.txt");
    ObservableList<BaseSalariedEmployee> managerBaseSalariedEmployeeObservableList;
    ArrayList<BaseSalariedEmployee> baseSalariedArrayList = new ArrayList<>();
    ArrayList<BaseSalariedEmployee> managerBaseSalariedArrayList = new ArrayList<>();

    //manager hourly salaried variables.
    @FXML
    private TableColumn<HourlySalariedEmployee, Double> managerHourlySalaryAmountOfHoursColumn;

    @FXML
    private TableColumn<HourlySalariedEmployee, String> managerHourlySalaryBirthColumn;

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

    File hourlySalaryFile = new File("HourlySalaried.txt");
    ObservableList<HourlySalariedEmployee> managerHourlySalariedEmployeeObservableList;
    ArrayList<HourlySalariedEmployee> hourlySalariedArrayList = new ArrayList<>();
    ArrayList<HourlySalariedEmployee> managerHourlySalariedArrayList = new ArrayList<>();

    //manager commission salaried variables.
    @FXML
    private TableView<CommissionSalariedEmployee> managerCommissionSalaryTable;

    @FXML
    private TableColumn<CommissionSalariedEmployee,String> managerCommissionSalaryBirthColumn;

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

    File commissionSalaryFile = new File("CommissionSalaried.txt");
    ObservableList<CommissionSalariedEmployee> managerCommissionSalariedEmployeeObservableList;
    ArrayList<CommissionSalariedEmployee> commissionSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionSalariedEmployee> managerCommissionSalariedArrayList = new ArrayList<>();

    //manager commission base salaried variables.
    @FXML
    private TableView<CommissionBaseSalariedEmployee> managerCommissionBaseTable;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> managerCommissionBaseBirthColumn;

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

    File commissionBaseSalaryFile = new File("CommissionBaseSalaried.txt");
    ObservableList<CommissionBaseSalariedEmployee> managerCommissionBaseSalariedEmployeeObservableList;
    ArrayList<CommissionBaseSalariedEmployee> commissionBaseSalariedArrayList = new ArrayList<>();
    ArrayList<CommissionBaseSalariedEmployee> managerCommissionBaseSalariedArrayList = new ArrayList<>();

    //constant textFields in add manager Scene.

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
    private TextField managerBonusField;

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
    private ComboBox<String> managerPickTypeCombo;

    @FXML
    private Button applyButton;

    @FXML
    private Button applyButton2;

    @FXML
    private Button cancelButton;

    @FXML
    private Button cancelButton2;

    @FXML
    private Button editButton;

    @FXML
    private Button addManagerButton;

    @FXML
    private Button deActiveButton;

    @FXML
    private RadioButton employeeRadioButton;

    @FXML
    private RadioButton managerRadioButton;

    ObservableList<String> typeOfEmployee = FXCollections.observableArrayList("base-salaried","hourly-salaried",
            "commission-salaried","base-commission salaried");



    @FXML
    void onAddManagerButton(ActionEvent event) {
        var type = (String) managerPickTypeCombo.getSelectionModel().getSelectedItem();

        try {
            if (numericOnlyManagerTextFieldsChecker() && charOnlyTextFieldsChecker()) {

                var department = (Department) DepartmentCombo.getSelectionModel().getSelectedItem();
                switch (type) {
                    case "base-salaried":
                        if (!department.isHasManager()) {
                            if (isNumeric(baseSalaryField.getText())) {
                                var baseSalariedEmp = new BaseSalariedEmployee(nameField.getText(), familyField.getText(),
                                        nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                        LocalDate.now(), birthDatePicker.getValue(), department, Double.parseDouble(baseSalaryField.getText()));
                                departmentWriteToFile();
                                baseSalariedArrayList.add(baseSalariedEmp);
                                managerBaseSalariedArrayList.add(baseSalariedEmp);
                                managerBaseSalariedEmployeeObservableList = managerBaseSalaryTable.getItems();
                                managerBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(managerBaseSalariedArrayList);
                                managerBaseSalaryTable.setItems(managerBaseSalariedEmployeeObservableList);
                                baseSalaryWriteToFile();
                                //reset value of text boxes.
                                nameField.setText("");
                                familyField.setText("");
                                nationalIdField.setText("");
                                phoneField.setText("");
                                managerBonusField.setText("");
                                birthDatePicker.setValue(null);
                                baseSalaryField.setText("");
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
                                var hourlySalariedEmp = new HourlySalariedEmployee(nameField.getText(), familyField.getText(),
                                        nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                        LocalDate.now(), birthDatePicker.getValue(), department, Double.parseDouble(PayPerHourField.getText())
                                        , Double.parseDouble(amountOfHoursField.getText()));
                                departmentWriteToFile();
                                hourlySalariedArrayList.add(hourlySalariedEmp);
                                managerHourlySalariedArrayList.add(hourlySalariedEmp);
                                managerHourlySalariedEmployeeObservableList = managerHourlySalaryTable.getItems();
                                managerHourlySalariedEmployeeObservableList = FXCollections.observableArrayList(managerHourlySalariedArrayList);
                                managerHourlySalaryTable.setItems(managerHourlySalariedEmployeeObservableList);
                                hourlySalaryWriteToFile();
                                //reset value of text boxes.
                                nameField.setText("");
                                familyField.setText("");
                                nationalIdField.setText("");
                                phoneField.setText("");
                                managerBonusField.setText("");
                                birthDatePicker.setValue(null);
                                PayPerHourField.setText("");
                                amountOfHoursField.setText("");
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
                                var commissionSalariedEmp = new CommissionSalariedEmployee(nameField.getText(), familyField.getText(),
                                        nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                        LocalDate.now(), birthDatePicker.getValue(), department, Double.parseDouble(commissionRateField.getText())
                                        , Integer.parseInt(numberOfSalesField.getText()));
                                departmentWriteToFile();
                                commissionSalariedArrayList.add(commissionSalariedEmp);
                                managerCommissionSalariedArrayList.add(commissionSalariedEmp);
                                managerCommissionSalariedEmployeeObservableList = managerCommissionSalaryTable.getItems();
                                managerCommissionSalariedEmployeeObservableList = FXCollections.observableArrayList(managerCommissionSalariedArrayList);
                                managerCommissionSalaryTable.setItems(managerCommissionSalariedEmployeeObservableList);
                                commissionSalaryWriteToFile();
                                //reset value of text boxes.
                                nameField.setText("");
                                familyField.setText("");
                                nationalIdField.setText("");
                                phoneField.setText("");
                                managerBonusField.setText("");
                                birthDatePicker.setValue(null);
                                commissionRateField.setText("");
                                numberOfSalesField.setText("");
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
                            if (isNumeric(commissionRateField2.getText()) && isNumeric(numberOfSalesField2.getText()) && isNumeric(baseSalaryField.getText())) {
                                var commissionBaseSalariedEmp = new CommissionBaseSalariedEmployee(nameField.getText(), familyField.getText(),
                                        nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                        LocalDate.now(), birthDatePicker.getValue(), department, Double.parseDouble(baseSalaryField.getText())
                                        , Double.parseDouble(commissionRateField2.getText())
                                        , Integer.parseInt(numberOfSalesField2.getText()));
                                departmentWriteToFile();
                                commissionBaseSalariedArrayList.add(commissionBaseSalariedEmp);
                                managerCommissionBaseSalariedArrayList.add(commissionBaseSalariedEmp);
                                managerCommissionBaseSalariedEmployeeObservableList = managerCommissionBaseTable.getItems();
                                managerCommissionBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(managerCommissionBaseSalariedArrayList);
                                managerCommissionBaseTable.setItems(managerCommissionBaseSalariedEmployeeObservableList);
                                commissionBaseSalaryWriteToFile();
                                //reset value of text boxes.
                                nameField.setText("");
                                familyField.setText("");
                                nationalIdField.setText("");
                                phoneField.setText("");
                                managerBonusField.setText("");
                                birthDatePicker.setValue(null);
                                baseSalaryField.setText("");
                                commissionRateField2.setText("");
                                numberOfSalesField2.setText("");
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
        employeeRadioButton.setDisable(true);
        employeeRadioButton.setSelected(false);
        managerRadioButton.setSelected(true);
        managerRadioButton.setDisable(false);


            switch (managerPickTypeCombo.getValue()) {
                    case "base-salaried":
                        managerPickTypeCombo.setEditable(false);
                        nameField.setEditable(false);
                        familyField.setEditable(false);
                        nationalIdField.setEditable(false);
                        phoneField.setEditable(false);
                        birthDatePicker.setEditable(false);
                        birthDatePicker.setDisable(true);
                        baseSalaryField.setEditable(true);
                        managerBonusField.setEditable(true);
                        DepartmentCombo.setEditable(false);
                        DepartmentCombo.setDisable(false);
                        break;

                    case "base-commission salaried":
                        managerPickTypeCombo.setEditable(false);
                        nameField.setEditable(false);
                        familyField.setEditable(false);
                        nationalIdField.setEditable(false);
                        phoneField.setEditable(false);
                        birthDatePicker.setEditable(false);
                        birthDatePicker.setDisable(true);
                        numberOfSalesField2.setEditable(true);
                        baseSalaryField.setEditable(true);
                        commissionRateField2.setEditable(true);
                        managerBonusField.setEditable(true);
                        DepartmentCombo.setEditable(false);
                        DepartmentCombo.setDisable(false);
                        break;

                    case "hourly-salaried":
                        managerPickTypeCombo.setEditable(false);
                        nameField.setEditable(false);
                        familyField.setEditable(false);
                        nationalIdField.setEditable(false);
                        phoneField.setEditable(false);
                        birthDatePicker.setEditable(false);
                        birthDatePicker.setDisable(true);
                        PayPerHourField.setEditable(true);
                        amountOfHoursField.setEditable(true);
                        managerBonusField.setEditable(true);
                        DepartmentCombo.setEditable(false);
                        DepartmentCombo.setDisable(false);
                        break;

                    case "commission-salaried":
                        managerPickTypeCombo.setEditable(false);
                        nameField.setEditable(false);
                        familyField.setEditable(false);
                        nationalIdField.setEditable(false);
                        phoneField.setEditable(false);
                        birthDatePicker.setEditable(false);
                        birthDatePicker.setDisable(true);
                        numberOfSalesField.setEditable(true);
                        commissionRateField.setEditable(true);
                        managerBonusField.setEditable(true);
                        DepartmentCombo.setEditable(false);
                        DepartmentCombo.setDisable(false);
                        break;
            }
    }

    @FXML
    void onCancelButton(ActionEvent event) throws  IOException {
        //resetting all fields.
        addManagerButton.setDisable(false);
        managerBonusField.setDisable(false);
        statusCombo.setVisible(false);
        applyButton2.setVisible(false);
        cancelButton2.setVisible(false);
        deActiveButton.setVisible(false);
        editButton.setVisible(false);
        statusCombo.setVisible(false);
        applyButton.setVisible(false);
        cancelButton.setVisible(false);
        employeeRadioButton.setVisible(false);
        managerRadioButton.setVisible(false);

        managerPickTypeCombo.setEditable(false);
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

    @FXML
    void onApplyButton(ActionEvent event) throws IOException {
        if (!managerRadioButton.isSelected() && !employeeRadioButton.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Employee or Manager ?");
            alert.setTitle("ERROR !");
            alert.setContentText("You must select the new role of your selection.");
            alert.showAndWait();
        }


        else if (managerRadioButton.isSelected()){
            Employee emp = null;
            if(managerBaseSalaryTable.getSelectionModel().getSelectedItem() instanceof BaseSalariedEmployee){
                emp = managerBaseSalaryTable.getSelectionModel().getSelectedItem();
            }
            else if (managerCommissionBaseTable.getSelectionModel().getSelectedItem() instanceof CommissionBaseSalariedEmployee) {
                emp = managerCommissionBaseTable.getSelectionModel().getSelectedItem();
            }
            else if(managerCommissionSalaryTable.getSelectionModel().getSelectedItem() instanceof CommissionSalariedEmployee){
                emp = managerCommissionSalaryTable.getSelectionModel().getSelectedItem();
            }
            else if(managerHourlySalaryTable.getSelectionModel().getSelectedItem() instanceof HourlySalariedEmployee){
                emp = managerHourlySalaryTable.getSelectionModel().getSelectedItem();
            }


            var type = (String) managerPickTypeCombo.getSelectionModel().getSelectedItem();
            boolean isAcceptable = false;

            try {
                if (charOnlyTextFieldsChecker() && numericOnlyManagerTextFieldsChecker()) {

                    var department = (Department) DepartmentCombo.getSelectionModel().getSelectedItem();

                    // This block of code is for creating another object with the new info
                    switch (type) {
                        case "base-salaried":
                            if (!department.isHasManager()) {
                                if (isNumeric(baseSalaryField.getText())) {
                                    var baseSalariedEmp = new BaseSalariedEmployee(nameField.getText(), familyField.getText(),
                                            nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                            LocalDate.now(), birthDatePicker.getValue(), department, Double.parseDouble(baseSalaryField.getText()));
                                    departmentWriteToFile();
                                    baseSalariedArrayList.add(baseSalariedEmp);
                                    managerBaseSalariedArrayList.add(baseSalariedEmp);
                                    managerBaseSalariedEmployeeObservableList = managerBaseSalaryTable.getItems();
                                    managerBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(managerBaseSalariedArrayList);
                                    managerBaseSalaryTable.setItems(managerBaseSalariedEmployeeObservableList);
                                    baseSalaryWriteToFile();
                                    isAcceptable = true;
                                    //reset value of text boxes.
                                    nameField.setText("");
                                    familyField.setText("");
                                    nationalIdField.setText("");
                                    phoneField.setText("");
                                    managerBonusField.setText("");
                                    birthDatePicker.setValue(null);
                                    baseSalaryField.setText("");
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
                                if (isNumeric(PayPerHourField.getText()) && isNumeric(amountOfHoursField.getText())) {
                                    var hourlySalariedEmp = new HourlySalariedEmployee(nameField.getText(), familyField.getText(),
                                            nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                            LocalDate.now(), birthDatePicker.getValue(), department, Double.parseDouble(PayPerHourField.getText())
                                            , Double.parseDouble(amountOfHoursField.getText()));
                                    departmentWriteToFile();
                                    hourlySalariedArrayList.add(hourlySalariedEmp);
                                    managerHourlySalariedArrayList.add(hourlySalariedEmp);
                                    managerHourlySalariedEmployeeObservableList = managerHourlySalaryTable.getItems();
                                    managerHourlySalariedEmployeeObservableList = FXCollections.observableArrayList(managerHourlySalariedArrayList);
                                    managerHourlySalaryTable.setItems(managerHourlySalariedEmployeeObservableList);
                                    hourlySalaryWriteToFile();
                                    isAcceptable = true;
                                    //reset value of text boxes.
                                    nameField.setText("");
                                    familyField.setText("");
                                    nationalIdField.setText("");
                                    phoneField.setText("");
                                    managerBonusField.setText("");
                                    birthDatePicker.setValue(null);
                                    PayPerHourField.setText("");
                                    amountOfHoursField.setText("");
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
                                    var commissionSalariedEmp = new CommissionSalariedEmployee(nameField.getText(), familyField.getText(),
                                            nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                            LocalDate.now(), birthDatePicker.getValue(), department, Double.parseDouble(commissionRateField.getText())
                                            , Integer.parseInt(numberOfSalesField.getText()));
                                    departmentWriteToFile();
                                    commissionSalariedArrayList.add(commissionSalariedEmp);
                                    managerCommissionSalariedArrayList.add(commissionSalariedEmp);
                                    managerCommissionSalariedEmployeeObservableList = managerCommissionSalaryTable.getItems();
                                    managerCommissionSalariedEmployeeObservableList = FXCollections.observableArrayList(managerCommissionSalariedArrayList);
                                    managerCommissionSalaryTable.setItems(managerCommissionSalariedEmployeeObservableList);
                                    commissionSalaryWriteToFile();
                                    isAcceptable = true;
                                    //reset value of text boxes.
                                    nameField.setText("");
                                    familyField.setText("");
                                    nationalIdField.setText("");
                                    phoneField.setText("");
                                    managerBonusField.setText("");
                                    birthDatePicker.setValue(null);
                                    commissionRateField.setText("");
                                    numberOfSalesField.setText("");
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
                                if (isNumeric(numberOfSalesField2.getText()) && isNumeric(commissionRateField2.getText()) && isNumeric(baseSalaryField.getText())) {
                                    var commissionBaseSalariedEmp = new CommissionBaseSalariedEmployee(nameField.getText(), familyField.getText(),
                                            nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                            LocalDate.now(), birthDatePicker.getValue(), department, Double.parseDouble(baseSalaryField.getText())
                                            , Double.parseDouble(commissionRateField2.getText())
                                            , Integer.parseInt(numberOfSalesField2.getText()));
                                    departmentWriteToFile();
                                    commissionBaseSalariedArrayList.add(commissionBaseSalariedEmp);
                                    managerCommissionBaseSalariedArrayList.add(commissionBaseSalariedEmp);
                                    managerCommissionBaseSalariedEmployeeObservableList = managerCommissionBaseTable.getItems();
                                    managerCommissionBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(managerCommissionBaseSalariedArrayList);
                                    managerCommissionBaseTable.setItems(managerCommissionBaseSalariedEmployeeObservableList);
                                    commissionBaseSalaryWriteToFile();
                                    isAcceptable = true;
                                    //reset value of text boxes.
                                    nameField.setText("");
                                    familyField.setText("");
                                    nationalIdField.setText("");
                                    phoneField.setText("");
                                    managerBonusField.setText("");
                                    birthDatePicker.setValue(null);
                                    baseSalaryField.setText("");
                                    commissionRateField2.setText("");
                                    numberOfSalesField2.setText("");
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
                    department.setHasManager(false);
                    department.setNumberOfActiveEmployees(department.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department);
                    baseSalaryWriteToFile();
                    departmentWriteToFile();
                    managerBaseSalaryTable.getItems().remove(emp);
                    managerBaseSalariedArrayList.remove(emp);
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
                    department1.setHasManager(false);
                    department1.setNumberOfActiveEmployees(department1.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department1);
                    commissionBaseSalaryWriteToFile();
                    departmentWriteToFile();
                    managerCommissionBaseTable.getItems().remove(emp);
                    managerCommissionBaseSalariedArrayList.remove(emp);
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
                    department2.setHasManager(false);
                    department2.setNumberOfActiveEmployees(department2.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department2);
                    hourlySalaryWriteToFile();
                    departmentWriteToFile();
                    managerHourlySalaryTable.getItems().remove(emp);
                    managerHourlySalariedArrayList.remove(emp);
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
                    department3.setHasManager(false);
                    department3.setNumberOfActiveEmployees(department3.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department3);
                    commissionSalaryWriteToFile();
                    departmentWriteToFile();
                    managerCommissionSalaryTable.getItems().remove(emp);
                    managerCommissionSalariedArrayList.remove(emp);
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);
                }
                //resetting all fields.
                addManagerButton.setDisable(false);
                baseSalaryField.setDisable(false);
                statusCombo.setVisible(false);
                applyButton2.setVisible(false);
                cancelButton2.setVisible(false);
                deActiveButton.setVisible(false);
                editButton.setVisible(false);
                statusCombo.setVisible(false);
                applyButton.setVisible(false);
                cancelButton.setVisible(false);
                employeeRadioButton.setVisible(false);
                managerRadioButton.setVisible(false);

                managerPickTypeCombo.setEditable(false);
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

        }

        else if (employeeRadioButton.isSelected()) {
            Employee emp = null;
            if(managerBaseSalaryTable.getSelectionModel().getSelectedItem() instanceof BaseSalariedEmployee){
                emp = managerBaseSalaryTable.getSelectionModel().getSelectedItem();
            }
            else if (managerCommissionBaseTable.getSelectionModel().getSelectedItem() instanceof CommissionBaseSalariedEmployee) {
                emp = managerCommissionBaseTable.getSelectionModel().getSelectedItem();
            }
            else if(managerCommissionSalaryTable.getSelectionModel().getSelectedItem() instanceof CommissionSalariedEmployee){
                emp = managerCommissionSalaryTable.getSelectionModel().getSelectedItem();
            }
            else if(managerHourlySalaryTable.getSelectionModel().getSelectedItem() instanceof HourlySalariedEmployee){
                emp = managerHourlySalaryTable.getSelectionModel().getSelectedItem();
            }


            var type = (String) managerPickTypeCombo.getSelectionModel().getSelectedItem();
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
                                        nationalIdField.getText(), phoneField.getText(), LocalDate.now(),
                                        birthDatePicker.getValue(), department, Double.parseDouble(baseSalaryField.getText())
                                );
                                departmentWriteToFile();
                                baseSalariedArrayList.add(baseSalariedEmp);
                                managerHourlySalaryTable.setItems(managerHourlySalariedEmployeeObservableList);
                                baseSalaryWriteToFile();
                                isAcceptable = true;
                                //reset value of text boxes.
                                nameField.setText("");
                                familyField.setText("");
                                nationalIdField.setText("");
                                phoneField.setText("");
                                managerBonusField.setText("");
                                birthDatePicker.setValue(null);
                                baseSalaryField.setText("");
                            }
                            else {
                                throwAlert("Check your inputs !", "ERROR!", "Please check your inputs and try again");
                            }
                            break;

                        case "hourly-salaried":
                            if (isNumeric(PayPerHourField.getText()) && isNumeric((amountOfHoursField.getText()))) {
                                var hourlySalariedEmp = new HourlySalariedEmployee(
                                        nameField.getText(), familyField.getText(),
                                        nationalIdField.getText(), phoneField.getText(), LocalDate.now(),
                                        birthDatePicker.getValue(), department, Double.parseDouble(PayPerHourField.getText()),
                                        Double.parseDouble(amountOfHoursField.getText())
                                );
                                departmentWriteToFile();
                                hourlySalariedArrayList.add(hourlySalariedEmp);
                                managerHourlySalaryTable.setItems(managerHourlySalariedEmployeeObservableList);
                                hourlySalaryWriteToFile();
                                isAcceptable = true;
                                //reset value of text boxes.
                                nameField.setText("");
                                familyField.setText("");
                                nationalIdField.setText("");
                                phoneField.setText("");
                                managerBonusField.setText("");
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
                                var commissionSalariedEmp = new CommissionSalariedEmployee(
                                        nameField.getText(), familyField.getText(),
                                        nationalIdField.getText(), phoneField.getText(), LocalDate.now(),
                                        birthDatePicker.getValue(), department, Double.parseDouble(commissionRateField.getText()),
                                        Integer.parseInt(numberOfSalesField.getText())
                                );
                                departmentWriteToFile();
                                commissionSalariedArrayList.add(commissionSalariedEmp);
                                managerCommissionSalaryTable.setItems(managerCommissionSalariedEmployeeObservableList);
                                commissionSalaryWriteToFile();
                                isAcceptable = true;
                                //reset value of text boxes.
                                nameField.setText("");
                                familyField.setText("");
                                nationalIdField.setText("");
                                phoneField.setText("");
                                managerBonusField.setText("");
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
                                        nationalIdField.getText(), phoneField.getText(), LocalDate.now(),
                                        birthDatePicker.getValue(), department, Double.parseDouble(baseSalaryField.getText()),
                                        Double.parseDouble(commissionRateField2.getText()), Integer.parseInt(numberOfSalesField2.getText())
                                );
                                departmentWriteToFile();
                                commissionBaseSalariedArrayList.add(commissionBaseSalariedEmp);
                                managerCommissionBaseTable.setItems(managerCommissionBaseSalariedEmployeeObservableList);
                                commissionBaseSalaryWriteToFile();
                                isAcceptable = true;
                                //reset value of text boxes.
                                nameField.setText("");
                                familyField.setText("");
                                nationalIdField.setText("");
                                phoneField.setText("");
                                managerBonusField.setText("");
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
                    department.setHasManager(false);
                    department.setNumberOfActiveEmployees(department.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department);
                    baseSalaryWriteToFile();
                    departmentWriteToFile();
                    managerBaseSalaryTable.getItems().remove(emp);
                    managerBaseSalariedArrayList.remove(emp);
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
                    department1.setHasManager(false);
                    department1.setNumberOfActiveEmployees(department1.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department1);
                    commissionBaseSalaryWriteToFile();
                    departmentWriteToFile();
                    managerCommissionBaseTable.getItems().remove(emp);
                    managerCommissionBaseSalariedArrayList.remove(emp);
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
                    department2.setHasManager(false);
                    department2.setNumberOfActiveEmployees(department2.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department2);
                    hourlySalaryWriteToFile();
                    departmentWriteToFile();
                    managerHourlySalaryTable.getItems().remove(emp);
                    managerHourlySalariedArrayList.remove(emp);
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
                    department3.setHasManager(false);
                    department3.setNumberOfActiveEmployees(department3.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department3);
                    commissionSalaryWriteToFile();
                    departmentWriteToFile();
                    managerCommissionSalaryTable.getItems().remove(emp);
                    managerCommissionSalariedArrayList.remove(emp);
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);
                }
                //resetting all fields.
                addManagerButton.setDisable(false);
                managerBonusField.setDisable(false);
                statusCombo.setVisible(false);
                applyButton2.setVisible(false);
                cancelButton2.setVisible(false);
                deActiveButton.setVisible(false);
                editButton.setVisible(false);
                statusCombo.setVisible(false);
                applyButton.setVisible(false);
                cancelButton.setVisible(false);
                employeeRadioButton.setVisible(false);
                managerRadioButton.setVisible(false);

                managerPickTypeCombo.setEditable(false);
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
        }
    }

    @FXML
    void onApplyButton2(ActionEvent event) {
        int index = 0;
        String departmentName;
        if(!statusCombo.getSelectionModel().isEmpty()) {
            switch (managerPickTypeCombo.getValue()) {
                case "base-salaried":
                    BaseSalariedEmployee emp = managerBaseSalaryTable.getSelectionModel().getSelectedItem();
                    departmentName = emp.getDepartment().getName();

                    for (Department department : departmentArrayList) {
                        if (department.getName().equals(departmentName)) {
                            index = departmentArrayList.indexOf(department);
                        }
                    }
                    emp.setActive(false);
                    emp.setEndDate(LocalDate.now().toString());
                    emp.setStatus(statusCombo.getValue());
                    Department department = emp.getDepartment();
                    department.setHasManager(false);
                    department.setNumberOfActiveEmployees(department.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department);
                    baseSalaryWriteToFile();
                    departmentWriteToFile();
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);
                    managerBaseSalaryTable.getItems().remove(emp);
                    managerBaseSalariedArrayList.remove(emp);
                    break;

                case "base-commission salaried":
                    CommissionBaseSalariedEmployee emp1 = managerCommissionBaseTable.getSelectionModel().getSelectedItem();
                    departmentName = emp1.getDepartment().getName();

                    for (Department department1 : departmentArrayList) {
                        if (department1.getName().equals(departmentName)) {
                            index = departmentArrayList.indexOf(department1);
                        }
                    }

                    emp1.setActive(false);
                    emp1.setEndDate(LocalDate.now().toString());
                    emp1.setStatus(statusCombo.getValue());
                    Department department1 = emp1.getDepartment();
                    department1.setHasManager(false);
                    department1.setNumberOfActiveEmployees(department1.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department1);
                    commissionBaseSalaryWriteToFile();
                    departmentWriteToFile();
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);
                    managerCommissionBaseTable.getItems().remove(emp1);
                    managerCommissionBaseSalariedArrayList.remove(emp1);
                    break;

                case "hourly-salaried":
                    HourlySalariedEmployee emp2 = managerHourlySalaryTable.getSelectionModel().getSelectedItem();
                    departmentName = emp2.getDepartment().getName();

                    for (Department department2 : departmentArrayList) {
                        if (department2.getName().equals(departmentName)) {
                            index = departmentArrayList.indexOf(department2);
                        }
                    }
                    emp2.setActive(false);
                    emp2.setEndDate(LocalDate.now().toString());
                    emp2.setStatus(statusCombo.getValue());
                    Department department2 = emp2.getDepartment();
                    department2.setHasManager(false);
                    department2.setNumberOfActiveEmployees(department2.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department2);
                    hourlySalaryWriteToFile();
                    departmentWriteToFile();
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);
                    managerHourlySalaryTable.getItems().remove(emp2);
                    managerHourlySalariedArrayList.remove(emp2);
                    break;

                case "commission-salaried":
                    CommissionSalariedEmployee emp3 = managerCommissionSalaryTable.getSelectionModel().getSelectedItem();
                    departmentName = emp3.getDepartment().getName();

                    for (Department department3 : departmentArrayList) {
                        if (department3.getName().equals(departmentName)) {
                            index = departmentArrayList.indexOf(department3);
                        }
                    }
                    emp3.setActive(false);
                    emp3.setEndDate(LocalDate.now().toString());
                    emp3.setStatus(statusCombo.getValue());
                    Department department3 = emp3.getDepartment();
                    department3.setHasManager(false);
                    department3.setNumberOfActiveEmployees(department3.getNumberOfActiveEmployees() - 1);
                    departmentArrayList.set(index, department3);
                    commissionSalaryWriteToFile();
                    departmentWriteToFile();
                    departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                    DepartmentCombo.setItems(departmentObservableList);
                    managerCommissionSalaryTable.getItems().remove(emp3);
                    managerCommissionSalariedArrayList.remove(emp3);
                    break;
            }
            //resetting all fields.
            addManagerButton.setDisable(false);
            managerBonusField.setDisable(false);
            statusCombo.setVisible(false);
            applyButton2.setVisible(false);
            cancelButton2.setVisible(false);
            deActiveButton.setVisible(false);
            editButton.setVisible(false);
            statusCombo.setVisible(false);
            applyButton.setVisible(false);
            cancelButton.setVisible(false);
            employeeRadioButton.setVisible(false);
            managerRadioButton.setVisible(false);

            managerPickTypeCombo.setEditable(false);
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
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please choose status for deactivation");
            alert.showAndWait();
        }
    }

    @FXML
    void onCancelButton2(ActionEvent event) {
        //resetting all fields.
        addManagerButton.setDisable(false);
        baseSalaryField.setDisable(false);
        statusCombo.setVisible(false);
        applyButton2.setVisible(false);
        cancelButton2.setVisible(false);
        deActiveButton.setVisible(false);
        editButton.setVisible(false);
        statusCombo.setVisible(false);
        applyButton.setVisible(false);
        cancelButton.setVisible(false);
        employeeRadioButton.setVisible(false);
        managerRadioButton.setVisible(false);

        managerPickTypeCombo.setEditable(false);
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

    @FXML
    void onDeActiveButton(ActionEvent event) {
        statusCombo.setVisible(true);
        applyButton2.setVisible(true);
        cancelButton2.setVisible(true);
    }

    @FXML
    void onEmployeeRadio(ActionEvent event) throws  IOException {
        if (employeeRadioButton.isSelected()) {
            managerBonusField.setDisable(true);
            managerRadioButton.setDisable(true);
        }
        else {
            managerBonusField.setDisable(false);
            managerRadioButton.setDisable(false);
        }
    }

    @FXML
    void onManagerRadio(ActionEvent event) throws  IOException {
        if (managerRadioButton.isSelected()) {
            managerBonusField.setDisable(false);
            employeeRadioButton.setDisable(true);
        }
        else {
            managerBonusField.setDisable(true);
            employeeRadioButton.setDisable(false);
        }
    }
    //get items from table.
    @FXML
    void managerBaseSalaryTableGetItem(MouseEvent event) {
        int index = managerBaseSalaryTable.getSelectionModel().getSelectedIndex();

        if(index <= -1){
            return;
        }

        managerPickTypeCombo.setValue("base-salaried");
        nameField.setText(managerBaseSalaryNameColumn.getCellData(index));
        familyField.setText(managerBaseSalaryFamilyColumn.getCellData(index));
        nationalIdField.setText(managerBaseSalaryNationalColumn.getCellData(index));
        phoneField.setText(managerBaseSalaryPhoneColumn.getCellData(index));
        birthDatePicker.setValue(LocalDate.parse(managerBaseSalaryBirthColumn.getCellData(index)));
        baseSalaryField.setText(String.valueOf(managerBaseSalaryColumn.getCellData(index)));
        managerBonusField.setText(String.valueOf(managerBaseSalaryBonusColumn.getCellData(index)));
        DepartmentCombo.setValue(managerBaseSalaryDepartmentColumn.getCellData(index));

        managerPickTypeCombo.setEditable(false);
        nameField.setEditable(false);
        familyField.setEditable(false);
        nationalIdField.setEditable(false);
        phoneField.setEditable(false);
        birthDatePicker.setEditable(false);
        birthDatePicker.setDisable(true);
        baseSalaryField.setEditable(false);
        managerBonusField.setEditable(false);
        DepartmentCombo.setEditable(false);
        DepartmentCombo.setDisable(true);
        deActiveButton.setVisible(true);
        editButton.setVisible(true);
        addManagerButton.setDisable(true);
    }

    @FXML
    void managerCommissionBaseSalaryTableGetItem(MouseEvent event) {
        int index = managerCommissionBaseTable.getSelectionModel().getSelectedIndex();

        if(index <= -1){
            return;
        }

        managerPickTypeCombo.setValue("base-commission salaried");
        nameField.setText(managerCommissionBaseNameColumn.getCellData(index));
        familyField.setText(managerCommissionBaseFamilyColumn.getCellData(index));
        nationalIdField.setText(managerCommissionBaseNationalColumn.getCellData(index));
        phoneField.setText(managerCommissionBasePhoneColumn.getCellData(index));
        birthDatePicker.setValue(LocalDate.parse(managerCommissionBaseBirthColumn.getCellData(index)));
        managerBonusField.setText(String.valueOf(managerCommissionBaseBonusColumn.getCellData(index)));
        DepartmentCombo.setValue(managerCommissionBaseDepartmentColumn.getCellData(index));
        baseSalaryField.setText(String.valueOf(managerCommissionBaseSalaryColumn.getCellData(index)));
        numberOfSalesField2.setText(String.valueOf(managerCommissionBaseNumberOfSalesColumn.getCellData(index)));
        commissionRateField2.setText(String.valueOf(managerCommissionBaseRateColumn.getCellData(index)));

        managerPickTypeCombo.setEditable(false);
        nameField.setEditable(false);
        familyField.setEditable(false);
        nationalIdField.setEditable(false);
        phoneField.setEditable(false);
        birthDatePicker.setEditable(false);
        birthDatePicker.setDisable(true);
        baseSalaryField.setEditable(false);
        managerBonusField.setEditable(false);
        numberOfSalesField2.setEditable(false);
        commissionRateField2.setEditable(false);
        DepartmentCombo.setEditable(false);
        DepartmentCombo.setDisable(true);
        deActiveButton.setVisible(true);
        editButton.setVisible(true);
        addManagerButton.setDisable(true);
    }

    @FXML
    void managerCommissionSalaryTableGetItem(MouseEvent event) {
        int index = managerCommissionSalaryTable.getSelectionModel().getSelectedIndex();

        if(index <= -1){
            return;
        }

        managerPickTypeCombo.setValue("commission-salaried");
        nameField.setText(managerCommissionSalaryNameColumn.getCellData(index));
        familyField.setText(managerCommissionSalaryFamilyColumn.getCellData(index));
        nationalIdField.setText(managerCommissionSalaryNationalColumn.getCellData(index));
        phoneField.setText(managerCommissionSalaryPhoneColumn.getCellData(index));
        birthDatePicker.setValue(LocalDate.parse(managerCommissionSalaryBirthColumn.getCellData(index)));
        managerBonusField.setText(String.valueOf(managerCommissionSalaryBonusColumn.getCellData(index)));
        DepartmentCombo.setValue(managerCommissionSalaryDepartmentColumn.getCellData(index));
        numberOfSalesField.setText(String.valueOf(managerCommissionSalarySalesColumn.getCellData(index)));
        commissionRateField.setText(String.valueOf(managerCommissionSalaryRateColumn.getCellData(index)));

        managerPickTypeCombo.setEditable(false);
        nameField.setEditable(false);
        familyField.setEditable(false);
        nationalIdField.setEditable(false);
        phoneField.setEditable(false);
        birthDatePicker.setEditable(false);
        birthDatePicker.setDisable(true);
        managerBonusField.setEditable(false);
        numberOfSalesField.setEditable(false);
        commissionRateField.setEditable(false);
        DepartmentCombo.setEditable(false);
        DepartmentCombo.setDisable(true);
        deActiveButton.setVisible(true);
        editButton.setVisible(true);
        addManagerButton.setDisable(true);
    }

    @FXML
    void managerHourlySalaryTableGetItem(MouseEvent event) {
        int index = managerHourlySalaryTable.getSelectionModel().getSelectedIndex();

        if(index <= -1){
            return;
        }

        managerPickTypeCombo.setValue("hourly-salaried");
        nameField.setText(managerHourlySalaryNameColumn.getCellData(index));
        familyField.setText(managerHourlySalaryFamilyColumn.getCellData(index));
        nationalIdField.setText(managerHourlySalaryNationalColumn.getCellData(index));
        phoneField.setText(managerHourlySalaryPhoneColumn.getCellData(index));
        birthDatePicker.setValue(LocalDate.parse(managerHourlySalaryBirthColumn.getCellData(index)));
        managerBonusField.setText(String.valueOf(managerHourlySalaryBonusColumn.getCellData(index)));
        DepartmentCombo.setValue(managerHourlySalaryDepartmentColumn.getCellData(index));
        PayPerHourField.setText(String.valueOf(managerHourlySalaryPayColumn.getCellData(index)));
        amountOfHoursField.setText(String.valueOf(managerHourlySalaryAmountOfHoursColumn.getCellData(index)));

        managerPickTypeCombo.setEditable(false);
        nameField.setEditable(false);
        familyField.setEditable(false);
        nationalIdField.setEditable(false);
        phoneField.setEditable(false);
        birthDatePicker.setEditable(false);
        birthDatePicker.setDisable(true);
        managerBonusField.setEditable(false);
        PayPerHourField.setEditable(false);
        amountOfHoursField.setEditable(false);
        DepartmentCombo.setEditable(false);
        DepartmentCombo.setDisable(true);
        deActiveButton.setVisible(true);
        editButton.setVisible(true);
        addManagerButton.setDisable(true);
    }

    @FXML
    void unlockFields(MouseEvent event) {
        if(event.getClickCount() == 2) {
            statusCombo.setVisible(false);
            applyButton.setVisible(false);
            cancelButton.setVisible(false);
            employeeRadioButton.setVisible(false);
            managerRadioButton.setVisible(false);
            addManagerButton.setDisable(false);
            switch (managerPickTypeCombo.getValue()) {
                case "base-salaried":
                    managerPickTypeCombo.setEditable(false);
                    nameField.setEditable(true);
                    familyField.setEditable(true);
                    nationalIdField.setEditable(true);
                    phoneField.setEditable(true);
                    birthDatePicker.setEditable(false);
                    birthDatePicker.setDisable(false);
                    baseSalaryField.setEditable(true);
                    managerBonusField.setEditable(true);
                    DepartmentCombo.setDisable(false);

                    nameField.setText("");
                    familyField.setText("");
                    nationalIdField.setText("");
                    phoneField.setText("");
                    managerBonusField.setText("");
                    birthDatePicker.setValue(null);
                    DepartmentCombo.setValue(null);
                    baseSalaryField.setText("");
                    deActiveButton.setVisible(false);
                    editButton.setVisible(false);

                    break;

                case "base-commission salaried":
                    managerPickTypeCombo.setEditable(false);
                    nameField.setEditable(true);
                    familyField.setEditable(true);
                    nationalIdField.setEditable(true);
                    phoneField.setEditable(true);
                    birthDatePicker.setEditable(false);
                    birthDatePicker.setDisable(false);
                    numberOfSalesField2.setEditable(true);
                    baseSalaryField.setEditable(true);
                    commissionRateField2.setEditable(true);
                    managerBonusField.setEditable(true);
                    DepartmentCombo.setDisable(false);

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
                    deActiveButton.setVisible(false);
                    editButton.setVisible(false);
                    break;

                case "hourly-salaried":
                    managerPickTypeCombo.setEditable(false);
                    nameField.setEditable(true);
                    familyField.setEditable(true);
                    nationalIdField.setEditable(true);
                    phoneField.setEditable(true);
                    birthDatePicker.setEditable(false);
                    birthDatePicker.setDisable(false);
                    PayPerHourField.setEditable(true);
                    amountOfHoursField.setEditable(true);
                    managerBonusField.setEditable(true);
                    DepartmentCombo.setDisable(false);

                    nameField.setText("");
                    familyField.setText("");
                    nationalIdField.setText("");
                    phoneField.setText("");
                    managerBonusField.setText("");
                    birthDatePicker.setValue(null);
                    DepartmentCombo.setValue(null);
                    PayPerHourField.setText("");
                    amountOfHoursField.setText("");
                    deActiveButton.setVisible(false);
                    editButton.setVisible(false);
                    break;

                case "commission-salaried":
                    managerPickTypeCombo.setEditable(false);
                    nameField.setEditable(true);
                    familyField.setEditable(true);
                    nationalIdField.setEditable(true);
                    phoneField.setEditable(true);
                    birthDatePicker.setEditable(false);
                    birthDatePicker.setDisable(false);
                    numberOfSalesField.setEditable(true);
                    commissionRateField.setEditable(true);
                    managerBonusField.setEditable(true);
                    DepartmentCombo.setDisable(false);

                    nameField.setText("");
                    familyField.setText("");
                    nationalIdField.setText("");
                    phoneField.setText("");
                    managerBonusField.setText("");
                    birthDatePicker.setValue(null);
                    DepartmentCombo.setValue(null);
                    baseSalaryField.setText("");
                    commissionRateField.setText("");
                    numberOfSalesField.setText("");
                    deActiveButton.setVisible(false);
                    editButton.setVisible(false);
                    break;
            }
        }
    }

    @FXML
    void onManagerPickTypeCombo(ActionEvent event) {
        switch (managerPickTypeCombo.getValue()) {
            case "base-salaried":
                managerBaseSalaryTable.setVisible(true);
                baseSalaryField.setVisible(true);
                managerHourlySalaryTable.setVisible(false);
                PayPerHourField.setVisible(false);
                amountOfHoursField.setVisible(false);
                commissionRateField.setVisible(false);
                numberOfSalesField.setVisible(false);
                managerCommissionSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(false);
                numberOfSalesField2.setVisible(false);
                commissionRateField2.setVisible(false);

                break;

            case "base-commission salaried":
                managerBaseSalaryTable.setVisible(false);
                baseSalaryField.setVisible(true);
                managerHourlySalaryTable.setVisible(false);
                PayPerHourField.setVisible(false);
                amountOfHoursField.setVisible(false);
                commissionRateField.setVisible(false);
                numberOfSalesField.setVisible(false);
                managerCommissionSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(true);
                numberOfSalesField2.setVisible(true);
                commissionRateField2.setVisible(true);

                break;

            case "hourly-salaried":
                managerBaseSalaryTable.setVisible(false);
                baseSalaryField.setVisible(false);
                managerHourlySalaryTable.setVisible(true);
                PayPerHourField.setVisible(true);
                amountOfHoursField.setVisible(true);
                commissionRateField.setVisible(false);
                numberOfSalesField.setVisible(false);
                managerCommissionSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(false);
                numberOfSalesField2.setVisible(false);
                commissionRateField2.setVisible(false);

                break;

            case "commission-salaried":
                managerBaseSalaryTable.setVisible(false);
                baseSalaryField.setVisible(false);
                managerHourlySalaryTable.setVisible(false);
                PayPerHourField.setVisible(false);
                amountOfHoursField.setVisible(false);
                commissionRateField.setVisible(true);
                numberOfSalesField.setVisible(true);
                managerCommissionSalaryTable.setVisible(true);
                managerCommissionBaseTable.setVisible(false);
                numberOfSalesField2.setVisible(false);
                commissionRateField2.setVisible(false);

                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //manger base salary set table view.
        managerBaseSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        managerBaseSalaryEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        managerBaseSalaryBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        managerBaseSalaryBonusColumn.setCellValueFactory(new PropertyValueFactory<>("managerBonus"));
        managerBaseSalaryFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        managerBaseSalaryIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        managerBaseSalaryNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        managerBaseSalaryNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        managerBaseSalaryPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        managerBaseSalaryDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        baseSalaryReadFromFile();
        //manager hourly salary set table view.
        managerHourlySalaryAmountOfHoursColumn.setCellValueFactory(new PropertyValueFactory<>("amountOfHours"));
        managerHourlySalaryBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        managerHourlySalaryBonusColumn.setCellValueFactory(new PropertyValueFactory<>("managerBonus"));
        managerHourlySalaryDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        managerHourlySalaryEarningColumn.setCellValueFactory(new PropertyValueFactory<>("earning"));
        managerHourlySalaryFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        managerHourlySalaryIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        managerHourlySalaryNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        managerHourlySalaryNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        managerHourlySalaryPayColumn.setCellValueFactory(new PropertyValueFactory<>("payPerHour"));
        managerHourlySalaryPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        hourlySalaryReadFromFile();
        //manager commission Salary set table view.
        managerCommissionSalaryBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
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
        commissionSalaryReadFromFile();
        //manager commission salary set table view.
        managerCommissionBaseBirthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
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
        commissionBaseSalaryReadFromFile();
        //initialize department comboBox and pick type combo box.
        departmentReadFromFile();
        managerPickTypeCombo.setItems(typeOfEmployee);
        DepartmentCombo.setItems(departmentObservableList);

        // Initializing Status Combobox
        statusArrayList.add(Status.NO_PAY_DISMISSAL);
        statusArrayList.add(Status.FIRED);
        statusArrayList.add(Status.RETIRED);
        statusArrayList.add(Status.END_OF_CONTRACT);
        statusObservableList = FXCollections.observableArrayList(statusArrayList);
        statusCombo.setItems(statusObservableList);


//        Remember to add these lines later:
//        if (managerRadioButton.isSelected()) {
//            managerBonusTextField.setVisible(true);
//        }
//        else {
//            managerBonusTextField.setVisible(false);
//        }
    }

    // department read and write to file method.
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

    //base Salary read and write to file methods.
    private void baseSalaryReadFromFile() {

        if(baseSalariedFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(baseSalariedFile));
                baseSalariedArrayList = (ArrayList<BaseSalariedEmployee>) ois.readObject();
                for (BaseSalariedEmployee emp : baseSalariedArrayList) {
                    if (emp.isManager() && emp.isActive() && !managerBaseSalariedArrayList.contains(emp)) {
                        managerBaseSalariedArrayList.add(emp);
                    }
                }
                ois.close();
                managerBaseSalariedEmployeeObservableList = managerBaseSalaryTable.getItems();
                managerBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(managerBaseSalariedArrayList);
                managerBaseSalaryTable.setItems(managerBaseSalariedEmployeeObservableList);
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
                    if (emp.isManager() && emp.isActive() && !managerHourlySalariedArrayList.contains(emp)) {
                        managerHourlySalariedArrayList.add(emp);
                    }
                }
                ois.close();
                managerHourlySalariedEmployeeObservableList = managerHourlySalaryTable.getItems();
                managerHourlySalariedEmployeeObservableList = FXCollections.observableArrayList(managerHourlySalariedArrayList);
                managerHourlySalaryTable.setItems(managerHourlySalariedEmployeeObservableList);
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

    //Commission Salary read and write to file.

    private void commissionSalaryReadFromFile(){

        if(commissionSalaryFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(commissionSalaryFile));
                commissionSalariedArrayList = (ArrayList<CommissionSalariedEmployee>) ois.readObject();
                for (CommissionSalariedEmployee emp : commissionSalariedArrayList) {
                    if (emp.isManager() && emp.isActive() && !managerCommissionSalariedArrayList.contains(emp)) {
                        managerCommissionSalariedArrayList.add(emp);
                    }
                }
                ois.close();
                managerCommissionSalariedEmployeeObservableList = managerCommissionSalaryTable.getItems();
                managerCommissionSalariedEmployeeObservableList = FXCollections.observableArrayList(managerCommissionSalariedArrayList);
                managerCommissionSalaryTable.setItems(managerCommissionSalariedEmployeeObservableList);
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
                    if (emp.isManager() && emp.isActive() && !managerCommissionBaseSalariedArrayList.contains(emp)) {
                        managerCommissionBaseSalariedArrayList.add(emp);
                    }
                }
                ois.close();
                managerCommissionBaseSalariedEmployeeObservableList = managerCommissionBaseTable.getItems();
                managerCommissionBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(managerCommissionBaseSalariedArrayList);
                managerCommissionBaseTable.setItems(managerCommissionBaseSalariedEmployeeObservableList);
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
        if (isNumeric(phoneField.getText()) && isNumeric(nationalIdField.getText()) && isNumeric(managerBonusField.getText()) &&
                (phoneField.getText().length() <= 11 && phoneField.getText().length() >= 10) && (nationalIdField.getText().length() == 10))
        {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean numericOnlyEmployeeTextFieldsChecker() {
        if (isNumeric(phoneField.getText()) && isNumeric(nationalIdField.getText()) && (phoneField.getText().length() <= 11 &&
                phoneField.getText().length() >= 10) && (nationalIdField.getText().length() == 10))
        {
            return true;
        }

        else {
            return false;
        }
    }

    private void throwAlert(String header, String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(header);
        alert.showAndWait();
    }
}
