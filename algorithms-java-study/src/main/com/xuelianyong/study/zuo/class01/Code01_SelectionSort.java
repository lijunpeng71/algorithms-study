package com.xuelianyong.study.zuo.class01;

import cn.hutool.core.util.ArrayUtil;

public class Code01_SelectionSort {


    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~N-1 找到最小值，在哪，放到0位置
        //1~N-1 找到最小值，在哪，放到1位置
        //2~N-1 找到最小值，在哪，放到2位置
        //……
        //N-1~N-1 找到最小值，在哪，放到N-1位置
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4, 6, 7, 8, 9, 0};
        System.out.println("排序前：" + ArrayUtil.toString(arr));
        selectionSort(arr);
        System.out.println("排序后：" + ArrayUtil.toString(arr));
    }
}
