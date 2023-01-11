package com.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Longest_Substring_Without_Repeating_Characters {
}

class Solution_LeetCode_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int answer = 0;
        HashSet<Character> hashSet = new HashSet<>();

        int start = 0, end;
        hashSet.add(s.charAt(start));

        for (end = 1; end < s.length(); end++) {
            if (hashSet.contains(s.charAt(end))) {//마지막과 겹치는 문자가 있다면
                answer = Math.max(answer, end - start);//현재까지의 문자열 비교

                do {//겹치는 문자가 없어질 때까지 start를 앞으로 땡김
                    hashSet.remove(s.charAt(start));
                } while (s.charAt(start++) != s.charAt(end));
            }

            hashSet.add(s.charAt(end));//마지막 부분 추가
        }

        answer = Math.max(answer, end - start);//최종 문자열도 비교

        return answer;
    }
}