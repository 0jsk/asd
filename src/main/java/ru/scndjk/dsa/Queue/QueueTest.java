package ru.scndjk.dsa.Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class QueueTest {
    private Queue<Integer> queue;

    @BeforeEach
    void init() {
        queue = new Queue<>();
    }

    @Test
    void testDeEnqueueAndSize() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(3, queue.size());

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertNull(queue.dequeue());

        assertEquals(0, queue.size());
    }
}
