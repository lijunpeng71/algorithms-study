package com.study.zuoshen.algorithmbasic2020.class02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 描述：数组中所有的数都出现了 m 次，只有一种数出现了 k 次
 * 找出两种数
 * @author lijunpeng02
 * @date 2023年03月23日 19:37
 */
public class Code03_KM {

    /**
     * 随机生成数组
     * @param maxKinds  最大的不同数
     * @param range  数组区间
     * @param k
     * @param m
     * @return
     */
    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        int ktimeNum = randomNumber(range);
        // 真命天子出现的次数
        int times = k;
        // 至少是两种
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        // 除去K次的数，其他数都出现了m次
        int[] arr = new int[times + (numKinds - 1) * m];
        int index = 0;
        for (; index < times; index++) {
            arr[index] = ktimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        // arr 填好了
        for (int i = 0; i < arr.length; i++) {
            // i 位置的数，我想随机和j位置的数做交换
            int j = (int) (Math.random() * arr.length);// 0 ~ N-1
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }

    public static int randomNumber(int range) {
        return (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
    }

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static int onlyKTimes(int[] arr,int k,int m){
        if(map.size()==0){
            mapCreater(map);
        }
        int[] t = new int[32];
        // t[0] 0位置的1出现了几个
        // t[i] i位置的1出现了几个
        for (int num : arr) {
            while (num != 0) {
                int rightOne = num & (-num);
                t[map.get(rightOne)]++;
                num ^= rightOne;
            }
        }
        int ans = 0;
        // 如果这个出现了K次的数，就是0
        // 那么下面代码中的 : ans |= (1 << i);
        // 就不会发生
        // 那么ans就会一直维持0，最后返回0，也是对的！
        for (int i = 0; i < 32; i++) {
            if (t[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void mapCreater(HashMap<Integer, Integer> map) {
        int value = 1;
        for (int i = 0; i < 32; i++) {
            map.put(value, i);
            value <<= 1;
        }
    }




    public static void main(String[] args) {
        int kinds = 5;
        int range = 30;
        int testTime = 100000;
        int max = 9;
        System.out.println("测试开始");
        int a = (int) (Math.random() * max) + 1; // a 1 ~ 9
        int b = (int) (Math.random() * max) + 1; // b 1 ~ 9
        int k = Math.min(a, b);
        int m = Math.max(a, b);
        // k < m
        if (k == m) {
            m++;
        }
        int[] arr = randomArray(kinds, range, k, m);
        System.out.println(Arrays.toString(arr));

        int rightOne = 7 & (-7);
        System.out.println("7 & (-7):"+rightOne);
    }
}
