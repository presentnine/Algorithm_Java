package com.algorithm;

public class 카카오모빌리티_2022_1 {
}
class Solution_카카오모빌리티_2022_1 {
    public int solution(int[][] flowers) {
        int answer = 0, temp;
        int[] acc = new int[366];

        for (int i = 0; i < flowers.length; i++) {//누적합 표시
            int start = flowers[i][0], end = flowers[i][1];
            ++acc[start];
            --acc[end];
        }

        temp = 0;
        for (int i = 1; i <= 365; i++) {//누적합 계산 + 날짜 확인
            acc[i] += temp;

            if (acc[i] > 0) {
                ++answer;
            }

            temp = acc[i];
        }

        return answer;
    }
}
