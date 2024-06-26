package ru.scndjk.dsa.SimpleTree;

import java.util.*;

class SimpleTreeNode<T> {
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null
    public int Level;

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = null;
        Level = parent == null ? 0 : parent.Level + 1;
    }
}

public class SimpleTree<T> {
    public SimpleTreeNode<T> Root;

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        if (ParentNode.Children == null) {
            ParentNode.Children = new ArrayList<>();
        }

        ParentNode.Children.add(NewChild);

        NewChild.Parent = ParentNode;
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        if (NodeToDelete == Root) {
            return;
        }

        final SimpleTreeNode<T> parentNode = NodeToDelete.Parent;

        if (parentNode != null && parentNode.Children != null) {
            parentNode.Children.remove(NodeToDelete);
        }
    }

    public List<SimpleTreeNode<T>> GetAllNodes() {
        final List<SimpleTreeNode<T>> nodes = new ArrayList<>();

        if (Root == null) {
            return nodes;
        }

        nodes.add(Root);

        if (Root.Children == null) {
            return nodes;
        }

        for (SimpleTreeNode<T> node : Root.Children) {
            nodes.add(node);

            if (node.Children != null) {
                nodes.addAll(GetAllNodesFromChildren(node.Children));
            }
        }

        return nodes;
    }

    private List<SimpleTreeNode<T>> GetAllNodesFromChildren(List<SimpleTreeNode<T>> children) {
        final List<SimpleTreeNode<T>> nodes = new ArrayList<>();

        for (SimpleTreeNode<T> node : children) {
            nodes.add(node);

            if (node.Children != null) {
                nodes.addAll(GetAllNodesFromChildren(node.Children));
            }
        }

        return nodes;
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        final List<SimpleTreeNode<T>> allNodes = GetAllNodes();

        return allNodes.stream().filter(node -> node.NodeValue.equals(val)).toList();
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        OriginalNode.Parent.Children.remove(OriginalNode);

        AddChild(NewParent, OriginalNode);
    }

    public int Count() {
        return GetAllNodes().size();
    }

    public int LeafCount() {
        return countLeavesRecursively(Root);
    }

    private int countLeavesRecursively(SimpleTreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        if (node.Children == null || node.Children.isEmpty()) {
            return 1;
        }

        int count = 0;

        for (SimpleTreeNode<T> child : node.Children) {
            count += countLeavesRecursively(child);
        }

        return count;
    }

    public void SetLevels() {
        setLevelsRecursively(Root, 0);
    }

    private void setLevelsRecursively(SimpleTreeNode<T> node, int level) {
        if (node == null) {
            return;
        }

        node.Level = level;

        if (node.Children == null) {
            return;
        }

        for (SimpleTreeNode<T> child : node.Children) {
            setLevelsRecursively(child, level + 1);
        }
    }

    public ArrayList<T> EvenTrees() {
        ArrayList<T> result = new ArrayList<>();
        removeEdgesForEvenTrees(Root, result);
        return result;
    }

    private int removeEdgesForEvenTrees(SimpleTreeNode<T> node, ArrayList<T> result) {
        if (node == null) {
            return 0;
        }

        int nodeCount = 1;

        if (node.Children != null) {
            for (SimpleTreeNode<T> child : node.Children) {
                int childCount = removeEdgesForEvenTrees(child, result);

                if (childCount % 2 == 0) {
                    result.add(node.NodeValue);
                    result.add(child.NodeValue);
                }

                nodeCount += childCount;
            }
        }

        return nodeCount;
    }
}

