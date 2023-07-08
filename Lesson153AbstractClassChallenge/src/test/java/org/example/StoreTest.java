package org.example;

import org.example.Product.ProductForSale;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StoreTest {

    @Test
    public void addProductTest() {
        Store store = new Store();
        ProductForSale productForSale = new ProductForSale("Milk", 1.5);
        store.addProductToProductsForSale(productForSale);
        assertEquals(1, store.productsForSale.size());
    }

    @Test
    public void addProductToOrderedItemsTest() {
        Store store = new Store();
        ProductForSale productForSale = new ProductForSale("Milk", 1.5);
        store.addProductToOrderedItems(productForSale);
        assertEquals(1, store.orderedProductForSales.size());
    }

}