package com.xuelianyong.study.leetcode;

import com.xuelianyong.study.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P000102_LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while (count > 0) {
                TreeNode<Integer> node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            resultList.add(levelList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> resultList = levelOrder(root);
        System.out.println(resultList.toString());
    }
}
