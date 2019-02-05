package com.example.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private static void sort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }

        int pivot = partition(arr, low, high);
        sort(arr, low, pivot - 1);
        sort(arr, pivot + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotIdx = (low + high) / 2;

        int pivot = arr[pivotIdx];

        swap(arr, pivotIdx, high);
        int i = low;
        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, high);

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if(i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int[] generate(int capacity) {
        int[] nums = new int[capacity];
        Random rand = new Random();

        for(int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt();
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] arr = QuickSort.generate(10000000);
        long st = System.nanoTime();
        QuickSort.sort(arr, 0, arr.length - 1);
        System.out.println("Nanoseconds to QuickSort.sort " + (System.nanoTime() - st));

        arr = QuickSort.generate(10000000);
        st = System.nanoTime();
        Arrays.sort(arr);
        System.out.println("Nanoseconds to Arrays.sort " + (System.nanoTime() - st));
    }
}
