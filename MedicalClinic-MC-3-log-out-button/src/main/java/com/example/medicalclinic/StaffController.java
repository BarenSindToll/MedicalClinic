package com.example.medicalclinic;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

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

