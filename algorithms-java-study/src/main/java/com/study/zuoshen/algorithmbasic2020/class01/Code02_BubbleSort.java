package com.study.zuoshen.algorithmbasic2020.class01;

/**
 * 冒泡排序
 */
public class Code02_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j-1]>arr[j]){
                    swap(arr,j,j-1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printShow(int[] arr) {
        for (int temp:arr){
            System.out.print(temp+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 6, 1, 8, 3, 5};
        printShow(arr);
        bubbleSort(arr);
        printShow(arr);
    }
}
