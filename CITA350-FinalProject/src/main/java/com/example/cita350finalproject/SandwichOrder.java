package com.example.cita350finalproject;

public class SandwichOrder extends Order
{
    private String breadType;
    private double breadTypePrice;
    private String sandwichProtein;
    private double sandwichProteinPrice;

    public SandwichOrder(){
        //craete object with no values
        this("",0,0,"",0,
                "",0);
    }

    public SandwichOrder(String customerName, double discount, int quantity,
                         String breadType, double breadTypePrice, String sandwichProtein, double
                         sandwichProteinPrice)
    {
        super(customerName, 0.07, discount, quantity);
        this.breadType = breadType.toLowerCase();
        this.breadTypePrice = breadTypePrice;
        this.sandwichProtein = sandwichProtein;
        this.sandwichProteinPrice = sandwichProteinPrice;

    }

    public void setBreadType(String newBreadType){
        this.breadType = newBreadType;}
    public void setBreadTypePrice(double newBreadTypePrice){
        this.breadTypePrice = newBreadTypePrice;}
    public void setSandwichProtein(String newSandwichProtein){
        this.sandwichProtein = newSandwichProtein;}
    public void setSandwichProteinPrice(double newSandwichProteinPrice)
        {this.sandwichProteinPrice = newSandwichProteinPrice;}

    public String toString()
    {
        String str;
        str = super.toString() + "Bread Type: " + breadType + "\nBread Type Price: " +
                Double.toString(breadTypePrice) + "\nSandwich Type: " + sandwichProtein +
                "\nSandwich Type Price: " + Double.toString(sandwichProteinPrice) +
                "\nSubtotal: " + Double.toString(calculateSubTotal()) + "\nTotal: " +
                Double.toString(calculateTotal());
        return str;
    }

    public double calculateSubTotal()
    {
        double subtotal = (breadTypePrice + sandwichProteinPrice) * getQuantity();
        return subtotal;
    }

    public double calculateTotal()
    {
        //total is equal to the (subtotal + cost of tax - cost of discount) multiplied by # of the order
        return (calculateSubTotal() + (calculateSubTotal() * getTaxRate()) - (calculateSubTotal() * getDiscount()));
    }

}
