package com.example.medicalclinic;
import com.example.medicalclinic.Main;
import com.example.medicalclinic.doctors.Doctors;
import com.example.medicalclinic.doctors.DoctorsList;
import com.example.medicalclinic.exceptions.DoctorAlreadyExistsException;
import com.example.medicalclinic.servicies.DoctorRegister;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorRegisterScene implements Initializable {

    public DoctorRegisterScene() {

    }


    @FXML
    private TextField name;

    @FXML
    private TextField service;

    @FXML
    private Label wrongCreate;


    public void doctorRegister(ActionEvent event) throws IOException {
        checkRegister();
    }

    private void checkRegister() throws IOException {
        if (name.getText().isEmpty()) {
            wrongCreate.setText("Please fill in the name field");
        } else if (service.getText().isEmpty()) {
            wrongCreate.setText("Please fill in the service field");
        } else {
            try {
                DoctorRegister.addDoctor(name.getText(), service.getText());
                wrongCreate.setText("Account created successfully");
            } catch (DoctorAlreadyExistsException e) {
                wrongCreate.setText(e.getMessage());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}