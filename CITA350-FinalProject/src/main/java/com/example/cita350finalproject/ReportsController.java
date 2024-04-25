package com.example.cita350finalproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class ReportsController {
    //create controls for scene
    public Button buttonReturnToMainMenu, buttonPrintIceCreamOrders, buttonPrintSandwichOrders;
    public Label labelOutput;

    //create connection object to connect to database
    Connection conn = null;

    public void onButtonReturnToMainMenuClick() throws IOException {
        //change scene view to main-screen-view.fxml
        Parent root = FXMLLoader.load(getClass().getResource("main-screen-view.fxml"));
        Stage stage = (Stage) buttonReturnToMainMenu.getScene().getWindow();
        stage.setScene(new Scene(root, 600, 509));
    }
    public void onButtonPrintIceCreamOrdersClick(){

    }
    public void onButtonPrintSandwichOrdersClick(){

    }

    public void initialize(){
        conn = DatabaseConnection.createConnection();
    }
}
