////////////////////////////////////////////////////////////////////
// Andrea Breggion 1192760
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
    public enum types{Bevanda, Gelato, Budino};
    private String name;
    private types type;
    private double price;
    public MenuItem(String n, types t, double d){
        name=n;
        type=t;
        price=d;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public types getType() {
        return type;
    }
}
