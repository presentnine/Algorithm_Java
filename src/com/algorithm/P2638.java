package com.algorithm;

//https://www.acmicpc.net/problem/2638

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2638 {
    static int[][] space;
    static int N, M, cheeseAmount = 0, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        space = new int[N][M];

        for (int i = 0; i < N; i++) {//격자 생성
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());

                if (space[i][j] == 1) {
                    ++cheeseAmount;
                }
            }
        }

        paint(0, 0);//외부 공기 표시

        while (cheeseAmount != 0) {//모든 치즈가 녹을때까지
            Queue<Point> q = new LinkedList<>();

            for (int i = 1; i < N - 1; i++) {//각 위치에서 녹는 치즈 체크 후 큐에 저장
                for (int j = 1; j < M - 1; j++) {
                    int outCount = 0;
                    if (space[i][j] == 1) {
                        if (space[i - 1][j] == -1) {
                            ++outCount;
                        }
                        if (space[i + 1][j] == -1) {
                            ++outCount;
                        }
                        if (space[i][j - 1] == -1) {
                            ++outCount;
                        }
                        if (space[i][j + 1] == -1) {
                            ++outCount;
                        }

                        if (outCount >= 2) {
                            q.add(new Point(i, j));
                        }
                    }
                }
            }

            while (!q.isEmpty()) {//녹은 치즈 표시 후 추가 공기 표시
                Point p = q.poll();
                space[p.r][p.c] = -1;
                paint(p.r + 1, p.c);
                paint(p.r - 1, p.c);
                paint(p.r, p.c + 1);
                paint(p.r, p.c - 1);
                --cheeseAmount;
            }

            ++answer;
        }

        System.out.println(answer);
        return;
    }

    static void paint(int r, int c) {//bfs 기반 외부 공기 체크 함수
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r < 0 || N <= now.r || now.c < 0 || M <= now.c
                    || space[now.r][now.c] == 1 || space[now.r][now.c] == -1) {
                continue;
            }

            space[now.r][now.c] = -1;

            q.add(new Point(now.r + 1, now.c));
            q.add(new Point(now.r - 1, now.c));
            q.add(new Point(now.r, now.c + 1));
            q.add(new Point(now.r, now.c - 1));
        }
    }

    static class Point {//좌표 클래스
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
