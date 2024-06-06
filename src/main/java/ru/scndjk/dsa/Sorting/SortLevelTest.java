package ru.scndjk.dsa.Sorting;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

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

    @Test
    void testInsertionSort() {
        int[] array = {1, 6, 5, 4, 3, 2, 7};

        SortLevel.InsertionSortStep(array, 3, 1);

        assertArrayEquals(array, new int[]{1, 3, 5, 4, 6, 2, 7});

        int[] array2 = {5, 3, 8, 1, 2};

        SortLevel.InsertionSortStep(array2, 1, 0);
        assertArrayEquals(array, new int[]{1, 3, 5, 4, 6, 2, 7});
    }

    @Test
    void testKnuthSequence() {
        assertIterableEquals(Arrays.asList(13, 4, 1), SortLevel.KnuthSequence(15));
        assertIterableEquals(List.of(1), SortLevel.KnuthSequence(1));
        assertIterableEquals(Arrays.asList(4, 1), SortLevel.KnuthSequence(5));
    }
}
