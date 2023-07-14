package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Mappable> mappables = new ArrayList<>();
        mappables.add(new Building("Empire State Building", UsageType.COMMERCIAL));
        mappables.add(new Building("White House", UsageType.GOVERNMENT));
        mappables.add(new Building("The Gherkin", UsageType.COMMERCIAL));
        mappables.add(new Building("The Shard", UsageType.COMMERCIAL));
        mappables.add(new Building("The Cheesegrater", UsageType.COMMERCIAL));
        mappables.add(new Building("The Walkie Talkie", UsageType.COMMERCIAL));


        mappables.add(new UtilityLine("Power Line", UtilityType.ELECTRICITY));
        mappables.add(new UtilityLine("Gas Line", UtilityType.GAS));
        mappables.add(new UtilityLine("Water Line", UtilityType.WATER));
        mappables.add(new UtilityLine("Sewer Line", UtilityType.SEWER));
        mappables.add(new UtilityLine("Fibre Optic Line", UtilityType.INTERNET));

        mappables.forEach(Mappable::mapIt);
    }
}