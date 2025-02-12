package TwoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LargestContainerTest {
    @Test
    void testLargestContainer() {
        Assertions.assertEquals(24, LargestContainer.largestContainer(new int[] {2, 7, 8, 3, 7, 6}));
        Assertions.assertEquals(0, LargestContainer.largestContainer(new int[] {}));
        Assertions.assertEquals(0, LargestContainer.largestContainer(new int[] {1}));
        Assertions.assertEquals(0, LargestContainer.largestContainer(new int[] {0, 1, 0}));
        Assertions.assertEquals(9, LargestContainer.largestContainer(new int[] {3, 3, 3, 3}));
        Assertions.assertEquals(2, LargestContainer.largestContainer(new int[] {1, 2, 3}));
        Assertions.assertEquals(2, LargestContainer.largestContainer(new int[] {3, 2, 1}));
    }
}