package com.algorithm;

import java.io.*;
import java.util.*;
public class 비타알고_제설작전 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int sectionsCount, snowShovelsCount, rocksCount, maxSnowAmount = 0, k = 1000000;
        int[] sections, snowShovels, rocks;
        int[][] sectionsAcc;

        //구간 눈의 높이 -> 배열 저장
        sectionsCount = Integer.parseInt(br.readLine());
        sections = new int[sectionsCount + 1];
        sectionsAcc = new int[2][sectionsCount + 1]; //누적 계산 & 이전 돌의 위치 저장 용

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= sectionsCount; i++) {
            sections[i] = Integer.parseInt(st.nextToken());
        }
        
        //눈삽의 너비 -> 배열 저장
        snowShovelsCount = Integer.parseInt(br.readLine());
        snowShovels = new int[snowShovelsCount];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < snowShovelsCount; i++) {
            snowShovels[i] = Integer.parseInt(st.nextToken());
        }

        //돌의 위치 -> 배열 저장
        rocksCount = Integer.parseInt(br.readLine());
        rocks = new int[rocksCount];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < rocksCount; i++) {
            rocks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(rocks);//정렬

        for (int i = 0; i < rocksCount; i++) {//각 구간 위치마다 가장 이전 돌의 위치 저장
            int rockPos = rocks[i];

            if (i == rocksCount - 1) {
                for (int j = rockPos; j <= sectionsCount; j++) {
                    sectionsAcc[1][j] = rockPos;
                }
            } else {
                for (int j = rockPos; j <= rocks[i + 1]; j++) {
                    sectionsAcc[1][j] = rockPos;
                }
            }
        }

        //눈의 높이 누적 계산
        sectionsAcc[0][0] = sections[0];
        for (int i = 1; i <= sectionsCount; i++) {
            if (sectionsAcc[1][i] == i) {//현 위치가 돌이면 자기 자신만
                sectionsAcc[0][i] = sections[i];
            } else {
                sectionsAcc[0][i] = sections[i] + sectionsAcc[0][i - 1];
            }
        }

        for (int i = 1; i <= sectionsCount; i++) {//구간 각 위치에 대해
            for (int j = 0; j < snowShovelsCount; j++) {//매 눈삽 너비마다
                int snowShovelLength = snowShovels[j];

                if (i - sectionsAcc[1][i] >= snowShovelLength && i >= snowShovelLength) {//눈삽 사용이 가능한 위치라면
                    int snowAmount = sectionsAcc[0][i] - sectionsAcc[0][i - snowShovelLength];//치울 수 있는 눈의 양 계산

                    if (snowAmount > maxSnowAmount) {//현재까지의 최대 눈의 양보다 많으면
                        maxSnowAmount = snowAmount;
                        k = snowShovelLength;
                    } else if (snowAmount == maxSnowAmount) {//현재까지의 최대 눈의 양과 같으면
                        k = Math.min(k, snowShovelLength);
                    }
                }
            }
        }

        System.out.println(k + " " + maxSnowAmount);
    }
}
