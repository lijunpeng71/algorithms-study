package com.study.aguigu.algorithms.lru.lru02;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 */
public class LRUCache {

    /**
     * 容量
     */
    private int capacity;

    private Map<Integer, Integer> map = null;

    private LinkedList<Integer> list = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        list = new LinkedList<>();
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value != null) {
            list.remove(key);
            list.addLast(key);
        }
        return value;
    }

    public void put(int key, int value) {
        Integer oldValue = map.get(key);
        if (oldValue == null) {
            if (map.size() == capacity) {
                Integer firstKey = list.removeFirst();
                map.remove(firstKey);
            }
        } else {
            for (Integer temp : list) {
                if (temp.equals(key)) {
                    list.remove();
                    break;
                }
            }
        }
        map.put(key, value);
        list.addLast(key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(3, 5);
        System.out.println(cache.list);
        cache.put(2, 3);
        System.out.println(cache.list);
    }
}
