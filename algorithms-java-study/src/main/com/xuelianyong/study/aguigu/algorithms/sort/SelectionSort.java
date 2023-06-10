package com.xuelianyong.study.aguigu.algorithms.sort;

import java.util.Arrays;

/**
 * Created on 2021/1/17.
 *
 * @author junpeng li
 */
public class SelectionSort {

    /**
     * 选择排序核心算法
     *
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 3, 4, 7, 9, 0, 2, 5, 1, 6};
        long startTime = System.currentTimeMillis();
        System.out.println("初始数组为：" + Arrays.toString(arr));
        int[] sortedArr = selectionSort(arr);
        System.out.println("排序数组为：" + Arrays.toString(sortedArr));
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间：" + (endTime - startTime));
    }
}
