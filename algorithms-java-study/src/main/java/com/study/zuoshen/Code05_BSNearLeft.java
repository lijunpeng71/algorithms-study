<<<<<<<< HEAD:algorithms-java-study/src/main/java/com/study/zuoshen/Code05_BSNearLeft.java
package com.study.zuoshen;

/**
 * @author lijunpeng02
 * @date 2023年02月10日 10:42
========
package com.study.zuoshen.algorithmbasic2020.class01;

/**
 * Created on 2022/6/1.
 *
 * @author Administrator
>>>>>>>> origin/master:algorithms-java-study/src/main/java/com/study/zuoshen/algorithmbasic2020/class01/Code05_BSNearLeft.java
 */
public class Code05_BSNearLeft {

    /**
     * 在有序数组arr上，找到满足>=value的最左位置
     *
     * @param arr
     * @param value
     * @return
     */
<<<<<<<< HEAD:algorithms-java-study/src/main/java/com/study/zuoshen/Code05_BSNearLeft.java
    public static int bsNearLeft(int[] arr, int value) {
        int L = 0, R = arr.length - 1;
========
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
>>>>>>>> origin/master:algorithms-java-study/src/main/java/com/study/zuoshen/algorithmbasic2020/class01/Code05_BSNearLeft.java
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
<<<<<<<< HEAD:algorithms-java-study/src/main/java/com/study/zuoshen/Code05_BSNearLeft.java
        int[] arr = {0, 1, 2, 3, 4, 6, 6, 7, 8, 9};
        int index = bsNearLeft(arr, 6);
        System.out.println(index);
========
        int[] arr = {1, 2, 3, 4, 5, 5, 5, 7, 9};
        int index = nearestIndex(arr, 6);
        System.out.println("index:" + index);
>>>>>>>> origin/master:algorithms-java-study/src/main/java/com/study/zuoshen/algorithmbasic2020/class01/Code05_BSNearLeft.java
    }

}
