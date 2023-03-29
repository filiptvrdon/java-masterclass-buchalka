import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[] intArray =  getRandomArray();
        System.out.println(Arrays.toString(intArray));

        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        int[] intArrayAsc = sortIntArrayDesc(intArray);
        System.out.println(Arrays.toString(intArrayAsc));
    }

    private static int[] getRandomArray() {
        Random random = new Random();
        int[] newInt = new int[10];

        for (int i = 0; i < 10; i++){
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }

    private static int[] sortIntArrayDesc(int[] intArray){
        int[] intArrayAsc = new int[intArray.length];
        int reverseIndex = intArray.length - 1;

        for (int index = 0; index < intArray.length; index++){
            intArrayAsc[index] = intArray[reverseIndex];
            reverseIndex--;
        }
        return intArrayAsc;
    }
}