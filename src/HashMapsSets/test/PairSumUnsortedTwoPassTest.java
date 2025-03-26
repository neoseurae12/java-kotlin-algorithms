package HashMapsSets.test;

import HashMapsSets.PairSumUnsorted_TwoPass;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PairSumUnsortedTwoPassTest {
    @Test
    void testPairSumUnsortedTwoPass() {
        assertThat(new int[] {0, 2}).containsExactlyInAnyOrder(PairSumUnsorted_TwoPass.pairSumUnsortedTwoPass(new int[] {-1, 3, 4, 2}, 3));
    }
}