package com.study.aguigu.algorithms.sort;

import java.util.Arrays;

/**
 * Created on 2021/1/17.
 *
 * @author junpeng li
 */
public class ShellSort {

    /**
     * 希尔排序算法
     *
     * @param arr
     * @return
     */
    public static int[] shellSort01(int[] arr) {
        int length = arr.length;
        int gap = 1;
        while (gap < length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap = gap / 3;
        }
        return arr;
    }

    /**
     * 希尔排序交换法
     *
     * @param arr
     * @return
     */
    public static int[] shellSort02(int[] arr) {
        int length = arr.length;
        int temp = 0;
        int count = 0;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                //遍历各组中所有的元素(共5组，每组有2个元素)，步长为5
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 希尔排序移位发
     *
     * @param arr
     * @return
     */
    public static int[] shellSort03(int[] arr) {
        int length = arr.length;
        int count = 0;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            System.out.println("第" + (++count) + "排序：" + Arrays.toString(arr));
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * arr.length);
        }
        long startTime = System.currentTimeMillis();
        int[] sortedArr = shellSort03(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间：" + (endTime - startTime));
    }
}