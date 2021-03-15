package com.study.zuoshen.class02;

import java.util.Stack;

/**
 * 获取栈中最小的元素
 * 1.利用两个栈
 * 2.一个存放元素
 * 3.另一个存放最小值
 */
public class Code05_GetMinStack {

    /**
     * 1.每次入栈的时候，都去与最小值栈顶进行比较，如果小于就入栈，如果大于忽略
     * 2.每次出栈的时候，都去与最小值栈顶进行比较，如果等于就出栈，如果不等于忽略
     */
    public static class MyStack {
        /**
         * 数据栈
         */
        private Stack<Integer> dataStack;
        /**
         * 最小值栈
         */
        private Stack<Integer> minDataStack;


        public MyStack() {
            this.dataStack = new Stack<>();
            this.minDataStack = new Stack<>();
        }

        /**
         * 入栈
         *
         * @param value
         */
        public void push(int value) {
            if (this.minDataStack.isEmpty()) {
                this.minDataStack.push(value);
            } else if (value <= this.getMin()) {
                this.minDataStack.push(value);
            }
            this.dataStack.push(value);
        }

        /**
         * 出栈
         *
         * @return
         */
        public int pop() {
            if (this.dataStack.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            int value = this.dataStack.pop();
            if (value == this.getMin()) {
                this.minDataStack.pop();
            }
            return value;
        }

        /**
         * 获取最小值
         *
         * @return
         */
        public int getMin() {
            if (this.minDataStack.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            return this.minDataStack.peek();
        }

    }


    public static void main(String[] args) {

    }
}
