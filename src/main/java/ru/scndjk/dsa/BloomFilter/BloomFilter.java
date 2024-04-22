package ru.scndjk.dsa.BloomFilter;

public class BloomFilter {
    public int filter_len;
    public int bitArray;

    private final Integer HASH1_SEED = 17;
    private final Integer HASH2_SEED = 223;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        bitArray = 0;
    }

    public int hash1(String str1) {
        int hash = 0;

        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            hash = hash * HASH1_SEED + code;
        }

        return hash % filter_len;
    }

    public int hash2(String str1) {
        int hash = 0;

        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            hash = hash * HASH2_SEED + code;
        }

        return hash % filter_len;
    }

    public void add(String str1) {
        int hash1 = hash1(str1);
        int hash2 = hash2(str1);

        bitArray |= (1 << hash1);
        bitArray |= (1 << hash2);
    }

    public boolean isValue(String str1) {
        int hash1 = hash1(str1);
        int hash2 = hash2(str1);

        int expected = (1 << hash1) | (1 << hash2);

        return (expected & bitArray) != 0;
    }
}

