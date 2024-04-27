package ru.scndjk.dsa.Recursion;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecursionTasksTest {
    @Test
    void testPower() {
        assertEquals(8, RecursionTasks.power(2, 3));
        assertEquals(16, RecursionTasks.power(2, 4));
        assertEquals(64, RecursionTasks.power(2, 6));
    }

    @Test
    void testSumDigits() {
        assertEquals(0, RecursionTasks.sumDigits(0));
        assertEquals(1, RecursionTasks.sumDigits(1));
        assertEquals(15, RecursionTasks.sumDigits(12345));
        assertEquals(1, RecursionTasks.sumDigits(10));
    }

    @Test
    void testLengthOfList() {
        assertEquals(0, RecursionTasks.lengthOfList(new ArrayList<>()));
        assertEquals(1, RecursionTasks.lengthOfList(new ArrayList<>(Arrays.asList(1))));
        assertEquals(2, RecursionTasks.lengthOfList(new ArrayList<>(Arrays.asList(1, 2))));
        assertEquals(3, RecursionTasks.lengthOfList(new ArrayList<>(Arrays.asList(1, 2, 3))));
    }

    @Test
    void testPalindrome() {
        assertTrue(RecursionTasks.isPalindrome(""));
        assertTrue(RecursionTasks.isPalindrome("a"));
        assertTrue(RecursionTasks.isPalindrome("aba"));
        assertTrue(RecursionTasks.isPalindrome("abba"));

        assertFalse(RecursionTasks.isPalindrome("ab"));
        assertFalse(RecursionTasks.isPalindrome("42"));
    }

    @Test
    void testPrintEvenNumbers() {
        RecursionTasks.printEvenNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        // 2 4 6 8 10

        RecursionTasks.printEvenNumbers(Arrays.asList(1, 3, 5));
        // nothing
    }

    @Test
    void testPrintedEvenIndexedNumbers() {

        RecursionTasks.printEvenIndexesElements(Arrays.asList(1, 2, 3, 4, 5));
        // 1 3 5

        RecursionTasks.printEvenIndexesElements(Arrays.asList(1, 3, 5));
        // 1 5

        RecursionTasks.printEvenIndexesElements(List.of(1));
        // 1
    }

    @Test
    void testSecondMax() {
        assertEquals(1, RecursionTasks.secondMax(Arrays.asList(1, 2)));
        assertEquals(2, RecursionTasks.secondMax(Arrays.asList(3, 2)));
        assertEquals(3, RecursionTasks.secondMax(Arrays.asList(3, 3)));
        assertEquals(2, RecursionTasks.secondMax(Arrays.asList(1, 2, 3)));
        assertEquals(2, RecursionTasks.secondMax(Arrays.asList(1, 3, 2)));
        assertEquals(3, RecursionTasks.secondMax(Arrays.asList(1, 2, 3, 3)));
    }

    @Test
    void testGenerateParentheses() {
        assertEquals(Arrays.asList("()"), RecursionTasks.generateParentheses(1));
        assertEquals(Arrays.asList("(())", "()()"), RecursionTasks.generateParentheses(2));
        assertEquals(
            Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"),
            RecursionTasks.generateParentheses(3)
        );
    }

    @Test
    void testFindFiles() throws IOException {
        List<String> files = RecursionTasks.findFiles("src/main/java/ru/scndjk/dsa/Recursion/testFolder");

        for (String file : files) {
            System.out.println(file);
        }
    }
}
