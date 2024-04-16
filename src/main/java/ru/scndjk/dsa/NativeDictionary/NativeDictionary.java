package ru.scndjk.dsa.NativeDictionary;

import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;

    @SuppressWarnings("unchecked")
    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        int hashCode = key.hashCode();

        return Math.abs(hashCode) % size;
    }

    public boolean isKey(String key) {
        int hashIndex = hashFun(key);

        return slots[hashIndex] != null && slots[hashIndex].equals(key);
    }

    public void put(String key, T value) {
        int hashIndex = hashFun(key);

        slots[hashIndex] = key;
        values[hashIndex] = value;
    }

    public T get(String key) {
        int hashIndex = hashFun(key);
        return values[hashIndex];
    }
}

