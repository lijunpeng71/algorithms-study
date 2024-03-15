package com.xuelianyong.study.algoscript.chapter02;

import cn.hutool.core.util.ArrayUtil;

public class C02_SelectedSort {
    /**
     * 选择排序
     *
     * @param arr
     * @return
     */
    public static int[] selectedSort01(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        System.out.println(ArrayUtil.toString(arr));
        arr = selectedSort01(arr);
        System.out.println(ArrayUtil.toString(arr));
    }
}
