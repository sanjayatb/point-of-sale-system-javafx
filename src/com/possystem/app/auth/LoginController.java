package com.possystem.app.auth;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.event.*;
import javafx.stage.Stage;

/** Controls the login screen */
public class LoginController {
    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwdField;

    @FXML
    private Button loginButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ImageView logo;

    public void initialize() {

    }

    public void initManager(final LoginManager loginManager) {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                String user = userNameField.getText();
                String passwd = passwdField.getText();
                boolean loginSuccess = loginManager.login(user,passwd);

               if (loginSuccess)
                {
                    //loginManager.showAdminPanel();
                    Stage stage = (Stage) cancelButton.getScene().getWindow();
                    stage.close();
                }
                else
                {
                    loginManager.showStatusWindow();
                }
            }
        });

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                // do what you have to do
                stage.close();
            }
        });



    }
}
