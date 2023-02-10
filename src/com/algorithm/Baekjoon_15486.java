package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/15486

public class Baekjoon_15486 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] tAndP = br.readLine().split(" ");
            int time = Integer.parseInt(tAndP[0]);
            int price = Integer.parseInt(tAndP[1]);

            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i + time - 1 <= N) {
                dp[i + time - 1] = Math.max(dp[i + time - 1], dp[i - 1] + price);
            }
        }

        System.out.println(dp[N]);
    }
}
