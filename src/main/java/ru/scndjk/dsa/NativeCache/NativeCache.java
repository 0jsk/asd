package ru.scndjk.dsa.NativeCache;

import java.util.Objects;

class NativeCache<T> {
    private final int size;
    private final String[] slots;
    private final T[] values;
    private final int[] hits;

    private final static int DEFAULT_SIZE = 10;

    public NativeCache() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public NativeCache(int size) {
        this.size = size;
        this.slots = new String[size];
        this.values = (T[]) new Object[size];
        this.hits = new int[size];
    }

    public int hashFun(String key) {
        return key.length() % size;
    }

    public boolean isKey(String key) {
        return find(key) != -1;
    }

    public void put(String key, T value) {
        int index = find(key);

        if (index != -1) {
            values[index] = value;
            hits[index]++;

            return;
        }

        index = findEmpty();
        if (index != -1) {
            slots[index] = key;
            values[index] = value;
            hits[index] = 1;

            return;
        }

        index = findLeastHits();
        slots[index] = key;
        values[index] = value;
        hits[index] = 1;
    }

    public T get(String key) {
        int index = find(key);

        if (index != -1) {
            hits[index]++;

            return values[index];
        }

        return null;
    }

    private int find(String key) {
        int index = hashFun(key);

        for (int i = 0; i < size; i++) {
            if (slots[index] != null && slots[index].equals(key)) {
                return index;
            }

            index = (index + 1) % size;
        }

        return -1;
    }

    private int findEmpty() {
        for (int i = 0; i < size; i++) {
            if (slots[i] == null) {
                return i;
            }
        }

        return -1;
    }

    private int findLeastHits() {
        int minHitsIndex = 0;

        for (int i = 1; i < size; i++) {
            if (hits[i] < hits[minHitsIndex]) {
                minHitsIndex = i;
            }
        }

        return minHitsIndex;
    }
}

