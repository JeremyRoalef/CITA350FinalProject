package com.example.cita350finalproject;

public class IceCreamOrder extends Order
{
    private String flavor;
    private float flavorPrice;
    private String topping;
    private float toppingPrice;


    public IceCreamOrder(String customerName, double discount, int quantity,
                         String flavor, float flavorPrice, String topping, float toppingPrice)
    {
        super(customerName, 0.07, discount, quantity);
        this.flavor = flavor;
        this.flavorPrice = flavorPrice;
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }

    public String getFlavor(){
        return flavor;
    }
    public float getFlavorPrice(){
        return flavorPrice;
    }
    public String getTopping(){
        return topping;
    }
    public float getToppingPrice(){
        return toppingPrice;
    }

    public String toString() {
        String str;
        str = super.toString() + "Flavor: " + flavor + "\nFlavor Price: " + Float.toString(flavorPrice) + "\nTopping: " +
        topping + "\nTopping Price: " + Float.toString(toppingPrice) + "\n";
        return str;
    }

    public double calculateSubTotal()
    {
        return (flavorPrice + toppingPrice) * getQuantity();
    }

    public double calculateTotal()
    {
        return (calculateSubTotal() + (calculateSubTotal() * getTaxRate()) - (calculateSubTotal() * getDiscount()));
    }
}
