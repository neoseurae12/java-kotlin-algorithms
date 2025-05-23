package HashMapsSets.test;

import HashMapsSets.ZeroStripingInPlace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroStripingInPlaceTest {
    @Test
    void testZeroStripingInplace() {
        ZeroStripingInPlace.zeroStriping(new int[][] {
                {1, 2, 3, 4, 5},
                {6, 0, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 0}
        });

        assertArrayEquals(new int[][] {
                        {1, 0, 3, 4, 0},
                        {0, 0, 0, 0, 0},
                        {11, 0, 13, 14, 0},
                        {0, 0, 0, 0, 0}
                },
                ZeroStripingInPlace.mMatrix
        );
    }
}