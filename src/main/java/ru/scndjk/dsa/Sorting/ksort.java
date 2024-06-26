package ru.scndjk.dsa.Sorting;

public class ksort {
    public String[] items;

    public ksort() {
        this.items = new String[800];
    }

    public int index(String s) {
        if (s == null || s.length() != 3) {
            return -1;
        }

        char firstChar = s.charAt(0);

        if (firstChar < 'a' || firstChar > 'h') {
            return -1;
        }

        try {
            int number = Integer.parseInt(s.substring(1));

            if (number < 0 || number > 99) {
                return -1;
            }

            return (firstChar - 'a') * 100 + number;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public boolean add(String s) {
        int index = index(s);

        if (index == -1) {
            return false;
        }

        items[index] = s;

        return true;
    }
}
