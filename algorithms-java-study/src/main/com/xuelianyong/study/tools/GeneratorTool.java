package com.xuelianyong.study.tools;

import cn.hutool.core.util.RandomUtil;

/**
 * @author lijunpeng02
 * @date 2023年02月02日 19:41
 */
public class GeneratorTool {

    public static int[] createIntArr(int maxLength){
        int length= RandomUtil.randomInt(0,maxLength);
        int[] arr=new int[length];
        for(int i=0;i<arr.length;i++){
            arr[i]=RandomUtil.randomInt();
        }
        return arr;
    }
}
