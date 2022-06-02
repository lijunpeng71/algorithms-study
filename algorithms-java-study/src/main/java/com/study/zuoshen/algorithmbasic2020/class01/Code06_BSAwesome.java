package com.study.zuoshen.algorithmbasic2020.class01;

/**
 * Created on 2022/6/1.
 *
 * @author Administrator
 */
public class Code06_BSAwesome {

    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int L = 1;
        int R = arr.length - 2;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            } else {
                return mid;
            }
        }
        return L;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 4, 5, 5, 5, 7, 9};
        int index = getLessIndex(arr);
        System.out.println("index:" + index);
    }
}
