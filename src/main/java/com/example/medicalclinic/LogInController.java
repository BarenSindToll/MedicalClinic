package com.example.medicalclinic;

import com.example.medicalclinic.exceptions.UsernameAlreadyExistsException;
import com.example.medicalclinic.user.Users;
import com.example.medicalclinic.user.UsersList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.net.URL;

import java.io.IOException;

public class LogInController implements Initializable {

    public LogInController() {

    }

    @FXML
    private Button logIn;

    @FXML
    private Label wrongLogIn;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private ChoiceBox<String> role;

    private String [] options={"Doctor","Patient", "Admin"};


    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();
    }

    @FXML
    private void checkLogin() throws IOException{
        if(username.getText().isEmpty() && password.getText().isEmpty() && role.getValue()==null)
        {
            wrongLogIn.setText("Please enter all your data.");
        }
        else if(username.getText().isEmpty() && password.getText().isEmpty() && role.getValue()!=null)
        {
            wrongLogIn.setText("Please enter your username and password.");
        }
        else if(username.getText().isEmpty() && !password.getText().isEmpty() && role.getValue()==null)
        {
            wrongLogIn.setText("Please enter your username and status.");
        }
        else
        if(username.getText().isEmpty())
        {
            wrongLogIn.setText("Please enter your username.");
        }
        else if(password.getText().isEmpty())
        {
            wrongLogIn.setText("Please enter your password.");
        }
        else if(role.getValue()==null)
        {
            wrongLogIn.setText("Please select your status.");
        }
        else if(UsersList.checkUserCredentials(new Users(username.getText(),password.getText(),role.getValue())))
        {
            Main m = new Main();
            if(role.getValue().equals("Patient"))
            {
                m.changeScene("afterLoginPatient.fxml");
            }
            else
                if(role.getValue().equals("Doctor"))
                {
                    m.changeScene("afterLoginDoctor.fxml");
                }
                else
                if(role.getValue().equals("Admin"))
                {
                    m.changeScene("afterLoginAdmin.fxml");
                }

        }
        else
        {
            wrongLogIn.setText("The information are introduced wrong.");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        role.getItems().addAll(options);
    }

    public void moveToRegisterPage() throws IOException{
        Main m = new Main();
        m.changeScene("registerScene.fxml");
    }

}
