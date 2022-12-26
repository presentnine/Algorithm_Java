package com.algorithm;

//https://leetcode.com/problems/substring-with-concatenation-of-all-words/

import java.util.*;

public class LeetCode_Substring_with_Concatenation_of_All_Words {
    public static void main(String[] args) {
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo", "barr", "wing", "ding", "wing"};
        Solution_LeetCode_Substring_with_Concatenation_of_All_Words S = new Solution_LeetCode_Substring_with_Concatenation_of_All_Words();
        S.findSubstring(s, words);
    }
}

class Solution_LeetCode_Substring_with_Concatenation_of_All_Words {
    HashMap<String, Integer> wordIndex = new HashMap<>(), wordCount = new HashMap<>();

    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length(), searchCount;
        int[] wordContain = new int[words.length];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {//기존 words 배열을 돌며 
            wordIndex.put(words[i], i);//word의 인덱스화

            if (wordCount.containsKey(words[i])) {//중복된 word들의 개수 포함
                wordCount.replace(words[i], wordCount.get(words[i]) + 1);
            } else {
                wordCount.put(words[i], 1);
            }
        }

        for (int i = 0; i < wordLength; i++) {//한 개의 word 길이만큼
            searchCount = 0;
            Arrays.fill(wordContain, 0);

            for (int j = i; j < s.length();) {//s 길이만큼
                String substr;

                if (j + wordLength >= s.length()) {//현 위치부터 word 길이만큼의 문자열 가져오기
                    substr = s.substring(j);
                } else {
                    substr = s.substring(j, j + wordLength);
                }

                j += wordLength;//word 길이만큼 건너뛰기

                if (wordIndex.containsKey(substr)) {//기존에 있는 문자열에 있다면
                    ++wordContain[wordIndex.get(substr)];
                    ++searchCount;
                } else {//없다면 초기화
                    searchCount = 0;
                    Arrays.fill(wordContain, 0);
                }

                if (searchCount == words.length) {//word 개수만큼의 탐색을 완료했다면
                    int startIndex = j - wordLength * words.length;

                    if (isConcatenatedSubstring(wordContain)) {//concatenated substring이라면
                        answer.add(startIndex);
                    }

                    String removeString = s.substring(startIndex, startIndex + wordLength);//구간 앞부분의 문자열

                    if (wordIndex.containsKey(removeString)) {//앞부분 문자열 제거
                        --wordContain[wordIndex.get(removeString)];
                    }

                    --searchCount;
                }
            }
        }

        return answer;
    }

    boolean isConcatenatedSubstring(int[] wordContain) {//해당 구간이 concatenated substring인지
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (wordContain[wordIndex.get(entry.getKey())] != entry.getValue()) {
                return false;
            }
        }

        return true;
    }
}