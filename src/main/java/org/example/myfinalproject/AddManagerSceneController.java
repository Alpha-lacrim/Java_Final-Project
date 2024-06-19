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

public class AddManagerSceneController implements Initializable {
    //Department variables.
    File departmentFile = new File("Department.txt");
    ObservableList<Department> departmentObservableList;
    ArrayList<Department> departmentArrayList = new ArrayList<>();

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

    ObservableList<String> typeOfEmployee = FXCollections.observableArrayList("base-salaried","hourly-salaried",
            "commission-salaried","base-commission salaried");

    @FXML
    void onAddManagerButton(ActionEvent event) {
        var type = (String) managerPickTypeCombo.getSelectionModel().getSelectedItem();

        try {
            var department = (Department) DepartmentCombo.getSelectionModel().getSelectedItem();
            switch (type) {
                case "base-salaried":
                    if (!department.isHasManager()) {
                        var baseSalariedEmp = new BaseSalariedEmployee(nameField.getText(),familyField.getText(),
                                nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                LocalDate.now(),birthDatePicker.getValue(), department, Double.parseDouble(baseSalaryField.getText()));
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
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!");
                        alert.setContentText("This Department already has a manager");
                        alert.showAndWait();
                    }
                    break;
                case "hourly-salaried":
                    if (!department.isHasManager()) {
                        var hourlySalariedEmp = new HourlySalariedEmployee(nameField.getText(),familyField.getText(),
                                nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                LocalDate.now(),birthDatePicker.getValue(), department, Double.parseDouble(PayPerHourField.getText())
                                ,Double.parseDouble(amountOfHoursField.getText()));
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
                    } else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!");
                        alert.setContentText("This Department already has a manager");
                        alert.showAndWait();
                    }
                    break;
                case "commission-salaried":
                    if (!department.isHasManager()) {
                        var commissionSalariedEmp = new CommissionSalariedEmployee(nameField.getText(),familyField.getText(),
                                nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                LocalDate.now(),birthDatePicker.getValue(), department, Double.parseDouble(commissionRateField.getText())
                                ,Integer.parseInt(numberOfSalesField.getText()));
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
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!");
                        alert.setContentText("This Department already has a manager");
                        alert.showAndWait();
                    }
                    break;
                case "base-commission salaried":
                    if (!department.isHasManager()) {
                        var commissionBaseSalariedEmp = new CommissionBaseSalariedEmployee(nameField.getText(),familyField.getText(),
                                nationalIdField.getText(), phoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                LocalDate.now(),birthDatePicker.getValue(), department,Double.parseDouble(baseSalaryField.getText())
                                , Double.parseDouble(commissionRateField2.getText())
                                ,Integer.parseInt(numberOfSalesField2.getText()));
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
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!");
                        alert.setContentText("This Department already has a manager");
                        alert.showAndWait();
                    }
                    break;
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
                    if (emp.isManager() && !managerBaseSalariedArrayList.contains(emp)) {
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
                    if (emp.isManager() && !managerHourlySalariedArrayList.contains(emp)) {
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
                    if (emp.isManager() && !managerCommissionSalariedArrayList.contains(emp)) {
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
                    if (emp.isManager() && !managerCommissionBaseSalariedArrayList.contains(emp)) {
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
}
