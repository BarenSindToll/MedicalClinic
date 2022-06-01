package com.example.medicalclinic;

import com.example.medicalclinic.exceptions.UsernameAlreadyExistsException;
import com.example.medicalclinic.servicies.Register;
import com.example.medicalclinic.user.Users;
import com.example.medicalclinic.user.UsersList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class AdminController {
    public PasswordField newDocPassword;
    public TextField name2;
    public Label wrongCreate;
    public Button createButton;
    public TableColumn specialtyColumn;
    public TableView tableOfSetAppointments;
    public TableColumn dateSetColumn;
    public TableColumn doctorSetColumn;
    public TableView tableOfPatients;
    public TableColumn patientColumn;
    public TableColumn historyColumn;
    public TableColumn doctorColumn;
    public TableView tableOfDoctors;
    public TextField service;
    public TableColumn specialtySetColumn;
    public TextField newDocName;
    public Text ErrorText;

    public AdminController()
    {

    }
    @FXML
    private ListView<String> listOfNames;


    @FXML
    public void initialize(){
        listOfNames.getItems().clear();
        ArrayList<Users> dl = UsersList.getUsersWithRole("doctor");
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
        String selectedName = listOfNames.getSelectionModel().getSelectedItem();
        UsersList.removeUser(selectedName);
        initialize();
    }

    @FXML
    public void doctorRegister(ActionEvent actionEvent) {
    }

    public void addDoctor(ActionEvent actionEvent) {
        ErrorText.setText("");
        if(newDocName.getText().isEmpty() || newDocPassword.getText().isEmpty()) {
            ErrorText.setText("Name and password can't be empty!");
            return;
        }
        try {
            Register.addUser(newDocName.getText(),newDocPassword.getText(),"doctor");
            newDocName.setText("");
            newDocPassword.setText("");
        } catch (UsernameAlreadyExistsException e) {
            //pui un text pe ecran
            ErrorText.setText("Doctor with this name already exists!");
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
