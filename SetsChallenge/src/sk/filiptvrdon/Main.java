package sk.filiptvrdon;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static Set<HeavenlyBody> solarSystem = new HashSet<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        Planet temp = new Planet("Mercury",88);
        solarSystem.add(temp);
        planets.add(temp);

        temp = new Planet("Venus",225);
        solarSystem.add(temp);
        planets.add(temp);

        temp = new Planet("Earth",365);
        solarSystem.add(temp);
        planets.add(temp);

        Moon tempMoon = new Moon("Moon", 27);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars",687);
        solarSystem.add(temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter", 4332);
        solarSystem.add(temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon(    "Europa", 3.5);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);

        System.out.println("JUPITER'S MOONS");
        Set<HeavenlyBody> jupitersMoons = new HashSet<>(temp.getSatellites());
        for (HeavenlyBody moon : jupitersMoons){
            System.out.println("\t" + moon.getName());
        }

        temp = new Planet("Jupiter", 4332);
        solarSystem.add(temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon(    "Europa", 3.5);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);



        temp = new Planet("Saturn",10759);
        solarSystem.add(temp);
        planets.add(temp);

        temp = new Planet("Neptune",165);
        solarSystem.add(temp);
        planets.add(temp);

        temp = new Planet("Pluto",248);
        solarSystem.add(temp);
        planets.add(temp);



        Planet pluto1 = new Planet("Pluto",248);
        Moon pluto2 = new Moon("Pluto",248);
        System.out.println(pluto1.equals(pluto2));
        System.out.println(pluto2.equals(pluto1));


        System.out.println("Planets: ");
        for (HeavenlyBody planet : planets){
            System.out.println("\t" + planet.getName());
        }

//        Set<HeavenlyBody> moons = new HashSet<>();
//        for (HeavenlyBody planet : planets){
//            moons.addAll(planet.getSatellites());
//        }
//        System.out.println("List of moons:");
//        for (HeavenlyBody moon : moons){
//            System.out.println("\t" + moon.getName());
//        }
//
        System.out.println("THE SOLAR SYSTEM:");
        for (HeavenlyBody heavenlyBody : solarSystem){
            System.out.println("\t" + heavenlyBody.getName() + " - " + heavenlyBody.getBodyType());
        }



        /*

        Test cases:
        1. The planets and moons that we added in the previous video should appear in
        the solarSystem collection and in the sets of moons for the appropriate planets.

        2. a.equals(b) must return the same result as b.equals(a) - equals is symmetric.

        3. Attempting to add a duplicate to a Set must result in no change to the set (so
        the original value is not replaced by the new one).

        4. Attempting to add a duplicate to a Map results in the original being replaced
        by the new object.

        5. Two bodies with the same name but different designations can be added to the same set.

        6. Two bodies with the same name but different designations can be added to the same map,
        and can be retrieved from the map.
*/

    }

}