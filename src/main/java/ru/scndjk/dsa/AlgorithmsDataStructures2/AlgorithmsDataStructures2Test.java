package ru.scndjk.dsa.AlgorithmsDataStructures2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmsDataStructures2Test {

    @Test
    void test_EmptyArray() {
        assertNull(AlgorithmsDataStructures2.GenerateBBSTArray(null));
        assertNull(AlgorithmsDataStructures2.GenerateBBSTArray(new int[0]));
    }

    @Test
    void test_ArrayWithOneElement() {
        int[] a = new int[]{1};
        int[] b = AlgorithmsDataStructures2.GenerateBBSTArray(a);
        assertArrayEquals(a, b);
    }

    @Test
    void test_ArrayWithElements() {
        int[] a = new int[]{1, 2, 3};
        int[] aResult = AlgorithmsDataStructures2.GenerateBBSTArray(a);
        int[] aExpected = new int[]{2, 1, 3};

        assertArrayEquals(aExpected, aResult);

        int[] b = new int[]{-10, -3, 0, 5, 9, 1, 4};
        int[] bResult = AlgorithmsDataStructures2.GenerateBBSTArray(b);
        int[] bExpected = new int[]{1, -3, 5, -10, 0, 4, 9};

        assertArrayEquals(bExpected, bResult);
    }
}
