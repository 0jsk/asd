package ru.scndjk.dsa.BloomFilter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BloomFilterTest {
    private BloomFilter filter;

    @BeforeEach
    void init() {
        filter = new BloomFilter(32);
    }

    @Test
    @DisplayName("should add string using hash functions and set bits")
    public void testAdd() {
        filter.add("123456");

        assertTrue(filter.isValue("123456"));
    }

    @Test
    public void testAddStrings() {
        List<String> testCases = Arrays.asList("0123456789", "1234567890", "2345678901", "3456789012",
            "4567890123", "5678901234", "6789012345", "7890123456", "8901234567", "9012345678");

        testCases.forEach(filter::add);

        testCases.forEach(str -> Assertions.assertTrue(filter.isValue(str), "Failed test case: " + str));
    }

    @Test
    public void testIsValueStrings() {
        List<String> testCases = Arrays.asList("0123456789", "1234567890", "2345678901", "3456789012",
            "4567890123", "5678901234", "6789012345", "7890123456", "8901234567", "9012345678");

        testCases.forEach(filter::add);
        testCases.forEach(str -> Assertions.assertTrue(filter.isValue(str), "Failed test case: " + str));

        List<String> notAddedTestCases = Arrays.asList("0012345678", "1123456789", "2234567890");

        notAddedTestCases.forEach(str -> Assertions.assertFalse(filter.isValue(str), "Failed test case: " + str));
    }
}
