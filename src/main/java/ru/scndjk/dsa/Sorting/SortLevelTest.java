package ru.scndjk.dsa.Sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortLevelTest {

    @Test
    void testSelectionSort() {
        int[] array = {1, 2, 3, 4, 5, 10, 7, 8, 9, -13};
        SortLevel.SelectionSortStep(array, 5);
        assertArrayEquals(array, new int[]{1, 2, 3, 4, 5, -13, 7, 8, 9, 10});
    }

    @Test
    void testBubbleSortSwapped() {
        int[] array = {4, 3, 1, 2};

        assertFalse(SortLevel.BubbleSortStep(array));
        assertEquals(4, array[array.length - 1]);
        assertFalse(SortLevel.BubbleSortStep(array));
    }

    @Test
    void testBubbleSortNotSwapped() {
        int[] array = {1, 2, 3, 4, 5};
        assertTrue(SortLevel.BubbleSortStep(array));
    }

}
