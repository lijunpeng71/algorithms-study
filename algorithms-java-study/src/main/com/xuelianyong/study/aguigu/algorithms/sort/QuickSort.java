package com.xuelianyong.study.aguigu.algorithms.sort;

import java.util.Arrays;

/**
 * Created on 2021/1/18.
 *
 * @author junpeng li
 */
public class QuickSort {

    public static int[] quickSort01(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //中轴值
        int pivot = arr[(left + right) / 2];
        int temp;
        //while循环的目的是让比pivot值小放到左边，比pivot值大放到右边
        while (l < r) {
            //在pivot的左边一直找，找到大于等于pivot值才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找，找到小于等于pivot值才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l>=r说明pivot的左右两边的值，已经按照左边全部是小于pivot值，右边全部大于pivot值排列
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现这个arr[l]==pivot值 相等--，前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现arr[r]==pivot值，相等l++,后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        //古国l==r,必须l++,r--否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quickSort01(arr, left, r);
        }
        if (right > l) {
            quickSort01(arr, l, right);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-9, 78, 0, 23, -567, 70};
        System.out.println(Arrays.toString(arr));
        quickSort01(arr, 0, 5);
        System.out.println(Arrays.toString(arr));
    }
}
