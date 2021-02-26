package com.study.datastruct.queue;

import java.util.Scanner;

/**
 * @author administrator
 * @description:
 * @date:2020/8/19 10:41
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueueObject arrayQueueObject = new ArrayQueueObject(3);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("====================================================");
            System.out.println("s(show):\t显示队列");
            System.out.println("e(exit):\t退出程序");
            System.out.println("a(add):\t\t添加数据到队列");
            System.out.println("g(get):\t\t从队列取出数据");
            System.out.println("h(head):\t查看队列头的数据");
            System.out.println("请选择：");
            key = scanner.next().charAt(0);
            System.out.println("****************************************************");
            switch (key) {
                case 's':
                    arrayQueueObject.show();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入数值：");
                    int data = scanner.nextInt();
                    arrayQueueObject.add(data);
                    break;
                case 'g':
                    try {
                        int temp = arrayQueueObject.get();
                        System.out.printf("取出的数据是:%d\n", temp);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int temp = arrayQueueObject.head();
                        System.out.printf("查看的数据是:%d\n", temp);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
