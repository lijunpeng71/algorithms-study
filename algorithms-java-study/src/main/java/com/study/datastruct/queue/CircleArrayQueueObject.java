package com.study.datastruct.queue;

/**
 * @author administrator
 * @description:
 * @date:2020/8/19 14:06
 **/
public class CircleArrayQueueObject {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;

    /**
     * 队头
     */
    private int front;

    /**
     * 队尾
     */
    private int rear;

    /**
     * 队列元素
     */
    private int[] datas;

    /**
     * 队列构造器
     *
     * @param maxSize
     */
    public CircleArrayQueueObject(int maxSize) {
        this.maxSize = maxSize;
        this.datas = new int[maxSize];
        //front就指向队列的第一个元素
        this.front = 0;
        //指向队列尾，指向队列尾的元素
        this.rear = 0;
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean full() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean empty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     *
     * @param n
     */
    public void add(int n) {
        //判断队列是否为空
        if (full()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        datas[rear] = n;
        //后移
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取队列的数据，出队列
     *
     * @return
     */
    public int get() {
        if (empty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        //这里需要分析出 front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移
        int data = datas[front];
        front = (front + 1) % maxSize;
        return data;
    }

    /**
     * 显示队列的所有数据
     */
    public void show() {
        if (empty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < datas.length; i++) {
            System.out.printf("datas[%d]=%d\n", i, datas[i]);
        }
    }

    /**
     * 查看队头数据
     *
     * @return
     */
    public int head() {
        if (empty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return datas[front];
    }
}
