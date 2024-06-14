package org.example.myfinalproject;

import javafx.beans.Observable;
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
import javafx.util.converter.BooleanStringConverter;
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
    private TextField nameOfDepartmentFiled;

    @FXML
    private DatePicker departmentDatePicker;

    File departmentFile = new File("Department.txt");
    ObservableList<Department> departmentObservableList;
    ArrayList<Department> departmentArrayList = new ArrayList<>();

    // upside variables used for department.

    @FXML
    private TextField mangerBaseSalaryFiled;

    @FXML
    private DatePicker mangerBirthDatePicker;

    @FXML
    private TextField mangerBonusFiled;

    @FXML
    private TextField mangerFamilyNameFiled;

    @FXML
    private TextField mangerNameFiled;

    @FXML
    private TextField mangerNationalIdFiled;

    @FXML
    private TextField mangerPhoneFiled;

    @FXML
    private ComboBox<Department> mangerPickDepartmentCombo;

    @FXML
    private ComboBox<String> mangerPickTypeCombo;

    ObservableList<String> typeOfEmployee = FXCollections.observableArrayList("base-salaried","hourly-salaried",
            "commission-salaried","base-commission salaried");

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

    //upside variables for manger.

    @FXML
    private AnchorPane addDepartmentPane;

    @FXML
    private AnchorPane addEmployeePane;

    @FXML
    private AnchorPane addManagerPane;

    File baseSalariedFile = new File("BaseSalaried.txt");
    ArrayList<BaseSalariedEmployee> baseSalariedArrayList = new ArrayList<>();
    ObservableList<BaseSalariedEmployee> baseSalariedEmployeeObservableList;

    //upside variables used for pane.
    ObjectInputStream ois;
    ObjectOutputStream oos;

    @FXML
    void onAddDepartmentButton(ActionEvent event) {
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
    void onAddManagerButton(ActionEvent event) {
        addDepartmentPane.setVisible(false);
        addEmployeePane.setVisible(false);
        addManagerPane.setVisible(true);
    }

    @FXML
    void onAddDepartmentButton2(ActionEvent event) {
        departmentReadFromFile();
        var department = new Department(nameOfDepartmentFiled.getText(),departmentDatePicker.getValue());
        departmentArrayList.add(department);
        departmentObservableList = departmentTable.getItems();
        departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
        departmentTable.setItems(departmentObservableList);
        nameOfDepartmentFiled.setText("");
        departmentWriteToFile();
    }

    @FXML
    void onAddManagerButton2(ActionEvent event) {
        String type = (String) mangerPickTypeCombo.getSelectionModel().getSelectedItem();
        switch (type) {
            case "base-salaried":
                var department = (Department) mangerPickDepartmentCombo.getSelectionModel().getSelectedItem();
                if (!department.isHasManager()) {
                    baseSalaryReadFromFile();
                    var baseSalariedEmp = new BaseSalariedEmployee(mangerNameFiled.getText(),mangerFamilyNameFiled.getText(),
                            mangerNationalIdFiled.getText(),mangerPhoneFiled.getText(),Double.parseDouble(mangerBonusFiled.getText()),
                            LocalDate.now(),mangerBirthDatePicker.getValue(),department,Double.parseDouble(mangerBaseSalaryFiled.getText()));
                    baseSalariedArrayList.add(baseSalariedEmp);
                    baseSalariedEmployeeObservableList = managerBaseSalaryTable.getItems();
                    baseSalariedEmployeeObservableList = FXCollections.observableArrayList(baseSalariedArrayList);
                    managerBaseSalaryTable.setItems(baseSalariedEmployeeObservableList);
                    baseSalaryWriteToFile();

                } else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("This Department has Manger!");
                    alert.showAndWait();
                }
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        departmentColumn.setCellValueFactory(new PropertyValueFactory<Department,String>("name"));
        numberOfEmployeesColumn.setCellValueFactory(new PropertyValueFactory<Department,Integer>("numberOfEmployees"));
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
        mangerPickTypeCombo.setItems(typeOfEmployee);
        mangerPickDepartmentCombo.setItems(departmentObservableList);
        baseSalaryReadFromFile();
    }

    private void departmentReadFromFile(){
        if(departmentFile.isFile()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(departmentFile));
                departmentArrayList = (ArrayList<Department>) ois.readObject();
                ois.close();
                departmentObservableList = departmentTable.getItems();
                departmentObservableList = FXCollections.observableArrayList(departmentArrayList);
                departmentTable.setItems(departmentObservableList);
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("There is no department to Show");
                alert.showAndWait();
            }
        }
    }

    private void departmentWriteToFile(){
        try {
            oos = new ObjectOutputStream(new FileOutputStream(departmentFile));
            oos.writeObject(departmentArrayList);
            oos.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Something went wrong");
            alert.showAndWait();
        }
    }

    private void baseSalaryReadFromFile(){
        if(baseSalariedFile.isFile()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(baseSalariedFile));
                baseSalariedArrayList = (ArrayList<BaseSalariedEmployee>) ois.readObject();
                ois.close();
                baseSalariedEmployeeObservableList = managerBaseSalaryTable.getItems();
                baseSalariedEmployeeObservableList = FXCollections.observableArrayList(baseSalariedArrayList);
                managerBaseSalaryTable.setItems(baseSalariedEmployeeObservableList);
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("There is no base Salaried Employee to Show");
                alert.showAndWait();
            }
        }
    }

    private void baseSalaryWriteToFile(){
        try {
            oos = new ObjectOutputStream(new FileOutputStream(baseSalariedFile));
            oos.writeObject(baseSalariedArrayList);
            oos.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Something went wrong");
            alert.showAndWait();
        }
    }
}