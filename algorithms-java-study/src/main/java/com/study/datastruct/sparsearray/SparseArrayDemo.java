package com.study.datastruct.sparsearray;

public class SparseArrayDemo {

    /**
     * 数组的行数
     */
    public static final int ARRAY_ROW_LENGTH = 11;
    /**
     * 数组的列数
     */
    public static final int ARRAY_COLUMN_LENGTH = 11;

    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        int normalChessArr[][] = new int[ARRAY_ROW_LENGTH][ARRAY_COLUMN_LENGTH];
        normalChessArr[1][2] = 1;
        normalChessArr[2][3] = 2;
        normalChessArr[4][5] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组为：");
        for (int[] row : normalChessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将二维数据 转成 稀疏数组
        int[][] sparseArray = SparseArrayObject.normalToSparse(normalChessArr);
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为：");
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将稀疏数组转换为原始数组
        int[][] normalArray = SparseArrayObject.sparseToNormal(sparseArray);
        //输出原始的二维数组
        System.out.println("输出转换的二维数组为：");
        for (int[] row : normalArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
