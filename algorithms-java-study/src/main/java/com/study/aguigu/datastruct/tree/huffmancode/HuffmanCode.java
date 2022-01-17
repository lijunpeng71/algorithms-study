package com.study.aguigu.datastruct.tree.huffmancode;

import java.util.*;

/**
 * Created on 2021/1/20.
 *
 * @author junpeng li
 */
public class HuffmanCode {
    /**
     * 用于存放赫夫曼编码
     */
    private static Map<Byte, String> huffmanCodeMap = new HashMap<>();

    /**
     * 在生成赫夫曼编码表示，需要去拼接路径
     */
    private static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println("原始数组长度：" + contentBytes.length);
        //编码
        byte[] huffmanCodesBytes = huffmanZip(contentBytes);
        System.out.println("编码数组长度：" + huffmanCodesBytes.length);
        //解码
        byte[] sourceContents = decode(huffmanCodeMap, huffmanCodesBytes);
        System.out.println(new String(sourceContents));
    }

    /**
     * 返回就是list形式
     *
     * @param bytes
     * @return
     */
    public static List<Node> getNodeList(byte[] bytes) {
        //1.创建一个ArrayList
        List<Node> nodeList = new ArrayList<>();
        //遍历bytes,统计每一个byte出现的次数->map
        Map<Byte, Integer> byteCountMap = new HashMap<>();
        for (byte b : bytes) {
            Integer count = byteCountMap.get(b);
            if (count == null) {
                byteCountMap.put(b, 1);
            } else {
                byteCountMap.put(b, count + 1);
            }
        }
        //把每一个键值对转成一个node对象，并加入到nodes集合
        byteCountMap.forEach((b, count) -> {
            nodeList.add(new Node(b, count));
        });
        return nodeList;
    }

    /**
     * 创建赫夫曼树
     *
     * @param nodeList
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodeList) {
        while (nodeList.size() > 1) {
            Collections.sort(nodeList);
            Node leftNode = nodeList.get(0);
            Node rightNode = nodeList.get(1);
            Node parent = new Node(null, leftNode.getWeight() + rightNode.getWeight());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
            nodeList.add(parent);
        }
        return nodeList.get(0);
    }


    public static Map<Byte, String> getCodes(Node node) {
        if (node == null) {
            return null;
        }
        //处理root的左字树
        getCodes(node.left, "0", stringBuffer);
        getCodes(node.right, "1", stringBuffer);
        return huffmanCodeMap;
    }

    /**
     * 生产赫夫曼树对应的赫夫曼编码
     * 1.将赫夫曼编码表示存放在Map<Byte,String>形式
     *
     * @param node
     * @param code
     * @param stringBuffer
     */
    public static void getCodes(Node node, String code, StringBuffer stringBuffer) {
        StringBuffer stringBufferTemp = new StringBuffer(stringBuffer);
        //将code加入到stringBuilderTemp中
        stringBufferTemp.append(code);
        if (node != null) {
            //判断当前node是叶子结点还是非叶子结点
            //当前为非叶子结点
            if (node.data == null) {
                getCodes(node.left, "0", stringBufferTemp);
                getCodes(node.right, "1", stringBufferTemp);
            }
            //说明是一个叶子结点
            else {
                huffmanCodeMap.put(node.data, stringBufferTemp.toString());
            }
        }
    }

    /**
     * 返回赫夫曼编码处理后的byte[]
     *
     * @param bytes
     * @param huffmanCodes
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        //记录是第几个byte
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    /**
     * 经过赫夫曼编码处理贷后的字节数组
     *
     * @param bytes：原始的字符串对应的字符数组
     * @return
     */
    public static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodeList = getNodeList(bytes);
        //创建赫夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodeList);
        //对应的赫夫曼编码
        Map<Byte, String> huffmanCodeMap = getCodes(huffmanTreeRoot);
        //根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码自己数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodeMap);
        return huffmanCodeBytes;
    }

    /**
     * 将一个byte字符转成二进制的字符串
     *
     * @param flag : 标志是否需要补高位。ture:需要补高位;false:不需要补高位
     * @param b    对应的二进制的字符串
     * @return
     */
    public static String byteToBitString(boolean flag, byte b) {
        //使用变量保存b
        int temp = b;
        if (flag) {
            //按位与
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     * 对压缩数据进行解码
     *
     * @param huffmanCodeMap：赫夫曼编码表
     * @param huffmanBytes:赫夫曼编码得到的字节数组
     * @return 原来的字符串对应的数组
     */
    public static byte[] decode(Map<Byte, String> huffmanCodeMap, byte[] huffmanBytes) {
        //1.先得到huffmanBytes对应的二进制字符串，形式为：10010001
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        //把字符串按照指定的赫夫曼编码进行解码
        Map<String, Byte> map = new HashMap<>();
        huffmanCodeMap.forEach((key, value) -> map.put(value, key));
        //创建集合，存放byte
        List<Byte> list = new ArrayList<>();
        //i可以理解成就是索引，扫描stringBuilder
        for (int i = 0; i < stringBuilder.length(); ) {
            //小的计数器
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] resultByte = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultByte[i] = list.get(i);
        }
        return resultByte;
    }

    public static void preOrder(Node node) {
        if (node != null) {
            node.preOrder();
        } else {
            System.out.println("结点为空，不能遍历");
        }
    }

}

/**
 * 创建Node,待数据和权值
 */
class Node implements Comparable<Node> {
    /**
     * 存放数据(字符)本身，比如'a'=97
     */
    Byte data;
    /**
     * 权值，表示字符出现的次数
     */
    int weight;
    /**
     * 左节点
     */
    Node left;
    /**
     * 右结点
     */
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }


    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    @Override
    public String toString() {
        return "Node[" + "data=" + data + ", weight=" + weight + ']';
    }


    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
