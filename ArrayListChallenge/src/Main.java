import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> mainArrayList = new ArrayList<>();

    public static void main(String[] args) {

        boolean repeatLoop = true;

        do {
            System.out.println("Available actions:");
            System.out.println("0 - to shutdown");
            System.out.println("1 - to add item(s) to list (csv)");
            System.out.println("2 - to remove any item(s) from the list (csv)");
            System.out.println("Enter a number for which action you want to do");
            String menuInput = scanner.nextLine();

            if (menuInput.equals("0")) {
                repeatLoop = false;
            }
            if (menuInput.equals("1")) {
                addItemsToListIfNotPresent();
                mainArrayList.sort(Comparator.naturalOrder());
                System.out.println(mainArrayList);
            } else if (menuInput.equals("2")) {
                removeItemsFromListIfPresent();
                System.out.println(mainArrayList);
            } else {
                System.out.println("Invalid input, try again");
            }
        } while (repeatLoop);

    }

    private static void removeItemsFromListIfPresent() {
        System.out.println("Please enter comma separated integer values to be removed");
        boolean isUserInputValid = false;

        do {
            try {
                String[] stringsArray = getStringsArrayFromInput(scanner.nextLine());

                for (String s : stringsArray) {
                    if (checkItemPresence(s)) {
                        mainArrayList.remove(s.trim());
                    }
                }

                isUserInputValid = true;
            } catch (NumberFormatException e){
                System.out.println("Invalid characters. Try again.");
            }
        } while (!isUserInputValid);
    }

    private static String[] getStringsArrayFromInput(String nextLine) {
        return nextLine.split(",");
    }

    private static void addItemsToListIfNotPresent() {
        System.out.println("Please enter comma separated integer values");
        boolean isUserInputValid = false;

        do {
            try {
//                String csvValues = scanner.nextLine();
//                String[] stringsArray = csvValues.split(",");
                // mainArrayList.addAll(Arrays.asList(stringsArray));

                String[] stringsArray = getStringsArrayFromInput(scanner.nextLine());

                for (String s : stringsArray) {
                    if (!checkItemPresence(s)) {
                        mainArrayList.add(s.trim());
                    }
                }

                isUserInputValid = true;
            } catch (NumberFormatException e){
                System.out.println("Invalid characters. Try again.");
            }
        } while (!isUserInputValid);


    }

    private static boolean checkItemPresence(String s) {
        return mainArrayList.contains(s);
    }

}
