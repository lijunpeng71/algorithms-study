package com.xuelianyong.study.others;

import java.util.Arrays;

public class Algorithm002 {


    public static int[] intersection(int arr1[], int arr2[]) {
        if (arr1 == null || arr1.length <= 0 || arr2 == null || arr2.length <= 0) {
            return null;
        }
        int[] result = new int[arr1.length > arr2.length ? arr2.length : arr1.length];
        int i = 0;
        int index1 = 0, index2 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] == arr2[index2]) {
                result[i] = arr2[index2];
                index1++;
                index2++;
                i++;
            } else if (arr1[index1] < arr2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        if (result.length > 0) {
            
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {3, 9, 10};
        int[] result = intersection(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}
