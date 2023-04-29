package sk.filiptvrdon;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(org.junit.runners.Parameterized.class)
public class UtilitiesTestParameterized {

    // write parameterized tests for everyNthChar method
    private Utilities util;
    char[] input;
    char[] expectedOutput;
    int n;

    public UtilitiesTestParameterized(char[] input, char[] expectedOutput, int n) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.n = n;
    }

    @org.junit.Before
    public void setup() {
        util = new Utilities();
        System.out.println("Running a test...");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {'h', 'e', 'l', 'l', 'o'}, {'e', 'l'},
                {'h', 'e', 'l', 'l', 'o'}, {'h', 'e', 'l', 'l', 'o'},
                {'h', 'e', 'l', 'l', 'o'}, {'h', 'l'}
        });
    }

    @Test
    public void everyNthChar() {
        char[] output = util.everyNthChar(input, n);
        assertArrayEquals(expectedOutput, output);
    }



}
