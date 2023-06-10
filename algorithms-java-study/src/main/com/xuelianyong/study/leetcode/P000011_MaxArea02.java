package com.xuelianyong.study.leetcode;

/**
 * Created on 2021/2/5.
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 *
 * @author junpeng li
 */
public class P000011_MaxArea02 {

    /**
     * 盛最多水的容器
     *
     * @param height
     * @return
     */
    public static int maxArea01(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int length = height.length;
        int maxWater = 0, water = 0;
        int left = 0, right = length - 1;
        int leftLargest = 0, rightLargest = 0;
        while (left < right) {
            leftLargest = Math.max(leftLargest, height[left]);
            rightLargest = Math.max(rightLargest, height[right]);
            if (leftLargest > rightLargest) {
                water = (right-- - left) * rightLargest;
            } else {
                water = (right - left++) * leftLargest;
            }
            maxWater = Math.max(maxWater, water);
        }
        return maxWater;
    }

    /**
     * 盛最多水的容器
     *
     * @param height
     * @return
     */
    public static int maxArea02(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int length = height.length;
        int maxWater = 0, water = 0;
        int left = 0, right = length - 1;
        while (left < right) {
            water = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, water);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxWater;
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        int water = maxArea01(arr);
        System.out.println("water:" + water);
    }
}
