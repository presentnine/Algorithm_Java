package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 카카오_2022_하반기_1 {
    public static void main(String[] args) {
        Solution_카카오_2022_하반기_1 s = new Solution_카카오_2022_하반기_1();

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A"};

        s.solution(today, terms, privacies);
    }
}
class Solution_카카오_2022_하반기_1 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> temp = new ArrayList<>();
        HashMap<String, Integer> termsHashMap = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {//약관 저장
            String[] s = terms[i].split(" ");
            termsHashMap.put(s[0], Integer.parseInt(s[1]));
        }

        String[] todaySplit = today.split("[.]");
        int todayInt = Integer.parseInt(todaySplit[0] + todaySplit[1] + todaySplit[2]);

        for (int i = 0; i < privacies.length; i++) {//privacies 처리
            String[] s = privacies[i].split(" ");
            String date = s[0], term = s[1];

            if (todayInt >= addTerm(date, termsHashMap.get(term))) {//삭제해야 하는 정보
                temp.add(i + 1);
            }
        }

        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }

    int addTerm(String date, int termMonth) {//날짜 계산
        String[] dates = date.split("[.]");
        int year = Integer.parseInt(dates[0]), month = Integer.parseInt(dates[1]);

        month += termMonth;

        year += (month - 1) / 12;
        month = (month - 1) % 12 + 1;

        String result = year + "";

        if (month < 10) {
            result += "0" + month;
        } else {
            result += month;
        }

        return Integer.parseInt(result + dates[2]);
    }
}