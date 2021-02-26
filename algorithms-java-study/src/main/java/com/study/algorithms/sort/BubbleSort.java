package com.study.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {
    /**
     * 没有优化的冒泡排序
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort01(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] bubbleSort02(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 3, 4, 7, 9, 0, 2, 5, 1, 6};
        long startTime = System.currentTimeMillis();
        System.out.println("初始数组为：" + Arrays.toString(arr));
        int[] sortedArr = bubbleSort01(arr);
        System.out.println("排序数组为：" + Arrays.toString(sortedArr));
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间：" + (endTime - startTime));
        //优化后的冒泡排序
        startTime = System.currentTimeMillis();
        arr = new int[]{8, 3, 4, 7, 9, 0, 2, 5, 1, 6};
        System.out.println("初始数组为：" + Arrays.toString(arr));
        sortedArr = bubbleSort02(arr);
        System.out.println("排序数组为：" + Arrays.toString(sortedArr));
        endTime = System.currentTimeMillis();
        System.out.println("执行时间：" + (endTime - startTime));
    }
}
