package com.xuelianyong.study.common;

/**
 * 队列(链表实现)
 *
 * @param <T>
 */
public class MyLinkedQueue<T> {

    private DoubleEndsQueue<T> queue;

    public MyLinkedQueue() {
        queue = new DoubleEndsQueue<T>();
    }

    /**
     * 插入队列
     *
     * @param value
     */
    public void push(T value) {
        queue.addFromBottom(value);
    }

    /**
     * 弹出队列
     *
     * @return
     */
    public T poll() {
        return queue.popFromBottom();
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
