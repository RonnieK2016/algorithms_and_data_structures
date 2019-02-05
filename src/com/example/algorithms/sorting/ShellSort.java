package com.example.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {

    private static void sort(int[] array) {
        for(int gap = array.length/2; gap > 0; gap /= 2) {
            for(int i = gap; i < array.length; i ++) {
                int j = i;
                while(j >= gap && array[j-gap] > array[j]) {
                    int tmp = array[j-gap];
                    array[j-gap] = array[j];
                    array[j] = tmp;
                    j -= gap;
                }
            }
        }
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
        int[] arr = ShellSort.generate(1000000);
        long st = System.nanoTime();
        ShellSort.sort(arr);
        System.out.println("Nanoseconds to ShellSort.sort " + (System.nanoTime() - st));

        arr = ShellSort.generate(100000000);
        st = System.nanoTime();
        Arrays.sort(arr);
        System.out.println("Nanoseconds to Arrays.sort*100 " + (System.nanoTime() - st));

        //System.out.println(Arrays.toString(arr));
    }
}
