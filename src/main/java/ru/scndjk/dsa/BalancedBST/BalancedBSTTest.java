package ru.scndjk.dsa.BalancedBST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedBSTTest {
    private BalancedBST tree;

    @BeforeEach
    void init() {
        tree = new BalancedBST();
    }

    @Test
    void test_GenerateTreeEmptyArray() {
        tree.GenerateTree(new int[]{});
        assertNull(tree.Root);
    }

    @Test
    void test_GenerateSingleElement() {
        tree.GenerateTree(new int[]{1});
        assertNotNull(tree.Root);
        assertEquals(1, tree.Root.NodeKey);
        assertNull(tree.Root.LeftChild);
        assertNull(tree.Root.RightChild);
        assertEquals(0, tree.Root.Level);
    }

    @Test
    void testGenerateTreeMultipleElements() {
        BalancedBST tree = new BalancedBST();
        tree.GenerateTree(new int[]{1, 2, 3, 4, 5});

        assertNotNull(tree.Root);
        assertEquals(3, tree.Root.NodeKey);
        assertEquals(0, tree.Root.Level);

        assertEquals(1, tree.Root.LeftChild.NodeKey);
        assertEquals(4, tree.Root.RightChild.NodeKey);
        assertEquals(1, tree.Root.LeftChild.Level);
        assertEquals(1, tree.Root.RightChild.Level);

        assertEquals(1, tree.Root.LeftChild.Level);
        assertEquals(1, tree.Root.RightChild.Level);

        assertEquals(2, tree.Root.LeftChild.RightChild.NodeKey);
        assertEquals(5, tree.Root.RightChild.RightChild.NodeKey);

        assertEquals(2, tree.Root.LeftChild.RightChild.Level);
        assertEquals(2, tree.Root.RightChild.RightChild.Level);

        assertNull(tree.Root.LeftChild.LeftChild);
        assertNull(tree.Root.RightChild.LeftChild);
    }

    @Test
    void test_isBalancedNullTree() {
        assertTrue(tree.IsBalanced(null));
    }

    @Test
    void test_isBalancedUnbalancedTree() {
        tree.Root = new BSTNode(2, null);
        tree.Root.LeftChild = new BSTNode(999, tree.Root);
        tree.Root.RightChild = new BSTNode(3, tree.Root);

        assertFalse(tree.IsBalanced(tree.Root));
    }

    @Test
    void test_isBalancedBalancedTree() {
        tree.Root = new BSTNode(2, null);
        tree.Root.LeftChild = new BSTNode(1, tree.Root);
        tree.Root.RightChild = new BSTNode(3, tree.Root);

        assertTrue(tree.IsBalanced(tree.Root));
    }
}
