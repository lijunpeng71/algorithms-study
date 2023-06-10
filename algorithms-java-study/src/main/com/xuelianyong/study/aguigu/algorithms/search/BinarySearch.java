package com.xuelianyong.study.aguigu.algorithms.search;

/**
 * Created on 2021/1/22.
 * 二分查找
 *
 * @author junpeng li
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index1 = binarySearch(arr, 8, 0, arr.length - 1);
        System.out.println("index1:" + index1);
        int index2 = binarySearchNoRecursive(arr, 8);
        System.out.println("index2:" + index2);
    }

    /**
     * 二分查找(递归实现)
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch(arr, target, left, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, right);
        }
    }

    /**
     * 二分查找(非递归实现)
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchNoRecursive(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
