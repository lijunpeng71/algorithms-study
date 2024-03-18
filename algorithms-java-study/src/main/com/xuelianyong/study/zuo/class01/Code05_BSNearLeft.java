package com.xuelianyong.study.zuo.class01;

/**
 * 在一个有序数组中，找>=某个数最左侧的位置
 */
public class Code05_BSNearLeft {


    public static int nearstIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        int index = nearstIndex(arr, 5);
        System.out.println("index:" + index);
    }
}
