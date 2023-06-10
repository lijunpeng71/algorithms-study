package com.xuelianyong.study.aguigu.algorithms.kruskal;

import java.util.Arrays;

/**
 * Created on 2021/1/22.
 *
 * @author junpeng li
 */
public class KruskalAlgorithm {

    /**
     * 边的个数
     */
    private int edgeNum;
    /**
     * 顶点数组
     */
    private char[] vertexes;
    /**
     * 邻接矩阵
     */
    private int[][] matrix;

    /**
     * 不连通
     */
    private static final int INF = Integer.MAX_VALUE;

    /**
     * 构造器
     *
     * @param vertexes
     * @param matrix
     */
    public KruskalAlgorithm(char[] vertexes, int[][] matrix) {
        //初始化顶点数和边的个数
        int vLen = vertexes.length;
        //初始化顶点,复杂拷贝的方式
        this.vertexes = new char[vLen];
        for (int i = 0; i < vertexes.length; i++) {
            this.vertexes[i] = vertexes[i];
        }
        //初始化边，使用的是复制拷贝方式
        this.matrix = new int[vLen][vLen];
        for (int i = 0; i < vLen; i++) {
            for (int j = 0; j < vLen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边
        for (int i = 0; i < vLen; i++) {
            for (int j = i + 1; j < vLen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    /**
     * 打印邻接矩阵
     */
    public void print() {
        System.out.println("邻接矩阵为：");
        for (int i = 0; i < vertexes.length; i++) {
            for (int j = 0; j < vertexes.length; j++) {
                System.out.printf("%12d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 对边进行排序
     *
     * @param edges
     */
    public void sortEdges(EData[] edges) {
        EData temp = null;
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].getWeight() > edges[j + 1].getWeight()) {
                    temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 获取当前节点的索引
     *
     * @param vertex
     * @return
     */
    public int getPosition(char vertex) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == vertex) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中的边，放到EData数组中
     *
     * @return
     */
    public EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexes.length; i++) {
            for (int j = i + 1; j < vertexes.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexes[i], vertexes[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点，用于判断两个顶点的终点是否相同
     *
     * @param ends
     * @param i
     * @return
     */
    public int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }


    public void kruskal() {
        //表示最后结果数组的索引
        int index = 0;
        //用于保存已有最小生成树中的每个顶点在最小生成树中的终点
        int[] ends = new int[edgeNum];
        //创建结果数组，保存最后的最小生成树
        EData[] rets = new EData[edgeNum];

        //获取图中所有的边的集合，一共12条边
        EData[] edges = getEdges();
        System.out.println("图的边的集合=" + Arrays.toString(edges) + " 共" + edges.length);
        sortEdges(edges);
        //遍历edges数组，将边添加到最小生成树时，判断是准备加入的边，是否形成了回路，如果没有，就加入rets,否则不能加入
        for (int i = 0; i < edgeNum; i++) {
            //获取到第i条边的第一个顶点
            int p1 = getPosition(edges[i].getStart());
            //获取到第i条边的第二个顶点
            int p2 = getPosition(edges[i].getEnd());

            //获取p1这个顶点在已有最小生成树中的终点
            int m = getEnd(ends, p1);
            //获取p2这个顶点在已有最小生成树中的终点
            int n = getEnd(ends, p2);
            if (m != n) {
                //设置m在已有最小生成树中的终点<E,F>
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }
        System.out.println(Arrays.toString(rets));
    }

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(vertexes, matrix);
        kruskalAlgorithm.kruskal();
    }
}

/**
 * 创建一个类EData,它的对象实例就是表示一条边
 */
class EData {
    /**
     * 边的起点
     */
    private char start;
    /**
     * 边的终点
     */
    private char end;

    /**
     * 权值
     */
    private int weight;

    /**
     * 构造器
     *
     * @param start
     * @param end
     * @param weight
     */
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public char getStart() {
        return start;
    }

    public void setStart(char start) {
        this.start = start;
    }

    public char getEnd() {
        return end;
    }

    public void setEnd(char end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData[" + "<" + start + ", " + end + ">, weight=" + weight + ']';
    }
}
