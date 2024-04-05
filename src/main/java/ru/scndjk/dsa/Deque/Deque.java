package ru.scndjk.dsa.Deque;

import java.util.*;

public class Deque<T> {
    private final LinkedList<T> list;

    public Deque() {
        list = new LinkedList<>();
    }

    public void addFront(T item) {
        list.addFirst(item);
    }

    public void addTail(T item) {
        list.addLast(item);
    }

    public T removeFront() {
        return list.pollFirst();
    }

    public T removeTail() {
        return list.pollLast();
    }

    public int size() {
        return list.size();
    }

    public static boolean isPalindrome(String str) {
        Deque<Character> deque = new Deque<>();

        for (char c : str.toCharArray()) {
            deque.addTail(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFront() != deque.removeTail()) {
                return false;
            }
        }

        return true;
    }
}
