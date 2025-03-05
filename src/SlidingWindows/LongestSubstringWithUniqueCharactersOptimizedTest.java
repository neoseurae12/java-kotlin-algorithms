package SlidingWindows;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithUniqueCharactersOptimizedTest {
    @Test
    void testEmptyString() {
        assertEquals(0, LongestSubstringWithUniqueCharactersOptimized.longestSubstringWithUniqueCharsOptimized(""));
    }

    @Test
    void testNotEmptyString() {
        assertEquals(3, LongestSubstringWithUniqueCharactersOptimized.longestSubstringWithUniqueCharsOptimized("abcba"));
        assertEquals(2, LongestSubstringWithUniqueCharactersOptimized.longestSubstringWithUniqueCharsOptimized("abbbb"));
    }
}