package com.study.common;

/**
 * 栈(链表实现)
 *
 * @param <T>
 */
public class MyLinkedStack<T> {

    private DoubleEndsQueue<T> stack;

    public MyLinkedStack() {
        stack = new DoubleEndsQueue<T>();
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(T value) {
        stack.addFromHead(value);
    }

    /**
     * 出栈
     *
     * @return
     */
    public T pop() {
        return stack.popFromHead();
    }

    /**
     * 是否为空栈
     *
     * @return
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
