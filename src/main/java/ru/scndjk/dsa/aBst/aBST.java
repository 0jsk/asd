package ru.scndjk.dsa.aBst;

class aBST {
    public Integer Tree[]; // массив ключей

    public aBST(int depth) {
        int tree_size = (2 << depth) + 1;
        Tree = new Integer[tree_size];
        for (int i = 0; i < tree_size; i++) {
            Tree[i] = null;
        }
    }

    public Integer FindKeyIndex(int key) {
        for (int i = 0; i < Tree.length;) {
            if (Tree[i] == null) {
                return -i;
            }

            if (Tree[i] == key) {
                return i;
            }

            i = Tree[i] > key ? getLeftChildIndex(i) : getRightChildIndex(i);
        }

        return null;
    }

    public int AddKey(int key) {
        int index = findInsertionIndex(key, 0);
        if (index >= 0) {
            Tree[index] = key;
        }
        return index;
    }

    private int findInsertionIndex(int key, int currentIndex) {
        if (currentIndex >= Tree.length) {
            return -1;
        }

        if (Tree[currentIndex] == null) {
            return currentIndex;
        }

        if (key < Tree[currentIndex]) {
            return findInsertionIndex(key, getLeftChildIndex(currentIndex));
        } else if (key > Tree[currentIndex]) {
            return findInsertionIndex(key, getRightChildIndex(currentIndex));
        }

        return currentIndex;
    }

    public boolean isEmpty() {
        return Tree[0] == null;
    }

    private Integer getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private Integer getRightChildIndex(int index) {
        return getLeftChildIndex(index) + 1;
    }
}
