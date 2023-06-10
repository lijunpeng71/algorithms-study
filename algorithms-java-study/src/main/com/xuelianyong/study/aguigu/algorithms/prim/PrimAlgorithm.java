package com.xuelianyong.study.aguigu.algorithms.prim;

import java.util.Arrays;

/**
 * Created on 2021/1/22.
 *
 * @author junpeng li
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertexes = data.length;
        //邻接矩阵的关系使用二维数组表示，10000这个大数，表示两个点不联通
        int[][] edges = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        //创建Graph
        Graph graph = new Graph(vertexes);
        MinTree minTree = new MinTree();
        //生成图
        minTree.createGraph(graph, vertexes, data, edges);
        //输出
        minTree.showGraph(graph);
        minTree.prim(graph, 1);

    }
}

class MinTree {
    /**
     * 生成图
     *
     * @param graph
     * @param vertexes
     * @param data
     * @param edges
     */
    public void createGraph(Graph graph, int vertexes, char[] data, int[][] edges) {
        int i, j;
        for (i = 0; i < vertexes; i++) {
            graph.getData()[i] = data[i];
            for (j = 0; j < vertexes; j++) {
                graph.getEdges()[i][j] = edges[i][j];
            }
        }
    }

    /**
     * 遍历图
     *
     * @param graph
     */
    public void showGraph(Graph graph) {
        for (int[] link : graph.getEdges()) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 得到最小生成树
     *
     * @param graph
     * @param vertex
     */
    public void prim(Graph graph, int vertex) {
        //标记顶点是否被访问过
        int visited[] = new int[graph.getVertexes()];
        //把当前结点标记为已访问
        visited[vertex] = 1;
        //h1和h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        //将minWeight初始成一个大数，后面在便利过程中，会被替换
        int minWeight = 10000;
        for (int k = 1; k < graph.getVertexes(); k++) {
            for (int i = 0; i < graph.getVertexes(); i++) {
                for (int j = 0; j < graph.getVertexes(); j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.getEdges()[i][j] < minWeight) {
                        minWeight = graph.getEdges()[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边<" + graph.getData()[h1] + "," + graph.getData()[h2] + "> 权值：" + minWeight);
            //将当前这个节点标记为已经访问
            visited[h2] = 1;
            //minWeight重新设置为最大值10000
            minWeight = 10000;
        }
    }
}


/**
 *
 */
class Graph {
    //表示图的结点个数
    private int vertexes;
    //存放结点数据
    private char[] data;
    //存放边，就是我们的邻接矩阵
    private int[][] edges;

    public Graph(int vertexes) {
        this.vertexes = vertexes;
        data = new char[vertexes];
        edges = new int[vertexes][vertexes];
    }

    public int getVertexes() {
        return vertexes;
    }

    public void setVertexes(int vertexes) {
        this.vertexes = vertexes;
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }

    public int[][] getEdges() {
        return edges;
    }

    public void setEdges(int[][] edges) {
        this.edges = edges;
    }
}
