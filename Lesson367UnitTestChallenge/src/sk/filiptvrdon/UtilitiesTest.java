package sk.filiptvrdon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    Utilities util = new Utilities();

    @BeforeAll
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = ");
    }
    @BeforeEach
    public void setup() {
        System.out.println("Running a test...");
        util = new Utilities();
    }

    @Test
    void everyNthChar() {
        char[] output = util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[] {'e', 'l'}, output);

        char[] output2 = util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output2);
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
        assertEquals(300, util.converter(10, 5));
    }

    @Test
    void converter_arithmeticException() {
        assertThrows(ArithmeticException.class, () -> util.converter(10, 0));
    }

    @Test
    void nullIfOddLength() {
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }
}
