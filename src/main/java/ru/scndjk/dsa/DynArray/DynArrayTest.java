package ru.scndjk.dsa.DynArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;

public class DynArrayTest {
    private DynArray<Integer> dynArray;

    @BeforeEach
    public void setup() {
        dynArray = new DynArray<>(Integer.class);
    }

    @Test
    public void testAppend() {
        for (int i = 0; i < 20; i += 1) {
            dynArray.append(i);
        }

        for (int i = 20; i < 40; i += 1) {
            dynArray.append(i);
        }

        for (int i = 0; i < 40; i += 1) {
            assertEquals(i, dynArray.getItem(i));
        }

        assertEquals(40, dynArray.count);
        assertEquals(64, dynArray.capacity);
    }

    @Test
    public void testInsert() {
        for (int i = 0; i < 16; i += 1) {
            dynArray.append(i);
        }

        dynArray.insert(15, 3);
        for (int i = 0; i < 17; i += 1) {
            if (i == 3) {
                assertEquals(15, dynArray.getItem(i));
            } else {
                assertEquals(i < 3 ? i : i - 1, dynArray.getItem(i));
            }
        }

        dynArray.insert(16, 17);

        assertEquals(18, dynArray.count);
        assertEquals(32, dynArray.capacity);

        for (int i = 18; i <= 33; i += 1) {
            dynArray.insert(i, dynArray.count);
        }

        assertEquals(33, dynArray.count - 1);
        assertEquals(64, dynArray.capacity);

        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.insert(1337, 1337));
        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.insert(1337, -1337));
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < 20; i += 1) {
            dynArray.append(i);
        }

        dynArray.remove(3);
        for (int i = 0; i < 19; i += 1) {
            assertEquals(i < 3 ? i : i + 1, dynArray.getItem(i));
        }

        assertEquals(19, dynArray.count);
        assertEquals(32, dynArray.capacity);

        for (int i = 18; i >= 0; i -= 1) {
            dynArray.remove(i);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.remove(-1337));

        assertEquals(0, dynArray.count);
        assertEquals(16, dynArray.capacity);
    }

    @Test
    public void testGetItem() {
        for (int i = 0; i < 10; i += 1) {
            dynArray.append(i);
        }

        for (int i = 0; i < 10; i += 1) {
            assertEquals(i, dynArray.getItem(i));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.getItem(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.getItem(11));
    }
}
