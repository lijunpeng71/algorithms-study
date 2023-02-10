package com.study.zuoshen;

import java.util.Arrays;

/**
 * @author lijunpeng02
 * @date 2023年02月08日 15:44
 */
public class Code02_BubbleSort {

    /**
     * 冒泡排序(以正序排列为例) 把数据分成两部分，循环数组
     * 第1次 比较 arr[0] 和 arr[1] 若arr[0] > arr[1] 则交换arr[0]和arr[1]
     * 第2次 比较 arr[1] 和 arr[2] 若arr[1] > arr[2] 则交换arr[1]和arr[2]
     * ……
     * n-1次后，最右的一位数就是数组中最大的值
     * 然后 对 arr[0~n-1]个数重复上面的操作，直到结束
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
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
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
