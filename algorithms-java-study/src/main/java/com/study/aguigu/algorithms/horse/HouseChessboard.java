package com.study.aguigu.algorithms.horse;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created on 2021/1/23.
 *
 * @author junpeng li
 */
public class HouseChessboard {
    /**
     * 棋盘的列数
     */
    private static int X;

    /**
     * 棋盘的行数
     */
    private static int Y;

    /**
     * 创建一个数组，标记棋盘的各个位置是否被访问过
     */
    private static boolean visited[];

    /**
     * 是否已经结束
     */
    private static boolean finished;

    /**
     * 马踏棋盘算法
     *
     * @param chessboard: 棋盘
     * @param row：第几行
     * @param column：第几列
     * @param step:       第几步
     */
    public static void travelChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        //把当前位置设置为已访问
        visited[row * X + column] = true;
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> pointList = next(new Point(column, row));
        sort(pointList);
        while (!pointList.isEmpty()) {
            //取出下一个可以走的位置
            Point point = pointList.remove(0);
            //判断改点是否已经访问过
            if (!visited[point.y * X + point.x]) {
                travelChessboard(chessboard, point.y, point.x, step + 1);
            }
        }
        //判断马儿是否完成了任务，使用step和应该走的步数比较
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    /**
     * 根据当前位置，计算马儿还能走哪些位置，并放到一个集合中，最多有8个位置
     *
     * @param currentPoint
     * @return
     */
    public static ArrayList<Point> next(Point currentPoint) {
        ArrayList<Point> pointList = new ArrayList<>();
        //创建一个point
        Point point = new Point();
        if ((point.x = currentPoint.x - 2) >= 0 && (point.y = currentPoint.y - 1) >= 0) {
            pointList.add(new Point(point));
        }
        if ((point.x = currentPoint.x - 1) >= 0 && (point.y = currentPoint.y - 2) >= 0) {
            pointList.add(new Point(point));
        }
        if ((point.x = currentPoint.x + 1) < X && (point.y = currentPoint.y - 2) >= 0) {
            pointList.add(new Point(point));
        }
        if ((point.x = currentPoint.x + 2) < X && (point.y = currentPoint.y - 1) >= 0) {
            pointList.add(new Point(point));
        }
        if ((point.x = currentPoint.x + 2) < X && (point.y = currentPoint.y + 1) < Y) {
            pointList.add(new Point(point));
        }
        if ((point.x = currentPoint.x + 1) < X && (point.y = currentPoint.y + 2) < Y) {
            pointList.add(new Point(point));
        }
        if ((point.x = currentPoint.x - 1) >= 0 && (point.y = currentPoint.y + 2) < Y) {
            pointList.add(new Point(point));
        }
        if ((point.x = currentPoint.x - 2) >= 0 && (point.y = currentPoint.y + 1) < Y) {
            pointList.add(new Point(point));
        }
        return pointList;
    }

    /**
     * 排序
     *
     * @param pointList
     */
    public static void sort(ArrayList<Point> pointList) {
        pointList.sort((o1, o2) -> {
            int o1NextNum = next(new Point(o1.y, o1.x)).size();
            int o2NextNum = next(new Point(o2.y, o2.x)).size();
            if (o1NextNum < o2NextNum) {
                return -1;
            } else if (o1NextNum == o2NextNum) {
                return 0;
            } else {
                return 1;
            }
        });
    }

    public static void main(String[] args) {
        X = 6;
        Y = 6;
        int row = 5;
        int column = 3;
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];
        long start = System.currentTimeMillis();
        travelChessboard(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start) + " ms");
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }
}
