package FastAndSlowPointers.test;

import FastAndSlowPointers.HappyNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {
    @Test
    void testHappyNumber() {
        Assertions.assertTrue(HappyNumber.happy_number(23));
    }

    @Test
    void testUnhappyNumber() {
        assertFalse(HappyNumber.happy_number(116));
    }
}