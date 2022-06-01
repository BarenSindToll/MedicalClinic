package com.example.medicalclinic;

import com.example.medicalclinic.appointment.Appointment;
import com.example.medicalclinic.appointment.AppointmentList;
import com.example.medicalclinic.servicies.Register;
import com.example.medicalclinic.user.UsersList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private Label message;

    public void initialize(){
        username.setText(UsersList.logat);
    }

    public void addAppointment() {
        AppointmentList.addAppointment(new Appointment(String.valueOf(date.getValue()), username.getText(), doctor.getText()));
        message.setText("Appointment made. Thank you!");
        AppointmentList.persistAppointment();
    }

}
