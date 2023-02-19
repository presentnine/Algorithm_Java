package com.algorithm;

//https://leetcode.com/problems/group-anagrams/

import java.util.*;

public class LeetCode_Group_Anagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> answer = new ArrayList<>();
            HashMap<AlphabetInWord, List<String>> hashMap = new HashMap<>();

            for (int i = 0; i < strs.length; i++) {
                AlphabetInWord alphabetInWord = new AlphabetInWord(strs[i]);

                if (hashMap.containsKey(alphabetInWord)) {//동일한 키가 존재하면 단순 해당 리스트에 추가
                    hashMap.get(alphabetInWord).add(strs[i]);
                } else {//존재하지 않으면 새로 리스트를 생성해 추가
                    List<String> temp = new ArrayList<>();
                    temp.add(strs[i]);
                    hashMap.put(alphabetInWord, temp);
                }
            }

            for (Map.Entry<AlphabetInWord, List<String>> entry : hashMap.entrySet()) {//answer에 옮겨담기
                answer.add(entry.getValue());
            }

            return answer;
        }

        class AlphabetInWord{
            int[] alphabets = new int[26];

            public AlphabetInWord(String str) {//주어진 String 기반 생성자
                for (int i = 0; i < str.length(); i++) {
                    ++alphabets[str.charAt(i) - 'a'];
                }
            }

            @Override
            public int hashCode() {//해당 클래스 hashCode() 오버라이딩
                int h = 0;

                for (int i = 0; i < alphabets.length; i++) {
                    h = 31 * h + alphabets[i];
                }

                return h;
            }

            @Override
            public boolean equals(Object obj) {//해당 클래스 equals() 오버라이딩
                if (obj instanceof AlphabetInWord) {
                    return Arrays.equals(this.alphabets, ((AlphabetInWord) obj).alphabets);
                }
                return false;
            }
        }
    }
}
