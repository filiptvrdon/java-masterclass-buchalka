import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] integers = readIntegers();
        System.out.println("RESULTING INTEGER ARRAY");
        System.out.println(Arrays.toString(integers));

        Arrays.sort(integers);
        System.out.println("SORTED INTEGER ARRAY");
        System.out.println(Arrays.toString(integers));

        int min = findMin(integers);
        System.out.println("MIN VALUE OF THE INTEGER ARRAY");
        System.out.println(min);

        int[] reversed = reverseIntArray(integers);
        System.out.println("REVERSED INTEGER ARRAY");
        System.out.println(Arrays.toString(reversed));

    }
    public static int[] readIntegers(){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter csv integers");
            String integers = scanner.nextLine();
            try {
                return validateIntegerInput(integers);
            } catch (Exception e){
                System.out.println("Invalid input. Try again.");
            }
        } while (true);
    }
    private static int[] validateIntegerInput (String csvIntegers){
        String[] separatedIntegerStrings = csvIntegers.split(",");
        int[] integerArray = new int[separatedIntegerStrings.length];
        for (int i = 0; i < separatedIntegerStrings.length; i++){
            integerArray[i] = Integer.parseInt(separatedIntegerStrings[i].trim());
        }
        return integerArray;
    }

    private static int findMin(int[] sortedIntegers) {
        return sortedIntegers[0];
    }


    private static int[] reverseIntArray(int[] integers) {
        int[] reversedIntegers = new int[integers.length];
        int reverseIndex = integers.length - 1;

//        for (int index = 0; index < integers.length; index++) {
//            reversedIntegers[index] = integers[reverseIndex];
//            reverseIndex--;
//        }

        for (int integer : integers){
            reversedIntegers[reverseIndex--] = integer;
        }
        return reversedIntegers;
    }

}