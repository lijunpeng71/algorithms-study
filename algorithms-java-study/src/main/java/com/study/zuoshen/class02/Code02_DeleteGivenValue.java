package com.study.zuoshen.class02;

import com.study.common.ListNode;

/**
 * 删除给定的值
 */
public class Code02_DeleteGivenValue {

    /**
     * 删除给定的值
     *
     * @param head
     * @param value
     * @return
     */
    public static ListNode removeListNode(ListNode<Integer> head, int value) {
        while (head != null) {
            if (head.val == value) {
                break;
            }
            head = head.next;
        }
        //head来到第一个不需要删的位置
        ListNode<Integer> pre = head;
        ListNode<Integer> cur = head;
        while (cur != null) {
            if (cur.val == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {

    }
}
