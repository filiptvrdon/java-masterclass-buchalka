package sk.filiptvrdon;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> stockList;

    public StockList() {
        this.stockList = new LinkedHashMap<>();
    }

    public int addStock(StockItem stockItem){
        if (stockItem != null){
            if (stockList.containsKey(stockItem.getName())){
                stockItem.adjustTotalQuantity(stockList.get(stockItem.getName()).getTotalQuantity());
            }
            stockList.put(stockItem.getName(), stockItem);
            return stockItem.getTotalQuantity();
        }
        return 0;
    }

    public int subtractFromStock(StockItem stockItem, int quantity){
        StockItem itemInStock = stockList.get(stockItem.getName());
        if ((itemInStock != null) && (itemInStock.getTotalQuantity() >= quantity) && (quantity > 0)){
            itemInStock.adjustTotalQuantity((-quantity));
            return quantity;
        }
        return 0;
    }

    public StockItem getStockItem(String key){
        return stockList.get(key);
    }

    public Map<String, StockItem> getStockItems(){
        return Collections.unmodifiableMap(stockList);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nStock list:\n");
        double totalCost = 0.0;

        for (Map.Entry<String, StockItem> entry : stockList.entrySet()) {
            StockItem stockItem = entry.getValue();
            double itemStockValue = (stockItem.getPrice() * stockItem.getTotalQuantity()) + (stockItem.getPrice() * stockItem.getReservedQuantity());

            s.append(stockItem).append(", total value: ").append(String.format("%.2f", itemStockValue)).append("\n");
            totalCost += itemStockValue;
        }
        return s + "\n " + "Total stock value: " + totalCost;
    }
}
