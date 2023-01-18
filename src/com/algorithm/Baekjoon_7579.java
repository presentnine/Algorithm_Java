package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_7579 {

    static int N, M, memory[], cost[], dp[][], answer = 10000000;

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memory = new int[N];
        cost = new int[N];
        dp = new int[N + 1][10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            memory[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            cost[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (j >= cost[i - 1])
                    dp[i][j] = Math.max(dp[i - 1][j - cost[i - 1]] + memory[i - 1], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];

                if (dp[i][j] >= M)
                    answer = Math.min(answer, j);
            }
        }

        System.out.println(answer);
    }
}
