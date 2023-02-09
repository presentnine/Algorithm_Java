package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/15486
public class Baekjoon_15486 {
    static int[][] schedule;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        schedule = new int[N][2];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            String[] tAndP = br.readLine().split(" ");
            schedule[i][0] = Integer.parseInt(tAndP[0]);
            schedule[i][1] = Integer.parseInt(tAndP[1]);
        }

        for (int i = 0; i < N; i++) {
            if (schedule[i][0] + i - 1 < N) {
                dp[schedule[i][0] + i - 1] += schedule[i][1];
            }
        }
    }
}
