import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String[] originalArray = new String[]  {"First", "Second", "Third"};
        System.out.println("ARRAY: " + Arrays.toString(originalArray));

        var originalList = Arrays.asList(originalArray);
        originalList.set(0,"one");
        System.out.println("LIST: " + originalList);
        System.out.println("ARRAY: " + Arrays.toString(originalArray));

        originalList.sort(Comparator.naturalOrder());
        System.out.println("LIST: " + originalList);
        System.out.println("ARRAY: " + Arrays.toString(originalArray));

        originalList.add()

    }
}