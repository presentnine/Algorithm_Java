package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class 비타알고_두루마리_휴지_공장 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String answer = "";

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long totalLength = 0;
        long MaxLength = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            totalLength += temp;
            MaxLength = Math.max(MaxLength, temp);
        }

        if ((MaxLength * N - totalLength) > M) {//불가능의 경우
            answer = "No way!";
        } else {
            answer = MaxLength + (M - (MaxLength * N - totalLength)) / N + "";
        }

        System.out.println(answer);
    }
}
