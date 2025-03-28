package Stacks.test;

import Stacks.ValidParenthesisExpression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisExpressionTest {
    @Test
    void testValidCases() {
        assertTrue(ValidParenthesisExpression.validParenthesisExpression("()"));
        assertTrue(ValidParenthesisExpression.validParenthesisExpression("()[]{}"));
        assertTrue(ValidParenthesisExpression.validParenthesisExpression("{[()]}"));
        assertTrue(ValidParenthesisExpression.validParenthesisExpression("([]{})"));
        assertTrue(ValidParenthesisExpression.validParenthesisExpression("((({[]})))"));
    }

    @Test
    void testInvalidCases() {
        assertFalse(ValidParenthesisExpression.validParenthesisExpression("(]"));
        assertFalse(ValidParenthesisExpression.validParenthesisExpression("([)]"));
        assertFalse(ValidParenthesisExpression.validParenthesisExpression("((("));
        assertFalse(ValidParenthesisExpression.validParenthesisExpression("(()"));
        assertFalse(ValidParenthesisExpression.validParenthesisExpression("([]{)}"));
        assertFalse(ValidParenthesisExpression.validParenthesisExpression("{[(])}"));
    }

    @Test
    void testEmptyString() {
        assertTrue(ValidParenthesisExpression.validParenthesisExpression(""));
    }

    @Test
    void testOnlyOpening() {
        assertFalse(ValidParenthesisExpression.validParenthesisExpression("(((("));
        assertFalse(ValidParenthesisExpression.validParenthesisExpression("{["));
    }

    @Test
    void testOnlyClosing() {
        assertFalse(ValidParenthesisExpression.validParenthesisExpression("))))"));
        assertFalse(ValidParenthesisExpression.validParenthesisExpression("]}"));
    }

    @Test
    void testSingleCharacter() {
        assertFalse(ValidParenthesisExpression.validParenthesisExpression("("));
        assertFalse(ValidParenthesisExpression.validParenthesisExpression("]"));
    }
}