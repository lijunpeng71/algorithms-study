package com.xuelianyong.study.aguigu.algorithms.fibonacci;

/**
 * Created on 2021/1/22.
 *
 * @author junpeng li
 */
public class Fibonacci {


    public static int fib(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 斐波那契(非递归)
     *
     * @param n
     * @return
     */
    public static int fibNoRecursive(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int result = 0;
        int r1 = 1;
        int r2 = 1;
        for (int i = 2; i <= n; i++) {
            result = r1 + r2;
            r2 = r1;
            r1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            int result = fib(i);
            System.out.println("第" + i + "个数：" + result);
        }
    }
}
