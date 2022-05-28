package com.study;

import java.nio.ByteBuffer;

public class Test {

    static ByteBuffer byteBuffer;
    public static void main(String[] args) {
        byteBuffer=ByteBuffer.allocateDirect(128*1024*1024);
    }
}
