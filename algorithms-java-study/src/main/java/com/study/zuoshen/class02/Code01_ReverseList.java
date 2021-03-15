package com.study.zuoshen.class02;


import com.study.common.DoubleListNode;
import com.study.common.ListNode;

/**
 * 链表逆序
 * 单链表
 * 双链表
 */
public class Code01_ReverseList {

    /**
     * 逆序单链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseListNode(ListNode head) {
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

    /**
     * 逆序双向链表
     *
     * @param head
     * @return
     */
    public static DoubleListNode reverseDoubleListNode(DoubleListNode head) {
        DoubleListNode next = null;
        DoubleListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        DoubleListNode head = new DoubleListNode(arr);
        DoubleListNode root = head;
        head.show();
        head = root;
        head = reverseDoubleListNode(head);
        head.show();
        head = root;
        System.out.println();
    }
}
