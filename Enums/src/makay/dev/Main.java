package makay.dev;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DayOfTheWeek weekDay = DayOfTheWeek.TUES;
//        System.out.println(weekDay);
//        System.out.printf("Name is %s, Ordinal value is %d%n", weekDay.name(), weekDay.ordinal());
//        System.out.println(getRandomDay());

        for (DayOfTheWeek day : DayOfTheWeek.values()){
            switchDayOfTheWeek(day);
        }
    }

    public static DayOfTheWeek getRandomDay(){
        int randomInt = new Random().nextInt(7);
        return DayOfTheWeek.values()[randomInt];
    }
    
    
    public static void switchDayOfTheWeek(DayOfTheWeek weekday){
        int weekdayInteger = weekday.ordinal() + 1;

        switch (weekday){
            case WED -> System.out.println("Wednesday is day " + weekdayInteger);
            case FRI -> System.out.println("Friday is day " + weekdayInteger);
            default -> System.out.println(weekday.name().charAt(0) +
                    weekday.name().substring(1).toLowerCase() +
                    "day is day " + weekdayInteger);
        }
    }
}