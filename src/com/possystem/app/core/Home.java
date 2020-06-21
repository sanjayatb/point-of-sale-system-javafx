package com.possystem.app.core;

import com.possystem.app.core.CheckoutController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Home {

    private Scene scene;

    public Home(Scene scene) {

        this.scene = scene;
    }

    public void showCheckout()
    {
        System.out.println("checkout");

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("../fxml/checkout.fxml")
            );

            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("ABC SHOPPING CENTER");
            //.setFullScreen(true);
            Scene scn = new Scene(root1);
            stage.setScene(scn);
            stage.show();

            CheckoutController controller =
                    loader.<CheckoutController>getController();


        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

}
