package com.study.zuoshen.class01;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序
 */
public class Code03_InsertSort {

    /**
     * 插入排序
     * 新节点和已排序的节点进行比较，效率比较低
     *
     * @param arr
     * @return
     */
    public static int[] insertSort01(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = 0;
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        return arr;
    }


    /**
     * 插入排序
     * 先找到要插入的点，然后进行数组后移
     *
     * @param arr
     * @return
     */
    public static int[] insertSort02(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            //找到要插入的位置
            int temp = arr[i];
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            //插入数值
            arr[j + 1] = temp;

        }
        return arr;
    }

    public static void main(String[] args) {
        int NUM = 50000;
        int[] arr = new int[NUM];
        Random random = new Random();
        for (int i = 0; i < NUM; i++) {
            arr[i] = random.nextInt(1000);
        }
        long start = System.currentTimeMillis();
        insertSort02(arr);
        long end = System.currentTimeMillis();
        System.out.println("花费时间为：" + (end - start));

    }
}
