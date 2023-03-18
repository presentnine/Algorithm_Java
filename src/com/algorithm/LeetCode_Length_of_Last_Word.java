package com.algorithm;

//https://leetcode.com/problems/length-of-last-word/

public class LeetCode_Length_of_Last_Word {
}

class Solution_LeetCode_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        boolean lastCheck = false;
        int start = -1, end = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' '&&!lastCheck) {//처음으로 문자를 만난 경우 끝으로 지정
                end = i;
                lastCheck = true;
            }

            if (s.charAt(i) == ' ' && lastCheck) {//끝이 지정된 상태에서 공백을 만난 경우
                start = i;
                break;
            }
        }

        return end - start;//차이 반환
    }
}