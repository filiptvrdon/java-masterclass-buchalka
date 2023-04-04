package sk.filiptvrdon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    private static final int STARTING_ROOM = 1;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Location currentLocation = locations.getLocation(1);
        System.out.println(currentLocation.getDescription());

        while(true){
            System.out.println(currentLocation.getDescription());
            if (currentLocation.getLocationID() == 0){
                break;
            }

            Map<String, Integer> exits = currentLocation.getExits();
            System.out.println("Available exits are:");
            for (String exit : exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (exits.containsKey(direction)){
                currentLocation = locations.getLocation(currentLocation.getExits().get(direction));

            } else {
                System.out.println("You cannot go in that direction");
            }

        }
        locations.close();
    }
}