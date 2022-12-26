package com.algorithm;

//https://leetcode.com/problems/reverse-words-in-a-string/

public class LeetCode_Reverse_Words_in_a_String {
}

class Solution_LeetCode_Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        StringBuilder answer = new StringBuilder();
        String trim = s.trim();
        String[] split = trim.split(" ");

        for (int i = split.length - 1; i >= 0; i--) {
            if (!split[i].isBlank()) {
                answer.append(split[i]);
                answer.append(" ");
            }
        }

        answer.deleteCharAt(answer.length() - 1);

        return answer.toString();
    }
}
