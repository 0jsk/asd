package ru.scndjk.dsa.AlgorithmsDataStructures2;

import java.util.*;

public class AlgorithmsDataStructures2 {
    public static int[] GenerateBBSTArray(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        int[] aSorted = a.clone();
        Arrays.sort(aSorted);

        int[] bbstArray = new int[a.length];

        generateBBSTArray(aSorted, bbstArray, 0, 0, a.length - 1);

        return bbstArray;
    }

    private static void generateBBSTArray(int[] sorted, int[] bst, int index, int start, int end) {
        if (start > end || index > bst.length - 1) {
            return;
        }

        int min = start + (end - start) / 2;
        bst[index] = sorted[min];

        generateBBSTArray(sorted, bst, 2 * index + 1, start, min - 1);
        generateBBSTArray(sorted, bst, 2 * index + 2, min + 1, end);
    }
}
