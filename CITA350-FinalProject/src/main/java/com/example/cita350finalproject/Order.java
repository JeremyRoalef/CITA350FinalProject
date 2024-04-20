package com.example.cita350finalproject;

public class Order
{
    private String customerName;
    private double taxRate;
    private double discount;
    private int quantity;

    public Order(){}
    public Order(String customerName, double taxRate, double discount, int quantity)
    {
        this.customerName = customerName;
        this.taxRate = taxRate;
        this.discount = discount;
        this.quantity = quantity;
    }


    //create getters for atttributes
    public int getQuantity(){return quantity;}
    public double getTaxRate(){return taxRate;}
    public double getDiscount(){return discount;}
    public String getCustomerName(){return customerName;}

    //create setters for attributes
    public void setCustomerName(String newCustomerName){this.customerName = newCustomerName;}
    public void setTaxRate(double newTaxRate){this.taxRate = newTaxRate;}
    public void setDiscount(double newDiscount){this.discount = newDiscount;}
    public void setQuantity(int newQuantity){this.quantity = newQuantity;}

    public String toString()
    {
        String str;
        str = "Customer Name: " + customerName + "\nTax Rate: " + Double.toString(taxRate) + "\nDiscount Rate: " +
                Double.toString(discount) + "\nQuantity: " + Integer.toString(quantity) + "\n";
        return str;
    }
}
