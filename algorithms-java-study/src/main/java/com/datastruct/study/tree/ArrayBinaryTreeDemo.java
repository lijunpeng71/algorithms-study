package com.datastruct.study.tree;

/**
 * Created on 2021/1/19.
 *
 * @author junpeng li
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree binaryTree = new ArrayBinaryTree(arr);
        System.out.print("前序遍历：");
        binaryTree.preOrder(0);
        System.out.println();
        System.out.print("中序遍历：");
        binaryTree.infixOrder(0);
        System.out.println();
        System.out.print("后序遍历：");
        binaryTree.postOrder(0);
        System.out.println();
    }
}

class ArrayBinaryTree {
    /**
     * 存储数据节点的数组
     */
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 完成顺序存储二叉树的前序遍历
     *
     * @param index
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        System.out.print(arr[index] + "\t");
        //左子节点的索引
        int leftIndex = index * 2 + 1;
        if (leftIndex < arr.length) {
            preOrder(leftIndex);
        }
        //右子节点的索引
        int rightIndex = index * 2 + 2;
        if (rightIndex < arr.length) {
            preOrder(rightIndex);
        }
    }

    /**
     * 完成顺序存储二叉树的中序遍历
     *
     * @param index
     */
    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        //左子节点的索引
        int leftIndex = index * 2 + 1;
        if (leftIndex < arr.length) {
            infixOrder(leftIndex);
        }
        System.out.print(arr[index] + "\t");
        //右子节点的索引
        int rightIndex = index * 2 + 2;
        if (rightIndex < arr.length) {
            infixOrder(rightIndex);
        }
    }

    /**
     * 完成顺序存储二叉树的后序遍历
     *
     * @param index
     */
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        //左子节点的索引
        int leftIndex = index * 2 + 1;
        if (leftIndex < arr.length) {
            postOrder(leftIndex);
        }
        //右子节点的索引
        int rightIndex = index * 2 + 2;
        if (rightIndex < arr.length) {
            postOrder(rightIndex);
        }
        System.out.print(arr[index] + "\t");
    }
}
