package com.xuelianyong.study.aguigu.datastruct.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 2021/1/21.
 *
 * @author junpeng li
 */
public class Graph {

    /**
     * 存储顶点集合
     */
    private List<String> vertexList;
    /**
     * 存储图对应的临结矩阵
     */
    private int[][] edges;

    /**
     * 表示边的数目
     */
    private int numOfEdges;

    /**
     * 记录某个结点是否被访问
     */
    private boolean[] isVisited;

    /**
     * 构造器
     *
     * @param n：有多少个顶点
     */
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>();
        numOfEdges = 0;
    }

    /**
     * 插入结点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 插入边
     *
     * @param v1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 得到顶点的数目
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 得到边的数目
     *
     * @return
     */
    public int getNumOfEdge() {
        return numOfEdges;
    }

    /**
     * 根据索引获取订单值
     *
     * @param index
     * @return
     */
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 获取权重值
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 得到第一个邻接结点的下标
     *
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个结点的下标来获取下一个邻接结点
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }


    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 深度优先遍历算法
     *
     * @param isVisited
     * @param i
     */
    public void dfs(boolean[] isVisited, int i) {
        //首先访问该结点
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }


    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    public void bfs(boolean[] isVisited, int i) {
        //表示队列的头结点对应的下标
        int u;
        //邻接结点w
        int w;
        //队列，记录结点访问的顺序
        LinkedList<Integer> queue = new LinkedList<>();
        //访问结点，输出结点信息
        String vertex = getValueByIndex(i);
        System.out.print(vertex + "->");
        //标记已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            //取出队列的头节点下标
            u = queue.removeFirst();
            //得到第一个邻接结点的下标
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻结点
                w = getNextNeighbor(u, w);
            }
        }
    }

    /**
     * 显示图
     */
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    public static void main(String[] args) {
        String vertexStr[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(vertexStr.length);
        //添加顶点
        for (String vertex : vertexStr) {
            graph.insertVertex(vertex);
        }
        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        System.out.println("深度优先遍历~");
        graph.dfs();
        System.out.println();
        System.out.println("广度优先遍历~");
        graph.bfs();
        System.out.println();
    }
}
