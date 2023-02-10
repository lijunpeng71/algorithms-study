package com.study.zuoshen;

/**
 * @author lijunpeng02
 * @date 2023年02月09日 09:35
 */
public class Code04_BSExist {

    /**
     * 二分查找  查找指定元素是否在数组中存在
     * @param arr
     * @param L
     * @param R
     * @param value
     * @return
     */
    public static boolean bsExist(int[] arr, int L, int R, Integer value) {
        if (arr == null) {
            return false;
        }
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] == value) {
                return true;
            }
            if (arr[mid] < value) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[L] == value;
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean exist = bsExist(arr, 0, arr.length, 18);
        System.out.println(exist);
    }
}
