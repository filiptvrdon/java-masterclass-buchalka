import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Integer[] intArray =  getRandomArray();
        System.out.println(Arrays.toString(intArray));

        Arrays.sort(intArray, Collections.reverseOrder());
        System.out.println(Arrays.toString(intArray));
    }

    private static Integer[] getRandomArray() {
        Random random = new Random();
        Integer[] newInt = new Integer[10];

        for (int i = 0; i < 10; i++){
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}