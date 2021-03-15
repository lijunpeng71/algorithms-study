package com.study.zuoshen.class03;

/**
 * 归并排序
 */
public class Code01_MergeSort {

    /**
     * 递归实现
     *
     * @param arr
     */
    public static void mergeSort01(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    /**
     * 非递归实现
     *
     * @param arr
     */
    public static void mergeSort02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        //当前有序的，左组长度
        int mergeSize = 1;
        while (mergeSize < N) {
            int left = 0;
            while (left < N) {
                int mid = left + mergeSize - 1;
                if (mid >= N) {
                    break;
                }
                int right = Math.min(mid + mergeSize, N - 1);
                merge(arr, left, mid, right);
                left = right + 1;
            }
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    /**
     * 先分后合
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * 合并
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        //左边数组的起点
        int p1 = left;
        //右边数组的起点
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }


    public static void main(String[] args) {

    }
}
