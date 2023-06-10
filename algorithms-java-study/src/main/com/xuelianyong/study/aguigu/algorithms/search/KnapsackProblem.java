package com.xuelianyong.study.aguigu.algorithms.search;

/**
 * Created on 2021/1/22.
 *
 * @author junpeng li
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        //物品重量
        int[] weights = {1, 4, 3};
        //物品价值
        int[] values = {1500, 3000, 2000};
        //背包的容量
        int capacity = 4;
        //物品个数
        int num = values.length;
        //创建二维数组
        //v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[num + 1][capacity + 1];
        //为了记录放入商品的情况
        int[][] path = new int[num + 1][capacity + 1];
        //初始化第一行和第一列
        for (int i = 0; i < v.length; i++) {
            //将第一列设置为0
            v[i][0] = 0;
        }
        for (int j = 0; j < v[0].length; j++) {
            //将第一行设置为0
            v[0][j] = 0;
        }

        //根据前面得到的公式来动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                //物品重量大于背包能够装如最大重量
                if (weights[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                }
                //物品重量小于等于背包能够装如最大重量
                else {
                    //v[i][j] = Math.max(v[i - 1][j], values[i - 1] + v[i - 1][j - weights  [i - 1]]);
                    if (v[i - 1][j] < values[i - 1] + v[i - 1][j - weights[i - 1]]) {
                        v[i][j] = values[i - 1] + v[i - 1][j - weights[i - 1]];
                        //把当前的情况记录到path中
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出看当前情况
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + "\t");
            }
            System.out.println();
        }

        //行的最大下标
        int i = path.length - 1;
        //列的最大下标
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= weights[i - 1];
            }
            i--;
        }
    }
}
