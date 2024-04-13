package ru.scndjk.dsa.HashTable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    @Test
    @DisplayName("should calculate hash index correctly")
    public void testHashFun() {
        HashTable ht = new HashTable(17, 3);
        assertEquals(12, ht.hashFun("hello"));
        assertEquals(15, ht.hashFun("world"));


    }

    @Test
    @DisplayName("should put and find value correctly")
    public void testPutAndFind() {
        HashTable ht = new HashTable(17, 3);
        assertEquals(12, ht.put("hello"));
        assertEquals(15, ht.put("world"));
        assertEquals(12, ht.find("hello"));
        assertEquals(15, ht.find("world"));
    }

    @Test
    @DisplayName("should return -1 when value not found")
    public void testFindNotFound() {
        HashTable ht = new HashTable(17, 3);
        assertEquals(-1, ht.find("not found"));
    }

    @Test
    @DisplayName("should handle collision when putting values")
    public void testPutWithCollision() {
        HashTable ht = new HashTable(17, 3);
        assertEquals(12, ht.put("hello"));
        assertEquals(15, ht.put("world"));
        assertEquals(1, ht.put("hello"));
    }

    @Test
    @DisplayName("should return -1 when putting value in full table")
    public void testPutWhenFull() {
        HashTable ht = new HashTable(3, 1);
        assertEquals(1, ht.put("one"));
        assertEquals(2, ht.put("two"));
        assertEquals(0, ht.put("three"));
        assertEquals(-1, ht.put("four"));
    }

    @Test
    @DisplayName("should find value after collision resolution")
    public void testFindAfterCollisionResolution() {
        HashTable ht = new HashTable(17, 3);
        ht.put("hello");
        ht.put("world");
        ht.put("hello");
        assertEquals(12, ht.find("hello"));
    }

    @Test
    @DisplayName("should return -1 when seeking slot in full table")
    public void testSeekSlotWhenFull() {
        HashTable ht = new HashTable(3, 1);
        ht.put("one");
        ht.put("two");
        ht.put("three");
        assertEquals(-1, ht.seekSlot("four"));
    }

    @Test
    @DisplayName("should return correct slot when seeking free slot")
    public void testSeekFreeSlot() {
        HashTable ht = new HashTable(17, 3);
        ht.put("hello");
        ht.put("world");
        assertEquals(4, ht.seekSlot("new value"));
    }
}
