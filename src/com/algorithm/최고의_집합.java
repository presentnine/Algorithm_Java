package com.algorithm;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12938
public class 최고의_집합 {
}
class Solution_최고의_집합 {
    public int[] solution(int n, int s) {
        int[] answer;
        int quotient = s / n; //몫
        int remainder = s - quotient * n; //나머지

        if (quotient == 0) {//애초에 몫이 0이면
            return new int[]{-1};
        }

        answer = new int[n];
        Arrays.fill(answer, quotient);
        for (int i = 1; i <= remainder; i++) {
            answer[n - i] += 1;
        }

        return answer;
    }
}
