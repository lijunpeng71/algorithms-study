package com.xuelianyong.study.leetcode;

import com.xuelianyong.study.leetcode.common.ListNode;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class AddTwoNumber {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(), head = result;
        ListNode head1 = l1.next, head2 = l2.next;
        int stepVal = (l1.val + l2.val) / 10;
        head.val = (l1.val + l2.val) % 10;
        while (head1 != null && head2 != null) {
            ListNode tempNode = new ListNode();
            tempNode.val = (head1.val + head2.val + stepVal) % 10;
            stepVal = (head1.val + head2.val + stepVal) / 10;
            head1 = head1.next;
            head2 = head2.next;
            head.next = tempNode;
            head = head.next;

        }
        while (head1 != null) {
            ListNode tempNode = new ListNode();
            tempNode.val = (head1.val + stepVal) % 10;
            stepVal = (head1.val + stepVal) / 10;
            head1 = head1.next;
            head.next = tempNode;
            head = head.next;
        }
        while (head2 != null) {
            ListNode tempNode = new ListNode();
            tempNode.val = (head2.val + stepVal) % 10;
            stepVal = (head2.val + stepVal) / 10;
            head2 = head2.next;
            head.next = tempNode;
            head = head.next;
        }
        if (stepVal != 0) {
            ListNode tempNode = new ListNode();
            tempNode.val = stepVal;
            head.next = tempNode;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numsA = {3, 7};
        int[] numsB = {9, 2};
        ListNode l1 = ListNode.initWithArray(numsA);
        ListNode l2 = ListNode.initWithArray(numsB);
        ListNode head = addTwoNumbers(l1, l2);
        while (head != null) {
            System.out.println(head.val + "\t");
            head = head.next;
        }
    }
}
