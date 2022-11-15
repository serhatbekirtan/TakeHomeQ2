package com.Prog2;

public class Main {

    public static void main(String[] args) {

        int[] arr = {3, 0, 1, 8, 7, 2, 5, 4, 9, 6};
        HungarianQS(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        printArray(arr, arr.length);
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        int temp;
        while (true){
            while (arr[j] > pivot){
                j--;
            }

            if (i >= j){
                return j;
            }

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            while (arr[i] < pivot){
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

    public static void HungarianQS(int[] arr, int low, int high){
        if (low < high) {
            int i = partition(arr, low, high);
            HungarianQS(arr, low, i);
            HungarianQS(arr, i + 1, high);
        }
    }

    public static void printArray(int[] arr, int n){
        for (int i = 0; i < n; i++)
            System.out.print(" " + arr[i]);
        System.out.println();
    }
}
