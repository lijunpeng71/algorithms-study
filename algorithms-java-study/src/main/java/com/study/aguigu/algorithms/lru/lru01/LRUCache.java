package com.study.aguigu.algorithms.lru.lru01;

import java.util.LinkedHashMap;

/**
 * 利用LinkedHashMap实现LRU(lease recent use)
 * LinkedHashMap采用的是HashMap+双向链表结构，很适合实现LRU
 * 使用构造函数
 * public LinkedHashMap(int initialCapacity,float loadFactor,boolean accessOrder)
 * initialCapacity：初始化容量
 * loadFactor：负载因子
 * accessOrder：true:按照访问顺序；false：按照插入顺序
 */
public class LRUCache extends LinkedHashMap {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lruHashMap = new LinkedHashMap<>(3, 0.75f, true);
        lruHashMap.put("a", 2);
        lruHashMap.put("b", 3);
        lruHashMap.put("c", 5);
        System.out.println(lruHashMap.values());
        lruHashMap.get("b");
        System.out.println(lruHashMap.values());
        lruHashMap.get("b");
        System.out.println(lruHashMap.values());
        lruHashMap.put("b", 6);
        System.out.println(lruHashMap.values());
    }
}
