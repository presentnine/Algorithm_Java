package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비타알고_동전_줍기_대회 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = -10000000000l;

        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) //동전 값어치 저장
            cost[i] = Integer.parseInt(st.nextToken());

        long[] dp = new long[N]; //dp 용 배열 초기화
        dp[0] = cost[0];

        for (int i = 1; i < N; i++) //현 위치 값과, 이전 위치 dp값 + 현 위치 값 비교
            dp[i] = Math.max(dp[i - 1] + cost[i], cost[i]);

        for (int i = 0; i < N; i++) //최대 상금 get
            answer = Math.max(answer, dp[i]);

        System.out.println(answer);
    }
}
