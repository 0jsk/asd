package ru.scndjk.dsa.Sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortLevel {
    public static void SelectionSortStep(int[] array, int i) {
        int minIndex = i;
        int min = array[minIndex];

        for (int j = i + 1; j < array.length; j += 1) {
            if (array[j] < min) {
                minIndex = j;
                min = array[minIndex];
            }
        }

        swap(array, i, minIndex);
    }

    public static boolean BubbleSortStep(int[] array) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1; i += 1) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
                isSorted = false;
            }
        }
        return isSorted;
    }

    public static void InsertionSortStep(int[] array, int step, int startIndex) {
        if (step < 0 || startIndex < 0 || startIndex >= array.length) {
            return;
        }

        for (int i = startIndex; i < array.length; i += step) {
            int currentValue = array[i];
            int j = i - step;

            while (j >= startIndex && array[j] > currentValue) {
                array[j + step] = array[j];
                j -= step;
            }

            array[j + step] = currentValue;
        }
    }

    public static ArrayList<Integer> KnuthSequence(int size) {
        ArrayList<Integer> sequence = new ArrayList<>();
        int step = 1;

        while (step <= size) {
            sequence.add(step);
            step = 3 * step + 1;
        }

        Collections.reverse(sequence);
        return sequence;
    }


    public static int partition(int[] M, int left, int right) {
        if (M.length == 0) {
            return 0;
        }

        int pivotIndex = left + (right - left) / 2;
        int pivot = M[pivotIndex];
        int i1 = left;
        int i2 = right;

        while (i1 <= i2) {
            while (i1 < right && M[i1] < pivot) {
                i1 += 1;
            }

            while (i2 > left && M[i2] > pivot) {
                i2 -= 1;
            }

            if (i1 > i2) {
                break;
            }

            swap(M, i1, i2);

            if (i1 == pivotIndex) {
                pivotIndex = i2;
            } else if (i2 == pivotIndex) {
                pivotIndex = i1;
            }

            i1 += 1;
            i2 -= 1;
        }

        return pivotIndex;

    }

    public static int ArrayChunk(int[] M) {
        return partition(M, 0, M.length - 1);
    }

    public static int ArrayChunk(int[] M, int left, int right) {
        return partition(M, left, right);
    }

    public static void QuickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = ArrayChunk(array, left, right);
        QuickSort(array, left, pivotIndex - 1);
        QuickSort(array, pivotIndex + 1, right);
    }

    public static void QuickSortTailOptimization(int[] array, int left, int right) {
        while (left < right) {
            int pivotIndex = ArrayChunk(array, left, right);

            if (pivotIndex - left < right - pivotIndex) {
                QuickSortTailOptimization(array, left, pivotIndex - 1);
                left = pivotIndex + 1;
            } else {
                QuickSortTailOptimization(array, pivotIndex + 1, right);
                right = pivotIndex - 1;
            }
        }
    }

    public static ArrayList<Integer> KthOrderStatisticsStep(int[] array, int L, int R, int k) {
        int pivotIndex = partition(array, L, R);

        if (pivotIndex == k) {
            return new ArrayList<>(Arrays.asList(pivotIndex, pivotIndex));
        }

        if (pivotIndex < k) {
            return new ArrayList<>(Arrays.asList(pivotIndex + 1, R));
        }

        return new ArrayList<>(Arrays.asList(L, pivotIndex - 1));
    }

    public static ArrayList<Integer> MergeSort(ArrayList<Integer> array) {
        if (array.size() <= 1) {
            return array;
        }

        int middle = array.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(array.subList(0, middle));
        ArrayList<Integer> right = new ArrayList<>(array.subList(middle, array.size()));

        left = MergeSort(left);
        right = MergeSort(right);

        return merge(left, right);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                result.add(left.get(leftIndex));
                leftIndex += 1;
            } else {
                result.add(right.get(rightIndex));
                rightIndex += 1;
            }
        }

        while (leftIndex < left.size()) {
            result.add(left.get(leftIndex));
            leftIndex += 1;
        }

        while (rightIndex < right.size()) {
            result.add(right.get(rightIndex));
            rightIndex += 1;
        }

        return result;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    void testBinarySearchStepElementFound() {
        int[] arr = {1, 3, 5, 7, 9};

        BinarySearch bs = new BinarySearch(arr);
        bs.Step(5);
        assertEquals(1, bs.GetResult());
    }

    @Test
    void testBinarySearchStepElementNotFound() {
        int[] arr = {1, 3, 5, 7, 9};

        BinarySearch bs = new BinarySearch(arr);
        bs.Step(4);
        bs.Step(4);
        bs.Step(4);
        assertEquals(-1, bs.GetResult());
    }

    @Test
    void testBinarySearchStepSearchContinues() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};

        BinarySearch bs = new BinarySearch(arr);
        bs.Step(13);
        assertEquals(0, bs.GetResult());
        assertTrue(bs.Left < bs.Right);
    }

    @Test
    void testBinarySearchEmptyArray() {
        int[] arr = {};

        BinarySearch bs = new BinarySearch(arr);
        bs.Step(1);
        assertEquals(-1, bs.GetResult());
    }
}
