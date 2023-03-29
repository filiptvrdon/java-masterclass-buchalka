package sk.filiptvrdon;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int totalQuantity;
    private int reservedQuantity;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.totalQuantity = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.totalQuantity = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }


    public int getAvailableQuantity() {
        return this.getTotalQuantity() - this.getReservedQuantity();
    }

    public int adjustReservedQuantity(int quantity) {
        reservedQuantity += quantity;
        return this.getReservedQuantity();
    }

    public void setPrice(double price) {
        if (price > 0){
            this.price = price;
        }
    }

//    public void setQuantityStock(int quantityStock) {
//        this.totalQuantity = quantityStock;
//    }

    public void adjustTotalQuantity(int quantity){
        this.totalQuantity = Math.max(this.totalQuantity + quantity, 0);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("CALLING STOCK ITEM EQUALS METHOD");
        if (obj == this){
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        return this.name.equals(((StockItem) obj).getName());
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("CALLING STOCK ITEM COMPARE_TO METHOD");
        if (this == o){
            return 0;
        }

        if (o != null){
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ", price: " + this.price +", in stock: " + this.totalQuantity + " + reserved: " + this.reservedQuantity;
    }
}
