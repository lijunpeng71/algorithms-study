package com.study.leetcode;

/**
 * Created on 2021/2/5.
 * 题目：给出一个数组代表围柱的高度，求能围柱的最大的水量，例如数组{ 5，2，3，2，4 }，最大水量为5。
 * 如下图：黄色部分为围柱，绿色部分是能够围住的水，图中围柱的高度依次为 5，2，3，2，4最多能围住的水量是5。
 * @author junpeng li
 */
public class P000011MaxArea01 {

    /**
     * 盛最多水的容器
     *
     * @param arr
     * @return
     */
    public static int maxArea01(int[] arr) {
        int water = 0;
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int length = arr.length;
        int leftLargest = 0, rightLargest = 0;
        for (int i = 0; i < length; i++) {
            leftLargest = 0;
            rightLargest = 0;
            for (int j = 0; j < i; j++) {
                leftLargest = Math.max(leftLargest, arr[j]);
            }
            for (int j = length - 1; j > i; j--) {
                rightLargest = Math.max(rightLargest, arr[j]);
            }
            water += Math.min(leftLargest, rightLargest) > arr[i] ? Math.min(leftLargest, rightLargest) - arr[i] : 0;
        }
        return water;
    }

    /**
     * 盛最多水的容器
     *
     * @param arr
     * @return
     */
    public static int maxArea02(int[] arr) {
        int water = 0;
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int leftLargest = 0, rightLargest = 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            leftLargest = Math.max(arr[left], leftLargest);
            rightLargest = Math.max(arr[right], rightLargest);
            if (leftLargest > rightLargest) {
                water += rightLargest - arr[right--];
            } else {
                water += leftLargest - arr[left++];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int water = maxArea02(arr);
        System.out.println("water:" + water);
    }
}
