package com.example.medicalclinic.controller;

import com.example.medicalclinic.appointment.Appointment;
import com.example.medicalclinic.appointment.AppointmentList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PatientController {
    @FXML
    private TextField doctor;
    @FXML
    private TextField username;
    @FXML
    private DatePicker date;

    @FXML
    private Label message;

    public void addAppointment() {
        AppointmentList.addAppointment(new Appointment(String.valueOf(date.getValue()), username.getText(), doctor.getText()));
        message.setText("Appointment made. Thank you!");
    }
}
