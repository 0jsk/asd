package ru.scndjk.dsa.LinkedList2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedList2Test {
    private LinkedList2 list;

    @BeforeEach
    void setUp() {
        list = new LinkedList2();
    }

    @Test
    @DisplayName("should find existing element in list")
    void testFind_ExistingElement() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        list.addInTail(node1);
        list.addInTail(node2);

        assertEquals(node1, list.find(1));
        assertEquals(node2, list.find(2));
    }

    @Test
    @DisplayName("should return null on find not existing element")
    void testFind_NotExistingElement() {
        Node node = new Node(1);
        list.addInTail(node);
        assertNull(list.find(2));
    }

    @Test
    @DisplayName("should return null on find with empty list")
    void testFind_EmptyList() {
        assertNull(list.find(1));
    }

    @Test
    @DisplayName("should find all existing elements")
    void testFindAll_ExistingElements() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(1);

        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        ArrayList<Node> expected = new ArrayList<>(Arrays.asList(node1, node3));
        assertEquals(expected, list.findAll(1));
    }

    @Test
    @DisplayName("should return empty list when finding non-existing elements")
    void testFindAll_NonExistingElements() {
        Node node = new Node(1);
        list.addInTail(node);
        assertTrue(list.findAll(2).isEmpty());
    }

    @Test
    @DisplayName("should return empty list when finding in empty list")
    void testFindAll_EmptyList() {
        assertTrue(list.findAll(1).isEmpty());
    }

    @Test
    @DisplayName("should remove existing element")
    void testRemove_ExistingElement() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        list.addInTail(node1);
        list.addInTail(node2);

        assertTrue(list.remove(1));
        assertEquals(node2, list.head);
        assertEquals(node2, list.tail);
    }

    @Test
    @DisplayName("should return false when removing non-existing element")
    void testRemove_NonExistingElement() {
        Node node = new Node(1);

        list.addInTail(node);

        assertFalse(list.remove(2));
        assertEquals(node, list.head);
        assertEquals(node, list.tail);
    }

    @Test
    @DisplayName("should return false when removing from empty list")
    void testRemove_EmptyList() {
        assertFalse(list.remove(1));
    }

    @Test
    @DisplayName("should remove single element from list")
    void testRemove_OnlyOneElementInList() {
        Node node = new Node(1);
        list.addInTail(node);

        assertTrue(list.remove(1));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    @DisplayName("should remove last element from list")
    void testRemove_LastElement() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        list.addInTail(node1);
        list.addInTail(node2);

        assertTrue(list.remove(1));
        assertEquals(1, list.count());
        assertEquals(node2, list.head);
        assertEquals(node2, list.tail);
    }

    @Test
    @DisplayName("should remove all elements with specified value")
    void testRemoveAll_ExistingElements() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(1);

        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        list.removeAll(1);
        assertEquals(node2, list.head);
        assertEquals(node2, list.tail);
    }

    @Test
    @DisplayName("should not modify list when removing non-existing elements")
    void testRemoveAll_NonExistingElements() {
        Node node = new Node(1);

        list.addInTail(node);

        list.removeAll(2);
        assertEquals(node, list.head);
        assertEquals(node, list.tail);
    }

    @Test
    @DisplayName("should not modify empty list when removing elements")
    void testRemoveAll_EmptyList() {
        list.removeAll(1);

        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    @DisplayName("should clear non-empty list")
    void testClear_NonEmptyList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        list.addInTail(node1);
        list.addInTail(node2);

        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    @DisplayName("should not modify empty list after clearing")
    void testClear_EmptyList() {
        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    @DisplayName("should count elements in non-empty list")
    void testCount_NonEmptyList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        list.addInTail(node1);
        list.addInTail(node2);

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
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node nodeToInsert = new Node(3);

        list.addInTail(node1);
        list.addInTail(node2);
        list.insertAfter(node1, nodeToInsert);

        assertEquals(node1, list.head);
        assertEquals(node2, list.tail);
        assertEquals(nodeToInsert, node1.next);
        assertEquals(node1, nodeToInsert.prev);
    }

    @Test
    @DisplayName("should insert element at the beginning of the list")
    void testInsertAfter_NullNode() {
        Node nodeToInsert = new Node(1);

        list.insertAfter(null, nodeToInsert);

        assertEquals(nodeToInsert, list.head);
        assertEquals(nodeToInsert, list.tail);
        assertNull(nodeToInsert.prev);
        assertNull(nodeToInsert.next);
    }

    @Test
    @DisplayName("should insert element after the last node")
    void testInsertAfter_LastNode() {
        Node node = new Node(1);
        Node nodeToInsert = new Node(2);

        list.addInTail(node);
        list.insertAfter(node, nodeToInsert);

        assertEquals(node, list.head);
        assertEquals(nodeToInsert, list.tail);
        assertEquals(node, nodeToInsert.prev);
        assertNull(nodeToInsert.next);
    }

    @Test
    @DisplayName("should insert element at the begging of the list with insertFirst")
    void testInsertFirst_ExistingNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node nodeToInsert = new Node(3);

        list.addInTail(node1);
        list.addInTail(node2);
        list.insertFirst(nodeToInsert);

        assertEquals(nodeToInsert, list.head);
        assertEquals(node2, list.tail);
        assertEquals(node2, node1.next);
        assertNull(nodeToInsert.prev);
    }

    @Test
    @DisplayName("should insert head to the empty list")
    void testInsertFirst_EmptyList() {
        Node nodeToInsert = new Node(1);

        list.insertFirst(nodeToInsert);

        assertEquals(nodeToInsert, list.head);
        assertEquals(nodeToInsert, list.tail);
        assertNull(nodeToInsert.next);
        assertNull(nodeToInsert.prev);
    }

}
