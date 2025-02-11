package TwoPointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsPalindromeValidTest {

    @Test
    void testPalindromeValidCases() {
        assertTrue(IsPalindromeValid.isPalindromeValid(""));
        assertTrue(IsPalindromeValid.isPalindromeValid("a"));
        assertTrue(IsPalindromeValid.isPalindromeValid("aa"));
        assertTrue(IsPalindromeValid.isPalindromeValid("!, (?)"));
        assertTrue(IsPalindromeValid.isPalindromeValid("12.02.2021"));
    }

    @Test
    void testPalindromeInvalidCases() {
        assertFalse(IsPalindromeValid.isPalindromeValid("ab"));
        assertFalse(IsPalindromeValid.isPalindromeValid("21.02.2021"));
        assertFalse(IsPalindromeValid.isPalindromeValid("hello, world!"));
    }
}