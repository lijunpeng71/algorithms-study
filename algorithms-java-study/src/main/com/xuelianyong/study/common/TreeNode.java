package com.xuelianyong.study.common;

public class TreeNode<T> {
    public T val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}