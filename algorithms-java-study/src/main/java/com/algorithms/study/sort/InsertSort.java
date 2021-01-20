package com.algorithms.study.sort;

import java.util.Arrays;

/**
 * Created on 2021/1/17.
 *
 * @author junpeng li
 */
public class InsertSort {

    /**
     * 插入排序核心算法
     *
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 3, 4, 7, 9, 0, 2, 5, 1, 6};
        long startTime = System.currentTimeMillis();
        System.out.println("初始数组为：" + Arrays.toString(arr));
        int[] sortedArr = insertSort(arr);
        System.out.println("排序数组为：" + Arrays.toString(sortedArr));
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间：" + (endTime - startTime));
    }
}
