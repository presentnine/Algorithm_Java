package com.algorithm;

//https://leetcode.com/problems/remove-duplicate-letters/

import java.util.Arrays;

public class LeetCode_Remove_Duplicate_Letters {
}

class Solution_LeetCode_Remove_Duplicate_Letters {
    public String removeDuplicateLetters(String s) {
        int[] alphabet = new int[26];

        Arrays.fill(alphabet, -1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (alphabet[c - 'a'] == -1) {//첫 등장
                sb.append(c);
                alphabet[c - 'a'] = sb.length() - 1;
            } else {//중복인 경우
                String s1 = sb.toString();

                sb.deleteCharAt(alphabet[c - 'a']);
                sb.append(c);

                String s2 = sb.toString();

                System.out.println(s1 + ", " + s2);

                if (s1.compareTo(s2) < 0) {//기존 문자열이 더 빠르다면
                    sb.deleteCharAt(sb.length() - 1);
                    sb.insert(alphabet[c - 'a'], c);
                } else {//새로운 문자열이 더 빠르다면
                    alphabet[c - 'a'] = sb.length() - 1;
                }

                System.out.println(sb.toString());
            } 
        }

        return sb.toString();
    }
}
