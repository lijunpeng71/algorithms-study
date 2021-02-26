package com.study.leetcode;

/**
 * Created on 2021/1/25.
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author junpeng li
 */
public class P000002AddTwoNumbers {

    /**
     * 不知不觉中写的是正确答案
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int[] nums = new int[100];
        int length = 0;
        boolean flag = false;
        int result = 0;
        while (temp1 != null || temp2 != null) {
            if (temp1 != null && temp2 != null) {
                result = temp1.val + temp2.val;
                if (flag) {
                    result += 1;
                }
                if (result > 9) {
                    flag = true;
                    nums[length++] = result % 10;
                } else {
                    nums[length++] = result;
                    flag = false;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else if (temp1 != null) {
                if (flag) {
                    result = temp1.val + 1;
                    if (result > 9) {
                        flag = true;
                        nums[length++] = result % 10;
                    } else {
                        nums[length++] = result;
                        flag = false;
                    }
                } else {
                    nums[length++] = temp1.val;
                }
                temp1 = temp1.next;
            } else if (temp2 != null) {
                if (flag) {
                    result = temp2.val + 1;
                    if (result > 9) {
                        flag = true;
                        nums[length++] = result % 10;
                    } else {
                        nums[length++] = result;
                        flag = false;
                    }
                } else {
                    nums[length++] = temp2.val;
                }
                temp2 = temp2.next;
            }
        }
        if (flag) {
            nums[length++] = 1;
        }
        ListNode node = new ListNode(nums[0]);
        ListNode temp = node;
        for (int i = 1; i < length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        return node;
    }

    public static void main(String[] args) {
        int[] l1Arr = {9, 9, 9, 9, 9, 9, 9};
        ListNode l1 = new ListNode(l1Arr);
        int[] l2Arr = {9, 9, 9, 9};
        ListNode l2 = new ListNode(l2Arr);

        ListNode resultNode = addTwoNumbers(l1, l2);
    }
}

/**
 * 链表
 */
class ListNode {
    /**
     * 值
     */
    int val;
    /**
     * 下一个结点
     */
    ListNode next;


    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] arr) {
        if (arr != null && arr.length > 0) {
            this.val = arr[0];
            ListNode temp = this;
            for (int i = 1; i < arr.length; i++) {
                temp.next = new ListNode(arr[i]);
                temp = temp.next;
            }
        }
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
