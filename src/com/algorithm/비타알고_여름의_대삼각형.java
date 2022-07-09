package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class 비타알고_여름의_대삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double area = 0;
        int[] x = new int[3], y = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        area = Math.abs(x[0] * y[1] + x[1] * y[2] + x[2] * y[0] - x[1] * y[0] - x[2] * y[1] - x[0] * y[2]) / 2.0;

        System.out.println(String.format("%.2f", area));
    }
}
