package com.study.zuoshen.class02;

/**
 * 递归求最大值
 */
public class Code08_GetMax {

    public int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    /**
     * 递归求最大值
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    private static int process(int[] arr, int L, int R) {
        //此处为跳出条件
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {

    }
}
