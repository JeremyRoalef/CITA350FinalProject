package com.example.cita350finalproject;

public class IceCreamOrder extends Order
{
    private String flavor;
    private double flavorPrice;
    private String topping;
    private double toppingPrice;


    public IceCreamOrder(){
        this("",0,0,"",0,"",0);
    }
    public IceCreamOrder(String customerName, double discount, int quantity,
                         String flavor, double flavorPrice, String topping, double toppingPrice)
    {
        super(customerName, 0.07, discount, quantity);
        this.flavor = flavor;
        this.flavorPrice = flavorPrice;
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }

    //create getter methods for attributes
    public String getFlavor(){
        return flavor;
    }
    public double getFlavorPrice(){
        return flavorPrice;
    }
    public String getTopping(){
        return topping;
    }
    public double getToppingPrice(){
        return toppingPrice;
    }

    //create setter methods for attributes
    public void setFlavor(String newFlavor){
        this.flavor = newFlavor;}
    public void setFlavorPrice(double newFlavorPrice){
        this.flavorPrice = newFlavorPrice;
    }
    public void setTopping(String newTopping){
        this.topping = newTopping;
    }
    public void setToppingPrice(double newToppingPrice){
        this.toppingPrice = newToppingPrice;
    }


    public String toString() {
        String str;
        str = super.toString() + "Flavor: " + flavor + "\nFlavor Price: " + Double.toString(flavorPrice) +
                "\nTopping: " + topping + "\nTopping Price: " + Double.toString(toppingPrice) +
                "\nSubtotal: " + Double.toString(calculateSubTotal()) + "\nTotal: " +
                Double.toString(calculateTotal());
        return str;
    }

    public double calculateSubTotal()
    {
        return (flavorPrice + toppingPrice) * getQuantity();
    }

    public double calculateTotal()
    {
        return (calculateSubTotal() + (calculateSubTotal() * getTaxRate()) -
                (calculateSubTotal() * getDiscount()));
    }
}
