package SlidingWindows.test;

import SlidingWindows.SubstringAnagrams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubstringAnagramsTest {
    @Test
    void testSubstringAnagrams() {
        Assertions.assertEquals(2, SubstringAnagrams.substringAnagrams("caabab", "aba"));
    }
}