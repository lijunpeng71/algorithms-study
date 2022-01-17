package com.study.aguigu.datastruct.stack;

public class CalculatorDemo {

    /**
     * 判断字符是否为运算符
     *
     * @param ch
     * @return
     */
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    /**
     * 获取符号的优先级
     *
     * @param operator
     * @return
     */
    public static int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 计算器
     *
     * @param num1
     * @param num2
     * @param operator
     * @return
     */
    public static int calculator(int num1, int num2, int operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        //表达式
        //String express = "7*2*2-5+1-5+3-4";
        String express = "7*2*2-1";
        //数栈
        ArrayStackObject numStack = new ArrayStackObject(express.length());
        //附号栈
        ArrayStackObject operatorStack = new ArrayStackObject(express.length());
        //定义需要的相关变量
        //用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int operator = 0;
        int result = 0;
        //将每次扫描得到的char保存到ch
        char ch = ' ';
        //用于拼接多位数
        String keepNum = "";
        while (true) {
            //依次得到expression的没有个字符
            ch = express.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if (isOperator(ch)) {
                //如果操作符栈不为空
                if (!operatorStack.isEmpty()) {
                    //当前运算符小于等于上一个运算符，则对上一个运算符进行运算
                    if (priority(ch) <= priority(operatorStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operatorStack.pop();
                        result = calculator(num1, num2, operator);
                        numStack.push(result);
                        operatorStack.push(ch);
                    }
                    //如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
                    else {
                        operatorStack.push(ch);
                    }
                } else {
                    //如果符号栈为空，则直接入栈
                    operatorStack.push(ch);
                }
            } else {
                //分析思路
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                keepNum += ch;
                //如果ch已经是最后一位，就直接入栈
                if (index == express.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，如果是数字就继续扫描，如果是运算符，则入栈
                    if (isOperator(express.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            //让index++;
            index++;
            if (index >= express.length()) {
                break;
            }
        }

        while (true) {
            if (operatorStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operatorStack.pop();
            result = calculator(num1, num2, operator);
            numStack.push(result);
        }
        System.out.printf("表达式 %s = %d\n", express, numStack.pop());
    }
}
