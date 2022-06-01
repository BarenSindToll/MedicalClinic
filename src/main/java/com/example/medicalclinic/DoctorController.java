package com.example.medicalclinic;

import com.example.medicalclinic.appointment.Appointment;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DoctorController {

    @FXML
    private TableColumn<Appointment, String> doctorColumn;

    @FXML
    private TableColumn<Appointment, String> dateColumn;

    @FXML
    private TableColumn<Appointment, String> serviceColumn;

    @FXML
    private TableView<Appointment> tableOfAppointments;

    @FXML
    private TableColumn<?, ?> patientColumn;



}

