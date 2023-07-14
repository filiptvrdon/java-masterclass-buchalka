package org.example;

import org.example.Product.ProductForSale;

import java.util.ArrayList;
import java.util.List;

public class Store {
    List<ProductForSale> productsForSale = new ArrayList<ProductForSale>();
    List<ProductForSale> orderedProductForSales = new ArrayList<ProductForSale>();


    public static void main(String[] args) {
        System.out.println("Hello store!");
    }

    void addProductToProductsForSale(ProductForSale productForSale) {
        productsForSale.add(productForSale);
    }

    void addProductToOrderedItems(ProductForSale productForSale) {
        orderedProductForSales.add(productForSale);
    }

    void printOrderedItems() {
        for (ProductForSale productForSale : orderedProductForSales) {
            System.out.println(productForSale.getName() + " " + productForSale.getPrice());
        }
    }





}