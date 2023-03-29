import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int currentYear = 2022;

        try {
            System.out.println(getInputFromConsole(currentYear));
        } catch (NullPointerException e) {
            System.out.println(getInputFromScanner(currentYear));
        }


    }
    public static String getInputFromConsole (int currentYear){
        String name = System.console().readLine("Hi, what's your name?");
        String dateOfBirth = System.console().readLine("Hi, what's your birth year?");
        int age = currentYear - Integer.parseInt((dateOfBirth));
        return "So you are " + age + ", years old";
    }

    public static String getInputFromScanner (int currentYear){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi, what's your name?");
        String name = scanner.nextLine();

        boolean validateOfBirth = false;
        int age = 0;

        do {
            System.out.println("Enter a year of birth >= " + (currentYear - 125) + " and <= " + (currentYear));
            try {
                age = checkDateOfBirth(2022, scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Invalid characters. Try again.");
            }


            if (age > 0){
                validateOfBirth = true;
            }
        } while (!validateOfBirth);


        return "So you are " + age + ", years old";
    }

    public static int checkDateOfBirth (int currentYear, String dateOfBirth){
        int dateOfBirthInt = Integer.parseInt((dateOfBirth));
        int minimumYear = currentYear - 125;

        if ((dateOfBirthInt < minimumYear) || (dateOfBirthInt > currentYear)){
            return -1;
        }

        return (currentYear - dateOfBirthInt);


    }
}
