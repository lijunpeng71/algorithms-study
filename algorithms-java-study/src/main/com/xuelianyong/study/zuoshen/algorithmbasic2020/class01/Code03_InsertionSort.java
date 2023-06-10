package com.xuelianyong.study.zuoshen.algorithmbasic2020.class01;

/**
 * 插入排序
 */
public class Code03_InsertionSort {
    /**
     * 插入排序思路
     * 1、把数组分成两部分，一部分是已经排过序的，一部分是还未排序的
     * 2、每次从未排序的部分找到一个数，然后插入到排过序部分中
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }

    public static void printShow(int[] arrs) {
        for (int arr : arrs) {
            System.out.print(arr + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 6, 1, 8, 3, 5};
        printShow(arr);
        insertionSort(arr);
        printShow(arr);
    }
}
