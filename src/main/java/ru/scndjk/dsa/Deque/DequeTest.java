package ru.scndjk.dsa.Deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeTest {
    private Deque<Integer> deque;

    @BeforeEach
    void init() {
        deque = new Deque<>();
    }

    @Test
    void testAddFrontAndRemoveFront() {
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);

        assertEquals(3, deque.size());
        assertEquals(3, deque.removeFront());
        assertEquals(2, deque.removeFront());
        assertEquals(1, deque.removeFront());

        assertNull(deque.removeFront());
    }

    @Test
    void testAddTailAndRemoveTail() {
        deque.addTail(1);
        deque.addTail(2);
        deque.addTail(3);

        assertEquals(3, deque.size());
        assertEquals(3, deque.removeTail());
        assertEquals(2, deque.removeTail());
        assertEquals(1, deque.removeTail());

        assertNull(deque.removeTail());
    }

    @Test
    void testSize() {
        deque.addTail(1);
        deque.addFront(2);

        assertEquals(2, deque.size());
        assertEquals(2, deque.removeFront());
        assertEquals(1, deque.size());
        assertEquals(1, deque.removeTail());
        assertEquals(0, deque.size());
    }

    @Test
    void testIsPalindrome() {
        assertTrue(Deque.isPalindrome(""));
        assertTrue(Deque.isPalindrome("a"));
        assertTrue(Deque.isPalindrome("aaaaa"));
        assertTrue(Deque.isPalindrome("ababa"));

        assertFalse(Deque.isPalindrome("ab"));
        assertFalse(Deque.isPalindrome("abca"));
        assertFalse(Deque.isPalindrome("abcda"));
    }
}
