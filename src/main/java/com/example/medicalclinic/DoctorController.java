package com.example.medicalclinic;

import com.example.medicalclinic.appointment.Appointment;
import com.example.medicalclinic.appointment.AppointmentList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class DoctorController {
    @FXML
    public TableColumn dateSetColumn;
    @FXML
    public TableView tableOfSetAppointments;
    @FXML
    public TableColumn patientSetColumn;

    @FXML
    public void initialize() throws IOException {

        ArrayList<Appointment>App;
        AppointmentList.loadUsersFromFile();
        App = AppointmentList.getDoctorAppointment();

        ObservableList<Appointment> Info = FXCollections.observableArrayList(App);

        tableOfSetAppointments.setItems(Info);
        dateSetColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        patientSetColumn.setCellValueFactory((new PropertyValueFactory<>("patient")));
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

