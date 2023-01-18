package com.algorithm;

//https://www.acmicpc.net/problem/1463

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1463 {
    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Arrays.fill(dp, -1);
        dp[1] = 0;
        dp[2] = 1;

        search(N);
        System.out.println(dp[N]);
    }

    static int search(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }

        int result = 987654321;

        if (n % 3 == 0) {
            result = Math.min(result, search(n / 3));
        }

        if (n % 2 == 0) {
            result = Math.min(result, search(n / 2));
        }

        result = Math.min(result, search(n - 1));

        return dp[n] = result + 1;
    }
}
