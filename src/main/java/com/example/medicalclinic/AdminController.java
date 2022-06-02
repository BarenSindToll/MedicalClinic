package com.example.medicalclinic;

import com.example.medicalclinic.appointment.Appointment;
import com.example.medicalclinic.appointment.AppointmentList;
import com.example.medicalclinic.exceptions.UsernameAlreadyExistsException;
import com.example.medicalclinic.servicies.Register;
import com.example.medicalclinic.user.Users;
import com.example.medicalclinic.user.UsersList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class AdminController {
    public TextField newDocPassword;
    public TextField name2;

    public TableView tableOfSetAppointments;
    public TableColumn dateSetColumn;
    public TableColumn doctorSetColumn;

    public TableColumn patientSetColumn;

    public TextField newDocName;

    public AdminController()
    {

    }
    @FXML
    private ListView<String> listOfNames;


    @FXML
    public void initialize(){
        listOfNames.getItems().clear();
        ArrayList<Users> dl = UsersList.getUsersWithRole("Doctor");
        for(Users u : dl)
            listOfNames.getItems().add(u.getUsername());
    }


    @FXML
    private TextField name;

    @FXML
    void addName(MouseEvent event) {
        listOfNames.getItems().add(name.getText());
        initialize();
    }

    @FXML
    void removeName(MouseEvent event) {
        int selectID = listOfNames.getSelectionModel().getSelectedIndex();
        listOfNames.getItems().remove(selectID);
        initialize();
    }

    @FXML
    public void doctorRegister(ActionEvent actionEvent) {
    }

    public void addDoctor(ActionEvent actionEvent) {
        try {
            Register.addUser(newDocName.getText(),newDocPassword.getText(),"Doctor");
        } catch (UsernameAlreadyExistsException e) {

        }
        initialize();
    }


    @FXML
    private ListView<String> listPatientOfNames;

    @FXML
    public void initialize2(){
        listPatientOfNames.getItems().clear();
        ArrayList<Users> dl = UsersList.getUsersWithRole("Patient");
        for(Users u : dl)
            listPatientOfNames.getItems().add(u.getUsername());
    }

    @FXML
    void removePatient(MouseEvent event) {
        int selectID = listPatientOfNames.getSelectionModel().getSelectedIndex();
        listPatientOfNames.getItems().remove(selectID);
        initialize2();
    }

    @FXML
    Text logoutMessage;

    public void logOut() {
        Main m = new Main();
        try {
            m.changeScene("initial.fxml");
        } catch (Exception e) {
            logoutMessage.setText("Failed to log out...");
        }
    }


}