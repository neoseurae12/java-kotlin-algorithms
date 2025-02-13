package HashMapsSets;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PairSumUnsortedOnePassTest {
    @Test
    void testPairSumUnsortedOnePass() {
        assertThat(new int[] {0, 2}).containsExactlyInAnyOrder(PairSumUnsorted_OnePass.pairSumUnsortedOnePass(new int[] {-1, 3, 4, 2}, 3));
    }
}