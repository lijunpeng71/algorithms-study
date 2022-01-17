package com.study.aguigu.algorithms.sort;

/**
 * Created on 2021/1/18.
 *
 * @author junpeng li
 */
public class RadixSort {

    /**
     * 基数排序
     *
     * @param arr
     * @return
     */
    public static int[] radixSort(int[] arr) {
        //1.得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        //定义一个数组，表示10个桶，每个桶就是一个一维数组
        //说明：
        //1.二维数组包含10个一维数组
        //2.为了防止在放入数的时候，数据溢出，则每个一维数组，大小定位arr.length
        //3.名确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //针对每个元素的对应位进行排序处理，第一位是：个位，第二位是：十位，第三位是：百位
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来的数组)
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组中
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //处理完后，要把每个桶中的元素个数清零
                bucketElementCounts[k] = 0;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * arr.length);
        }
        //System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        int[] sortedArr = radixSort(arr);
        //System.out.println(Arrays.toString(arr));
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间：" + (endTime - startTime));
    }
}
