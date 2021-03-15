package com.study.zuoshen.class01;

import java.util.Arrays;

/**
 * 异或运算
 */
public class Code07_EvenTimesOddTimes {

    /**
     * arr中，只有一种数，出现奇数次
     * 1.偶数次的异或是0
     * 2.奇数次的异或是数本身
     *
     * @param arr
     */
    public static int printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        return eor;
    }

    /**
     * 有两种数，出现奇数次
     * 1.所有数进行异或后是两个数的异或
     * 2.题目说明是两种数，异或结果不为0
     * 3.找到最后出现1的地方，然后把数组分成两部分
     * 4.计数一部分的异或就可以分出一个数
     *
     * @param arr
     * @return
     */
    public static int[] printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //提取最右边的1
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        return new int[]{onlyOne, eor ^ onlyOne};
    }

    /**
     * 统计位为1的数量
     *
     * @param N
     * @return
     */
    public static int bit1counts(int N) {
        int count = 0;
        while (N != 0) {
            //找到最右边为1的位置
            int rightOne = N & (~N + 1);
            count++;
            N ^= rightOne;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 4, 6, 6, 1, 7, 3};
        int[] values = printOddTimesNum2(arr);
        System.out.println(Arrays.toString(values));
    }
}
