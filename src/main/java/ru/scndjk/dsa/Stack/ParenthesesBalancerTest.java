package ru.scndjk.dsa.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParenthesesBalancerTest {
    @Test
    void testIsBalancedTrue() {
        assertTrue(ParenthesesBalancer.isParenthesesBalanced("(())"));
        assertTrue(ParenthesesBalancer.isParenthesesBalanced("((()))"));
        assertTrue(ParenthesesBalancer.isParenthesesBalanced("(((()())))"));
    }

    @Test
    void testIsBalancedFalse() {
        assertFalse(ParenthesesBalancer.isParenthesesBalanced(")"));
        assertFalse(ParenthesesBalancer.isParenthesesBalanced("(("));
        assertFalse(ParenthesesBalancer.isParenthesesBalanced("(())("));
        assertFalse(ParenthesesBalancer.isParenthesesBalanced(")("));
    }
}
