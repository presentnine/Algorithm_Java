package com.algorithm;

public class 라인_2022_하반기_3 {
}

class Solution_라인_2022_하반기_3 {
    public long[][] solution(int n, int m, int[][] fires, int[][] ices) {
        long[][] answer = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < fires.length; k++) {
                    answer[i][j] += tempFromFire(i + 1, j + 1, fires[k][0], fires[k][1], m);
                }

                for (int k = 0; k < ices.length; k++) {
                    answer[i][j] += tempFromIce(i + 1, j + 1, ices[k][0], ices[k][1], m);
                }
            }
        }

        return answer;
    }

    long tempFromFire(int posR, int posC, int fireR, int fireC, int m) {
        int dist = Math.max(Math.abs(posR - fireR), Math.abs(posC - fireC));//행, 열 중 최대 길이
        long result = m - dist + 1;

        if (dist == 0) {
            --result;
        }

        if (result <= 0) {
            return 0;
        }

        return result;
    }

    long tempFromIce(int posR, int posC, int iceR, int iceC, int m) {
        int dist = Math.abs(posR - iceR) + Math.abs(posC - iceC);//절대값의 합
        long result = dist - m - 1;

        if (dist == 0) {
            ++result;
        }

        if (result >= 0) {
            return 0;
        }

        return result;
    }
}
