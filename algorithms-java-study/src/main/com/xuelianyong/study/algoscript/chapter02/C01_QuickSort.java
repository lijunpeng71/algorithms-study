package com.xuelianyong.study.algoscript.chapter02;

import cn.hutool.core.util.ArrayUtil;

public class C01_QuickSort {
    /**
     * 快速排序
     * 中枢值固定为第一个元素，比较过程中，中枢值位置不变
     *
     * @param arr
     */
    public static void quickSort01(int[] arr) {
        quickSort01(arr, 0, arr.length - 1);
    }

    public static void quickSort01(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition01(arr, start, end);
            quickSort01(arr, start, pivotIndex - 1);
            quickSort01(arr, pivotIndex + 1, end);
        }
    }

    private static int partition01(int[] arr, int start, int end) {
        int pivotValue = arr[start];
        int j = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, j, start);
        return j;
    }

    /**
     * 交换
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void quickSort02(int[] arr) {
        quickSort02(arr, 0, arr.length - 1);
    }

    public static void quickSort02(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition02(arr, start, end);
            quickSort02(arr, start, pivotIndex - 1);
            quickSort02(arr, pivotIndex + 1, end);
        }
    }

    private static int partition02(int[] arr, int start, int end) {
        int pivotValue = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= pivotValue) {
                --end;
            }
            swap(arr, start, end);
            while (start < end && arr[start] <= pivotValue) {
                ++start;
            }
            swap(arr, start, end);
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("排序前:" + ArrayUtil.toString(arr));
        quickSort02(arr);
        System.out.println("排序后:" + ArrayUtil.toString(arr));
    }
}
