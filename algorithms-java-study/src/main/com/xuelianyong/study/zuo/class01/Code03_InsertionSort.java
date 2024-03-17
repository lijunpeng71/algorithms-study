package com.xuelianyong.study.zuo.class01;

import cn.hutool.core.util.ArrayUtil;

public class Code03_InsertionSort {


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

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4, 6, 7, 8, 9, 0};
        System.out.println("排序前：" + ArrayUtil.toString(arr));
        insertionSort(arr);
        System.out.println("排序后：" + ArrayUtil.toString(arr));
    }
}
