package org.example;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        System.out.println("BIG DECIMAL");

        double amount = 100_000_000;
        int divisor = 3;
        float percentageFloat = 1.0f / divisor;
        double percentageDouble = 1.0 / divisor;

        System.out.printf("Result = %,.2f%n", amount * percentageFloat);
        System.out.printf("Result = %,.2f%n", amount * percentageDouble);

        double totalUsingFloat = amount - ((amount * percentageFloat) * divisor);
        System.out.printf("Total using float: %,.2f%n", totalUsingFloat);

        double totalUsingDouble = amount - ((amount * percentageDouble) * divisor);
        System.out.printf("Total using double: %,.2f%n", totalUsingDouble);

        // imprecissions occur when when using primitive decimals



        // USING BIG DECIMAL //
        /*
        DO NOT USE DOUBLE CONSTRUCTOR -> USE STRINGS
         */

        BigDecimal result = BigDecimal.ONE.divide(BigDecimal.valueOf(divisor), new MathContext(60, RoundingMode.UP));
        System.out.printf("Result: %,.60f%n", result);
        System.out.printf("%-60s %-60d %-8d %d %n", result, result.unscaledValue(), result.scale(), result.precision());


        BigDecimal resultRounded = BigDecimal.ONE.divide(BigDecimal.valueOf(divisor), new MathContext(60, RoundingMode.UP));
        resultRounded = resultRounded.setScale(2, RoundingMode.HALF_UP);
        System.out.printf("Result: %,.60f%n", resultRounded);
        System.out.printf("%-60s %-60d %-8d %d %n", resultRounded, resultRounded.unscaledValue(), resultRounded.scale(), resultRounded.precision());

        BigDecimal totalAmount = resultRounded.multiply(BigDecimal.valueOf(divisor));
        System.out.printf("Divided parts combined: %.2f%n",totalAmount)e;






    }
}