package com.study.datastruct.linkedlist;

public class SingleLinkedListObject {
    //创建头节点
    private static final HeroNode head = new HeroNode(0, "", "");

    /**
     * 返回头节点
     *
     * @return
     */
    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加结点到单链表
     * 1.找到当前链表的最后结点
     * 2.将最后这个结点的next指向新的结点
     *
     * @param node
     */
    public void add(HeroNode node) {
        //因为head节点不能动,因此用临时变量存储
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.getNext() == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    /**
     * 排序插入结点
     *
     * @param node
     */
    public void addByOrder(HeroNode node) {
        //临时变量
        HeroNode temp = head;
        //flag标志添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() > node.getNo()) {
                break;
            } else if (temp.getNext().getNo() == node.getNo()) {
                //说明节点已经存在
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            System.out.printf("准备插入的英雄的编号： %d 已经存在，不能加入", node.getNo());
        } else {
            temp.setNext(node);
        }
    }

    /**
     * 遍历链表
     */
    public void show() {
        //判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        //辅助变量
        HeroNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

/**
 * 定义HeroNode
 * 每个HeroNode对象就是一个结点
 */
class HeroNode {
    /**
     * 编号
     */
    private int no;
    /**
     * 名字
     */
    private String name;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 下一个结点
     */
    private HeroNode next;

    /**
     * 构造函数
     *
     * @param no
     * @param name
     * @param nickname
     */
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
