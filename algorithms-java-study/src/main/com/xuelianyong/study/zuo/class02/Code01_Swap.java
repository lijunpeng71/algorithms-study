package com.xuelianyong.study.zuo.class02;

public class Code01_Swap {
    public static void main(String[] args) {
        int a = 16;
        int b = 603;
        System.out.println(a);
        System.out.println(b);
        //*** 运用  a^a = 0   a^0=a 的特性
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);

        //异或的两个数地址不能相同，相同的情况异或的结果为零
        int[] arr = {3, 1, 100};
        int i = 0;
        int j = 0;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        System.out.println(arr[i] + "," + arr[j]);
        System.out.println(arr[0]);
        System.out.println(arr[2]);

        swap(arr, i, j);
        System.out.println(arr[0]);
        System.out.println(arr[2]);
    }


    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
