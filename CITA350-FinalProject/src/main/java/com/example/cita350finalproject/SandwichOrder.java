package com.example.cita350finalproject;

public class SandwichOrder extends Order
{
    String breadType;
    double breadTypePrice;
    String sandwichType;
    double sandwichTypePrice;

    public SandwichOrder(String customerName, double discount, int quantity,
                         String breadType, double breadTypePrice, String sandwichType, double
                         sandwichTypePrice)
    {
        super(customerName, 0.07, discount, quantity);
        this.breadType = breadType.toLowerCase();
        this.breadTypePrice = breadTypePrice;
        this.sandwichType = sandwichType;
        this.sandwichTypePrice = sandwichTypePrice;

    }

    public String toString()
    {
        String str;
        str = super.toString() + "Bread Type: " + breadType + "\nBread Type Price: " + Double.toString(breadTypePrice)
                + "\nSandwich Type: " + sandwichType + "\nSandwich Type Price: " + Double.toString(sandwichTypePrice) + "\n";
        return str;
    }

    public double calculateSubTotal()
    {
        double subtotal = (breadTypePrice + sandwichTypePrice) * getQuantity();
        return subtotal;
    }

    public double calculateTotal()
    {
        //total is equal to the (subtotal + cost of tax - cost of discount) multiplied by # of the order
        return (calculateSubTotal() + (calculateSubTotal() * getTaxRate()) - (calculateSubTotal() * getDiscount()));
    }

}
