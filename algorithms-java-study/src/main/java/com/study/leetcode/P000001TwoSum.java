package com.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2021/1/24.
 * <p>
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * @author junpeng li
 */
public class P000001TwoSum {

    /**
     * 暴力算法
     * 时间复杂度O(N^2)
     * 空间复杂度O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution01(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            int j = i + 1;
            for (j = i + 1; j < nums.length; j++) {
                if (nums[j] == search) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 一次遍历查找
     * 时间复杂度： O(N)
     * 空间复杂度：O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            if (map.containsKey(search)) {
                int j = map.get(search);
                return new int[]{j, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {11, 15, 2, 7};
        long start = System.currentTimeMillis();
        int[] result = solution02(nums, 9);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(result));
        System.out.println("消耗时间为：" + (end - start) + " ms");
    }
}
