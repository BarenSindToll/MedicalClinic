module com.example.medicalclinic {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires org.json;


    opens com.example.medicalclinic to javafx.fxml;
    exports com.example.medicalclinic;
    exports com.example.medicalclinic.exceptions;
    exports com.example.medicalclinic.servicies;
    exports com.example.medicalclinic.user;
}