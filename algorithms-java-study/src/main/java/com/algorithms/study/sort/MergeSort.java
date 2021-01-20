package com.algorithms.study.sort;

import java.util.Arrays;

/**
 * Created on 2021/1/18.
 *
 * @author junpeng li
 */
public class MergeSort {

    /**
     * 分解加合并方法
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     * @return
     */
    public static int[] mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
        return arr;
    }

    /**
     * 合并方法
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    public static int[] merge(int[] arr, int left, int mid, int right, int[] temp) {
        //初始化i,左边有序序列的初始索引
        int i = left;
        //初始化j,右边有序序列的初始索引
        int j = mid + 1;
        //指向temp数组的当前索引
        int t = 0;
        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //(二)
        //把剩余数据的一遍的数据依次全部填充到temp
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //(三)
        //将temp数组的元素拷贝到arr,并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * arr.length);
        }
        //System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        int[] sortedArr = mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        //System.out.println(Arrays.toString(arr));
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间：" + (endTime - startTime));
    }
}
