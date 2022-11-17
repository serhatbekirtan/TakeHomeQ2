package com.Prog2;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Integer[] arr = {3, 0, 1, 8, 7, 2, 4, 4, 9, 6};
        /*int[] inputArray10k = new int[10000];
        for (int i = 0; i < inputArray10k.length; i++){
            inputArray10k[i] = i;
        }*/
        //long start = System.currentTimeMillis();
        /*Integer[] arr = new Integer[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }*/
        //Collections.shuffle(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
        HungarianQS(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        //long end = System.currentTimeMillis();
        //System.out.println("Sorted array: ");
        //printArray(inputArray10k, inputArray10k.length);
        //System.out.println((end - start) + " ms");
    }

    public static int partition(Integer[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        int temp;
        while (true){
            while (arr[j] >= pivot && j > 0){
                j--;
            }

            if (i >= j){
                return i;
            }

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            while (arr[i] <= pivot && i < arr.length - 1){
                i++;
            }

            if (i >= j){
                return j;
            }

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void HungarianQS(Integer[] arr, int low, int high){
        if (low < high) {
            int i = partition(arr, low, high);
            HungarianQS(arr, low, i);
            HungarianQS(arr, i + 1, high);
        }
    }
}
