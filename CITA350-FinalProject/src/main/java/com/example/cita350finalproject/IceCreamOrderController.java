package com.example.cita350finalproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
public class IceCreamOrderController {

    //add controls from ice cream order window
    public Button buttonSubmit, buttonCreateSandwichOrder, buttonReturnToMainScreen;
    public TextField textFieldName, textFieldQuantity, textFieldDiscount;
    public RadioButton radioButtonChocolate, radioButtonStrawberry, radioButtonVanilla,
        radioButtonRaspberry, radioButtonCottonCandy, radioButtonMint;
    public CheckBox checkBoxChocolateSprinkles, checkBoxRainbowSprinkes, checkBoxChocolateFudge,
        checkBoxBrownieBits, checkBoxMeltedMarshmallows, checkBoxCookieDough;
    public Label labelReceipt;


    //create methods to add functionality to screen
    public void onSubmitClick() {
        //create ice cream order object

    }

    public void onCreateSandwichOrderClick() throws IOException {
        //go to sandwich order screen
        Parent root = FXMLLoader.load(getClass().getResource("sandwich-order-view.fxml"));
        Stage stage = (Stage) buttonSubmit.getScene().getWindow();
        stage.setScene(new Scene(root, 600, 509));
    }

    public void onReturnToMainScreenClick() throws IOException {
        //go to main menu screen
        Parent root = FXMLLoader.load(getClass().getResource("main-screen-view.fxml"));
        Stage stage = (Stage) buttonSubmit.getScene().getWindow();
        stage.setScene(new Scene(root, 600, 509));
    }

}
