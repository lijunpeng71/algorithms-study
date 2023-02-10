package com.study.zuoshen;

/**
 * @author lijunpeng02
 * @date 2023年02月10日 10:42
 */
public class Code05_BSNearRight {
    /**
     * 在arr上，找满足>=value的最右位置
     *
     * @param arr
     * @param value
     * @return
     */
    public static int bsNearRight(int[] arr, int value) {
        int L = 0, R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] <= value) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 6, 6, 7, 8, 9};
        int index = bsNearRight(arr, 6);
        System.out.println(index);
    }

}
