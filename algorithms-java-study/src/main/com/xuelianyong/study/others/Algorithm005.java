package com.xuelianyong.study.others;

import com.xuelianyong.study.common.TreeNode;

import java.util.*;

/**
 * 求二叉树两个节点的最近公共父节点的两种方法
 */
public class Algorithm005 {

    /**
     * 查找二叉树两个节点的最近公共父节点(非递归实现)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor01(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = getPath(root, p);
        List<TreeNode> listQ = getPath(root, q);
        Set<TreeNode> set = new HashSet<>();
        for (int i = 0; i < listP.size(); i++) {
            set.add(listP.get(i));
        }
        for (int i = 0; i < listQ.size(); i++) {
            if (set.contains(listQ.get(i))) {
                return listQ.get(i);
            }
        }
        return null;
    }

    /**
     * 获取所查节点的路径
     *
     * @param root
     * @param search
     * @return
     */
    public static List<TreeNode> getPath(TreeNode root, TreeNode search) {
        List<TreeNode> list = new LinkedList<>();
        isContainNode(root, search, list);
        return list;
    }

    /**
     * 递归判断是否包含
     *
     * @param root
     * @param p
     * @param list
     * @return
     */
    public static boolean isContainNode(TreeNode root, TreeNode p, List<TreeNode> list) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            list.add(p);
            return true;
        } else if (isContainNode(root.left, p, list) || isContainNode(root.right, p, list)) {
            list.add(root);
            return true;
        }
        return false;
    }

    /**
     * 递归实现
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor02(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor02(root.left, p, q);
        TreeNode right = lowestCommonAncestor02(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        left.left = leftLeft;
        left.right = leftRight;
        TreeNode right = new TreeNode(3);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);
        right.left = rightLeft;
        right.right = rightRight;
        treeNode.left = left;
        treeNode.right = right;
        TreeNode parent = lowestCommonAncestor02(treeNode, new TreeNode(6), new TreeNode(7));
        System.out.println(parent.val);
    }
}
