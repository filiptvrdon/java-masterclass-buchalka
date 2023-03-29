import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


//        int[] myIntArray = new int[10];
//        myIntArray[0] = 45;
//        myIntArray[1] = 100;
//        myIntArray[5] = 50;
//
//        for (int j : myIntArray) {
//            System.out.println(j);
//        }
//
//
//        double[] myDoubleArray = new double[10];
//        myDoubleArray[2] = 3.5;
//        System.out.println(myDoubleArray[2]);
//        System.out.println(myDoubleArray[0]);
//        System.out.println(myDoubleArray.toString());
//
//        int[] newIntArray = {1,2,3,4,5};
//        System.out.println(Arrays.toString(newIntArray));
//
//        String[] newStringArray = {"A", "B", "C"};
//        System.out.println(Arrays.toString(newStringArray));


        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));

        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray));
        Arrays.fill((secondArray),5);
        System.out.println(Arrays.toString(secondArray));
        System.out.println();


        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));
        System.out.println();

        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(thirdArray));
        System.out.println(Arrays.toString(fourthArray));
        System.out.println();

        int[] smallARray = Arrays.copyOf(thirdArray, 2);
        System.out.println(Arrays.toString(smallARray));
        System.out.println();

        int[] smallARray = Arrays.copyOf(thirdArray, 2);
        System.out.println(Arrays.toString(smallARray));


    }
    private static int[] getRandomArray(int len) {
        Random random = new Random();
        int[] newInt = new int[len];

        for (int i = 0; i < len; i++){
            newInt[i] = random.nextInt(100);
        }

        return newInt;
    }
}