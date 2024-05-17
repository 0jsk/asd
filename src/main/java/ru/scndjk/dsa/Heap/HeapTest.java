package ru.scndjk.dsa.Heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    private Heap heap;

    @BeforeEach
    void setUp() {
        heap = new Heap();
    }

    @Test
    void temp_EmptyArrayOnEmptyHeap() {
        heap.MakeHeap(new int[]{}, 0);
        assertArrayEquals(new int[]{0}, heap.HeapArray);
    }

    @Test
    void test_AddOnHeap() {
        heap.MakeHeap(new int[]{11, 5, 17, 2, 8, 14, 19}, 2);
        assertArrayEquals(new int[]{19, 8, 17, 2, 5, 11, 14}, heap.HeapArray);
    }

    @Test
    void test_AddOnHeap2() {
        heap.MakeHeap(new int[]{8, 5, 2, 17, 19, 11, 14, 21}, 3);
        assertArrayEquals(new int[]{21, 19, 14, 17, 8, 2, 11, 5, 0, 0, 0, 0, 0, 0, 0}, heap.HeapArray);
    }

    @Test
    void test_MaxOnEmptyHeap() {
        heap.MakeHeap(new int[]{}, 0);
        assertEquals(-1, heap.GetMax());
    }

    @Test
    void test_MaxOnHeap() {
        heap.MakeHeap(new int[]{11, 5, 17, 2, 8, 14, 19}, 2);
        assertEquals(19, heap.GetMax());
        assertArrayEquals(new int[]{17, 8, 14, 2, 5, 11, 0}, heap.HeapArray);
    }

    @Test
    void test_MaxOnHeap2() {
        heap.MakeHeap(new int[]{8, 5, 2, 17, 19, 11, 14, 21}, 3);
        assertEquals(21, heap.GetMax());
        assertArrayEquals(new int[]{19, 17, 14, 5, 8, 2, 11, 0, 0, 0, 0, 0, 0, 0, 0}, heap.HeapArray);
    }

    @Test
    void shouldAddToEmptyHeap() {
        heap.MakeHeap(new int[]{}, 0);
        assertTrue(heap.Add(10));
        assertArrayEquals(new int[]{10}, heap.HeapArray);
    }

    @Test
    void test_AddToFullHeap() {
        heap.MakeHeap(new int[]{11, 5, 17, 2, 8, 14, 19}, 2);
        assertFalse(heap.Add(22));
    }
}

