package com.study.aguigu.datastruct.tree.avltree;

/**
 * Created on 2021/1/21.
 *
 * @author junpeng li
 */
public class AvlTreeDemo {
    public static void main(String[] args) {
        int[] arr;
        //左旋转
        //arr = new int[]{4, 3, 6, 5, 7, 8};
        //右旋转
        //arr = new int[]{10, 11, 7, 6, 8, 9};
        //双旋转
        arr = new int[]{10, 11, 7, 6, 8, 9};
        AvlTree avlTree = new AvlTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        avlTree.infixOrder();
        System.out.println("在平衡处理~");
        System.out.println("树的高度：" + avlTree.getRoot().height());
        System.out.println("树的左子树高度：" + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度：" + avlTree.getRoot().rightHeight());
    }
}


class AvlTree {
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
        //当添加完一个结点后，如果：(右子树的高度-左子树的高度)>1,左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果它的右子树的左子树的高度大于它的右子树的右子树的高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先对右子树结点进行右旋转
                right.rightRotate();
            }
            //左旋转
            leftRotate();
            return;
        }
        //当添加完一个结点后，如果：(左子树的高度-右子树的高度)>1,右旋转
        if (leftHeight() - rightHeight() > 1) {
            //如果它的左子树的右子树高度大于它的左子树高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //先对当前结点的左子树进行左旋转
                left.leftRotate();
            }
            rightRotate();
            return;
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

    /**
     * 左子树的高度
     *
     * @return
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    /**
     * 右子树的高度
     *
     * @return
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /**
     * 返回当前结点的高度，以该结点为根结点的树的高度
     *
     * @return
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 左旋
     */
    public void leftRotate() {
        //1.创建新的结点，以当前根结点的值
        Node newNode = new Node(value);
        //2.把新的结点的左子树设置成当前结点的左子树
        newNode.setLeft(this.left);
        //3.把新的结点的右子树设置为当前节点的右子树的左子树
        newNode.setRight(this.right.left);
        //4.把当前节点的值替换成有子结点的值
        this.setValue(this.right.getValue());
        //5.把当前结点的右子树设置成当前结点的右子树的右子树
        this.setRight(this.right.right);
        //6.把当前结点的左子树设置成新结点
        this.setLeft(newNode);
    }

    /**
     * 右旋
     */
    public void rightRotate() {
        //1.创建新结点
        Node newNode = new Node(value);
        //2.把新的结点的右子树设置成当前节点的右子树
        newNode.setRight(this.right);
        //3.把新结点的右子树设置成当前节点的左子树的右子树
        newNode.setLeft(this.left.right);
        //4.把当前结点的值设置为当前结点左结点的值
        value = left.value;
        //5.把当前节点的左结点设置成当前节点左结点的左结点
        left = left.left;
        //6.把当前结点的右结点设置成新结点
        right = newNode;
    }
}