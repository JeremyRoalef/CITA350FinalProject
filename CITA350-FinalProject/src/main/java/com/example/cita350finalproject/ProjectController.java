package com.example.cita350finalproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ProjectController {
    //create controls for login-view.fxml
    public TextField textFieldUsername;
    public TextField textFieldPassword;

    public Button buttonSignIn;

    //create controls for main-screen-view.fxml
    public Button buttonIceCreamOrder;
    public Button buttonSandwichOrder;

    //create username and password attributes
    String username = "a";
    String password = "a";


    //use action to determine if the user entered the right username and paswword
    public void onButtonSignInClick() throws Exception {
        if (textFieldUsername.getText().equals(username) &&
                textFieldPassword.getText().equals(password)){

            //change scene view to main-screen-view.fxml
            Parent root = FXMLLoader.load(getClass().getResource("main-screen-view.fxml"));
            Stage stage = (Stage) buttonSignIn.getScene().getWindow();
            stage.setScene(new Scene(root, 320, 100));
        }
    }

    public void onButtonIceCreamOrderClick() throws IOException {
        //change scene view to main-screen-view.fxml
        Parent root = FXMLLoader.load(getClass().getResource("ice-cream-order-view.fxml"));
        Stage stage = (Stage) buttonIceCreamOrder.getScene().getWindow();
        stage.setScene(new Scene(root, 320, 100));
    }
    public void onButtonSandwichOrderClick() throws IOException {
        //change scene view to main-screen-view.fxml
        Parent root = FXMLLoader.load(getClass().getResource("sandwich-order-view.fxml"));
        Stage stage = (Stage) buttonSandwichOrder.getScene().getWindow();
        stage.setScene(new Scene(root, 320, 100));
    }
}
