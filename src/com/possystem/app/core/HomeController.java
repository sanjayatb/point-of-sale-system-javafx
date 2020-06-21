package com.possystem.app.core;

import com.possystem.app.auth.LoginManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Button chekcout;

    @FXML
    private Button checkin;

    @FXML
    private Button reports;

    @FXML
    private Label date;

    @FXML
    private Label Month;

    @FXML
    private Label year;

    @FXML
    private Clock clockLbl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void initActions(final Home hme) {

        System.out.println("Actions");
        //clockLbl.getScene();
        chekcout.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
                hme.showCheckout();
            }
        });
    }

    public void startClock()
    {
        clockLbl = new Clock();
    }



}
