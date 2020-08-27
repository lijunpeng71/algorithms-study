package com.datastruct.study.tree;

public class BinaryTreeObject {
}

/**
 * 英雄结点
 */
class HeroNode {
    /**
     * 编号
     */
    private int no;
    /**
     * 姓名
     */
    private String name;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 左结点
     */
    private HeroNode leftNode;
    /**
     * 右结点
     */
    private HeroNode rightNode;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HeroNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(HeroNode leftNode) {
        this.leftNode = leftNode;
    }

    public HeroNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(HeroNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "HeroNode {no=" + no + ", name='" + name + ", nickname='" + nickname + "}";
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        //先输出父结点
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }
        //递归向右子树前序遍历
        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.leftNode != null) {
            this.leftNode.infixOrder();
        }
        System.out.println(this);
        //递归向右子树中序遍历
        if (this.rightNode != null) {
            this.rightNode.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        //递归向左子树后序遍历
        if (this.leftNode != null) {
            this.leftNode.postOrder();
        }
        //递归向右子树后序遍历
        if (this.rightNode != null) {
            this.rightNode.postOrder();
        }
        System.out.println(this);
    }

}