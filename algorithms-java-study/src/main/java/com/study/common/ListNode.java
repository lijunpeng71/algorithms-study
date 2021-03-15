package com.study.common;

public class ListNode<T> {
    public T val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 通过数组构建链表
     *
     * @param values
     */
    public ListNode(T[] values) {
        this.val = values[0];
        ListNode curNode = this, node = null;
        for (int i = 1; i < values.length; i++) {
            node = new ListNode(values[i]);
            curNode.next = node;
            curNode = node;

        }
    }

    /**
     * 打印链表
     */
    public void show() {
        ListNode head = this;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}