package com.study.leetcode;

import com.study.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P000094InorderTraversal {

    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (true) {
            TreeNode<Integer> node = stack.pop();
            list.add(node.val);
            if (node.right != null) {

            }
        }
    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (true) {
            TreeNode<Integer> node = stack.pop();
            list.add(node.val);
            if (node.right != null) {

            }
        }
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode<Integer> curNode = root;
        while (curNode != null || !stack.empty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            list.add(curNode.val);
            curNode = curNode.right;
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
