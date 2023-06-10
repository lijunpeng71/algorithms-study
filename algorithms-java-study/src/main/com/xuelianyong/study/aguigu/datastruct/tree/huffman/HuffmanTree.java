package com.xuelianyong.study.aguigu.datastruct.tree.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 2021/1/20.
 *
 * @author junpeng li
 */
public class HuffmanTree {

    /**
     * 1.遍历arr数组
     * 2.将arr的每个元素构成一个node
     * 3.ArrayList中
     *
     * @param arr
     */
    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodeList = new ArrayList<>();
        for (int value : arr) {
            nodeList.add(new Node(value));
        }
        while (nodeList.size() > 1) {
            //排序 从小到大
            Collections.sort(nodeList);
            System.out.println("nodeList:" + nodeList);
            //(1)取出权值最小的结点
            Node leftNode = nodeList.get(0);
            //(2)取出权值次小的结点
            Node rightNode = nodeList.get(1);
            //(3)构建一棵新的二叉树
            Node parent = new Node(leftNode.getValue() + rightNode.getValue());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            //(4)从ArrayList删除处理过的二叉树
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
            //(5)将parent加入到nodeList中
            nodeList.add(parent);
        }
        return nodeList.get(0);
    }

}

class Node implements Comparable<Node> {
    /**
     * 结点权值
     */
    private int value;
    /**
     * 指向左子结点
     */
    private Node left;
    /**
     * 指向右子结点
     */
    private Node right;


    public Node(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node[" +
                "value=" + value +
                ']';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
