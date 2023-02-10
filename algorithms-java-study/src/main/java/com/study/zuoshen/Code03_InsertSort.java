package com.study.zuoshen;

import java.util.Arrays;

/**
 * @author lijunpeng02
 * @date 2023年02月08日 19:28
 */
public class Code03_InsertSort {

    /**
     * 插入排序 (以正序排序举例)
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j+1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 4, 8, 2, 5, 3, 6, 1, 0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
