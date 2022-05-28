package com.study.zuoshen.algorithmbasic2020.class01;

/**
 * 二分查找
 */
public class Code04_BSExist {

    /**
     * 判断给定的值是否存在
     *
     * @param sortedArr
     * @param num
     * @return
     */
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R) {
            mid = L + (L - R) >> 1;
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }

    public static void main(String[] args) {

    }
}
