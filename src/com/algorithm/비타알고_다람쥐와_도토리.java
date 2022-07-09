package com.algorithm;

import java.io.*;
import java.util.*;

public class 비타알고_다람쥐와_도토리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] map = new long[M + 1][N + 1];
        Arrays.fill(map[0], 1);

        for (int i = 1; i <= M; i++)
            map[i][0] = 1;

        st = new StringTokenizer(br.readLine()); //도토리
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()); //함정
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        if (x2 < x1 && y2 < y1) {

        } else if (x2 < N && y2 < M) {

        } else {

        }

    }
}
