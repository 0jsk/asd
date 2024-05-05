package ru.scndjk.dsa.SimpleTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTreeTest {

    private SimpleTree<String> tree;
    private SimpleTreeNode<String> root;

    @BeforeEach
    void setUp() {
        root = new SimpleTreeNode<>("Root", null);
        tree = new SimpleTree<>(root);
    }

    @Test
    void testAddChild_NodeWithNoChildren() {
        SimpleTreeNode<String> child = new SimpleTreeNode<>("Child", null);
        tree.AddChild(root, child);

        assertNotNull(root.Children);
        assertEquals(1, root.Children.size());
        assertEquals(child, root.Children.get(0));
        assertEquals(root, child.Parent);
    }

    @Test
    void testAddChild_NodeWithExistingChildren() {
        SimpleTreeNode<String> child1 = new SimpleTreeNode<>("Child1", null);
        SimpleTreeNode<String> child2 = new SimpleTreeNode<>("Child2", null);
        tree.AddChild(root, child1);
        tree.AddChild(root, child2);

        assertEquals(2, root.Children.size());
        assertTrue(root.Children.contains(child1));
        assertTrue(root.Children.contains(child2));
    }

    @Test
    void testAddChild_NullParentNode() {
        SimpleTreeNode<String> child = new SimpleTreeNode<>("Child", null);

        assertThrows(NullPointerException.class, () -> tree.AddChild(null, child));
    }

    @Test
    void testAddChild_checkChildLevelAfterAdding() {
        SimpleTreeNode<String> child = new SimpleTreeNode<>("Child", null);
        tree.AddChild(root, child);

        assertEquals(0, child.Level);
    }

    @Test
    public void testDeleteNode_RootNode() {
        tree.DeleteNode(root);

        assertSame(root, tree.Root);
    }

    @Test
    public void testDeleteNode_LeafNode() {
        SimpleTreeNode<String> child = new SimpleTreeNode<>("Child", root);
        tree.AddChild(root, child);

        tree.DeleteNode(child);

        assertEquals(0, root.Children.size());
        assertEquals(1, tree.Count());
    }

    @Test
    public void testDeleteNode_NodeWithChildren() {
        SimpleTreeNode<String> child1 = new SimpleTreeNode<>("Child1", root);
        SimpleTreeNode<String> child2 = new SimpleTreeNode<>("Child2", child1);

        tree.AddChild(root, child1);
        tree.AddChild(child1, child2);

        tree.DeleteNode(child1);

        assertEquals(0, root.Children.size());
        assertEquals(1, tree.Count());
    }

    @Test
    public void testDeleteNode_NonExistingNode() {
        SimpleTreeNode<String> child = new SimpleTreeNode<>("Child", root);
        SimpleTreeNode<String> nonExistingNode = new SimpleTreeNode<>("NonExisting", null);

        tree.AddChild(root, child);

        tree.DeleteNode(nonExistingNode);

        assertEquals(2, tree.Count());
    }

    @Test
    public void testGetAllNodes_NotEmptyTree() {
        SimpleTreeNode<String> child1 = new SimpleTreeNode<>("Child1", root);
        SimpleTreeNode<String> child2 = new SimpleTreeNode<>("Child2", root);
        SimpleTreeNode<String> grandchild1 = new SimpleTreeNode<>("Grandchild1", child1);

        tree.AddChild(root, child1);
        tree.AddChild(root, child2);
        tree.AddChild(child1, grandchild1);

        List<SimpleTreeNode<String>> allNodes = tree.GetAllNodes();

        assertEquals("Root", allNodes.get(0).NodeValue);
        assertEquals("Child1", allNodes.get(1).NodeValue);
        assertEquals("Grandchild1", allNodes.get(2).NodeValue);
        assertEquals("Child2", allNodes.get(3).NodeValue);
    }

    @Test
    public void testGetAllNodes_EmptyTree() {
        SimpleTree<String> emptyTree = new SimpleTree<>(null);
        List<SimpleTreeNode<String>> allNodes = emptyTree.GetAllNodes();

        assertTrue(allNodes.isEmpty());
    }
}
