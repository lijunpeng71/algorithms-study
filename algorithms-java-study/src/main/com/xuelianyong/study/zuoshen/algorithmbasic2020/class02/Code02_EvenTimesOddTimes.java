package com.xuelianyong.study.zuoshen.algorithmbasic2020.class02;

/**
 * Created on 2022/6/5.
 *
 * @author Administrator
 */
public class Code02_EvenTimesOddTimes {

    /**
     * arr中，只有一种数，出现奇数次
     * 思路：eor：相同的数eor=0，不同的数eor!=0
     * 推出：偶数次相同的数 eor=0
     *
     * @param arr
     */
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println("result:" + eor);
    }

    /**
     * arr中，有两种数出现奇数次
     * 思路：eor：相同的数eor=0，不同的数eor!=0
     * 推出：偶数次相同的数 eor=0
     * 有两种数为奇数则 所以数的eor!=0
     * 然后找到eor最右侧为1的那一位，然后找出期中一个数
     *
     * @param arr
     */
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //找到最右边为1的那一位
        int rightOne = eor & (-eor);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
                break;
            }
        }
        System.out.println("onlyOne:" + onlyOne + "otherOne:" + (eor ^ onlyOne));
    }

    public static void main(String[] args) {

    }
}
