package ru.scndjk.dsa.Queue;

import java.util.*;

public class Queue<T> {
    private final LinkedList<T> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        return queue.pollFirst();
    }

    public int size() {
        return queue.size();
    }

    public void cycle(int n) {
        for (int i = 0; i < n; i += 1) {
            queue.add(queue.pollFirst());
        }
    }
}

