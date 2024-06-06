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

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
