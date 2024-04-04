package ru.scndjk.dsa.Queue;

import java.util.Stack;

public class QueueOnStacks<T> {
    private final Stack<T> inputStack;
    private final Stack<T> outputStack;

    public QueueOnStacks() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void enqueue(T item) {
        inputStack.push(item);
    }

    public T dequeue() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        return outputStack.pop();
    }

    public int size() {
        return inputStack.size() + outputStack.size();
    }
}

