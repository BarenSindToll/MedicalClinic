package com.example.medicalclinic;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StaffController {

    @FXML
    private TableColumn<?, ?> doctorColumn;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> serviceColumn;

    @FXML
    private TableView<?> tableOfAppointments;

    @FXML
    private TableColumn<?, ?> patientColumn;



}

