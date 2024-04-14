package ru.scndjk.dsa.HashTable;

public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        int hash = 0;

        for (char ch : value.toCharArray()) {
            hash += Character.getNumericValue(ch);
        }

        return hash % size;
    }

    public int seekSlot(String value) {
        int index = hashFun(value);

        if (slots[index] == null) {
            return index;
        }

        int currentIndex = index + step >= size ? index + step - size : index + step;

        while (currentIndex != index) {
            if (slots[currentIndex] == null) {
                return currentIndex;
            }

            currentIndex += step;

            if (currentIndex >= size) {
                currentIndex -= size;
            }
        }

        return -1;
    }

    public int put(String value) {
        int index = seekSlot(value);

        if (index != -1) {
            slots[index] = value;
        }

        return index;
    }

    public int find(String value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(slots[i])) {
                return i;
            }
        }
        return -1;
    }
}
