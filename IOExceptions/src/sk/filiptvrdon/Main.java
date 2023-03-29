package sk.filiptvrdon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int x = 98;
//        int y = 0;

//        System.out.println(divideLBYL(x,y));
//        System.out.println(divideEAFP(x,y));
//        System.out.println(divide(x,y));

        // System.out.println(getIntLBYL());
        System.out.println(getIntEAFP());

        int x = getInt();
        System.out.println("x is " + x);

    }

    private static int getInt(){
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    public static int getIntLBYL(){
        Scanner s = new Scanner(System.in);
        boolean isValid = false;
        System.out.println("Enter an int");

        String input = s.next();

        for (int i=0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                break;
            }
            isValid = true;
        }

        if (isValid) {
            return Integer.parseInt(input);
        } else {
            return 0;
        }

    }

    private static int getIntEAFP(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer");

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e){
            return 0;
        }
    }

    private static int divideLBYL(int x, int y){
        if (y != 0){
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y){
        try {
            return x / y;
        } catch (ArithmeticException e){
            return 0;
        }
    }

    private static int divide(int x, int y){
        return x / y;
    }

}