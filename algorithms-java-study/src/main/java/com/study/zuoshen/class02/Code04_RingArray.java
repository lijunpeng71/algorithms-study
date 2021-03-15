package com.study.zuoshen.class02;

import com.study.common.MyArrayStack;

/**
 * 数组实现循环队列和栈
 */
public class Code04_RingArray {

    public static void main(String[] args) {
        MyArrayStack myArrayStack = new MyArrayStack(6);
        myArrayStack.push(1);
        myArrayStack.push(2);
        System.out.println(myArrayStack.pop());
        System.out.println(myArrayStack.pop());
    }
}
