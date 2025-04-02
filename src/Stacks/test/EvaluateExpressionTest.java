package Stacks.test;

import Stacks.EvaluateExpression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateExpressionTest {
    @Test
    void testSingleNumber() {
        assertEquals(42, EvaluateExpression.evaluateExpression("42"));
    }

    @Test
    void testSimpleAddition() {
        assertEquals(3, EvaluateExpression.evaluateExpression("1+2"));
    }

    @Test
    void testAdditionAndSubtraction() {
        assertEquals(5, EvaluateExpression.evaluateExpression("4-1+2"));
    }

    @Test
    void testJustParentheses() {
        assertEquals(1, EvaluateExpression.evaluateExpression("(1)"));
        assertEquals(3, EvaluateExpression.evaluateExpression("(1+(2))"));
    }

    @Test
    void testWithSingleParentheses() {
        assertEquals(2, EvaluateExpression.evaluateExpression("1-(2-3)"));
    }

    @Test
    void testWithNestedParentheses() {
        assertEquals(13, EvaluateExpression.evaluateExpression("18-(7+(2-4))"));
        assertEquals(2, EvaluateExpression.evaluateExpression("7+6-(3+(4-5)+8)-1"));
    }

    @Test
    void testWithWhitespace() {
        assertEquals(7, EvaluateExpression.evaluateExpression(" 2 + ( 3 + 2 ) "));
    }

    @Test
    void testNegativeResult() {
        assertEquals(-4, EvaluateExpression.evaluateExpression("1-(2+3)"));
    }
}