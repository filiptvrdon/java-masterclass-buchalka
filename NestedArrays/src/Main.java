import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        int[][] nestedArray = new int[4][4];

        for (int[] inner : nestedArray){
            // System.out.println(Arrays.toString(inner));
        }

        for (int i = 0; i < nestedArray.length; i++) {
            var innerArray = nestedArray[i];

            for (int j = 0; j < innerArray.length; j++) {
                nestedArray[i][j] = (i*10) + (j+1);
            }
//            System.out.println();
        }
//        for(var outer : nestedArray){
//            for (var element : outer){
//                System.out.print(element + " ");
//            }
//            System.out.println();
//        }

//        System.out.println(Arrays.deepToString(nestedArray));



        Object[] anyArray = new Object[3];
        System.out.println(Arrays.deepToString(anyArray));

        anyArray[0] = new String[] {"a", "b", "c"};
        System.out.println(Arrays.deepToString(anyArray));

        anyArray[1] = new String[][]{
                {"1", "2"},
                {"3","4","5"},
                {"6","7","8","9"}
        };
        System.out.println(Arrays.deepToString(anyArray));

        anyArray[2] = new int[2][2][2];
        System.out.println(Arrays.deepToString(anyArray));

        for (Object element : anyArray){
            System.out.println("Element type = " + element.getClass().getSimpleName());
            System.out.println(("Element toString() " + element ));
            System.out.println(Arrays.deepToString((Object[]) element));
        }
    }


}