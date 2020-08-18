package com.datastruct.study.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphObject {

    /**
     * 存储顶点集合
     */
    private List<String> vertexList;

    /**
     * 存储图对应的邻接矩阵
     */
    private int[][] edges;

    /**
     * 表示边的数目
     */
    private int numOfEdges;

    /**
     * 构造器
     *
     * @param n
     */
    public GraphObject(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>();
    }
}
