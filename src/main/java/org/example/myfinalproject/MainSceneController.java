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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    @FXML
    private TableView<Department> departmentTable;

    @FXML
    private TableColumn<Department,String> departmentColumn;

    @FXML
    private TableColumn<Department,Integer> numberOfEmployeesColumn;

    @FXML
    private TableColumn<Department,String> sinceColumn;

    @FXML
    private TextField nameOfDepartmentField;

    @FXML
    private DatePicker departmentDatePicker;

    File departmentFile = new File("Department.txt");
    ObservableList<Department> departmentObservableList;
    ArrayList<Department> departmentArrayList = new ArrayList<>();

    // upside variables used for department.

    @FXML
    private TextField managerBaseSalaryField;

    @FXML
    private TextField managerCommissionRateField;

    @FXML
    private TextField managerNumberOfSalesField;

    @FXML
    private DatePicker managerBirthDatePicker;

    @FXML
    private TextField managerBonusField;

    @FXML
    private TextField managerFamilyNameField;

    @FXML
    private TextField managerNameField;

    @FXML
    private TextField managerNationalIdField;

    @FXML
    private TextField managerPhoneField;

    @FXML
    private ComboBox<Department> managerPickDepartmentCombo;

    @FXML
    private ComboBox<String> managerPickTypeCombo;

    ObservableList<String> typeOfEmployee = FXCollections.observableArrayList("base-salaried","hourly-salaried",
            "commission-salaried","base-commission salaried");


    // Creating observable list, array list and file for baseSalary employees
    File baseSalariedFile = new File("BaseSalaried.txt");
    ObservableList<BaseSalariedEmployee> managerBaseSalariedEmployeeObservableList;
    ArrayList<BaseSalariedEmployee> baseSalariedArrayList = new ArrayList<>();
    ArrayList<BaseSalariedEmployee> managerBaseSalariedArrayList = new ArrayList<>();

    // Base Salaried managers Arraylists
    @FXML
    private TableView<BaseSalariedEmployee> managerBaseSalaryTable;

    @FXML
    private TableColumn<BaseSalariedEmployee,Double> managerBaseSalariedBaseColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalariedBirthDateColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Double> managerBaseSalariedBonusColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalariedFamilyColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Integer> managerBaseSalariedIDColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalariedNameColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalariedNationalColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,String> managerBaseSalariedPhoneColumn;

    @FXML
    private TableColumn<BaseSalariedEmployee,Department> managerBaseSalariedDepartmentColumn;


    // Creating observable list, array list and file for baseSalary employees
    File commissionBaseFile = new File("CommissionBaseSalaried.txt");
    ObservableList<CommissionBaseSalariedEmployee> managerCommissionBaseEmployeeObservableList;
    ArrayList<CommissionBaseSalariedEmployee> commissionBaseArrayList = new ArrayList<>();
    ArrayList<CommissionBaseSalariedEmployee> managerCommissionBaseArrayList = new ArrayList<>();


    // Commission Base Salaried managers Arraylists
    @FXML
    private TableView<CommissionBaseSalariedEmployee> managerCommissionBaseTable;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,Double> managerBaseCommissionBaseColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> managerCommissionBaseBirthDateColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,Double> managerCommissionBaseBonusColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> managerCommissionBaseFamilyColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,Integer> managerCommissionBaseIDColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> managerCommissionBaseNameColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> managerCommissionBaseNationalColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,String> managerCommissionBasePhoneColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,Department> managerCommissionBaseDepartmentColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee, Integer> managerCommissionBaseNumberOfSalesColumn;

    @FXML
    private TableColumn<CommissionBaseSalariedEmployee,Department> managerCommissionBaseCommissionRateColumn;


    @FXML
    private AnchorPane addDepartmentPane;

    @FXML
    private AnchorPane addEmployeePane;

    @FXML
    private AnchorPane addManagerPane;


    @FXML
    void onAddDepartmentButton(ActionEvent event) {
        departmentReadFromFile();
        addDepartmentPane.setVisible(true);
        addEmployeePane.setVisible(false);
        addManagerPane.setVisible(false);
    }

    @FXML
    void onAddEmployeeButton(ActionEvent event) {
        addDepartmentPane.setVisible(false);
        addEmployeePane.setVisible(true);
        addManagerPane.setVisible(false);
    }

    @FXML
    void onAddManagerButton(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addManagerScene.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void onAddDepartmentButton2(ActionEvent event) {
        departmentReadFromFile();
        var department = new Department(nameOfDepartmentField.getText(), departmentDatePicker.getValue());
        departmentArrayList.add(department);
        departmentObservableList = departmentTable.getItems();
        departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
        departmentTable.setItems(departmentObservableList);
        nameOfDepartmentField.setText("");
        departmentDatePicker.setValue(null);
        departmentWriteToFile();
    }

    @FXML
    void onManagerComboBox(ActionEvent event) {
        switch (managerPickTypeCombo.getValue()) {
            case "base-salaried":
                managerCommissionBaseTable.setVisible(false);
                managerBaseSalaryTable.setVisible(true);

                managerCommissionRateField.setVisible(false);
                managerNumberOfSalesField.setVisible(false);
                break;

            case "base-commission salaried":
                managerBaseSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(true);

                managerCommissionRateField.setVisible(true);
                managerNumberOfSalesField.setVisible(true);
                break;

            case "hourly-salaried":
                managerBaseSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(false);
                break;

            case "commission-salaried":
                managerBaseSalaryTable.setVisible(false);
                managerCommissionBaseTable.setVisible(false);
                break;
        }
    }

    @FXML
    void onAddManagerButton2(ActionEvent event) {
        String type = (String) managerPickTypeCombo.getSelectionModel().getSelectedItem();

        try {
            var department = (Department) managerPickDepartmentCombo.getSelectionModel().getSelectedItem();
            switch (type) {
                case "base-salaried":
                    if (!department.isHasManager()) {
                        baseSalaryReadFromFile();
                        var baseSalariedEmp = new BaseSalariedEmployee(managerNameField.getText(), managerFamilyNameField.getText(),
                                managerNationalIdField.getText(), managerPhoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                LocalDate.now(), managerBirthDatePicker.getValue(), department, Double.parseDouble(managerBaseSalaryField.getText()));
                        departmentWriteToFile();
                        baseSalariedArrayList.add(baseSalariedEmp);
                        managerBaseSalariedEmployeeObservableList = managerBaseSalaryTable.getItems();
                        managerBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(baseSalariedArrayList);
                        managerBaseSalaryTable.setItems(managerBaseSalariedEmployeeObservableList);
                        baseSalaryWriteToFile();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!");
                        alert.setContentText("This Department already has a manager");
                        alert.showAndWait();
                    }
                    break;
                case "base-commission salaried":
                    managerBaseSalaryTable.setVisible(false);
                    managerCommissionBaseTable.setVisible(true);

                    if (!department.isHasManager()) {
                        commissionBaseReadFromFile();
                        var commissionBaseSalariedEmp = new CommissionBaseSalariedEmployee(managerNameField.getText(), managerFamilyNameField.getText(),
                                managerNationalIdField.getText(), managerPhoneField.getText(), Double.parseDouble(managerBonusField.getText()),
                                LocalDate.now(), managerBirthDatePicker.getValue(), department, Double.parseDouble(managerBaseSalaryField.getText()),
                                Double.parseDouble(managerCommissionRateField.getText()), Integer.parseInt(managerNumberOfSalesField.getText()));
                        departmentWriteToFile();
                        commissionBaseArrayList.add(commissionBaseSalariedEmp);
                        managerCommissionBaseEmployeeObservableList = managerCommissionBaseTable.getItems();
                        managerCommissionBaseEmployeeObservableList = FXCollections.observableArrayList(commissionBaseArrayList);
                        managerCommissionBaseTable.setItems(managerCommissionBaseEmployeeObservableList);
                        commissionBaseWriteToFile();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        numberOfEmployeesColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfEmployees"));
        sinceColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        departmentReadFromFile();
        managerBaseSalariedBaseColumn.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        managerBaseSalariedBirthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        managerBaseSalariedBonusColumn.setCellValueFactory(new PropertyValueFactory<>("managerBonus"));
        managerBaseSalariedFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        managerBaseSalariedIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        managerBaseSalariedNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        managerBaseSalariedNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        managerBaseSalariedPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        managerBaseSalariedDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        baseSalaryReadFromFile();




        managerBaseCommissionBaseColumn.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        managerCommissionBaseBirthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        managerCommissionBaseBonusColumn.setCellValueFactory(new PropertyValueFactory<>("managerBonus"));
        managerCommissionBaseFamilyColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        managerCommissionBaseIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        managerCommissionBaseNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        managerCommissionBaseNationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalID"));
        managerCommissionBasePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        managerCommissionBaseDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        managerCommissionBaseNumberOfSalesColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfSales"));
        managerCommissionBaseCommissionRateColumn.setCellValueFactory(new PropertyValueFactory<>("commissionRate"));
        commissionBaseReadFromFile();

        managerPickTypeCombo.setItems(typeOfEmployee);
        managerPickDepartmentCombo.setItems(departmentObservableList);
    }

    private void departmentReadFromFile(){
        if(departmentFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(departmentFile));
                departmentArrayList = (ArrayList<Department>) ois.readObject();
                ois.close();
                departmentObservableList = departmentTable.getItems();
                departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                departmentTable.setItems(departmentObservableList);
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nothing to show !");
                alert.setContentText("There is no department to show ...");
                alert.showAndWait();
            }
        }
    }

    private void departmentWriteToFile(){
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

    private void baseSalaryReadFromFile(){
        int sameManagerQuantity = 0;
        if(baseSalariedFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(baseSalariedFile));
                baseSalariedArrayList = (ArrayList<BaseSalariedEmployee>) ois.readObject();
                for (BaseSalariedEmployee emp : baseSalariedArrayList) {
                    if (emp.isManager()) {
                        for (BaseSalariedEmployee manager : managerBaseSalariedArrayList) {
                            if (manager.getID() == emp.getID()) {
                                sameManagerQuantity += 1;
                                break;
                            }
                        }

                        if (sameManagerQuantity == 1) {
                            managerBaseSalariedArrayList.add(emp);
                        }
                    }
                }
                ois.close();
                managerBaseSalariedEmployeeObservableList = managerBaseSalaryTable.getItems();
                managerBaseSalariedEmployeeObservableList = FXCollections.observableArrayList(baseSalariedArrayList);
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

    // file handling for base + commission managers
    private void commissionBaseReadFromFile(){
        int sameManagerQuantity = 0;
        if(commissionBaseFile.isFile()) {
            try {
                ObjectInputStream ois;
                ois = new ObjectInputStream(new FileInputStream(commissionBaseFile));
                commissionBaseArrayList = (ArrayList<CommissionBaseSalariedEmployee>) ois.readObject();
                for (CommissionBaseSalariedEmployee emp : commissionBaseArrayList) {
                    if (emp.isManager()) {
                        for (CommissionBaseSalariedEmployee manager : managerCommissionBaseArrayList) {
                            if (manager.getID() == emp.getID()) {
                                sameManagerQuantity += 1;
                                break;
                            }
                        }

                        if (sameManagerQuantity == 1) {
                            managerCommissionBaseArrayList.add(emp);
                        }
                    }
                }
                ois.close();
                managerCommissionBaseEmployeeObservableList = managerCommissionBaseTable.getItems();
                managerCommissionBaseEmployeeObservableList = FXCollections.observableArrayList(commissionBaseArrayList);
                managerCommissionBaseTable.setItems(managerCommissionBaseEmployeeObservableList);
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nothing to show !");
                alert.setContentText("There is no Commission Base Salaried Employee in this department ...");
                alert.showAndWait();
            }
        }
    }


    private void commissionBaseWriteToFile(){
        try {
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream(commissionBaseFile));
            oos.writeObject(commissionBaseArrayList);
            oos.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR !");
            alert.setContentText("Something went wrong while trying to write in Commission Base Salary file ...");
            alert.showAndWait();
        }
    }


    private void refreshDepartmentComboBox(){
        departmentReadFromFile();
        managerPickDepartmentCombo.setItems(departmentObservableList);
    }

}