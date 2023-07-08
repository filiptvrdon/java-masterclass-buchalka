package org.example.Product;

public abstract class ProductForSale {
    String name;
    double price;

    String description;

    public ProductForSale(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract void showDetails();


}
