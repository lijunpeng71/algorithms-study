package com.study.datastruct.tree.binarysort;

/**
 * Created on 2021/1/21.
 *
 * @author junpeng li
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.delNode(7);
        Node root = binarySortTree.getRoot();
        System.out.println(root);
    }
}

/**
 * 排序二叉树
 */
class BinarySortTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历~");
        }
    }

    /**
     * 查找结点
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 查找父结点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 删除结点
     *
     * @param value
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //1.需要先去找到要删除的结点 targetNode;
            Node targetNode = search(value);
            //如果没有要找到要删除的结点
            if (targetNode == null) {
                return;
            }
            //如果我们发现当前这棵二叉树只有一个结点
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }
            //找到targetNode的父节点
            Node parent = searchParent(value);
            //如果要删除的结点是叶子结点
            if (targetNode.getLeft() == null && targetNode.getRight() == null) {
                //targetNode是父节点的左子结点
                if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
                    parent.setLeft(null);
                }
                if (parent.getRight() != null && parent.getRight().getValue() == value) {
                    parent.setRight(null);
                }
            }
            //删除有两棵子树的结点
            else if (targetNode.getLeft() != null && targetNode.getRight() != null) {
                int minVal = delRightTreeMin(targetNode.getRight());
                targetNode.setValue(minVal);
            }
            //删除有一棵子树的结点
            else {
                //如果要删除的结点有左子树
                if (targetNode.getLeft() != null) {
                    //如果父结点不为空
                    if (parent != null) {
                        if (parent.getLeft().getValue() == value) {
                            parent.setLeft(targetNode.getLeft());
                        } else {
                            parent.setRight(targetNode.getLeft());
                        }
                    }
                    //如果父结点为空，则删除结点的子树需要作为父节点
                    else {
                        root = targetNode.getLeft();
                    }
                }
                //如果要删除的结点有右子结点
                else {
                    if (parent != null) {
                        //如果targetNode是parent的左子结点
                        if (parent.getLeft().getValue() == value) {
                            parent.setLeft(targetNode.getRight());
                        } else {
                            parent.setRight(targetNode.getRight());
                        }
                    } else {
                        root = targetNode.getRight();
                    }
                }
            }
        }
    }

    /**
     * 删除树中最小的结点
     *
     * @param node
     * @return
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.getLeft() != null) {
            target = target.getLeft();
        }
        //这时target指向了最小结点
        //删除最小结点
        delNode(target.getValue());
        return target.getValue();
    }

    /**
     * 新增结点
     *
     * @param node
     */
    public void add(Node node) {
        //如果root为空则直接让root指向node
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }
}

/**
 * 结点
 */
class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * 新增结点
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入结点的值和当前子树的根结点的值关系
        if (node.value < this.value) {
            //如果当前节点的左节点为空
            if (this.left == null) {
                this.left = node;
            }
            //如果当前结点的左结点不为空
            else {
                this.left.add(node);
            }
        }
        //添加结点的值大于或等于当前结点的值
        else {
            //如果当前结点的右子结点为空
            if (this.right == null) {
                this.right = node;
            }
            //如果当前结点的右子结点不为空
            else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
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
     * 查找结点
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        //如果当前节点就是要找的值
        if (value == this.value) {
            return this;
        }
        //当前结点大于要找的值
        else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        }
        //当前结点小于等于要找的值
        else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找值得父结点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        //如果当前节点就是要查找的结点的父结点
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值，并且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                //向左子树递归查找
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                //向右子树递归查找
                return this.right.searchParent(value);
            } else {
                //没有找到父节点
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return "Node[" + "value=" + value + ']';
    }
}
