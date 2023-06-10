package com.xuelianyong.study.common;

public class DoubleListNode<T> {

    public T val;

    public DoubleListNode pre;

    public DoubleListNode next;

    public DoubleListNode(T val) {
        this.val = val;
    }


    /**
     * 通过数组构建链表
     *
     * @param values
     */
    public DoubleListNode(T[] values) {
        this.val = values[0];
        DoubleListNode curNode = this, node = null;
        for (int i = 1; i < values.length; i++) {
            node = new DoubleListNode(values[i]);
            curNode.next = node;
            node.pre = curNode;
            curNode = node;
        }
    }


    /**
     * 打印链表
     */
    public void show() {
        DoubleListNode head = this;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
