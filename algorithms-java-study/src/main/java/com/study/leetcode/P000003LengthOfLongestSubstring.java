package com.study.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2021/1/29.
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author junpeng li
 */
public class P000003LengthOfLongestSubstring {


    public static int lengthOfLongestSubstring(String s) {
        //哈希集合，记录每次字符是否出现过
        Set<Character> occ = new HashSet<>();
        int length = s.length();
        //右指针初始为-1;相当于我们在字符串的左边界的左边，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < length && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int ret = lengthOfLongestSubstring(s);
        System.out.println("ret:" + ret);
    }
}
