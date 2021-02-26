package com.study.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2021/1/28.
 *
 * @author junpeng li
 */
public class P000763PartitionLabels {

    /**
     * 题解
     * 执行用时：4 ms, 在所有 Java 提交中击败了66.14%的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了51.05%的用户
     *
     * @param S
     * @return
     */
    public static List<Integer> partitionLabs01(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partitions.add(end - start + 1);
                start = end + 1;
            }
        }
        return partitions;
    }

    /**
     * 题解
     * 效率没有第一个好
     * 执行用时：9 ms, 在所有 Java 提交中击败了26.17%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了10.26%的用户
     *
     * @param S
     * @return
     */
    public static List<Integer> partitionLabs02(String S) {
        Map<Integer, Integer> charEndMap = new HashMap<>();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            charEndMap.put(S.charAt(i) - 'a', i);
        }
        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, charEndMap.get(S.charAt(i) - 'a'));
            if (i == end) {
                partitions.add(end - start + 1);
                start = end + 1;
            }
        }
        return partitions;
    }

    public static void main(String[] args) {
        String str = "aaaaabaaab";
        List<Integer> result = partitionLabs02(str);
        System.out.println(result);
    }
}
