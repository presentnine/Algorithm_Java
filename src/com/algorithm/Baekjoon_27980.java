package com.algorithm;

//https://www.acmicpc.net/problem/27980

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_27980 {

    static int[][] memory;
    public static void main(String[] args) throws IOException {
        int maxPoint = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        memory = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(memory[i], -1);
        }

        String boardString = br.readLine();
        String string = br.readLine();

        for (int i = 0; i < N; i++) {//보드 속 시작 위치를 모두 다르게
            maxPoint = Math.max(maxPoint,
                    check(N, M, boardString, string, i, 0));
        }

        System.out.println(maxPoint);
    }

    static int check(int N, int M, String boardString, String string, int boardStringIndex, int stringIndex) {
        if (stringIndex == M) {//기저 조건
            return 0;
        }

        if (memory[boardStringIndex][stringIndex] != -1) {//기존 연산값 존재
            return memory[boardStringIndex][stringIndex];
        }

        int point = 0;

        if (boardStringIndex > 0) {//보드에서 왼쪽으로 갈 수 있다면
            point = check(N, M, boardString, string, boardStringIndex - 1, stringIndex + 1);
        }

        if (boardStringIndex < N - 1) {//보드에서 오른쪽으로 갈 수 있다면
            point = Math.max(point, check(N, M, boardString, string, boardStringIndex + 1, stringIndex + 1));
        }

        if (boardString.charAt(boardStringIndex) == string.charAt(stringIndex)) {//현 위치의 문자가 같다면
            ++point;
        }

        return memory[boardStringIndex][stringIndex] = point;
    }
}
