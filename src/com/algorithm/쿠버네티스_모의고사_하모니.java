package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 쿠버네티스_모의고사_하모니 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[N][10];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j + 1] % 1000000000;
                } else if (j == 9) {
                    dp[i][j] += dp[i - 1][j - 1] % 1000000000;
                } else {
                    dp[i][j] += dp[i - 1][j - 1] % 1000000000;
                    dp[i][j] += dp[i - 1][j + 1] % 1000000000;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            answer += dp[N - 1][i] % 1000000000;
        }

        System.out.println(answer);
    }
}
