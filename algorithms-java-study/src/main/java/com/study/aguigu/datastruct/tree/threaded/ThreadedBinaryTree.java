package com.study.aguigu.datastruct.tree.threaded;

/**
 * 定义ThreadedBinaryTree实现了线索化功能的二叉树
 */
public class ThreadedBinaryTree {

    private ThreadedNode root;
    //为了实现线索化，需要前驱结点的指针
    /**
     * 在递归进行线索化时，pre总是保留前一个结点
     */
    private ThreadedNode pre;

    public void setRoot(ThreadedNode root) {
        this.root = root;
    }


    public void threadedList() {
        //定义一个便令，存储当前遍历的结点，从root开始
        ThreadedNode node = root;
        while (node != null) {
            //循环的找到leftType==1的节点，第一个找到就是8节点
            //后面随着遍历二变化，因为leftType==1时，说明该结点是按照线索化处理后的有效结点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前结点
            System.out.println(node);
            //如果当前节点的右指针指向的是后继结点，就一直输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }

    /**
     * 编写对二叉树进行中序线索化的方法
     *
     * @param node
     */
    public void threadedNodes(ThreadedNode node) {
        if (node == null) {
            return;
        }
        /**
         * 一、先线索化左子树
         */
        threadedNodes(node.getLeft());
        /**
         * 二、线索化当前节点
         */
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        /**
         * 处理后继结点
         */
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        /**
         * 三、线索化右子树
         */
        threadedNodes(node.getRight());
    }

}