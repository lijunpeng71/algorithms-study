package com.study.zuoshen;

import com.study.tools.GeneratorTool;

import java.util.Arrays;

/**
 * @author lijunpeng02
 * @date 2023年02月01日 12:28
 */
public class Code01_SelectionSort {

    /**
     * 选择排序
     * 描述：(以正序排序举例) 把数据分成两部分，一部分为已经排序，一部分为未排序
     * 选择排序每次选择出最小值，放到已经排序的最末端，知道未排序的部分没有值
     * 举例：
     * 第1次：从[0~n]个数中选择出最小的数放到 0 位置
     * 第二次:从[1~n]个数中选择出最小的数放到 1 位置
     * ……
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //找到最小值，然后与arr[i]进行交换
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int aIndex, int bIndex) {
        int temp = arr[aIndex];
        arr[aIndex] = arr[bIndex];
        arr[bIndex] = temp;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int[] srcArr = GeneratorTool.createIntArr(10000);
            int[] dist1Arr = Arrays.copyOf(srcArr, srcArr.length);
            int[] dist2Arr = Arrays.copyOf(srcArr, srcArr.length);
            Arrays.sort(dist1Arr);
            selectionSort(dist2Arr);
            boolean equals = Arrays.equals(dist1Arr, dist2Arr);
            if (!equals) {
                System.out.println("源数组排序前:" + Arrays.toString(srcArr));
                System.out.println("函数排序后:" + Arrays.toString(dist1Arr));
                System.out.println("函数排序后:" + Arrays.toString(dist2Arr));
                return;
            }
        }
        System.out.println("well done!");
    }
}
