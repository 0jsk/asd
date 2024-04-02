package ru.scndjk.dsa.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PostfixEvaluatorTest {
    @Test
    void testDefault() {
        assertEquals(59.0, PostfixEvaluator.evalPostfix("8 2 + 5 * 9 + ="));
        assertEquals(2301.0, PostfixEvaluator.evalPostfix("4 55 + 62 23 - * ="));
        assertEquals(9139.0, PostfixEvaluator.evalPostfix("9139 3 / 3 * ="));
    }

}
