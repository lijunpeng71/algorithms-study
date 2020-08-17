package com.algorithms.study.violence;

public class ViolenceStudy {
    /**
     * 暴力查询
     *
     * @param mainStr
     * @param patternStr
     * @return
     */
    public static int violenceSearch(String mainStr, String patternStr) {
        if (mainStr == null || patternStr == null) {
            return -1;
        }
        int mainLength = mainStr.length();
        int patternLength = patternStr.length();
        char[] mainChars = mainStr.toCharArray();
        char[] patternChars = patternStr.toCharArray();
        int i = 0, j = 0;
        while (i < mainLength && j < patternLength) {
            if (mainChars[i] == patternChars[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == patternLength) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String mainStr = "BBC ABCDAB ABCDABCDABDE";
        String patternStr = "ABCDABD";
        int index = violenceSearch(mainStr, patternStr);
        System.out.println("index:" + index);
    }
}
