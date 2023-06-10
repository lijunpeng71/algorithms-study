package com.xuelianyong.study.zuoshen.algorithmbasic2020.class01;

/**
 * @author lijunpeng02
 * @date 2023年02月10日 10:42
 */
public class Code05_BSNearLeft {

    /**
     * 在有序数组arr上，找到满足>=value的最左位置
     *
     * @param arr
     * @param value
     * @return
     */
    public static int bsNearLeft(int[] arr, int value) {
        int L = 0, R = arr.length - 1;

        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 6, 6, 7, 8, 9};
        int index = bsNearLeft(arr, 6);
        System.out.println(index);
    }

}
