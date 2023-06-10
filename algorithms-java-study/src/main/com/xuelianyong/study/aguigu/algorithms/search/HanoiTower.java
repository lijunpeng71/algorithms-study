package com.xuelianyong.study.aguigu.algorithms.search;

/**
 * Created on 2021/1/22.
 * 汉诺塔
 *
 * @author junpeng li
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    /**
     * 汉诺塔算法
     *
     * @param num
     * @param a
     * @param b
     * @param c
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第" + num + "个盘： 从" + a + "到" + c);
        } else {
            //如果有n>=2情况，我们总是可以看做两个盘
            //1.先把最上面的所有盘a->b 移动过程为
            hanoiTower(num - 1, a, c, b);
            //2.把最下班的盘a->c
            System.out.println("第" + num + "个盘： 从" + a + "到" + c);
            //3.把B塔的所有盘从b->c
            hanoiTower(num - 1, b, a, c);
        }
    }
}
