package SlidingWindows;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstringAnagramsTest {
    @Test
    void testSubstringAnagrams() {
        assertEquals(2, SubstringAnagrams.substringAnagrams("caabab", "aba"));
    }
}