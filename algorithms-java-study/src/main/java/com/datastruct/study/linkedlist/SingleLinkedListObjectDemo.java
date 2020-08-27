package com.datastruct.study.linkedlist;

public class SingleLinkedListObjectDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedListObject singleLinkedListObject = new SingleLinkedListObject();
        singleLinkedListObject.add(hero1);
        singleLinkedListObject.add(hero4);
        singleLinkedListObject.add(hero2);
        singleLinkedListObject.add(hero3);
        //测试一下单链表的反转功能
        singleLinkedListObject.show();
    }
}
