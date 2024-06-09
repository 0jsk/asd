package ru.scndjk.dsa.Sorting;

import java.util.ArrayList;
import java.util.Collections;

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

        final int length = right + left;

        while (true) {
            int pivotIndex = length / 2;
            int N = M[pivotIndex];
            int i1 = left;
            int i2 = right - 1;

            while (true) {
                while (M[i1] < N) {
                    i1++;
                }

                while (M[i2] > N) {
                    i2--;
                }

                if (i1 == i2 - 1 && M[i1] > M[i2]) {
                    swap(M, i1, i2);
                    break;
                }

                if (i1 == i2 || (i1 == i2 - 1 && M[i1] < M[i2])) {
                    return pivotIndex;
                }

                swap(M, i1, i2);

                if (M[i1] == N) {
                    pivotIndex = i1;
                }

                if (M[i2] == N) {
                    pivotIndex = i2;
                }
            }
        }
    }

    public static int ArrayChunk(int[] M) {
        return partition(M, 0, M.length);
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


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
