package com.xuelianyong.study.aguigu.datastruct.sparsearray;

public class SparseArrayObject {

    /**
     * 普通数组转换为稀疏数组
     *
     * @param normalArray
     * @return
     */
    public static int[][] normalToSparse(int[][] normalArray) {
        int[][] sparseArray = null;
        if (normalArray == null) {
            sparseArray = new int[1][3];
            sparseArray[0][0] = 0;
            sparseArray[0][1] = 0;
            sparseArray[0][2] = 0;
            return sparseArray;
        }
        int rowLength = normalArray.length;
        int columnLength = normalArray[0].length;
        //1.先遍历二维数组，得到非0数据个数
        int sum = 0;
        for (int[] row : normalArray) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = rowLength;
        sparseArray[0][1] = columnLength;
        //3.遍历二维数组，将非零的值存放到稀疏数组中
        int count = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (normalArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = normalArray[i][j];
                }
            }
        }
        sparseArray[0][2] = count;
        return sparseArray;
    }

    /**
     * 稀疏数组恢复成原始数组
     * 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
     * 2.在读取稀疏数组后几行的数据，并赋给原始二维数组
     *
     * @param sparseArray
     * @return
     */
    public static int[][] sparseToNormal(int[][] sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        //1.先根据稀疏数组第一行数据，创建原始二维数组
        //行数
        int rowLength = sparseArray[0][0];
        //列数
        int columnLength = sparseArray[0][1];
        //不为零的元素数
        int count = sparseArray[0][2];
        int[][] normalArray = new int[rowLength][columnLength];
        for (int i = 1; i <= count; i++) {
            int row = sparseArray[i][0];
            int column = sparseArray[i][1];
            int data = sparseArray[i][2];
            normalArray[row][column] = data;
        }
        return normalArray;
    }
}
