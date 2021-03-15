package com.study.zuoshen.class01;

/**
 * 找满足>=value的最左位置
 */
public class Code05_BSNearLeft {
    /**
     * 在arr上，找满足>=value的最左位置
     *
     * @param arr
     * @param value
     * @return
     */
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        //记录最左的位置
        int index = -1;
        while (L < R) {
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
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = nearestIndex(arr, 6);
        System.out.println(index);
    }
}
