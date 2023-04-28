package sk.filiptvrdon;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    Utilities util = new Utilities();

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = ");
    }

    @org.junit.Before
    public void setup() {
        System.out.println("Running a test...");
        util = new Utilities();
    }





    @Test
    void everyNthChar() {
        fail("This test has yet to be implemented");
    }

    @Test
    void removePairs() {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));

        // write test cases to check for failures
        assertNull(util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));

    }

    @Test
    void converter() {
        fail("This test has yet to be implemented");
    }

    @Test
    void nullIfOddLength() {
        fail("This test has yet to be implemented");
    }
}