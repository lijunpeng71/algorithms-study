package com.study.algorithms.sort;

import java.util.Arrays;

/**
 * Created on 2021/1/19.
 *
 * @author junpeng li
 */
public class HeapSort {
    /**
     * 堆排序
     *
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr) {
        int temp = 0;
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //将堆顶元素与末尾元素交换，将最大元素下沉到数组末端
        //重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        return arr;
    }

    /**
     * 调整堆
     *
     * @param arr：待调整的数组
     * @param i：表示非叶子结点在数组中索引
     * @param length：表示对多少个元素继续调整，length是逐渐减少的
     */
    public static void adjustHeap(int arr[], int i, int length) {
        //先取出当前元素的值，保存在临时变量
        //开始调整
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //说明左子结点的值小于右子结点的值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //k指向右子结点
                k++;
            }
            //如果子节点大于父节点
            if (arr[k] > temp) {
                //把较大的值赋给当前结点
                arr[i] = arr[k];
                //i指向k,继续循环比较
                i = k;
            } else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的树的最大值，放到了最顶端
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 6, 8, 7, 3, 0, 2, 5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
