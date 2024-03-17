package com.xuelianyong.study.zuo.class01;

import cn.hutool.core.util.ArrayUtil;

public class Code02_BubbleSort {

    /**
     * 通常算法
     *
     * @param arr
     */
    public static void bubbleSort01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSort02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
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
        bubbleSort01(arr);
        System.out.println("排序后：" + ArrayUtil.toString(arr));
    }
}
