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

    @Test
    void testArrayChunk() {
        int[] array1 = {7, 5, 6, 4, 3, 1, 2};
        assertEquals(3, SortLevel.ArrayChunk(array1));
        assertArrayEquals(new int[]{2, 1, 3, 4, 6, 5, 7}, array1);

        int[] array2 = {4, 3, 1, 2};
        assertEquals(0, SortLevel.ArrayChunk(array2));
        assertArrayEquals(new int[]{1, 3, 4, 2}, array2);

        int[] arrayEmpty = new int[]{};
        assertEquals(0, SortLevel.ArrayChunk(arrayEmpty));
        assertArrayEquals(new int[]{}, arrayEmpty);

        int[] array3 = {6, 5, 7};
        assertEquals(1, SortLevel.ArrayChunk(array3));
        assertArrayEquals(new int[]{5, 6, 7}, array3);
    }
}
