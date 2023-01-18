package com.algorithm;

//https://www.acmicpc.net/problem/16207

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_16207 {
    static Long[] dp;//dp용 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] bars = new Integer[N];
        dp = new Long[N];
        Arrays.fill(dp, -1L);

        long answer = 0;

        for (int i = 0; i < N; i++) {
            bars[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bars, Collections.reverseOrder());//막대 내림차순 정렬

        for (int i = 0; i < N - 3; i++) {//하나씩 제외시키며 탐색 적용
            answer = Math.max(answer, makeSquare(i, bars, N));
        }

        System.out.println(answer);
        return;
    }

    static long makeSquare(int startIndex, Integer[] bars, int N) {
        if (startIndex >= N - 3) {//현 상황에서 남은 막대 개수가 4개 미만
            return 0;
        }

        if (dp[startIndex] != -1L) {//dp값이 존재
            return dp[startIndex];
        }

        int sideA = 0, sideB = 0, sideAIndex = N, sideBIndex = N;

        for (int i = startIndex; i < N - 1; i++) {//막대길이 find
            if (bars[i].equals(bars[i + 1])  || bars[i].equals(bars[i + 1] + 1)) {
                sideA = bars[i + 1];
                sideAIndex = i + 1;
                break;
            }
        }

        for (int i = sideAIndex + 1; i < N - 1; i++) {//막대길이 find
            if (bars[i].equals(bars[i + 1])  || bars[i].equals(bars[i + 1] + 1)) {
                sideB = bars[i + 1];
                sideBIndex = i + 1;
                break;
            }
        }

        //dp배열에 넓이를 저장하며 다음 탐색 결과 call
        return dp[startIndex] = (long) sideA * sideB + makeSquare(sideBIndex + 1, bars, N);
    }
}
