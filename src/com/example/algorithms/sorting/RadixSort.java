package com.example.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RadixSort {

    int[] nums;

    RadixSort(int size) {
        nums = new int[size];
        generate();
    }

    private void generate() {
        Random rand = new Random();

        for(int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(100);
        }
    }

    public void sort() {
        boolean shouldRun = true;
        for(int i  = 0; i < 10 && shouldRun; i++) {
            shouldRun = radixSortSingle(nums, i, 10);
        }
    }

    private boolean radixSortSingle(int[] arr, int iter,  int radix) {
        List[] indexed = new List[radix];
        boolean shouldRun = false;
        int divider = (int) Math.pow(10, iter);
        for(int num : arr) {
            int index = getDigit(num, divider, radix);
            if(index != 0) {
                shouldRun = true;
            }

            if(indexed[index] == null) {
                indexed[index] = new ArrayList();
            }

            indexed[index].add(num);
        }

        if(!shouldRun) {
            return false;
        }

        int k = 0;
        for (List list : indexed) {
            if (list != null) {
                for (Integer numb : (List<Integer>) list) {
                    arr[k++] = numb;
                }
            }
        }

        return true;
    }


    private int getDigit(int number, int divider, int radix) {
        return (number/divider) % radix;
    }

    private void printArray() {
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort(100);
        radixSort.printArray();
        radixSort.sort();
        radixSort.printArray();
    }

}
