package com.datastruct.study.graph;

public class GraphDemo {


    public static void main(String[] args) {
        //结点个数
        int n = 8;
        String vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        GraphObject graphObject = new GraphObject(n);
        for (String vertex : vertexs) {
            graphObject.insertVertex(vertex);
        }
        //更新边的关系
        graphObject.insertEdge(0, 1, 1);
        graphObject.insertEdge(0, 2, 1);
        graphObject.insertEdge(1, 3, 1);
        graphObject.insertEdge(1, 4, 1);
        graphObject.insertEdge(3, 7, 1);
        graphObject.insertEdge(4, 7, 1);
        graphObject.insertEdge(2, 5, 1);
        graphObject.insertEdge(2, 6, 1);
        graphObject.insertEdge(5, 6, 1);
        //显示邻接矩阵
        graphObject.showGraph();
        graphObject.dfs();
        System.out.println();
    }
}
