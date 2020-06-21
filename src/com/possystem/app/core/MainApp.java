package com.possystem.app.core;

import javafx.scene.Scene;

import com.possystem.app.auth.LoginManager;
import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(new StackPane());

        LoginManager loginManager = new LoginManager(scene);

        loginManager.showLoginScreen();

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);
    }
}


