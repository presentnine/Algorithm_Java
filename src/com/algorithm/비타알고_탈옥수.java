package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class 비타알고_탈옥수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        br.readLine();br.readLine();

        double x1 = 0, y1 = 0, x2 = 1, y2 = 1, x3, y3, turnRightVecX, turnRightVecY;

        for (int i = 2; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            x3 = Double.parseDouble(st.nextToken());
            y3 = Double.parseDouble(st.nextToken());

            //오른쪽 90도 진행한 벡터
            turnRightVecX = y2 - y1;
            turnRightVecY = -(x2 - x1);

            if ((x3 - x2) * turnRightVecX + (y3 - y2) * turnRightVecY > 0) {
                answer.append("RIGHT\n");
            } else {
                answer.append("LEFT\n");
            }

            x1 = x2;
            y1 = y2;
            x2 = x3;
            y2 = y3;
        }

        System.out.println(answer);
    }
}
