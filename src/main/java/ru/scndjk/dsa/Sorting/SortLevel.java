package ru.scndjk.dsa.Sorting;

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

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
