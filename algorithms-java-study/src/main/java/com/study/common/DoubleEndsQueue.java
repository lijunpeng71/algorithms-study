package com.study.common;

/**
 * 双端队列
 *
 * @param <T>
 */
public class DoubleEndsQueue<T> {
    public T value;
    public DoubleListNode<T> head;
    public DoubleListNode<T> tail;

    /**
     * 头插
     *
     * @param value
     */
    public void addFromHead(T value) {
        DoubleListNode<T> cur = new DoubleListNode<>(value);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.next = head;
            head.pre = cur;
            head = cur;
        }
    }

    /**
     * 头弹出
     *
     * @return
     */
    public T popFromHead() {
        if (head == null) {
            return null;
        }
        DoubleListNode<T> cur = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            cur.next = null;
            head.pre = null;
        }
        return cur.val;
    }

    /**
     * 尾插
     *
     * @param value
     */
    public void addFromBottom(T value) {
        DoubleListNode<T> cur = new DoubleListNode<>(value);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.pre = head;
            tail.next = cur;
            head = cur;
        }
    }

    /**
     * 尾部弹出
     *
     * @return
     */
    public T popFromBottom() {
        if (head == null) {
            return null;
        }
        DoubleListNode<T> cur = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.pre;
            tail.next = null;
            cur.pre = null;
        }
        return cur.val;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }
}