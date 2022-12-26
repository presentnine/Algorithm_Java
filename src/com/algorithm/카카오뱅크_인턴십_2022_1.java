package com.algorithm;

public class 카카오뱅크_인턴십_2022_1 {
}

class Solution_카카오뱅크_인턴십_2022_1 {
    public int[] solution(String logs) {
        int[] answer = new int[24];

        String[] split = logs.split("\n");//한 줄씩 분할

        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            int hour = Integer.parseInt(s.substring(11, 13));//숫자 추출
            hour = (hour + 9) % 24;//+9시간
            ++answer[hour];
        }

        return answer;
    }
}