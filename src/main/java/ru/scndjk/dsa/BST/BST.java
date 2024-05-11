
class BSTNode<T> {
    public int NodeKey;
    public T NodeValue;
    public BSTNode<T> Parent;
    public BSTNode<T> LeftChild;
    public BSTNode<T> RightChild;

    public BSTNode(int key, T val, BSTNode<T> parent) {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BSTFind<T> {
    public BSTNode<T> Node;

    public boolean NodeHasKey;

    public boolean ToLeft;

    public BSTFind() {
        Node = null;
    }

    public BSTFind(BSTNode<T> node, boolean hasKey, boolean toLeft) {
        Node = node;
        NodeHasKey = hasKey;
        ToLeft = toLeft;
    }
}

class BST<T> {
    BSTNode<T> Root;

    public BST(BSTNode<T> node) {
        Root = node;
    }


    public BSTFind<T> FindNodeByKey(int key) {
        return FindNodeRecursive(key, Root, null);
    }

    private BSTFind<T> FindNodeRecursive(int key, BSTNode<T> currentNode, BSTNode<T> parent) {
        if (currentNode == null) {
            return new BSTFind<>(parent, false, parent != null && key < parent.NodeKey);
        }

        if (key == currentNode.NodeKey) {
            return new BSTFind<>(currentNode, true, false);
        }

        if (key > currentNode.NodeKey) {
            return FindNodeRecursive(key, currentNode.RightChild, currentNode);
        }

        return FindNodeRecursive(key, currentNode.LeftChild, currentNode);
    }

    public boolean AddKeyValue(int key, T val) {
        if (Root == null) {
            Root = new BSTNode<>(key, val, null);
            return true;
        }

        BSTNode<T> currentNode = Root;
        BSTNode<T> parent = null;

        while (currentNode != null) {
            parent = currentNode;

            if (key == currentNode.NodeKey) {
                return false;
            }

            if (key > currentNode.NodeKey) {
                currentNode = currentNode.RightChild;
            } else {
                currentNode = currentNode.LeftChild;
            }
        }

        BSTNode<T> newNode = new BSTNode<>(key, val, parent);

        if (key > parent.NodeKey) {
            parent.RightChild = newNode;
        } else {
            parent.LeftChild = newNode;
        }

        return true;
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
        if (FromNode == null) {
            return null;
        }

        BSTNode<T> current = FromNode;

        while (FindMax ? current.RightChild != null : current.LeftChild != null) {
            current = FindMax ? current.RightChild : current.LeftChild;
        }

        return current;
    }

    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> foundNode = FindNodeByKey(key);

        if (!foundNode.NodeHasKey) {
            return false;
        }

        BSTNode<T> nodeToDelete = foundNode.Node;
        BSTNode<T> parent = nodeToDelete.Parent;

        if (nodeToDelete.LeftChild == null && nodeToDelete.RightChild == null) {
            handleLeafNodeDeletion(nodeToDelete, parent);
        } else if (nodeToDelete.LeftChild != null && nodeToDelete.RightChild != null) {
            handleTwoChildrenDeletion(nodeToDelete);
        } else {
            handleOneChildDeletion(nodeToDelete, parent);
        }

        return true;
    }

    private void handleLeafNodeDeletion(BSTNode<T> nodeToDelete, BSTNode<T> parent) {
        if (parent == null) {
            Root = null;
        } else if (parent.LeftChild == nodeToDelete) {
            parent.LeftChild = null;
        } else {
            parent.RightChild = null;
        }
    }

    private void handleTwoChildrenDeletion(BSTNode<T> nodeToDelete) {
        BSTNode<T> successor = FinMinMax(nodeToDelete.RightChild, false);
        nodeToDelete.NodeKey = successor.NodeKey;
        nodeToDelete.NodeValue = successor.NodeValue;

        BSTNode<T> successorParent = successor.Parent;
        if (successor.RightChild == null) {
            handleLeafNodeDeletion(successor, successorParent);
        } else {
            handleOneChildDeletion(successor, successorParent);
        }
    }

    private void handleOneChildDeletion(BSTNode<T> nodeToDelete, BSTNode<T> parent) {
        BSTNode<T> child = nodeToDelete.LeftChild != null ? nodeToDelete.LeftChild : nodeToDelete.RightChild;

        if (parent == null) {
            Root = child;
        } else if (parent.LeftChild == nodeToDelete) {
            parent.LeftChild = child;
        } else {
            parent.RightChild = child;
        }

        child.Parent = parent;
    }

    public int Count() {
        return CountRecursive(Root);
    }

    private int CountRecursive(BSTNode<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + CountRecursive(node.LeftChild) + CountRecursive(node.RightChild);
    }
}

