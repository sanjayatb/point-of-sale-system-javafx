package com.possystem.app.auth;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminPanelController {

   @FXML
   private Pane mainViewPane;

   @FXML
   private AnchorPane DetailPane;

   @FXML
   private Button addUserBtn;

    @FXML
    private ColumnConstraints gridPane;

    @FXML
    private PasswordField passwdfld;

    @FXML
    private TextField userField;

    @FXML
    private Label date;


   public void initManager(final LoginManager loginManager) {
        addUserBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                loginManager.addUser(userField.getText(),passwdfld.getText());

            }
        });
    }



}
