package com.algorithm;

//https://www.acmicpc.net/problem/17144

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_17144 {
    static int[][] room;
    static int[] airCleanerRow = new int[2];
    static int R, C, T;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp = 0, answer = 0;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];

        for (int i = 0; i < R; i++) {//방 배열 생성, 공기청정기 위치, 각 먼지 양 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());

                if (room[i][j] == -1) {
                    airCleanerRow[temp++] = i;
                } else if (room[i][j] != 0) {
                    q.add(new Point(i, j, room[i][j]));
                }
            }
        }

        for (int i = 0; i < T; i++) {//주어진 초만큼 변화 반복
            change();
        }

        for (int i = 0; i < R; i++) {//방에 남은 미세먼지 양 모두 계산
            for (int j = 0; j < C; j++) {
                if (room[i][j] != 0 && room[i][j] != -1) {
                    answer += room[i][j];
                }
            }
        }

        System.out.println(answer);
    }

    static void change() {//한번의 순환
        while (!q.isEmpty()) {
            dirtMove(q.poll());
        }

        //공기청정기 위쪽 순환
        for (int r = airCleanerRow[0] - 1; r >= 1; r--) {
            room[r][0] = room[r - 1][0];
        }
        for (int c = 0; c < C - 1; c++) {
            room[0][c] = room[0][c + 1];
        }
        for (int r = 0; r < airCleanerRow[0]; r++) {
            room[r][C - 1] = room[r + 1][C - 1];
        }
        for (int c = C - 1; c > 1; c--) {
            room[airCleanerRow[0]][c] = room[airCleanerRow[0]][c - 1];
        }
        room[airCleanerRow[0]][1] = 0;

        //공기청정기 아래쪽 순환
        for (int r = airCleanerRow[1] + 1; r < R - 1; r++) {
            room[r][0] = room[r + 1][0];
        }
        for (int c = 0; c < C - 1; c++) {
            room[R - 1][c] = room[R - 1][c + 1];
        }
        for (int r = R - 1; r > airCleanerRow[1]; r--) {
            room[r][C - 1] = room[r - 1][C - 1];
        }
        for (int c = C - 1; c > 1; c--) {
            room[airCleanerRow[1]][c] = room[airCleanerRow[1]][c - 1];
        }
        room[airCleanerRow[1]][1] = 0;

        for (int i = 0; i < R; i++) {//다음 change() 함수에 사용할 먼지 좌표 큐 초기화
            for (int j = 0; j < C; j++) {
                if (room[i][j] != 0 && room[i][j] != -1) {
                    q.add(new Point(i, j, room[i][j]));
                }
            }
        }
    }

    static void dirtMove(Point p) {//퍼지는 먼지 계산
        int moveAmount = p.dirtAmount / 5, moveTotalAmount = 0;

        if (moveAmount == 0) {
            return;
        }

        if (p.c + 1 < C) {
            room[p.r][p.c + 1] += moveAmount;
            moveTotalAmount += moveAmount;
        }

        if (p.c - 1 >= 0 && room[p.r][p.c - 1] != -1) {
            room[p.r][p.c - 1] += moveAmount;
            moveTotalAmount += moveAmount;
        }

        if (p.r + 1 < R && room[p.r + 1][p.c] != -1) {
            room[p.r + 1][p.c] += moveAmount;
            moveTotalAmount += moveAmount;
        }

        if (p.r - 1 >= 0 && room[p.r - 1][p.c] != -1) {
            room[p.r - 1][p.c] += moveAmount;
            moveTotalAmount += moveAmount;
        }

        room[p.r][p.c] -= moveTotalAmount;
    }

    static class Point{
        int r, c, dirtAmount;

        public Point(int r, int c, int dirtAmount) {
            this.r = r;
            this.c = c;
            this.dirtAmount = dirtAmount;
        }
    }
}