package com.algorithm;

import java.util.HashSet;

public class LeetCode_Longest_Common_Prefix {
    public static void main(String[] args) {
        Solution_LeetCode_Longest_Common_Prefix s = new Solution_LeetCode_Longest_Common_Prefix();

        String[] strs = {"flower", "flow", "flight"};

        System.out.println(s.longestCommonPrefix(strs));

    }
}

class Solution_LeetCode_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        HashSet<String> candidates = new HashSet<>(); //접두사 후보군
        HashSet<String> temp = new HashSet<>();//삭제 접두사 임시 저장

        String answer = "";

        for (int i = 1; i <= strs[0].length(); i++) {//첫 번째 요소 속 접두사들 저장
            candidates.add(strs[0].substring(0, i));
        }

        for (int i = 1; i < strs.length; i++) {//이후 요소들을 돌며
            for (String prefix : candidates) {
                if (!strs[i].startsWith(prefix)) {//접두사가 맞지 않으면 삭제를 위해 표시
                    temp.add(prefix);
                }
            }

            for (String remove : temp) {//삭제할 접두사들을 제거
                candidates.remove(remove);
            }

            temp = new HashSet<>();
        }

        for (String prefix : candidates) {//이후 제일 긴 접두사를 찾아 반환
            if (prefix.length() > answer.length()) {
                answer = prefix;
            }
        }

        return answer;
    }
}