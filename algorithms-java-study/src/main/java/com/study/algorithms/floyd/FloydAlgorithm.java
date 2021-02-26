package com.study.algorithms.floyd;

import java.util.Arrays;

/**
 * Created on 2021/1/23.
 *
 * @author junpeng li
 */
public class FloydAlgorithm {


    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertexes.length][vertexes.length];
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};

        //创建Graph对象
        Graph graph = new Graph(vertexes.length, matrix, vertexes);
        graph.floyd();
        graph.show();
    }
}

class Graph {

    /**
     * 存放顶点的数据
     */
    private char[] vertexes;

    /**
     * 保存，从各个顶点出发到其他顶点的距离，最后的结果，也是保存在该数组
     */
    private int[][] dis;

    /**
     * 保存到达目标顶点的前驱顶点
     */
    private int[][] pre;

    /**
     * 构造方法
     *
     * @param length:大小
     * @param matrix:邻接矩阵
     * @param vertexes:顶点数组
     */
    public Graph(int length, int[][] matrix, char[] vertexes) {
        this.vertexes = vertexes;
        this.dis = matrix;
        this.pre = new int[length][length];
        //对pre数组进行初始化，存放的是前驱顶点的下标
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    /**
     * 显示
     */
    public void show() {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int k = 0; k < dis.length; k++) {
            //先将pre数组输出一行
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertexes[pre[k][i]] + " ");
            }
            System.out.println();
            //输出dis数组的一行数据
            for (int i = 0; i < dis.length; i++) {
                System.out.print("[" + vertexes[k] + "->" + vertexes[i] + "]:" + dis[k][i] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    /**
     * 弗洛伊德算法
     */
    public void floyd() {
        //变量保存距离
        int len = 0;
        //对中间顶点遍历，k就是中间顶点的下标
        for (int k = 0; k < dis.length; k++) {
            //从i顶点开始出发
            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; i < dis.length; i++) {
                    //求出从i顶点出发，经过k中间顶点，到达j顶点距离
                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]) {
                        //更新距离
                        dis[i][j] = len;
                        //更新前驱顶点
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}
