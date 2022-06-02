package com.example.medicalclinic;

import com.example.medicalclinic.appointment.Appointment;
import com.example.medicalclinic.appointment.AppointmentList;
import com.example.medicalclinic.servicies.Register;
import com.example.medicalclinic.user.UsersList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

public class PatientController {
    @FXML
    private TableView tableOfSetAppointments;
    @FXML
    private TableColumn dateSetColumn;
    @FXML
    private TableColumn doctorSetColumn;
    @FXML
    private TextField doctor;
    @FXML
    private DatePicker date;
    @FXML
    private Label message;


    @FXML
    public void initialize() throws IOException {
        reload();
    }

    public void reload() throws IOException {
        ArrayList<Appointment> App;
        AppointmentList.loadUsersFromFile();
        App = AppointmentList.getPatientAppointment();

        ObservableList<Appointment> Info = FXCollections.observableArrayList(App);

        tableOfSetAppointments.setItems(Info);
        dateSetColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        doctorSetColumn.setCellValueFactory((new PropertyValueFactory<>("doctor")));
    }


    public void addAppointment() throws IOException {
        AppointmentList.addAppointment(new Appointment(String.valueOf(date.getValue()),UsersList.logat, doctor.getText()));
        message.setText("Appointment made. Thank you!");
        doctor.setText("");
        AppointmentList.persistAppointment();
        reload();
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
