package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class 비타알고_외계인과_용돈_기입장 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] dp = new long[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            long result = dp[end] - dp[start - 1];

            if (result > 0) {
                answer.append("+" + result + "\n");
            } else {
                answer.append(result + "\n");
            }
        }

        System.out.println(answer);
    }
}
