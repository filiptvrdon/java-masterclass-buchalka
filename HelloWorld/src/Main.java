public class Main {
    public static void main (String[] args){

        Car car = new Car();
        car.describeCar();

    // checkNumber(-1);
    // checkNumber(0);
    // checkNumber(1);
    //System.out.println(toMilesPerHour(100L))
    // printConversion(456576L);
    // System.out.println(shouldWakeUp(true, 6));
    }
    public static void checkNumber (int number){
        if (number > 0){
            System.out.println("Number " + number + " is a positive number");
        } else if (number == 0){
            System.out.println("Number " + number + " is zero");
        } else {
            System.out.println("Number " + number + " is a negative number");
        }
    }

    public static double toMilesPerHour (long kilometersPerHour){
        System.out.println(kilometersPerHour);

        // check first //
        if (kilometersPerHour < 0) return -1;

        double milesPerHour = kilometersPerHour * 1.5;
        return milesPerHour;
    }

    public static void printConversion (long kilometersPerHour){
        System.out.println(toMilesPerHour(kilometersPerHour));
    }

    public static boolean shouldWakeUp (boolean barking, int hourOfDay){
        if (!barking){
            return false;
        } else if (hourOfDay > 8 && hourOfDay < 23){
            return false;
        } else {
            return true;
        }
    }

}