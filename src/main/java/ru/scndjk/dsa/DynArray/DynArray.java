package ru.scndjk.dsa.DynArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    private final int MIN_CAPACITY = 16;
    private final double GROWTH_FACTOR = 2.0;
    private final double SHRINK_FACTOR = 1.5;

    public DynArray(Class clz) {
        clazz = clz;
        count = 0;
        makeArray(MIN_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public void makeArray(int new_capacity) {
        T[] temp = array;

        capacity = Math.max(new_capacity, MIN_CAPACITY);
        array = (T[]) Array.newInstance(this.clazz, capacity);

        if (temp != null && array.length > 0) {
            System.arraycopy(temp, 0, array, 0, Math.min(temp.length, capacity));
        }
    }

    public T getItem(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return array[index];
    }

    public void append(T itm) {
        if (count == capacity) {
            int newCapacity = (int) (capacity * GROWTH_FACTOR);
            makeArray(newCapacity);
        }

        array[count] = itm;
        count += 1;
    }

    public void insert(T itm, int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (count + 1 > capacity) {
            int newCapacity = (int) (capacity * GROWTH_FACTOR);
            makeArray(newCapacity);
        }

        T[] temp = Arrays.copyOfRange(array, index, count);
        array[index] = itm;
        count += 1;

        System.arraycopy(temp, 0, array, index + 1, count - index - 1);
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        T[] temp = Arrays.copyOfRange(array, index + 1, count);
        count -= 1;
        System.arraycopy(temp, 0, array, index, count - index);

        if (count - 1 < capacity / 2 && capacity > MIN_CAPACITY) {
            int newCapacity = (int) (capacity / SHRINK_FACTOR);
            makeArray(newCapacity);
        }
    }
}

