package com.xuelianyong.study.algoscript.chapter02;

import cn.hutool.core.util.ArrayUtil;

public class C01_BubbleSort {

    /**
     * 冒泡排序
     * @param arr 原始数组
     * @return arr
     */
    public static int[] bubbleSort01(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return null;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


    public static int[] bubbleSort02(int[] arr){
        if (arr == null || arr.length <= 0) {
            return null;
        }
        boolean ordered=false;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    ordered=true;
                }
            }
            if(!ordered){
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2, 6, 7, 8, 9, 10};
        System.out.println("排序前:" + ArrayUtil.toString(arr));
        arr = bubbleSort02(arr);
        System.out.println("排序后:" + ArrayUtil.toString(arr));

    }
}
