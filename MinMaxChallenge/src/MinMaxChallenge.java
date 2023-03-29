import java.util.Scanner;

public class MinMaxChallenge {
    static double min = 0;
    static double max = 0;
    static int loopCount = 0;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            try {
                if (loopCount > 0){
                    System.out.println("Current Min Number: " + getMin());
                    System.out.println("Current Max Number: " + getMax());
                }
                System.out.println("Enter a number. If you wish to exit the process, enter a character.");

                double userNumber = parseUserInput(scanner.nextLine());

                updateMinIfNeeded(userNumber);
                updateMaxIfNeeded(userNumber);
                loopCount++;

            } catch (Exception e) {
                System.out.println("Bye bye!");
                return;
            }


        }
    }

    private static double parseUserInput(String userInput) {
        try {
            return Double.parseDouble((userInput));
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateMinIfNeeded(double userNumber){
        if (userNumber < getMin() || loopCount == 0){
            setMin(userNumber);
        }
    }

    private static void updateMaxIfNeeded(double userNumber){
        if (userNumber > getMax() || loopCount == 0){
            setMax(userNumber);
        }
    }

    public static double getMin() {
        return min;
    }

    public static double getMax() {
        return max;
    }

    public static void setMin(double min) {
        MinMaxChallenge.min = min;
    }

    public static void setMax(double max) {
        MinMaxChallenge.max = max;
    }
}

