package com.xuelianyong.study.zuoshen.algorithmbasic2020.class02;

/**
 * Created on 2022/6/2.
 *
 * @author Administrator
 */
public class Code01_Swap {

    public static void main(String[] args) {

        int a = 16;
        int b = 603;

        System.out.println(a);
        System.out.println(b);


        a = a ^ b;
        b = a ^ b;
        a = a ^ b;


        System.out.println(a);
        System.out.println(b);




        int[] arr = {3,1,100};

        int i = 0;
        int j = 0;

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

        System.out.println(arr[i] + " , " + arr[j]);

    }

}
