package com.xuelianyong.study.algoscript.chapter02;

import cn.hutool.core.util.ArrayUtil;

public class C03_InsertedSort {

    /**
     * 插入排序
     *
     * @param arr
     * @return arr
     */
    public static int[] insertedSort01(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j+1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        System.out.println("排序前:" + ArrayUtil.toString(arr));
        arr = insertedSort01(arr);
        System.out.println("排序后:" + ArrayUtil.toString(arr));
    }
}
