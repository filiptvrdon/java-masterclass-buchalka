public class Main {
    public static void main(String[] args) {

        Hamburger hamburger = new Hamburger("Hamburger", "Beef", "Sezame", 12.99);
        hamburger.addHamburgerAddition1("Bacon",1.00);
        hamburger.addHamburgerAddition2("Egg", 0.50);
        hamburger.addHamburgerAddition3("Avocado", 1.50);

        hamburger.itemizeHamburger();

    }
}