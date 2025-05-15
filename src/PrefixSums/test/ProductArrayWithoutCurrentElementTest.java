package PrefixSums.test;

import PrefixSums.ProductArrayWithoutCurrentElementByDivision;
import PrefixSums.ProductArrayWithoutCurrentElementByLeftRight;
import PrefixSums.ProductArrayWithoutCurrentElementByInPlace;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductArrayWithoutCurrentElementTest {
    @Nested
    class DivisionTests {
        @Test
        void testSimpleCase() {
            int[] nums = {1, 2, 3, 4};
            int[] expected = {24, 12, 8, 6};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByDivision.productArrayWithoutCurrentElementByDivision(nums));
        }

        @Test
        void testWithZero() {
            int[] nums = {1, 2, 0, 4};
            int[] expected = {0, 0, 8, 0};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByDivision.productArrayWithoutCurrentElementByDivision(nums));
        }

        @Test
        void testWithMultipleZeros() {
            int[] nums = {0, 2, 0, 4};
            int[] expected = {0, 0, 0, 0};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByDivision.productArrayWithoutCurrentElementByDivision(nums));
        }

        @Test
        void testSingleElement() {
            int[] nums = {5};
            int[] expected = {1};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByDivision.productArrayWithoutCurrentElementByDivision(nums));
        }

        @Test
        void testAllOnes() {
            int[] nums = {1, 1, 1, 1};
            int[] expected = {1, 1, 1, 1};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByDivision.productArrayWithoutCurrentElementByDivision(nums));
        }

        @Test
        void testWithNegativeNumbers() {
            int[] nums = {-1, 2, -3, 4};
            int[] expected = {-24, 12, -8, 6};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByDivision.productArrayWithoutCurrentElementByDivision(nums));
        }
    }

    @Nested
    class LeftRightTests {
        @Test
        void testSimpleCase() {
            int[] nums = {1, 2, 3, 4};
            int[] expected = {24, 12, 8, 6};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByLeftRight.productArrayWithoutCurrentElementByLeftRight(nums));
        }

        @Test
        void testWithZero() {
            int[] nums = {1, 2, 0, 4};
            int[] expected = {0, 0, 8, 0};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByLeftRight.productArrayWithoutCurrentElementByLeftRight(nums));
        }

        @Test
        void testWithMultipleZeros() {
            int[] nums = {0, 2, 0, 4};
            int[] expected = {0, 0, 0, 0};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByLeftRight.productArrayWithoutCurrentElementByLeftRight(nums));
        }

        @Test
        void testSingleElement() {
            int[] nums = {5};
            int[] expected = {1};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByLeftRight.productArrayWithoutCurrentElementByLeftRight(nums));
        }

        @Test
        void testAllOnes() {
            int[] nums = {1, 1, 1, 1};
            int[] expected = {1, 1, 1, 1};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByLeftRight.productArrayWithoutCurrentElementByLeftRight(nums));
        }

        @Test
        void testWithNegativeNumbers() {
            int[] nums = {-1, 2, -3, 4};
            int[] expected = {-24, 12, -8, 6};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByLeftRight.productArrayWithoutCurrentElementByLeftRight(nums));
        }
    }

    @Nested
    class InPlaceTests {
        @Test
        void testSimpleCase() {
            int[] nums = {1, 2, 3, 4};
            int[] expected = {24, 12, 8, 6};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByInPlace.productArrayWithoutCurrentElementByInPlace(nums));
        }

        @Test
        void testWithZero() {
            int[] nums = {1, 2, 0, 4};
            int[] expected = {0, 0, 8, 0};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByInPlace.productArrayWithoutCurrentElementByInPlace(nums));
        }

        @Test
        void testWithMultipleZeros() {
            int[] nums = {0, 2, 0, 4};
            int[] expected = {0, 0, 0, 0};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByInPlace.productArrayWithoutCurrentElementByInPlace(nums));
        }

        @Test
        void testSingleElement() {
            int[] nums = {5};
            int[] expected = {1};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByInPlace.productArrayWithoutCurrentElementByInPlace(nums));
        }

        @Test
        void testAllOnes() {
            int[] nums = {1, 1, 1, 1};
            int[] expected = {1, 1, 1, 1};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByInPlace.productArrayWithoutCurrentElementByInPlace(nums));
        }

        @Test
        void testWithNegativeNumbers() {
            int[] nums = {-1, 2, -3, 4};
            int[] expected = {-24, 12, -8, 6};
            assertArrayEquals(expected, ProductArrayWithoutCurrentElementByInPlace.productArrayWithoutCurrentElementByInPlace(nums));
        }
    }
}