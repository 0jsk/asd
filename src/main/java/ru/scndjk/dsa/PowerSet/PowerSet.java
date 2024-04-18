package ru.scndjk.dsa.PowerSet;

import java.util.HashMap;
import java.util.Map;

public class PowerSet {
    private final Map<String, Object> table;
    private final Object ELEMENT = new Object();

    private final Integer INITIAL_CAPACITY = 20000;

    public PowerSet() {
        table = new HashMap<>(INITIAL_CAPACITY);
    }

    public int size() {
        return table.size();
    }

    public void put(String value) {
        if (!table.containsKey(value)) {
            table.put(value, ELEMENT);
        }
    }

    public boolean get(String value) {
        return table.containsKey(value);
    }

    public boolean remove(String value) {
        return table.remove(value, ELEMENT);
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet result = new PowerSet();

        for (String key : table.keySet()) {
            if (set2.get(key)) {
                result.put(key);
            }
        }

        return result;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet result = new PowerSet();

        for (String key : table.keySet()) {
            result.put(key);
        }

        for (String key : set2.table.keySet()) {
            result.put(key);
        }

        return result;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet result = new PowerSet();

        for (String key : table.keySet()) {
            if (!set2.get(key)) {
                result.put(key);
            }
        }

        return result;
    }

    public boolean isSubset(PowerSet set2) {
        for (String key : table.keySet()) {
            if (!set2.get(key)) {
                return false;
            }
        }

        return true;
    }
}

