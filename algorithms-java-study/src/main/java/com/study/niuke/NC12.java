package com.study.niuke;

import com.study.niuke.common.TreeNode;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class NC12 {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length <= 0 || in == null || in.length <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                index = i;
                break;
            }
        }
        int[] preLeft = new int[index], preRight = new int[pre.length - index - 1];
        int[] inLeft = new int[index], inRight = new int[pre.length - index - 1];
        for (int i = 0; i < index; i++) {
            preLeft[i] = pre[i + 1];
            inLeft[i] = in[i];
        }
        for (int i = index; i < in.length - 1; i++) {
            preRight[i - index] = pre[i + 1];
            inRight[i - index] = in[i + 1];
        }
        root.left = reConstructBinaryTree(preLeft, inLeft);
        root.right = reConstructBinaryTree(preRight, inRight);
        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(pre, in);
        preOrder(root);
        System.out.println();
    }
}
