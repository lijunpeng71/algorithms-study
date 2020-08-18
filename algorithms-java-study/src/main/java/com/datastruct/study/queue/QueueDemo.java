package com.datastruct.study.queue;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class QueueDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list = list.subList(0, 1);
    }
}
