package com.study.others;

import java.util.*;

public class Algorithm001 {

    /**
     * @param givenOrder "2#","E2#","5#","E5#","8#","E8#","0#","-1#","-2#"
     * @param list       "-2#","E2#”,”-2#”,”8#”,”2#”
     * @return result     "2#","E2#”,”8#”,”-2#”,”-2#”
     */
    public static List<String> sort(List<String> givenOrder, List<String> list) {
        if (givenOrder == null || givenOrder.size() <= 0) {
            return null;
        }
        //字符串作为key
        Map<String, Integer> givenOrderStrMap = new HashMap(givenOrder.size());
        //value作为key
        Map<Integer, String> giverOrderValueMap = new HashMap<>();
        for (int i = 0; i < givenOrder.size(); i++) {
            String str = givenOrder.get(i);
            givenOrderStrMap.put(str, i);
            giverOrderValueMap.put(i, str);
        }
        List<Integer> strValueList = new ArrayList<>();
        for (int i = 0; i < givenOrder.size(); i++) {
            strValueList.add(0);
        }
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            Integer index = givenOrderStrMap.get(str);
            Integer value = strValueList.get(index);
            strValueList.set(index, ++value);
        }
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < strValueList.size(); i++) {
            int strTimes = strValueList.get(i);
            for (int j = 0; j < strTimes; j++) {
                resultList.add(giverOrderValueMap.get(i));
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("2#", "E2#", "5#", "E5#", "8#", "E8#", "0#", "-1#", "-2#");
        List<String> list = Arrays.asList("-2#", "E2#", "-2#", "8#", "2#");
        List<String> resultList = sort(givenList, list);
        System.out.println(resultList);
        Set<String> set = new HashSet<>();
        set.add("abc");
        set.add("abc");
    }
}
