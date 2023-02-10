<<<<<<<< HEAD:algorithms-java-study/src/main/java/com/study/zuoshen/Code05_BSNearRight.java
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
>>>>>>>> origin/master:algorithms-java-study/src/main/java/com/study/zuoshen/algorithmbasic2020/class01/Code05_BSNearRight.java
 */
public class Code05_BSNearRight {

    /**
<<<<<<<< HEAD:algorithms-java-study/src/main/java/com/study/zuoshen/Code05_BSNearRight.java
     * 在arr上，找满足>=value的最右位置
========
     * 在有序数组arr上，找到满足>=value的最右位置
>>>>>>>> origin/master:algorithms-java-study/src/main/java/com/study/zuoshen/algorithmbasic2020/class01/Code05_BSNearRight.java
     *
     * @param arr
     * @param value
     * @return
     */
<<<<<<<< HEAD:algorithms-java-study/src/main/java/com/study/zuoshen/Code05_BSNearRight.java
    public static int bsNearRight(int[] arr, int value) {
        int L = 0, R = arr.length - 1;
========
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
>>>>>>>> origin/master:algorithms-java-study/src/main/java/com/study/zuoshen/algorithmbasic2020/class01/Code05_BSNearRight.java
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                R = mid - 1;
            } else {
                index = mid;
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
<<<<<<<< HEAD:algorithms-java-study/src/main/java/com/study/zuoshen/Code05_BSNearRight.java
        int[] arr = {0, 1, 2, 3, 4, 6, 6, 7, 8, 9};
        int index = bsNearRight(arr, 6);
        System.out.println(index);
========
        int[] arr = {1, 2, 3, 4, 5, 5, 5, 7, 9};
        int index = nearestIndex(arr, 5);
        System.out.println("index:" + index);
>>>>>>>> origin/master:algorithms-java-study/src/main/java/com/study/zuoshen/algorithmbasic2020/class01/Code05_BSNearRight.java
    }

}
