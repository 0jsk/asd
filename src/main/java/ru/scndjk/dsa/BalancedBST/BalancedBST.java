package ru.scndjk.dsa.BalancedBST;

import java.util.*;

class BSTNode {
    public int NodeKey;
    public BSTNode Parent;
    public BSTNode LeftChild;
    public BSTNode RightChild;
    public int Level;

    public BSTNode(int key, BSTNode parent) {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST {
    public BSTNode Root;

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a) {
        Arrays.sort(a);

        Root = BuildBalancedTree(a, 0, a.length - 1, null);
    }

    public boolean IsBalanced(BSTNode rootNode) {
        if (rootNode == null) {
            return false;
        }

        return getHeight(rootNode) != -1;
    }

    private BSTNode BuildBalancedTree(int[] a, int start, int end, BSTNode parent) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        BSTNode node = new BSTNode(a[mid], parent);

        if (parent == null) {
            node.Level = 0;
        } else {
            node.Level = parent.Level + 1;
        }

        node.LeftChild = BuildBalancedTree(a, start, mid - 1, node);
        node.RightChild = BuildBalancedTree(a, mid + 1, end, node);

        return node;
    }

    private int getHeight(BSTNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.LeftChild);
        int rightHeight = getHeight(node.RightChild);

        int margin = Math.abs(leftHeight - rightHeight);

        if (margin <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        }

        return -1;
    }
}
