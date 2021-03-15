package com.study.leetcode;

import java.util.Arrays;

public class P000912SortAnArray {

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 快速排序
     *
     * @param arr
     * @return
     */
    public static int[] quickSort(int[] arr, int left, int right) {
        return arr;
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     * @return
     */
    public static int[] mergeSort(int[] arr, int left, int right, int[] temp) {
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1};
        arr = bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
