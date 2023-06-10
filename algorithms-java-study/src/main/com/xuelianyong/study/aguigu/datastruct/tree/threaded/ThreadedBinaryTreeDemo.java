package com.xuelianyong.study.aguigu.datastruct.tree.threaded;

/**
 * Created on 2021/1/19.
 *
 * @author junpeng li
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedNode root = new ThreadedNode(1, "tom");
        ThreadedNode node2 = new ThreadedNode(3, "jack");
        ThreadedNode node3 = new ThreadedNode(6, "smith");
        ThreadedNode node4 = new ThreadedNode(8, "mary");
        ThreadedNode node5 = new ThreadedNode(10, "king");
        ThreadedNode node6 = new ThreadedNode(14, "dim");
        //构建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        ThreadedNode leftNode = node5.getLeft();
        ThreadedNode rightNode = node5.getRight();
        System.out.println("10号节点的前驱节点是：" + leftNode);
        System.out.println("10号节点的后继节点是：" + rightNode);

        threadedBinaryTree.threadedList();
    }
}

