package com.algorithm;

import java.util.HashMap;

public class 카카오_여름_인턴_2022_1 {

}

class Solution_카카오_여름_인턴_2022_1 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] score = new int[8];
        String[] type = new String[]{"R", "T", "C", "F", "J", "M", "A", "N"};
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('R', 0);
        hashMap.put('T', 1);
        hashMap.put('C', 2);
        hashMap.put('F', 3);
        hashMap.put('J', 4);
        hashMap.put('M', 5);
        hashMap.put('A', 6);
        hashMap.put('N', 7);

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];

            if (choice < 4) {
                score[hashMap.get(survey[i].charAt(0))] += 4 - choice;
            } else if (choice > 4) {
                score[hashMap.get(survey[i].charAt(1))] += choice - 4;
            }
        }

        for (int i = 0; i < 4; i++) {
            int type1 = 2 * i, type2 = 2 * i + 1;

            if (score[type1] >= score[type2]) {
                answer += type[type1];
            } else {
                answer += type[type2];
            }
        }

        return answer;
    }
}
