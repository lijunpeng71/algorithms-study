package com.xuelianyong.study.leetcode;

import cn.hutool.core.util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/
 */
public class TwoNumber {

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int another = target - nums[i];
            if (numsMap.containsKey(another)) {
                return new int[]{numsMap.get(another), i};
            }
            numsMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int[] result = twoSum(nums, 6);
        System.out.println("结果:" + ArrayUtil.toString(result));
    }
}
