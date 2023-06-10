package com.xuelianyong.study.aguigu.datastruct.stack;

public class ArrayStackObject {

    /**
     * 栈的大小
     */
    private int maxSize;

    private int[] stack;

    private int top;

    /**
     * 栈构造函数
     *
     * @param maxSize
     */
    public ArrayStackObject(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        top = -1;
    }

    /**
     * 栈是否满
     *
     * @return
     */
    public boolean isFull() {
        return top >= maxSize - 1;
    }

    /**
     * 栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param data
     */
    public void push(int data) {
        if (isFull()) {
            System.out.println("栈已满了");
        }
        top++;
        stack[top] = data;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空了");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空了");
        }
        return stack[top];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
