package com.algorithm;

public class 토스_NEXT_2022_1 {
}
class Solution_토스_NEXT_2022_1 {
    public int solution(String s) {
        int answer = -1, num;

        if (s.length() <= 2) {
            return -1;
        }

        num = Integer.valueOf(s.substring(0, 2));

        for (int i = 2; i < s.length(); i++) {
            num = (num % 100) * 10 + (s.charAt(i) - '0');

            if (isNiceNum(num)) {
                answer = Math.max(answer, num);
            }
        }

        return answer;
    }

    boolean isNiceNum(int num) {
        int a = num / 100, b = (num % 100) / 10, c = num % 10;

        return a == b && b == c;
    }
}