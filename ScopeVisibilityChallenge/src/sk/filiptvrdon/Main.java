package sk.filiptvrdon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, insert a number!");
        X x = new X(new Scanner(System.in).nextInt());
        x.x();
    }
}