package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class 비타알고_A4_용지를_만들자 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken()) / 20;
        long M = Long.parseLong(st.nextToken()) / 20;

        long answer = N * M / 2;
        System.out.println(answer);
    }
}
