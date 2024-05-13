package ru.scndjk.dsa.aBst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class aBSTTest {

    @Test
    void testIsEmpty() {
        aBST tree = new aBST(2);
        assertTrue(tree.isEmpty());

        tree.AddKey(5);
        assertFalse(tree.isEmpty());
    }

    @Test
    void testFindKeyIndex() {
        aBST tree = new aBST(3);
        tree.AddKey(8);
        tree.AddKey(3);
        tree.AddKey(10);
        tree.AddKey(1);
        tree.AddKey(6);
        tree.AddKey(14);
        tree.AddKey(4);

        assertEquals(0, tree.FindKeyIndex(8).intValue());
        assertEquals(1, tree.FindKeyIndex(3).intValue());
        assertEquals(2, tree.FindKeyIndex(10).intValue());
        assertEquals(3, tree.FindKeyIndex(1).intValue());
        assertEquals(4, tree.FindKeyIndex(6).intValue());
        assertEquals(6, tree.FindKeyIndex(14).intValue());
        assertEquals(9, tree.FindKeyIndex(4).intValue());

        assertEquals(-13, tree.FindKeyIndex(12));
        assertEquals(-7, tree.FindKeyIndex(0));
    }

    @Test
    void testAddKey() {
        aBST tree = new aBST(2);

        assertEquals(0, tree.AddKey(5));
        assertEquals(5, tree.Tree[0]);

        assertEquals(1, tree.AddKey(3));
        assertEquals(3, tree.Tree[1]);

        assertEquals(2, tree.AddKey(7));
        assertEquals(7, tree.Tree[2]);

        assertEquals(1, tree.AddKey(3));


    }

    @Test
    void testAddKeyFullTree() {
        aBST tree = new aBST(1);

        assertEquals(0, tree.AddKey(1));
        assertEquals(2, tree.AddKey(2));
        assertEquals(-1, tree.AddKey(3));
    }
}
