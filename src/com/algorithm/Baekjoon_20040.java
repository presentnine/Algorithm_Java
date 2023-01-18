package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_20040 {

    static int n, m, par[];

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        par = new int[n];//부모 배열 초기화
        Arrays.fill(par, -1);

        for (int i = 1; i <= m; i++) {
            int point1, point2;
            st = new StringTokenizer(br.readLine());

            point1 = Integer.parseInt(st.nextToken());
            point2 = Integer.parseInt(st.nextToken());

            point1 = findPar(point1);
            point2 = findPar(point2);

            if (point1 == point2) {//같으면 사이클 -> 출력
                System.out.println(i);
                return;
            }
            else {//같지 않으면 그룹 merge
                par[point1]= point2;
            }
        }

        System.out.println(0);
    }

    static int findPar(int point){//재귀 함수 기반 최상단 부모 반환
        if (par[point] == -1)
            return point;

        return par[point] = findPar(par[point]);
    }
}
