package sk.filiptvrdon;

import java.util.*;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> basketList;

    public Basket(String name) {
        this.name = name;
        this.basketList = new LinkedHashMap<>();
    }

    public int addToBasket (StockItem stockItem, int quantity) {
        if (stockItem != null){

            // reserve item //
            int reserveResult = reserveItem(stockItem, quantity);

            // TODO - optionally we could reserve all available quantity ... //
            if (reserveResult != quantity){
                return -1;
            }

            // add to basket //
            int inBasketAlready = basketList.getOrDefault(stockItem, 0);
            basketList.put(stockItem,inBasketAlready + quantity);
            return inBasketAlready;
        }
        return 0;
    }
    // returns remaining quantity of given stockItem in the basket //
    public int removeFromBasket(StockItem stockItem, int quantity){
        if (!basketList.containsKey(stockItem)){
            System.out.println("No such item in the basket");
            return -1;
        }

        if (stockItem.getReservedQuantity() < quantity){
            System.out.println("Cannot remove more items of type " + stockItem.getName() + " than are actually in the basket");
            return -1;
        }

        return addToBasket(stockItem, -quantity);
    }

    private int reserveItem (StockItem stockItem, int quantity){
        System.out.println(stockItem);
        if (stockItem.getAvailableQuantity() < quantity){
            System.out.println("Insufficient quantity of " + stockItem.getName() + " in stock");
            return -1;
        }
        stockItem.adjustReservedQuantity(quantity);
        return quantity;
    }


    public Map<StockItem, Integer> getBasketList() {
        return Collections.unmodifiableMap(basketList);
    }

    public void checkoutBasket(){

        for (Map.Entry<StockItem, Integer> item : basketList.entrySet()){
            // reduce the total number of products in stock //
            item.getKey().adjustTotalQuantity(-(item.getValue()));

            // reduce the number of reserved items //
            item.getKey().adjustReservedQuantity(-(item.getValue()));
        }

        // clear the list of items in basket //
        this.basketList.clear();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nShopping Basket " + name + ", contains " + basketList.size() + " items:\n");
        double totalCost = 0.0;

        for (Map.Entry<StockItem, Integer> item : basketList.entrySet()){
            s.append(item.getKey().getName()).append(": ").append(item.getValue()).append(", at €").append(item.getKey().getPrice()).append("\n");
            totalCost += item.getKey().getPrice() * item.getValue();
        }

        return s.append("Total cost: ").append(totalCost).toString();
    }
}
