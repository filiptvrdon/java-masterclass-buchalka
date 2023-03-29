public class MealOrder {

    private Burger burger;
    private Drink drink;
    private String drinkSize;
    private Side side;

    public MealOrder() {
        this.burger = new Burger("classic");
        this.drink = new Drink("Coke");
        this.side = new Side("fries");
    }

    public MealOrder(Burger burger, Drink drink, Side side) {
        this.burger = burger;
        this.drink = drink;
        this.side = side;
    }

    @Override
    public String toString() {
        return "MealOrder{" +
                "burger=" + burger +
                ", drink=" + drink +
                ", drinkSize='" + drinkSize + '\'' +
                ", side=" + side +
                '}';
    }

    public double calculateOrderTotal() {
        return this.burger.getPrice() + this.side.getPrice()  + this.drink.getPrice();
    }
}
