package com.study;

/**
 * @author lijunpeng
 */
public class Test {

    public static void main(String[] args) {
        int a = 16;
        int b = 603;
        System.out.println("交换前：a=" + a + "\t b=" + b);
        System.out.println(b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("交换后：a=" + a + "\t b=" + b);
    }
}
