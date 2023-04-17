package com.study.zuoshen.algorithmbasic2020.class04;

import cn.hutool.core.util.ArrayUtil;

/**
 * Created on 2023/4/17.
 *
 * @author junpeng.li
 */
public class Code01_MergeSort {

    /**
     * 递归方式实现
     *
     * @param arr
     */
    public static void mergeSortV1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 分
     *
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);
    }


    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = {9, 2, 8, 5, 3, 6, 7, 1, 4, 0};
        mergeSortV1(arr);
        System.out.println(ArrayUtil.toString(arr));
    }
}
