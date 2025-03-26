package BinarySearch.test;

import BinarySearch.CuttingWood;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuttingWoodTest {
    @Test
    void testBasicCase() {
        int[] heights = {2, 6, 3, 8};
        int k = 7;
        int result = CuttingWood.cuttingWood(heights, k);
        assertEquals(3, result);    // 0+3+0+5 = 8
    }

    @Test
    void testLargerK() {
        int[] heights = {20, 15, 10, 17};
        int k = 20;
        int result = CuttingWood.cuttingWood(heights, k);
        assertEquals(10, result); // 10+5+0+7 = 22
    }

    @Test
    void testZeroRequiredWood() {
        int[] heights = {4, 5, 6};
        int k = 0;
        int result = CuttingWood.cuttingWood(heights, k);
        assertEquals(6, result);    // 0+0+0 = 0
    }

    @Test
    void testAllSameHeight() {
        int[] heights = {10, 10, 10, 10};
        int k = 5;
        int result = CuttingWood.cuttingWood(heights, k);
        assertEquals(8, result); // 2+2+2+2 =8
    }
}