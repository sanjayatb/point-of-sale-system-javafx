package com.possystem.app.auth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.logging.*;

import com.possystem.app.auth.AdminPanelController;
import com.possystem.app.core.Clock;
import com.possystem.app.core.Home;
import com.possystem.app.core.HomeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.util.Map;
import java.util.HashMap;

/** Manages control flow for logins */
public class LoginManager {
    private Scene scene;
    Map<String,String > mapUsers = new HashMap<>();

    public LoginManager(Scene scene) {

        this.scene = scene;
        mapUsers.put("Admin","admin");
        mapUsers.put("User","user");
    }

    public void showLoginScreen() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/login.fxml"));

            String css = LoginManager.class.getResource("../css/loginWnd.css").toExternalForm();
            scene.getStylesheets().add(css);
            scene.setRoot((Parent) loader.load());
        
            LoginController controller = loader.<LoginController>getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showStatusWindow()
    {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("../fxml/loginStatus.fxml")
            );

            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Login Status");
            //.setFullScreen(true);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showAdminPanel() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("../fxml/adminPanel.fxml")
            );

            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("WELCOME TO ABC SHOPPING CENTER");
            //.setFullScreen(true);
            stage.setScene(new Scene(root1));
            stage.show();

            AdminPanelController controller =
                    loader.<AdminPanelController>getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addUser(String userName,String password)
    {
        mapUsers.put(userName,password);
    }

    public boolean login(String userName,String password)
    {
        if(!mapUsers.containsKey(userName))
            return false;

        String pswd = mapUsers.get(userName);
        if(pswd.equals(password))
        {
            priviledgeValidation(userName);
            return true;
        }
        return false;
    }

    public void logout() {

        showLoginScreen();
    }

    private void priviledgeValidation(String user)
    {
        if (user.equals("User"))
        {
            showHomeScreen();
        }
        else if (user.equals("Admin"))
        {
            showAdminPanel();
        }
    }


    private void showHomeScreen()
    {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("../fxml/home.fxml")
            );

            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("ABC SHOPPING CENTER");
            //.setFullScreen(true);
            Scene scn = new Scene(root1);
            stage.setScene(scn);
            stage.show();

            HomeController controller =
                    loader.<HomeController>getController();

            Home hme1 = new Home(scn);
            controller.startClock();
            controller.initActions(hme1);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private void showClock()
//    {
//        Parent root1 = (Parent) loader.load();
//        Stage stage = new Stage();
//        stage.setTitle("ABC SHOPPING CENTER");
//        //.setFullScreen(true);
//        stage.setScene(new Scene(new Clock()));
//        stage.show();
//    }


}
