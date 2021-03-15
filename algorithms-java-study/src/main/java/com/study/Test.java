package com.study;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int n = 9;
        int rightOne = n & ((~n) + 1);
        System.out.println(rightOne);
    }
}
