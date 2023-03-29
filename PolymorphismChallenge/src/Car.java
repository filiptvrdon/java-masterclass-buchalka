public class Car {
    private final String type;
    public Car(String type) {
        this.type = type;
    }

    public static Car getCar(String type){
        return switch (type) {
            case "gas" -> new GasCar(type);
            case "electric" -> new ElectricCar(type);
            case "hybrid" -> new HybridCar(type);
            default -> new Car("default");
        };
    }

    public void startEngine(){
        System.out.println(type + "'s engine is starting");
    }

    protected void runEngine(){
        System.out.println(type + "'s engine is running");
    }

    public void drive(){
        System.out.println(type + " is driving");
    }
}

class GasCar extends Car{
    private double averageKmPerLitre;
    private double cylinders;

    public GasCar(String type) {
        super(type);
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Cloud of smoke veiled the street!");
    }

    @Override
    protected void runEngine() {
        super.runEngine();
        System.out.println("Gas is burning and emissions are rising to the sky!");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Engine roaring we drive to the sunset.");
    }
}

class ElectricCar extends Car{
    private double averageKmPerCharge;
    private int batterySize;

    public ElectricCar(String type) {
        super(type);
    }


}

class HybridCar extends Car{
    private double averageKmPerLitre;
    private double cylinders;
    private int batterySize;

    public HybridCar(String type) {
        super(type);
    }
}