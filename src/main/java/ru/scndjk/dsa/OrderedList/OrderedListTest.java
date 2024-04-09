package ru.scndjk.dsa.OrderedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderedListTest {
    private OrderedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new OrderedList<>(true);
    }

    @Test
    @DisplayName("should find existing element in list")
    void testFind_ExistingElement() {
        list.add(1);
        list.add(5);
        list.add(2);

        assertEquals(list.head, list.find(1));
        assertEquals(list.tail, list.find(5));
    }

    @Test
    @DisplayName("should return null on find not existing element")
    void testFind_NotExistingElement() {
        list.add(0);
        assertNull(list.find(2));
    }

    @Test
    @DisplayName("should return null on find with empty list")
    void testFind_EmptyList() {
        assertNull(list.find(1));
    }

    @Test
    @DisplayName("should remove existing element")
    void testRemove_ExistingElement() {
        list.add(1);
        list.add(2);

        list.delete(1);
        assertEquals(2, list.head.value);
        assertEquals(2, list.tail.value);
    }

    @Test
    @DisplayName("should return false when removing non-existing element")
    void testRemove_NonExistingElement() {
        list.add(1);

        list.delete(2);
        assertEquals(1, list.head.value);
        assertEquals(1, list.tail.value);
    }

    @Test
    @DisplayName("should remove only one element from list")
    void testRemove_OnlyOneElementInList() {
        list.add(1);
        list.add(1);
        list.add(2);

        list.delete(1);
        assertEquals(1, list.head.value);
        assertEquals(2, list.tail.value);
        assertEquals(2, list.count());
    }

    @Test
    @DisplayName("should remove last element from list")
    void testRemove_LastElement() {
        list.add(2);
        list.add(1);

        list.delete(1);
        assertEquals(1, list.count());
        assertEquals(2, list.head.value);
        assertEquals(2, list.tail.value);
    }

    @Test
    @DisplayName("should clear non-empty list")
    void testClear_NonEmptyList() {
        list.add(1);
        list.add(2);

        list.clear(true);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    @DisplayName("should not modify empty list after clearing")
    void testClear_EmptyList() {
        list.clear(true);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    @DisplayName("should count elements in non-empty list")
    void testCount_NonEmptyList() {
        list.add(1);
        list.add(2);

        assertEquals(2, list.count());
    }

    @Test
    @DisplayName("should return zero count for empty list")
    void testCount_EmptyList() {
        assertEquals(0, list.count());
    }

    @Test
    @DisplayName("should insert element after specified node")
    void testInsertAfter_ExistingNode() {
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);

        assertEquals(1, list.head.value);
        assertEquals(4, list.tail.value);
        assertEquals(3, list.find(2).next.value);
        assertEquals(3, list.find(4).prev.value);
    }

    @Test
    @DisplayName("should insert element at the beginning of the list")
    void testInsertAfter_NullNode() {
        list.add(1);
        list.add(0);

        assertEquals(0, list.head.value);
        assertEquals(1, list.tail.value);
    }

    @Test
    @DisplayName("should insert element at the beginning of the list in descending order")
    void testInsertAfter_NullNodeDesc() {
        OrderedList<Integer> list = new OrderedList<>(false);
        list.add(1);
        list.add(0);

        assertEquals(1, list.head.value);
        assertEquals(0, list.tail.value);
    }

    @Test
    @DisplayName("should delete at the end of the list")
    void testAddToEnd() {
        list.add(1);
        list.add(2);

        list.delete(2);

        assertEquals(1, list.head.value);
        assertEquals(1, list.tail.value);
    }

    @Test
    @DisplayName("should delete at the middle of the list")
    void testAddToMiddle() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.delete(2);

        assertEquals(1, list.head.value);
        assertEquals(3, list.tail.value);
    }

    @Test
    @DisplayName("should have all elements in the list")
    void testAllElements() {
        list.add(1);
        list.add(2);
        list.add(3);

        var allElements = list.getAll();

        assertEquals(1, allElements.get(0).value);
        assertEquals(2, allElements.get(1).value);
        assertEquals(3, allElements.get(2).value);
    }

    @Test
    @DisplayName("should properly add elements in descending order")
    void testAddDescending() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(4);
        list.add(5);
        list.add(6);

        assertEquals(1, list.head.value);
        assertEquals(6, list.tail.value);
    }

    @Test
    @DisplayName("should properly compare strings with trimmed spaces")
    void testCompareStrings() {
        OrderedList<String> strList = new OrderedList<>(true);

        strList.add("         c");
        strList.add("a  ");
        strList.add(" b ");

        assertEquals("a", strList.head.value.trim());
        assertEquals("b", strList.head.next.value.trim());
        assertEquals("c", strList.tail.value.trim());

        assertEquals(0, strList.compare("a", "a"));
        assertEquals(1, strList.compare("b", "a"));
        assertEquals(-1, strList.compare("a", "c"));
        assertEquals(0, strList.compare("b", "b"));
        assertEquals(-1, strList.compare("b", "c"));
        assertEquals(0, strList.compare("c", "c"));
    }

    @Test
    @DisplayName("should delete tail properly")
    void testDeleteTail() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.delete(3);

        assertEquals(1, list.head.value);
        assertEquals(2, list.tail.value);
    }
}

