package com.study.datastruct.tree.huffman;

/**
 * Created on 2021/1/20.
 *
 * @author junpeng li
 */
public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = HuffmanTree.createHuffmanTree(arr);
        root.preOrder();
    }
}


