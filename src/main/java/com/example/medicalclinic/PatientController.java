package com.example.medicalclinic;

import com.example.medicalclinic.appointment.Appointment;
import com.example.medicalclinic.appointment.AppointmentList;
import com.example.medicalclinic.user.UsersList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.event.ActionEvent;

public class PatientController {
    public TableView tableOfSetAppointments;
    public TableColumn dateSetColumn;
    public TableColumn doctorSetColumn;
    public TableColumn specialtySetColumn;
    @FXML
    private TextField doctor;
    @FXML
    private Label username;
    @FXML
    private DatePicker date;

    @FXML
    Text logoutMessage;

    @FXML
    private Label message;

    public void initialize(){
        username.setText(UsersList.logat);
    }

    public void addAppointment() {
        AppointmentList.addAppointment(new Appointment(String.valueOf(date.getValue()), username.getText(), doctor.getText()));
        message.setText("Appointment made. Thank you!");
    }

    public void logOut() {
        Main m = new Main();
        try {
            m.changeScene("initial.fxml");
        } catch (Exception e) {
            logoutMessage.setText("Failed to log out...");
        }
    }
}