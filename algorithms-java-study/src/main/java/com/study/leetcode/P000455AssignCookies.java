package com.study.leetcode;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P000455AssignCookies {

    /**
     * 暴力点
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren01(int[] g, int[] s) {
        int num = 0;
        g=Arrays.stream(g).sorted().toArray();
        s=Arrays.stream(s).sorted().toArray();
        int j=0;
        for (int i = 0; i < g.length; i++) {
            while(j<s.length){
                if(s[j]>=g[i]){
                    num++;
                    j++;
                    break;
                }
                j++;
            }
        }
        return num;
    }

    /**
     * 双变量推进
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren02(int[] g, int[] s) {
        int num = 0;
        g=Arrays.stream(g).sorted().toArray();
        s=Arrays.stream(s).sorted().toArray();
        int i=0,j=0;
        while(i<g.length&&j<s.length){
            if(s[j]>=g[i]){
                i++;
                j++;
                num++;
            }else{
                j++;
            }
        }
        return num;
    }


    public static void main(String[] args) {
        int[] g = {10,9,8,7,6};
        int[] s = {9,7,8,6};
        int num = 0;
        num = findContentChildren02(g, s);
        System.out.println("num:" + num);
    }
}
