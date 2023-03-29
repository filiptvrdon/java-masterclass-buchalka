public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public Car(int cylinders, String name) {
        this.engine = true;
        this.wheels = 4;
        this.cylinders = cylinders;
        this.name = name;
    }

    public void startEngine(){
        System.out.println("Car is starting engine");
    }
}

