package com.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *  
 *
 * 提示:
 *
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * -5 * 104 <= starti < endi <= 5 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P000435NonOverlappingIntervals {

    /**
     * 暴力解法 O(N^2)
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals01(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int n=intervals.length;
        int[] f=new int[n];
        Arrays.fill(f,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(intervals[j][1]<=intervals[i][0]){
                    f[i]=Math.max(f[i],f[j]+1);
                }
            }
        }
        return n-Arrays.stream(f).max().getAsInt();
    }

    /**
     *
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals02(int[][] intervals) {
        return 0;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int sum = eraseOverlapIntervals01(intervals);
        System.out.println("sum:" + sum);
    }
}
