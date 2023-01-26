package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Infor> queue = new LinkedList<>();
        HashSet<String> hashSet = new HashSet<>();//남은 토마토 좌표 저장

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] wareHouse = new int[N][M][H];
        boolean[][][] visited = new boolean[N][M][H];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    wareHouse[i][j][k] = Integer.parseInt(st.nextToken());

                    if (wareHouse[i][j][k] == 1) {//익은 토마토라면 시작 큐에
                        queue.add(new Infor(i, j, k, 0));
                    } else if (wareHouse[i][j][k] == 0) {//안익은 토마토라면 좌표 저장
                        hashSet.add(i + "-" + j + "-" + k);
                    }
                }
            }
        }


        while (!queue.isEmpty()) {
            Infor now = queue.poll();

            if (now.r < 0 || now.r >= N || now.c < 0 || now.c >= M || now.h < 0 || now.h >= H) {
                continue;
            }

            if (wareHouse[now.r][now.c][now.h] == -1 || visited[now.r][now.c][now.h]) {
                continue;
            }

            visited[now.r][now.c][now.h] = true;//방문 처리
            hashSet.remove(now.r + "-" + now.c + "-" + now.h);//남은 토마토 좌표에서 제거

            if (hashSet.isEmpty()) {//더 익을 토마토가 없다면
                System.out.println(now.time);
                return;
            }

            queue.add(new Infor(now.r + 1, now.c, now.h, now.time + 1));
            queue.add(new Infor(now.r - 1, now.c, now.h, now.time + 1));
            queue.add(new Infor(now.r, now.c + 1, now.h, now.time + 1));
            queue.add(new Infor(now.r, now.c - 1, now.h, now.time + 1));
            queue.add(new Infor(now.r, now.c, now.h + 1, now.time + 1));
            queue.add(new Infor(now.r, now.c, now.h - 1, now.time + 1));
        }

        System.out.println("-1");
    }

    static class Infor {
        int r, c, h, time;

        public Infor(int r, int c, int h, int time) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.time = time;
        }
    }
}
