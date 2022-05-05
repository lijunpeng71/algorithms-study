package com.study.leetcode;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P000135Candy {

    /**
     * 分发最少的糖果
     *
     * @param ratings
     * @return
     */
    public static int candy01(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0] = 1;
        right[ratings.length - 1] = 1;
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                left[i + 1] = left[i] + 1;
            } else {
                left[i + 1] = 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                right[i - 1] = right[i] + 1;
            } else {
                right[i - 1] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < left.length; i++) {
            if (left[i] >= right[i]) {
                sum += left[i];
            } else {
                sum += right[i];
            }
        }
        return sum;
    }


    /**
     * 分发最少的糖果
     *
     * @param ratings
     * @return
     */
    public static int candy02(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if(ratings[i]>=ratings[i-1]){
                dec=0;
                pre=ratings[i]==ratings[i-1]?1:pre+1;
                ret+=pre;
                inc=pre;
            }else{
                dec++;
                if(dec==inc){
                    dec++;
                }
                ret+=dec;
                pre=1;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] ratings = {1, 3, 5, 2, 3, 3};
        int sum = candy02(ratings);
        System.out.println("sum:" + sum);
    }
}
