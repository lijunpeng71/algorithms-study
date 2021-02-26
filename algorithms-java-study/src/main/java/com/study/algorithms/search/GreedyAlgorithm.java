package com.study.algorithms.search;

import java.util.*;

/**
 * Created on 2021/1/22.
 *
 * @author junpeng li
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台
        Map<String, Set<String>> broadcastMap = new HashMap<>();
        //将各个电台放入到broadcastMap中
        Set<String> hashSet01 = new HashSet<>();
        hashSet01.add("北京");
        hashSet01.add("上海");
        hashSet01.add("天津");
        Set<String> hashSet02 = new HashSet<>();
        hashSet02.add("广州");
        hashSet02.add("北京");
        hashSet02.add("深圳");
        Set<String> hashSet03 = new HashSet<>();
        hashSet03.add("成都");
        hashSet03.add("上海");
        hashSet03.add("杭州");
        Set<String> hashSet04 = new HashSet<>();
        hashSet04.add("上海");
        hashSet04.add("天津");
        Set<String> hashSet05 = new HashSet<>();
        hashSet05.add("杭州");
        hashSet05.add("大连");
        //加入到map中
        broadcastMap.put("K1", hashSet01);
        broadcastMap.put("K2", hashSet02);
        broadcastMap.put("K3", hashSet03);
        broadcastMap.put("K4", hashSet04);
        broadcastMap.put("K5", hashSet05);

        //存放所有的地区
        Set<String> allAreas = new HashSet<>();
        allAreas.addAll(hashSet01);
        allAreas.addAll(hashSet02);
        allAreas.addAll(hashSet03);
        allAreas.addAll(hashSet04);
        allAreas.addAll(hashSet05);

        //创建存放选择的电台集合
        List<String> selectList = new ArrayList<>();
        //定义一个临时集合，在遍历过程中，存放电台覆盖地区和当前还没覆盖的地区的交集
        Set<String> tempSet = new HashSet<>();
        String maxKey = null;
        while (allAreas.size() != 0) {
            //每进行一次while,需要初始化
            maxKey = null;
            //遍历broadcastMap取出对应的key
            for (String key : broadcastMap.keySet()) {
                tempSet.clear();
                //当前电台能覆盖的城市
                Set<String> areas = broadcastMap.get(key);
                tempSet.addAll(areas);
                //求出tempSet和allAreas集合的交集，交集会赋给tempSet
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcastMap.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                selectList.add(maxKey);
                allAreas.removeAll(broadcastMap.get(maxKey));
            }
        }
        System.out.println("得到的选择结果：" + selectList);
    }
}
