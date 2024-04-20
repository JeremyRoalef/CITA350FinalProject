package com.example.cita350finalproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
public class SandwichOrderController {

    //add controls from sandwich order window
    public Button buttonSubmit, buttonCreateIceCreamOrder, buttonReturnToMainScreen;
    public TextField textFieldName, textFieldQuantity, textFieldDiscount;
    public RadioButton radioButtonWheat, radioButtonWhite, radioButtonSourdough,
            radioButtonRye, radioButtonMultigrain, radioButtonItalian;
    public CheckBox checkBoxHam, checkBoxTurkey, checkBoxChicken,
            checkBoxTuna, checkBoxBacon, checkBoxRoastBeef;
    public Label labelReceipt;

    //create sandwich object
    SandwichOrder sandwichOrder = new SandwichOrder();

    //below is a set of prices for the sandwich bread types and protein types
    double priceOfWheat = 1.67;
    double priceOfWhite = 1.99;
    double priceOfMultigrain = 2.19;
    double priceOfSourdough = 1.89;
    double priceOfRye = 2.29;
    double priceOfItalian = 2.49;

    double priceOfHam = 4.89;
    double priceOfTurkey = 3.99;
    double priceOfTuna = 1.99;
    double priceOfRoastBeef = 4.59;
    double priceOfChicken = 3.29;
    double priceOfBacon = 2.19;

    //create methods to add functionality to screen
    public void onSubmitClick() {

        double breadTypePrice = 0;
        double proteinPrice = 0;
        String listOfProtein = "";

        //set values of given controls to the sandwich object
        sandwichOrder.setCustomerName(textFieldName.getText());
        sandwichOrder.setQuantity(Integer.parseInt(textFieldQuantity.getText()));
        sandwichOrder.setDiscount(Double.parseDouble(textFieldDiscount.getText())/100);

        //depending on the type of bread chosen, change the price of the bread & change the
        //type of bread in the order
        if (radioButtonWheat.isSelected()) {
            sandwichOrder.setBreadType(radioButtonWheat.getText());
            breadTypePrice = priceOfWheat;
        }
        else if (radioButtonWhite.isSelected()) {
            sandwichOrder.setBreadType(radioButtonWhite.getText());
            breadTypePrice = priceOfWhite;
        }
        else if (radioButtonMultigrain.isSelected()) {
            sandwichOrder.setBreadType(radioButtonMultigrain.getText());
            breadTypePrice = priceOfMultigrain;
        }
        else if (radioButtonSourdough.isSelected()) {
            sandwichOrder.setBreadType(radioButtonSourdough.getText());
            breadTypePrice = priceOfSourdough;
        }
        else if (radioButtonRye.isSelected()) {
            sandwichOrder.setBreadType(radioButtonRye.getText());
            breadTypePrice = priceOfRye;
        }
        else if (radioButtonItalian.isSelected()) {
            sandwichOrder.setBreadType(radioButtonItalian.getText());
            breadTypePrice = priceOfItalian;
        }
        //set the price of the bread in the object
        sandwichOrder.setBreadTypePrice(breadTypePrice);


        //update price of protein based on selected proteins. Set selected proteins to the object
        if (checkBoxHam.isSelected()) {
            listOfProtein += "Ham, ";
            proteinPrice += priceOfHam;
        }
        if (checkBoxTurkey.isSelected()) {
            listOfProtein += "Turkey, ";
            proteinPrice += priceOfTurkey;
        }
        if (checkBoxTuna.isSelected()) {
            listOfProtein += "Tuan, ";
            proteinPrice += priceOfTuna;
        }
        if (checkBoxRoastBeef.isSelected()) {
            listOfProtein += "Roast Beef, ";
            proteinPrice += priceOfRoastBeef;
        }
        if (checkBoxChicken.isSelected()) {
            listOfProtein += "Chicken, ";
            proteinPrice += priceOfChicken;
        }
        if (checkBoxBacon.isSelected()) {
            listOfProtein += "Bacon, ";
            proteinPrice += priceOfBacon;
        }
        //set price of protein for the object
        sandwichOrder.setSandwichProteinPrice(proteinPrice);
        //set protein selection for the obejct
        sandwichOrder.setSandwichProtein(listOfProtein);

        //print results of the order to the receipt.
        labelReceipt.setText(sandwichOrder.toString());
    }

    public void onCreateIceCreamOrderClick() throws IOException {
        //go to ice cream order screen
        Parent root = FXMLLoader.load(getClass().getResource("ice-cream-order-view.fxml"));
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
