public class Main {
    public static void main(String[] args) {
        Car car1 = Car.getCar("gas");
        car1.startEngine();
        car1.runEngine();
        car1.drive();
        System.out.println("-----------------------------------------------");

        Car car2 = Car.getCar("electric");
        car2.startEngine();
        car2.runEngine();
        car2.drive();
        System.out.println("-----------------------------------------------");

        Car car3 = Car.getCar("hybrids");
        car3.startEngine();
        car3.runEngine();
        car3.drive();

    }
}