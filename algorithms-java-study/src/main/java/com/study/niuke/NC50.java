package com.study.niuke;

import com.study.niuke.common.ListNode;

/**
 * 题目描述
 * 将给出的链表中的节点每 k k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度 O(1) O(1)
 * 例如：
 * 给定的链表是1\to2\to3\to4\to51→2→3→4→5
 * 对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
 * 对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
 */
public class NC50 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        if (0 == k) {
            return null;
        }
        ListNode begin = head;
        ListNode newHead = null;
        while (begin != null) {
            ListNode end = begin;
            for (int i = 0; i < k - 1; i++) {
                if (end == null) {
                    return head;
                }
                end = end.next;
            }
            ListNode nextSegBeginNode = end.next;
            ListNode newEndNode = begin;
            ListNode temp = null;
            while (begin != end) {
                temp = begin;
                begin = begin.next;
                end.next = temp;
            }
            if (newHead == null) {
                newHead = begin;
            }
            newEndNode.next = nextSegBeginNode;
            begin = nextSegBeginNode;
            head.next = nextSegBeginNode;
        }
        return newHead == null ? head : newHead;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = null, root = null;
        ListNode node = null;
        for (int i = 0; i < arr.length; i++) {
            if (root == null) {
                root = new ListNode();
                root.val = arr[i];
                head = root;
            } else {
                node = new ListNode();
                node.val = arr[i];
                root.next = node;
                root = root.next;
            }
        }
        head = reverseList2(head);
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
        System.out.println();
    }
}
