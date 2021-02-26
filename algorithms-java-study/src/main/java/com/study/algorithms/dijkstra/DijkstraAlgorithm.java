package com.study.algorithms.dijkstra;

import java.util.Arrays;

/**
 * Created on 2021/1/23.
 *
 * @author junpeng li
 */
public class DijkstraAlgorithm {

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //邻接矩阵
        int[][] matrix = new int[vertexes.length][vertexes.length];

        //表示不可联通
        final int N = 65535;

        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
        //创建Graph对象
        Graph graph = new Graph(vertexes, matrix);
        graph.dijkstra(6);
        graph.showDijkstra();
    }

}

/**
 * 已访问顶点集合
 */
class VisitedVertex {
    /**
     * 记录各个顶点是否访问过
     * 1：表示访问过
     * 0：表示未访问
     */
    public int[] already_arr;

    /**
     * 每个下标对应的值为前一个顶点下标
     */
    public int[] pre_visited;

    /**
     * 记录出发顶点到其他所有顶点的距离
     */
    public int[] dis;

    /**
     * 构造方法
     *
     * @param length:表示顶点的个数
     * @param index：出发顶点对应的下标，比如G顶点，下标就是6
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        //初始化dis数组
        Arrays.fill(dis, 65535);
        //设置出发顶点被访问过
        this.already_arr[index] = 1;
        //设置出发顶点的访问距离为0
        this.dis[index] = 0;
    }


    /**
     * 判断index顶点是否被访问过
     *
     * @param index
     * @return
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     *
     * @param index
     * @param len
     */
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    /**
     * 更新pre这个顶点的前驱顶点为index
     *
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * 获取出发顶点到index顶点的距离
     *
     * @param index
     * @return
     */
    public int getDis(int index) {
        return dis[index];
    }

    /**
     * 继续选择并返回新的访问顶点，比如这里G完成后，就是A顶点作为新的访问顶点
     *
     * @return
     */
    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }
}

class Graph {

    /**
     * 顶点数组
     */
    private char[] vertexes;

    /**
     * 邻接矩阵
     */
    private int[][] matrix;

    /**
     * 已经访问过的顶点
     */
    private VisitedVertex visitedVertex;

    /**
     * 构造方法
     *
     * @param vertexes
     * @param matrix
     */
    public Graph(char[] vertexes, int[][] matrix) {
        this.vertexes = vertexes;
        this.matrix = matrix;
    }

    /**
     * 显示图
     */
    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 帝杰斯算法
     *
     * @param index
     */
    public void dijkstra(int index) {
        visitedVertex = new VisitedVertex(vertexes.length, index);
        //更新index顶点到周围顶点的距离
        update(index);
        for (int j = 1; j < vertexes.length; j++) {
            //选择并返回新的访问结点
            index = visitedVertex.updateArr();
            update(index);
        }
    }


    public void showDijkstra() {
        System.out.println(Arrays.toString(visitedVertex.already_arr));
        System.out.println(Arrays.toString(visitedVertex.pre_visited));
        System.out.println(Arrays.toString(visitedVertex.dis));
    }

    /**
     * 更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
     *
     * @param index
     */
    public void update(int index) {
        int len = 0;
        //根据遍历我们的邻接矩阵的matrix[index]行
        for (int j = 0; j < matrix[index].length; j++) {
            //从出发顶点到index顶点的距离+从index顶点到j顶点的距离的和
            len = visitedVertex.getDis(index) + matrix[index][j];
            //如果j顶点没有被访问过，并且len小于出发顶点到j顶点的距离，就需要更新
            if (!visitedVertex.in(j) && len < visitedVertex.getDis(j)) {
                //更新j顶点的前驱为index顶点
                visitedVertex.updatePre(j, index);
                //更新出发顶点到j顶点的距离
                visitedVertex.updateDis(j, len);
            }
        }
    }
}
