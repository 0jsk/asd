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

    @Test
    void testQuickSort() {
        int[] array1 = {5, 4, 3, 2, 1};
        SortLevel.QuickSort(array1, 0, array1.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array1);

        int[] array2 = {1, 2, 3, 4, 5, 6, 7};
        SortLevel.QuickSort(array2, 0, array2.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, array2);

        int[] array3 = {};
        SortLevel.QuickSort(array3, 0, array3.length - 1);
        assertArrayEquals(new int[]{}, array3);

        int[] array4 = {2, -3, 1, 0};
        SortLevel.QuickSort(array4, 0, array4.length - 1);
        assertArrayEquals(new int[]{-3, 0, 1, 2}, array4);
    }

    @Test
    void testHeapSort() {
        int[] inputArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        HeapSort heapSort = new HeapSort(inputArray);
        int[] sortedArray = new int[inputArray.length];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = heapSort.getNextMax();
        }

        int[] expectedArray = {9, 6, 5, 5, 5, 4, 3, 3, 2, 1, 1};
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test
    void testEmptyHeap() {
        int[] inputArray = {};
        HeapSort heapSort = new HeapSort(inputArray);
        assertEquals(-1, heapSort.getNextMax());
    }

    @Test
    void testSingleElementHeap() {
        int[] inputArray = {42};
        HeapSort heapSort = new HeapSort(inputArray);
        assertEquals(42, heapSort.getNextMax());
        assertEquals(-1, heapSort.getNextMax());
    }

    @Test
    void testKSortIndexValidStrings() {
        var sorter  = new ksort();

        assertEquals(0, sorter.index("a00"));
        assertEquals(99, sorter.index("a99"));
        assertEquals(100, sorter.index("b00"));
        assertEquals(799, sorter.index("h99"));
    }

    @Test
    void testKSortIndexInvalidStrings() {
        var sorter  = new ksort();

        assertEquals(-1, sorter.index("i00"));
        assertEquals(-1, sorter.index("a-1"));
        assertEquals(-1, sorter.index("a100"));
        assertEquals(-1, sorter.index("aa0"));
        assertEquals(-1, sorter.index("a0"));
        assertEquals(-1, sorter.index("a000"));
        assertEquals(-1, sorter.index(null));
    }

    @Test
    void testKSortAddValidStrings() {
        var sorter = new ksort();


        assertTrue(sorter.add("a00"));
        assertTrue(sorter.add("h99"));
        assertTrue(sorter.add("d50"));

        assertEquals("a00", sorter.items[0]);
        assertEquals("h99", sorter.items[799]);
        assertEquals("d50", sorter.items[350]);
    }

    @Test
    void testKSortAddInvalidStrings() {
        var sorter = new ksort();

        assertFalse(sorter.add("i00"));
        assertFalse(sorter.add("a-1"));
        assertFalse(sorter.add("a100"));
        assertFalse(sorter.add("aa0"));
        assertFalse(sorter.add("a0"));
        assertFalse(sorter.add("a000"));
        assertFalse(sorter.add(null));
    }

    @Test
    void testKSortSort() {
        var sorter = new ksort();

        sorter.add("b64");
        sorter.add("a01");
        sorter.add("h99");
        sorter.add("c30");
        sorter.add("g00");

        assertEquals("a01", sorter.items[1]);
        assertEquals("b64", sorter.items[164]);
        assertEquals("c30", sorter.items[230]);
        assertEquals("g00", sorter.items[600]);
        assertEquals("h99", sorter.items[799]);

        String[] nonNullItems = java.util.Arrays.stream(sorter.items)
            .filter(java.util.Objects::nonNull)
            .toArray(String[]::new);

        assertArrayEquals(new String[]{"a01", "b64", "c30", "g00", "h99"}, nonNullItems);
    }

    @Test
    void testGallopingSearchElementAtStart() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        assertTrue(BinarySearch.GallopingSearch(arr, 1));
    }

    @Test
    void testGallopingSearchElementAtEnd() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        assertTrue(BinarySearch.GallopingSearch(arr, 15));
    }

    @Test
    void testGallopingSearchElementInMiddle() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        assertTrue(BinarySearch.GallopingSearch(arr, 7));
    }

    @Test
    void testGallopingSearchElementNotPresent() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        assertFalse(BinarySearch.GallopingSearch(arr, 6));
    }

    @Test
    void testGallopingSearchEmptyArray() {
        int[] arr = {};
        assertFalse(BinarySearch.GallopingSearch(arr, 5));
    }
}
