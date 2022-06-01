package com.example.medicalclinic;

import com.example.medicalclinic.user.UsersList;
import com.example.medicalclinic.servicies.Register;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Main extends Application {
    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws IOException {
        UsersList.loadUsersFromFile();
        stg = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("initial.fxml"));
        stg.setTitle("Medical Clinic");
        stg.setResizable(false);
        stg.setScene(new Scene(root, 900, 650));
        stg.show();
    }

    public void changeScene(String fxml) throws IOException
    {
        Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.setResizable(false);
        stg.setTitle("Medical Clinic");
        stg.setScene(new Scene(root,900,650));
        stg.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
