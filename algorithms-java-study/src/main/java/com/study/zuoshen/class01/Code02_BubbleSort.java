package com.study.zuoshen.class01;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Code02_BubbleSort {


    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
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

    public static void main(String[] args) {
        int[] arr = {6, 5, 7, 9, 4, 1, 8, 2, 3, 0};
        arr = bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
