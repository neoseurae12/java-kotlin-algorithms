package SlidingWindows.test;

import SlidingWindows.LongestSubstringWithUniqueCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithUniqueCharactersTest {
    @Test
    void testEmptyString() {
        Assertions.assertEquals(0, LongestSubstringWithUniqueCharacters.longestSubstringWithUniqueChars(""));
    }

    @Test
    void testNotEmptyString() {
        assertEquals(3, LongestSubstringWithUniqueCharacters.longestSubstringWithUniqueChars("abcba"));
        assertEquals(2, LongestSubstringWithUniqueCharacters.longestSubstringWithUniqueChars("abbbb"));
    }
}