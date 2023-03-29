public class SmartKitchen {
    private Refrigerator refrigerator = new Refrigerator();
    private CoffeeMaker coffeeMaker = new CoffeeMaker();
    private Dishwasher dishwasher = new Dishwasher();

    public void doKitchenWork(){
        if (refrigerator.hasWorkToDo){
            refrigerator.orderFood();
        }

        if (coffeeMaker.hasWorkToDo) {
            coffeeMaker.brewCoffee();
        }

        if (dishwasher.hasWorkToDo) {
            dishwasher.doDishes();
        }
    }

    public void addWater(){
        System.out.println("Adding water to coffee maker.");
        coffeeMaker.setHasWorkToDo(true);
    }

    public void pourMilk(){
        System.out.println("Pouring milk from the fridge.");
        refrigerator.setHasWorkToDo(true);
    }

    public void loadDishWasher(){
        System.out.println("Loading dishwasher.");
        dishwasher.setHasWorkToDo(true);
    }

    public class Appliance {
        boolean hasWorkToDo;

        public void setHasWorkToDo(boolean hasWorkToDo) {
            this.hasWorkToDo = hasWorkToDo;
        }
    }

    public class Refrigerator extends Appliance {
        public void orderFood(){
            System.out.println("Refrigerator is ordering food!");
        }
    }

    public class CoffeeMaker extends Appliance {
        public void brewCoffee(){
            System.out.println("Coffee maker brewing coffee!");
        }
    }

    public class Dishwasher extends Appliance {
        public void doDishes(){
            System.out.println("Dishwasher doing dishes!");
        }
    }
}


