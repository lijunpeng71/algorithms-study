package com.study.aguigu.datastruct.tree;

import java.util.LinkedList;

/**
 * Created on 2021/1/18.
 *
 * @author junpeng li
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        System.out.println("前序遍历:");
        binaryTree.preOrder();
        binaryTree.delNode(5);
        System.out.println("删除节点");
        binaryTree.preOrder();
    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 前序查找
     *
     * @param no
     * @return
     */
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return this.root.preOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法查找");
        }
        return null;
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历查找
     *
     * @param no
     * @return
     */
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法查找");
        }
        return null;
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 后序遍历查找
     *
     * @param no
     * @return
     */
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return this.root.postOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法查找");
        }
        return null;
    }

    /**
     * 逐层遍历
     *
     * @return
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }
        LinkedList<HeroNode> list = new LinkedList<>();
        HeroNode currentNode = null;
        list.offer(root);
        while (!list.isEmpty()) {
            currentNode = list.poll();
            System.out.print(currentNode.getName() + "=>");
            if (currentNode.getLeft() != null) {
                list.offer(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                list.offer(currentNode.getRight());
            }
        }
    }


    public void delNode(int no) {
        if (this.root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除~");
        }
    }

}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ']';
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

    /**
     * 前序遍历查找
     *
     * @param no
     * @return
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进行前序遍历~");
        //比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        //判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //当前节点的右子节点为空，如果不为空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }


    /**
     * 中序遍历查找
     *
     * @param no
     * @return
     */
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        //判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进行中序遍历~");
        //比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        //当前节点的右子节点为空，如果不为空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 中序遍历查找
     *
     * @param no
     * @return
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        //判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //当前节点的右子节点为空，如果不为空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进行后序遍历~");
        //比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        return null;
    }

    /**
     * 删除节点
     * 1.因为我们的二叉树是单向的，所以我们是判断当前节点的子节点是否需要删除节点，而不能去判断当前这个节点是不是需要删除节点
     * 2.如果当前节点的左子节点不为空，并且左子节点就是要删除节点，就将this.left=null;并且返回(结束递归删除)
     * 3.如果当前节点的右子节点不为空，并且右子节点就是要删除节点，就将this.right=null;并且返回(结束递归删除)
     * 4.如果第2和第3步没有删除节点，那么我们就需要向左字数进行递归删除
     * 5.如果第4步没有删除节点，则应向右子树进行递归删除
     *
     * @param no
     * @return
     */
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

}