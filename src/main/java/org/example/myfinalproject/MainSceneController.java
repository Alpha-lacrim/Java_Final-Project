package org.example.myfinalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
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
    private BarChart<String, Integer> departmentEmployeesBarChart;

    @FXML
    private TableView<Department> departmentTable;

    @FXML
    private TableColumn<Department, String> departmentColumn;

    @FXML
    private TableColumn<Department, Integer> numberOfEmployeesColumn;

    @FXML
    private TableColumn<Department, String> sinceColumn;

    @FXML
    private TextField nameOfDepartmentField;

    @FXML
    private DatePicker departmentDatePicker;

    File departmentFile = new File("Department.txt");
    ObservableList<Department> departmentObservableList;
    ArrayList<Department> departmentArrayList = new ArrayList<>();


    @FXML
    void onAddEmployeeButton(ActionEvent event) throws IOException{
        Stage stage;
        Scene scene;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddEmployeeScene.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void onAddManagerButton(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddManagerScene.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void onHistoryButton(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("History.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
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
        refreshBarChart();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        numberOfEmployeesColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfActiveEmployees"));
        sinceColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        departmentReadFromFile();

        XYChart.Series<String, Integer> series1 = new XYChart.Series();
        series1.setName("Employees");
        for (int i = 0; i < departmentArrayList.size(); i++) {
            series1.getData().add(new XYChart.Data(departmentArrayList.get(i).getName(), departmentArrayList.get(i).getNumberOfActiveEmployees()));
        }
        departmentEmployeesBarChart.getData().addAll(series1);

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


    private void refreshBarChart() {
        departmentEmployeesBarChart.getData().clear();
        departmentEmployeesBarChart.setAnimated(false);

        XYChart.Series<String, Integer> series1 = new XYChart.Series();

        for (int i = 0; i < departmentArrayList.size(); i++) {
            series1.getData().add(new XYChart.Data(departmentArrayList.get(i).getName(), departmentArrayList.get(i).getNumberOfActiveEmployees()));
        }
        series1.setName("Employees");

        departmentEmployeesBarChart.getData().addAll(series1);
    }


}