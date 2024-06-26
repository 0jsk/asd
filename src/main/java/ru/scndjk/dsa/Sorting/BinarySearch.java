package ru.scndjk.dsa.Sorting;

public class BinarySearch {
    public int[] sortedArray;
    public int Left;
    public int Right;

    private int searchStatus;

    public BinarySearch(int[] sortedArray) {
        this.sortedArray = sortedArray;
        this.Left = 0;
        this.Right = sortedArray.length - 1;
        this.searchStatus = sortedArray.length == 0 ? -1 : 0;
    }

    public void Step(int N) {
        if (searchStatus != 0) {
            return;
        }

        int mid = (Left + Right) / 2;

        if (sortedArray[mid] == N) {
            searchStatus = 1;
        } else if (Left >= Right) {
            searchStatus = -1;
        } else if (sortedArray[mid] < N) {
            Left = mid + 1;
        } else {
            Right = mid - 1;
        }

        if (Right - Left <= 1) {
            searchStatus = (sortedArray[Left] == N || sortedArray[Right] == N) ? 1 : -1;
        }
    }

    public int GetResult() {
        return searchStatus;
    }
}
