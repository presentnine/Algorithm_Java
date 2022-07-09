package com.algorithm;

//https://programmers.co.kr/learn/courses/30/lessons/12971

public class 스티커_모으기_2 {
    public static void main(String[] args) {
        int sticker[] =
                {14, 6, 5, 11, 3, 9, 2, 10};

        Solution_스티커_모으기_2 s = new Solution_스티커_모으기_2();
        System.out.println(s.solution(sticker));
    }
}

class Solution_스티커_모으기_2 {
    public int solution(int sticker[]) {
        int answer = 0, length = sticker.length;

        if (length <= 3) {//길이가 3이하
            for (int i = 0; i < length; i++) {
                answer = Math.max(answer, sticker[i]);
            }

            return answer;
        } else if (length == 4) {//길이가 4인 경우
            return Math.max(sticker[0] + sticker[2], sticker[1] + sticker[3]);
        }

        int[] dp1 = new int[length], dp2 = new int[length - 1];

        //각각 dp 배열의 뒤에 숫자 3개를 채워놓음
        dp1[length - 1] = sticker[length - 1];
        dp1[length - 2] = sticker[length - 2];
        dp1[length - 3] = sticker[length - 3] + dp1[length - 1];
        dp2[length - 2] = sticker[length - 2];
        dp2[length - 3] = sticker[length - 3];
        dp2[length - 4] = sticker[length - 4] + dp2[length - 2];

        for (int i = length - 4; i > 0; i--) {//탐색 반복
            dp1[i] = sticker[i] + Math.max(dp1[i + 2], dp1[i + 3]);
            dp2[i - 1] = sticker[i - 1] + Math.max(dp2[i + 1], dp2[i + 2]);
        }

        return Math.max(Math.max(dp1[1], dp1[2]), Math.max(dp2[1], dp2[0]));
    }

}