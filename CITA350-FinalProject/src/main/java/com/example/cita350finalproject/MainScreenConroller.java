package com.example.cita350finalproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
public class MainScreenConroller {

    //create controls for main-screen-view.fxml
    public Button buttonIceCreamOrder;
    public Button buttonSandwichOrder;

    public void onButtonIceCreamOrderClick() throws IOException {
        //change scene view to main-screen-view.fxml
        Parent root = FXMLLoader.load(getClass().getResource("ice-cream-order-view.fxml"));
        Stage stage = (Stage) buttonIceCreamOrder.getScene().getWindow();
        stage.setScene(new Scene(root, 600, 509));
    }
    public void onButtonSandwichOrderClick() throws IOException {
        //change scene view to main-screen-view.fxml
        Parent root = FXMLLoader.load(getClass().getResource("sandwich-order-view.fxml"));
        Stage stage = (Stage) buttonSandwichOrder.getScene().getWindow();
        stage.setScene(new Scene(root, 320, 100));
    }
}