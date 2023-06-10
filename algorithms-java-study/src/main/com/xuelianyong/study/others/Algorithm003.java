package com.xuelianyong.study.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个正数N，求这个N的所有的因子分解
 */
public class Algorithm003 {

    /**
     * @param n
     */
    public static List<List<Integer>> eval(int n) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < n / 2; i++) {
            if (n % i == 0) {
                result.add(i);
                result.add(n / i);
                resultList.add(result);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int N = 12;
        List<List<Integer>> resultList = eval(N);
        resultList.forEach(result -> System.out.println(result));
    }
}
