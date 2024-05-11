package ru.scndjk.dsa.BST;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {
    @Test
    void FindNodeByKey_EmptyTree_ReturnsNullAndFalse() {
        BST<Integer> bst = new BST<>(null);
        BSTFind<Integer> result = bst.FindNodeByKey(5);

        assertNull(result.Node);
        assertFalse(result.NodeHasKey);
    }

    @Test
    void FindNodeByKey_ExistingKey_ReturnsNodeAndTrue() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 10, null));
        bst.AddKeyValue(3, 6);
        bst.AddKeyValue(7, 14);

        BSTFind<Integer> result = bst.FindNodeByKey(3);

        assertNotNull(result.Node);
        assertTrue(result.NodeHasKey);
        assertEquals(3, result.Node.NodeKey);
        assertEquals(6, result.Node.NodeValue);
    }

    @Test
    void FindNodeByKey_NonExistingKey_ReturnsNullAndFalse() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 10, null));
        bst.AddKeyValue(3, 6);
        bst.AddKeyValue(7, 14);

        BSTFind<Integer> result = bst.FindNodeByKey(4);

        assertNull(result.Node);
        assertFalse(result.NodeHasKey);
    }

    @Test
    void AddKeyValue_EmptyTree_AddsRoot() {
        BST<Integer> bst = new BST<>(null);
        boolean result = bst.AddKeyValue(5, 10);

        assertTrue(result);
        assertNotNull(bst.Root);
        assertEquals(5, bst.Root.NodeKey);
        assertEquals(10, bst.Root.NodeValue);
    }

    @Test
    void AddKeyValue_ExistingKey_ReturnsFalse() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 10, null));
        boolean result = bst.AddKeyValue(5, 15);

        assertFalse(result);
    }

    @Test
    void AddKeyValue_NewKey_AddsNode() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 10, null));
        boolean result = bst.AddKeyValue(3, 6);

        assertTrue(result);
        assertNotNull(bst.Root.LeftChild);
        assertEquals(3, bst.Root.LeftChild.NodeKey);
        assertEquals(6, bst.Root.LeftChild.NodeValue);
    }

    @Test
    void FindMinMax_EmptyTree_ReturnsNull() {
        BST<Integer> bst = new BST<>(null);

        assertNull(bst.FinMinMax(null, true));
        assertNull(bst.FinMinMax(null, false));
    }

    @Test
    void FindMinMax_NonEmptyTree_ReturnsMinMax() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 10, null));
        bst.AddKeyValue(3, 6);
        bst.AddKeyValue(7, 14);
        bst.AddKeyValue(1, 2);
        bst.AddKeyValue(4, 8);

        BSTNode<Integer> minNode = bst.FinMinMax(bst.Root, false);
        BSTNode<Integer> maxNode = bst.FinMinMax(bst.Root, true);

        assertEquals(1, minNode.NodeKey);
        assertEquals(2, minNode.NodeValue);
        assertEquals(7, maxNode.NodeKey);
        assertEquals(14, maxNode.NodeValue);
    }

    @Test
    void DeleteNodeByKey_EmptyTree_ReturnsFalse() {
        BST<Integer> bst = new BST<>(null);
        boolean result = bst.DeleteNodeByKey(5);

        assertFalse(result);
    }

    @Test
    void DeleteNodeByKey_NonExistingKey_ReturnsFalse() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 10, null));
        boolean result = bst.DeleteNodeByKey(10);

        assertFalse(result);
    }

    @Test
    void DeleteNodeByKey_LeafNode_DeletesNode() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 10, null));
        bst.AddKeyValue(3, 6);
        bst.AddKeyValue(7, 14);

        boolean result = bst.DeleteNodeByKey(3);

        assertTrue(result);
        assertNull(bst.Root.LeftChild);
    }

    @Test
    void DeleteNodeByKey_NodeWithOneChild_DeletesNode() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 10, null));
        bst.AddKeyValue(3, 6);
        bst.AddKeyValue(7, 14);
        bst.AddKeyValue(4, 8);

        boolean result = bst.DeleteNodeByKey(3);

        assertTrue(result);
        assertNotNull(bst.Root.LeftChild);
        assertEquals(4, bst.Root.LeftChild.NodeKey);
        assertEquals(8, bst.Root.LeftChild.NodeValue);
    }

    @Test
    void DeleteNodeByKey_NodeWithTwoChildren_DeletesNode() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 10, null));
        bst.AddKeyValue(3, 6);
        bst.AddKeyValue(7, 14);
        bst.AddKeyValue(2, 4);
        bst.AddKeyValue(4, 8);

        boolean result = bst.DeleteNodeByKey(3);

        assertTrue(result);
        assertNotNull(bst.Root.LeftChild);
        assertEquals(4, bst.Root.LeftChild.NodeKey);
        assertEquals(8, bst.Root.LeftChild.NodeValue);
        assertNotNull(bst.Root.LeftChild.LeftChild);
        assertEquals(2, bst.Root.LeftChild.LeftChild.NodeKey);
        assertEquals(4, bst.Root.LeftChild.LeftChild.NodeValue);
    }

    @Test
    void Count_EmptyTree_ReturnsZero() {
        BST<Integer> bst = new BST<>(null);
        int count = bst.Count();

        assertEquals(0, count);
    }

    @Test
    void Count_NonEmptyTree_ReturnsCorrectCount() {
        BST<Integer> bst = new BST<>(new BSTNode<>(5, 10, null));
        bst.AddKeyValue(3, 6);
        bst.AddKeyValue(7, 14);
        bst.AddKeyValue(2, 4);
        bst.AddKeyValue(4, 8);

        int count = bst.Count();

        assertEquals(5, count);
    }
}
