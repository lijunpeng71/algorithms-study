package com.study.datastruct.tree.threaded;

/**
 * 先创建ThreadedNode节点
 */
public class ThreadedNode {
    /**
     * 编号
     */
    private int no;
    /**
     * 姓名
     */
    private String name;
    /**
     * 左节点
     */
    private ThreadedNode left;
    /**
     * 右节点
     */
    private ThreadedNode right;

    /**
     * 如果leftType==0表示指向的是左节点
     * 如果leftType==1表示指向前驱节点
     */
    private int leftType;

    /**
     * 如果rightType==0表示指向的是右节点
     * 如果rightType==1表示指向前后继节点
     */
    private int rightType;


    public ThreadedNode(int no, String name) {
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

    public ThreadedNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedNode left) {
        this.left = left;
    }

    public ThreadedNode getRight() {
        return right;
    }

    public void setRight(ThreadedNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "ThreadedNode[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ']';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        //输出父节点
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
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
    public ThreadedNode preOrderSearch(int no) {
        System.out.println("进入前序遍历~");
        //比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        ThreadedNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树前序遍历
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
    public ThreadedNode infixOrderSearch(int no) {
        System.out.println("进入前序遍历~");
        ThreadedNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    /**
     * 后序遍历查找
     *
     * @param no
     * @return
     */
    public ThreadedNode postOrderSearch(int no) {
        ThreadedNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入后序遍历~");
        //比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        return null;
    }
}