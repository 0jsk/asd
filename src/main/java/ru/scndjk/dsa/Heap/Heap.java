package ru.scndjk.dsa.Heap;

import java.util.Arrays;

public class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи

    public int size;

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        int size = (2 << depth) - 1;
        HeapArray = new int[size];

        Arrays.stream(a).forEach(this::Add);
    }


    public int GetMax() {
        if (size == 0) {
            return -1;
        }

        int max = HeapArray[0];

        HeapArray[0] = HeapArray[--size];
        HeapArray[size] = 0;

        heapifyDown(0);

        return max;
    }

    public boolean Add(int key) {
        if (HeapArray == null || size == HeapArray.length) {
            return false;
        }

        HeapArray[size] = key;
        heapifyUp(size);
        size++;

        return true;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (HeapArray[index] <= HeapArray[parentIndex]) {
                break;
            }

            int temp = HeapArray[index];
            HeapArray[index] = HeapArray[parentIndex];
            HeapArray[parentIndex] = temp;

            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        while (2 * index + 1 < size) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largerChildIndex = leftChildIndex;

            if (rightChildIndex < size && HeapArray[rightChildIndex] > HeapArray[leftChildIndex]) {
                largerChildIndex = rightChildIndex;
            }

            if (HeapArray[index] > HeapArray[largerChildIndex]) {
                break;
            }

            int temp = HeapArray[index];
            HeapArray[index] = HeapArray[largerChildIndex];
            HeapArray[largerChildIndex] = temp;

            index = largerChildIndex;
        }
    }
}
