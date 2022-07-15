package com.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Longest_Substring_Without_Repeating_Characters {
}

class Solution_LeetCode_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        Queue<Character> q = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (hashSet.contains(c)) {
                StringBuilder sb = new StringBuilder();
                while (!q.isEmpty()) {
                    sb.append(q.poll());
                }

                answer = Math.max(answer, sb.length());
                hashSet = new HashSet<>();
            }
            hashSet.add(c);
            q.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.poll());
        }

        answer = Math.max(answer, sb.length());

        return answer;
    }
}