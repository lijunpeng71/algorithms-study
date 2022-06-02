package com.study.zuoshen.algorithmbasic2020.class01;

/**
 * Created on 2022/6/1.
 *
 * @author Administrator
 */
public class Code05_BSNearLeft {

    /**
     * 在有序数组arr上，找到满足>=value的最左位置
     *
     * @param arr
     * @param value
     * @return
     */
    public static int nearestIndex(int[] arr, int value) {
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
        int[] arr = {1, 2, 3, 4, 5, 5, 5, 7, 9};
        int index = nearestIndex(arr, 6);
        System.out.println("index:" + index);
    }
}
