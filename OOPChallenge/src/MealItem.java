public class MealItem {

    protected String type;
    protected String size;
    protected double price;

    public MealItem(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Burger extends MealItem{
    private String[] extras;
    public Burger (String type){
        this(type, new String[]{""});
    }

    public Burger(String type, String[] extras){
        super(type,
                switch (type){
                    case "A" -> 14.99;
                    case "B" -> 12.99;
                    default -> 9.99;
                });
        this.extras = extras;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + getToppingPrice();
    }

    private double getToppingPrice() {
        double PRICE_PER_EXTRA_TOPPING = 0.49;
        double price = 0;
        for (int i = 0; i < extras.length; i++) {
            price += PRICE_PER_EXTRA_TOPPING;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}

class Drink extends MealItem{
    private String size;
    private static final double basePrice = 2.00;

    public Drink(String type){
        this(type, basePrice);
    }
    public Drink(String type, double price) {
        super(type,price);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}

class Side extends MealItem{
    private static final double basePrice = 2.00;
    public Side(String type) {
        super(type,
                switch(type){
                    case "P" -> 2.50;
                    case "S" -> 3.00;
                    default -> basePrice;
                }
            );
    }

    @Override
    public String toString() {
        return "Side{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}
