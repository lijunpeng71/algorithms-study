package com.study.zuoshen.algorithmbasic2020.class01;

/**
 * @author lijunpeng02
 * @date 2023年02月10日 11:17
 */
public class Code06_BSAwesome {


    public static int bsAwesome(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int L = 1, R = arr.length - 2;
        //先比较开头
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                R = mid - 1;
            } else if (arr[mid] > arr[mid - 1]) {
                L = mid + 1;
            }
        }
        return L;
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 3};
        int index = bsAwesome(arr);
        System.out.println(index);
    }
}
