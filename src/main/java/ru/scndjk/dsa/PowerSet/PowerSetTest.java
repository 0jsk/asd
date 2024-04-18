package ru.scndjk.dsa.PowerSet;

import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class PowerSetTest {
    private PowerSet powerSet;

    @BeforeEach
    void setUp() {
        powerSet = new PowerSet();
    }

    @Test
    @DisplayName("should create an empty power set")
    void testEmptyPowerSet() {
        PowerSet powerSet = new PowerSet();
        assertEquals(0, powerSet.size());
    }

    @Test
    @DisplayName("should add elements to the power set")
    void testAddElements() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("a");
        powerSet.put("b");
        assertEquals(2, powerSet.size());
        assertTrue(powerSet.get("a"));
        assertTrue(powerSet.get("b"));
    }

    @Test
    @DisplayName("should perform set operations")
    void testSetOperations() {
        PowerSet powerSet1 = new PowerSet();
        powerSet1.put("a");
        powerSet1.put("b");

        PowerSet powerSet2 = new PowerSet();
        powerSet2.put("b");
        powerSet2.put("c");

        PowerSet intersection = powerSet1.intersection(powerSet2);
        assertEquals(1, intersection.size());
        assertTrue(intersection.get("b"));

        PowerSet union = powerSet1.union(powerSet2);
        assertEquals(3, union.size());
        assertTrue(union.get("a"));
        assertTrue(union.get("b"));
        assertTrue(union.get("c"));

        PowerSet difference = powerSet1.difference(powerSet2);
        assertEquals(1, difference.size());
        assertTrue(difference.get("a"));

        PowerSet powerSet3 = new PowerSet();
        powerSet3.put("a");
        powerSet3.put("b");
        powerSet3.put("c");

        assertTrue(powerSet2.isSubset(powerSet3));
        assertTrue(powerSet1.isSubset(powerSet3));

        PowerSet powerSet4 = new PowerSet();
        powerSet4.put("c");

        assertFalse(powerSet3.isSubset(powerSet4));
    }

    @Test
    @DisplayName("should add and remove elements properly")
    void testAddAndRemoveElements() {
        PowerSet powerSet1 = new PowerSet();

        powerSet1.put("a");
        powerSet1.put("b");
        powerSet1.put("c");

        assertEquals(3, powerSet1.size());

        assertTrue(powerSet1.remove("a"));
        assertEquals(2, powerSet1.size());

        assertTrue(powerSet1.remove("b"));
        assertEquals(1, powerSet1.size());

        assertTrue(powerSet1.remove("c"));
        assertEquals(0, powerSet1.size());

        assertFalse(powerSet1.remove("a"));
        assertFalse(powerSet1.remove("dd"));
        assertEquals(0, powerSet1.size());
    }
}
