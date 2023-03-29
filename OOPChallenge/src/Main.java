import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Set<String> STEP_1_INPUTS = Set.of("A", "B", "C");
    private static final Set<String> STEP_SIDE_INPUTS = Set.of("F", "P", "S");
    private static final Set<String> STEP_DRINK_INPUTS = Set.of("C", "J", "W");
    private static final Set<String> EXTRAS_INPUTS = Set.of("C", "B", "E");


    public static void main(String[] args) {
        getOrder();
    }
    static Scanner scanner = new Scanner(System.in);
    public static void getOrder(){


        System.out.println("Welcome to Bill's Burgers! Let's start with burger - what type would you like to have? ");
        System.out.println("Enter 'A' for American Burger, 'B' for British or 'C' for Classic. You can also choose 'D' for default menu consisting of classic burger, small coke and fries.");
        System.out.println("(If you wish to quit the process at any time, enter 'Q')");


        boolean stepBurgerInputValidation = false;

        do {
            String stepBurgerInput = scanner.nextLine();

            if (STEP_1_INPUTS.contains(stepBurgerInput)) {
                stepBurgerInputValidation = true;
                String[] extras = getExtras();
                Burger burger = getBurger(stepBurgerInput, extras);
                System.out.println(burger);

                Side side = geSide();
                System.out.println(side);

                Drink drink = getDrink();
                System.out.println(drink);

                MealOrder order = new MealOrder(burger, drink, side);
                System.out.println(order);

                double orderTotal = order.calculateOrderTotal();
                System.out.println(orderTotal);


            } else if ("D".equals(stepBurgerInput)) {
                getDefaultOrder();
                stepBurgerInputValidation = true;

            } else if ("Q".equals(stepBurgerInput)) {
            quitProcess();
            stepBurgerInputValidation = true;

            } else {
                System.out.println("Errrrr, not sure about that :/");
            }
        } while (!stepBurgerInputValidation);



    }
    private static String[] getExtras() {
        String[] extras = new String[3];
        String extraTopping;
        boolean extraToppingValidation;
        int counter = 0;

        do {
            extraToppingValidation = false;

            System.out.println("Choose topping no. " + counter+1 + " . Enter 'C' for cheese, 'B' for bacon, 'E' for egg.");
            extraTopping = scanner.nextLine();

            if (EXTRAS_INPUTS.contains(extraTopping)) {
                extraToppingValidation = true;
                extras[counter] = extraTopping;
                counter++;
            }


        } while (counter < 3 && (extraToppingValidation));
        return extras;
    }

    private static Burger getBurger(String stepBurgerInput, String[] extras) {
        return new Burger(stepBurgerInput,extras);
    }

    private static Side geSide() {
        String sideType = getSideType();
        return new Side(sideType);
    }

    private static Drink getDrink() {
        String drinkType = getDrinkType();
        return new Drink(drinkType);
    }

    private static String getSideType() {
        System.out.println("Great choice! What would you like for a side?");
        System.out.println("Enter 'F' for fries, 'P' for potatoes or 'S' for sweet potatoes.");
        String stepSideInput;
        boolean stepSideInputValidation = false;

        do{
            stepSideInput = scanner.nextLine();
            if (STEP_SIDE_INPUTS.contains(stepSideInput)){
                stepSideInputValidation = true;
            } else {
                System.out.println("Errrrr, not sure about that :/");
            }
        } while (!stepSideInputValidation);

        return stepSideInput;
    }


    private static String getDrinkType() {
        System.out.println("Great choice! What would you like for a drink?");
        System.out.println("Enter 'C' for coke, 'J' for juice or 'W' for water.");
        String stepDrinkInput;
        boolean stepSideInputValidation = false;

        do{
            stepDrinkInput = scanner.nextLine();
            if (STEP_DRINK_INPUTS.contains(stepDrinkInput)){
                stepSideInputValidation = true;
            } else {
                System.out.println("Errrrr, not sure about that :/");
            }
        } while (!stepSideInputValidation);

        return stepDrinkInput;
    }

    private static void getDefaultOrder(){
        System.out.println("make a defualt order");
    }

    private static void quitProcess(){
        System.out.println("Sorry to see you go without a burger :(");
    }
}