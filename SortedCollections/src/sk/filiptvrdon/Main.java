package sk.filiptvrdon;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("bread", 0.86, 50);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("banana", 0.50, 40);
        stockList.addStock(temp);

        temp = new StockItem("apple", 0.10, 200);
        stockList.addStock(temp);

        temp = new StockItem("butter", 2.50, 25);
        stockList.addStock(temp);

        temp = new StockItem("sandwich", 3.10, 20);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.10, 36);
        stockList.addStock(temp);
        System.out.println(stockList);


        Basket basket = new Basket("My basket");
        addItemToBasket(basket, "bread", 20);

        addItemToBasket(basket, "cake", 5);

        addItemToBasket(basket, "butter", 10);
        System.out.println(basket);


        System.out.println();
        System.out.println("removing butter from basket");
        basket.removeFromBasket(stockList.getStockItem("butter"), 5);


        System.out.println(basket);
        System.out.println(stockList);

        System.out.println();
        System.out.println("check out basket");
        basket.checkoutBasket();

        System.out.println(stockList);
        System.out.println(basket);

    }

    public static int addItemToBasket(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.getStockItem(item);
        if (stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        basket.addToBasket(stockItem,quantity);
        stockList.subtractFromStock(stockItem, quantity);

        return quantity;
    }


}