package com.xuelianyong.study.common;

public class MyArrayStack {
    /**
     * 数组
     */
    private int[] arr;

    /**
     * 入栈位置
     */
    private int pushIndex;

    /**
     * 出栈位置
     */
    private int popIndex;

    /**
     * 大小
     */
    private int size;

    /**
     * 最大值
     */
    private final int limit;

    public MyArrayStack(int limit) {
        arr = new int[limit];
        pushIndex = 0;
        popIndex = 0;
        size = 0;
        this.limit = limit;
    }

    /**
     * 入队
     *
     * @param value
     */
    public void push(int value) {
        if (size == limit) {
            throw new RuntimeException("栈满了,不能再加了……");
        }
        size++;
        arr[pushIndex] = value;
        pushIndex = nextIndex(pushIndex);
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (size == 0) {
            throw new RuntimeException("栈空了，不能再拿了……");
        }
        size--;
        int ans = nextIndex(popIndex);
        popIndex = nextIndex(popIndex);
        return ans;
    }

    /**
     * 下一个位置
     *
     * @param i
     * @return
     */
    private int nextIndex(int i) {
        return i < limit - 1 ? i + 1 : 0;
    }
}
