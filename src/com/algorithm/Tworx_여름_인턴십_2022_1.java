package com.algorithm;

public class Tworx_여름_인턴십_2022_1 {
}
class Solution_Tworx_여름_인턴십_2022_1 {
    public int[] solution(int[] p) {
        int[] answer = new int[p.length];

        for (int i = 0; i < p.length; i++) {
            int j = i;

            for (int k = i+1; k < p.length; k++) {//가장 작은 숫자 find
                if (p[j] > p[k]) {
                    j = k;
                }
            }

            if (j != i) {//swap + 바뀐 횟수 기록
                int temp = p[i];
                p[i] = p[j];
                p[j] = temp;

                ++answer[i];
                ++answer[j];
            }
        }

        return answer;
    }
}