package com.example.cita350finalproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class IceCreamOrderController {

    //add controls from ice cream order window
    public Button buttonSubmit,
            buttonCreateSandwichOrder,
            buttonReturnToMainScreen;
    public TextField textFieldName,
            textFieldQuantity,
            textFieldDiscount;
    public RadioButton radioButtonChocolate,
            radioButtonStrawberry,
            radioButtonVanilla,
            radioButtonRaspberry,
            radioButtonCottonCandy,
            radioButtonMint;
    public CheckBox checkBoxChocolateSprinkles,
            checkBoxRainbowSprinkles,
            checkBoxChocolateFudge,
            checkBoxBrownieBits,
            checkBoxMeltedMarshmallows,
            checkBoxCookieDough;
    public Label labelReceipt;

    //create ice cream order obeject
    IceCreamOrder iceCreamOrder = new IceCreamOrder();

    //below is a set of prices for the flavor types and toppings
    double priceOfChocolate = 1.50;
    double priceOfStrawberry = 2.19;
    double priceOfVanilla = 1.79;
    double priceOfRaspberry = 1.89;
    double priceOfCottonCandy = 2.09;
    double priceOfMint = 1.99;

    double priceOfChocolateSprinkles = 0.39;
    double priceOfRainbowSprinkles = 0.39;
    double priceOfChocolateFudge = 0.67;
    double priceOfBrownieBits = 1.49;
    double priceOfMeltedMarshmallows = 0.79;
    double priceOfCookieDough = 0.99;

    //create connection object
    Connection conn = null;

    //create methods to add functionality to screen
    public void onSubmitClick() {

        double flavorTypePrice = 0;
        double toppingPrice = 0;
        String listOfToppings = "";

        //set values of given controls to the sandwich object
        iceCreamOrder.setCustomerName(textFieldName.getText());
        iceCreamOrder.setQuantity(Integer.parseInt(textFieldQuantity.getText()));
        iceCreamOrder.setDiscount(Double.parseDouble(textFieldDiscount.getText())/100);

        //depending on the type of bread chosen, change the price of the bread & change the
        //type of bread in the order
        if (radioButtonChocolate.isSelected()) {
            iceCreamOrder.setFlavor(radioButtonChocolate.getText());
            flavorTypePrice = priceOfChocolate;
        }
        else if (radioButtonStrawberry.isSelected()) {
            iceCreamOrder.setFlavor(radioButtonStrawberry.getText());
            flavorTypePrice = priceOfStrawberry;
        }
        else if (radioButtonVanilla.isSelected()) {
            iceCreamOrder.setFlavor(radioButtonVanilla.getText());
            flavorTypePrice = priceOfVanilla;
        }
        else if (radioButtonRaspberry.isSelected()) {
            iceCreamOrder.setFlavor(radioButtonRaspberry.getText());
            flavorTypePrice = priceOfRaspberry;
        }
        else if (radioButtonCottonCandy.isSelected()) {
            iceCreamOrder.setFlavor(radioButtonCottonCandy.getText());
            flavorTypePrice = priceOfCottonCandy;
        }
        else if (radioButtonMint.isSelected()) {
            iceCreamOrder.setFlavor(radioButtonMint.getText());
            flavorTypePrice = priceOfMint;
        }
        //set the price of the flave in the object
        iceCreamOrder.setFlavorPrice(flavorTypePrice);


        //update price of protein based on selected proteins. Set selected proteins to the object
        if (checkBoxChocolateSprinkles.isSelected()) {
            listOfToppings += "Chocolate Sprinkles, ";
            toppingPrice += priceOfChocolateSprinkles;
        }
        if (checkBoxRainbowSprinkles.isSelected()) {
            listOfToppings += "Rainbow Sprinkles, ";
            toppingPrice += priceOfRainbowSprinkles;
        }
        if (checkBoxChocolateFudge.isSelected()) {
            listOfToppings += "Chocolate Fudge, ";
            toppingPrice += priceOfChocolateFudge;
        }
        if (checkBoxBrownieBits.isSelected()) {
            listOfToppings += "Brownie Bits, ";
            toppingPrice += priceOfBrownieBits;
        }
        if (checkBoxMeltedMarshmallows.isSelected()) {
            listOfToppings += "Melted Marshmallows, ";
            toppingPrice += priceOfMeltedMarshmallows;
        }
        if (checkBoxCookieDough.isSelected()) {
            listOfToppings += "Cookie Dough";
            toppingPrice += priceOfCookieDough;
        }
        //set price of toppings for the object
        iceCreamOrder.setToppingPrice(toppingPrice);
        //set topping selection for the obejct
        iceCreamOrder.setTopping(listOfToppings);

        //print results of the order to the receipt.
        labelReceipt.setText(iceCreamOrder.toString());

        //add order to database
        addToDataBase();

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

    public void addToDataBase(){
        try{
            //1. initialize connection
            initialize();

            //2. create string query
            String INSERT_QUERY = "INSERT INTO ICECREAMORDER (CUSTOMERNAME, FLAVOR, TOPPING, SUBTOTAL, QUANTITY," +
                    "TAX, DISCOUNT, TOTAL) VALUES('" + iceCreamOrder.getCustomerName() + "','" + iceCreamOrder.getFlavor()
                    + "','" + iceCreamOrder.getTopping() + "'," + iceCreamOrder.calculateSubTotal() + "," +
                    iceCreamOrder.getQuantity() + "," + iceCreamOrder.getTaxRate() + "," + iceCreamOrder.getDiscount() +
                    "," + iceCreamOrder.calculateTotal() + ")";

            //3. create statement object from conn
            Statement statement = conn.createStatement();

            //4. execute statement w/ query argument
            statement.executeUpdate(INSERT_QUERY);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void initialize(){
        conn = DatabaseConnection.createConnection();
    }
}
