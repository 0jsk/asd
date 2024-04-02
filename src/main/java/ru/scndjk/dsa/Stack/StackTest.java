package ru.scndjk.dsa.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StackTest {
    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    void testSize() {
        assertEquals(3, stack.size());
    }

    @Test
    void testPop() {
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertNull(stack.pop());
    }

    @Test
    void testPeek() {
        assertEquals(3, stack.peek());
        stack.pop();
        assertEquals(2, stack.peek());

        stack.pop();
        stack.pop();

        assertNull(stack.peek());
    }
}
