package SlidingWindows.test;

import SlidingWindows.LongestUniformSubstringAfterReplacements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestUniformSubstringAfterReplacementsTest {
    @Test
    void test() {
        Assertions.assertEquals(5, LongestUniformSubstringAfterReplacements.longestUniformSubstringAfterReplacements("aabcdcca", 2));
    }
}