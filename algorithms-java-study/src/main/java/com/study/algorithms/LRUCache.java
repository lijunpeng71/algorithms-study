package com.study.algorithms;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created on 2021/1/22.
 *
 * @author junpeng li
 */
public class LRUCache {
    /**
     * 容量
     */
    private int capacity;


    private HashMap<Integer, Integer> map;


    private LinkedList<Integer> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove(key);
            list.addLast(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(key);
            list.addLast(key);
            map.put(key, value);
            return;
        }
        if (list.size() == capacity) {
            map.remove(list.removeFirst());
            map.put(key, value);
            list.addLast(key);
        } else {
            map.put(key, value);
            list.addLast(key);
        }
    }

    public static void main(String[] args) {

    }
}
