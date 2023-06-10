package com.xuelianyong.study.zuoshen.algorithmbasic2020.class01;

/**
 * 选择排序代码
 */
public class Code01_SelectionSort {

    /**
     * 选择排序思路
     * 1、把数组分成两部分，一部分是已经排过序的，一部分是还未排序的
     * 2、每次从未排序的部分找到最小的值，然后插入到排过序部分的尾部
     *
     * @param arrs
     */
    public static void selectionSort(int[] arrs) {
        if (arrs == null || arrs.length < 2) {
            return;
        }
        //执行步骤
        // 第1步：遍历 0~n-1 找到最小值，放到0位置上
        // 第2步：遍历 1~n-1 找到最小值，放到1未知上
        // ……
        // 第n-1步：遍历n-1~n-1 找到最小值，放到n-1位置上
        for (int i = 0; i < arrs.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[minIndex] > arrs[j]) {
                    minIndex = j;
                }
            }
            swap(arrs,i,minIndex);
        }
    }

    public static void swap(int[] arrs,int i, int j) {
        int temp=arrs[i];
        arrs[i]=arrs[j];
        arrs[j]=temp;
    }

    public static void printShow(int[] arrs) {
        for (int arr:arrs){
            System.out.print(arr+"\t");
        }
        System.out.println();
    }

    /**
     * 随机生成数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArr(int maxSize,int maxValue){
        int[] arr=new int[(int) ((maxSize+1)*Math.random())];
        for(int i=0;i<arr.length;i++){
            arr[i]= ((int)((maxValue+1)*Math.random())-(int)(maxValue*Math.random()));
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arrs = generateRandomArr(1000,5000);
        printShow(arrs);
        selectionSort(arrs);
        printShow(arrs);

    }
}
