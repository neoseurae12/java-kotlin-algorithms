package SlidingWindows;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestUniformSubstringAfterReplacementsTest {
    @Test
    void test() {
        assertEquals(5, LongestUniformSubstringAfterReplacements.longestUniformSubstringAfterReplacements("aabcdcca", 2));
    }
}