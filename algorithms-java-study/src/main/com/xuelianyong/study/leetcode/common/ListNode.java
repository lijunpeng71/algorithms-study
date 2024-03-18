package com.xuelianyong.study.leetcode.common;

import lombok.Data;

/**
 * 单向链表
 */
public class ListNode {
    public int val;

    public ListNode next;

    public static ListNode initWithArray(int[] nums) {
        ListNode head = new ListNode();
        head.val = nums[0];
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode tempNode = new ListNode();
            tempNode.val = nums[i];
            current.next = tempNode;
            current = current.next;
        }
        return head;
    }
}
