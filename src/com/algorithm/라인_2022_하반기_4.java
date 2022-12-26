package com.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 라인_2022_하반기_4 {
}

class Solution_라인_2022_하반기_4 {
    public int[][] solution(String[] wall) {
        Queue<Infor> q = new LinkedList<>();
        int wallR = wall.length, wallC = wall[0].length();

        int[][] answer = new int[wallR][wallC];
        char[][] map = new char[wallR][wallC];

        for (int i = 0; i < answer.length; i++) {//answer 큰 수로 초기화
            Arrays.fill(answer[i], 987654321);
        }

        for (int i = 0; i < wallR; i++) {//map 초기화
            for (int j = 0; j < wallC; j++) {
                map[i][j] = wall[i].charAt(j);
            }
        }

        q.add(new Infor(wallR - 1, 0, 1));//시작점 큐

        while (!q.isEmpty()) {//bfs 탐색
            Infor now = q.poll();

            if (now.r < 0 || now.r >= wallR || now.c < 0 || now.c >= wallC) {//기존 map 밖
                continue;
            }

            if (answer[now.r][now.c] <= now.holdCount || map[now.r][now.c] != 'H') {//현 홀드의 최소값보다 크거나 애초에 홀드가 아닌 경우
                continue;
            }

            answer[now.r][now.c] = now.holdCount;//홀드 카운트 더 작은 값으로 변경

            //상하좌우
            q.add(new Infor(now.r + 1, now.c, now.holdCount + 1));
            q.add(new Infor(now.r - 1, now.c, now.holdCount + 1));
            q.add(new Infor(now.r, now.c + 1, now.holdCount + 1));
            q.add(new Infor(now.r, now.c - 1, now.holdCount + 1));

            if (now.r - 2 >= 0) {
                if (map[now.r - 1][now.c] == '.' && map[now.r - 2][now.c] == 'H') {//2칸 위의 홀드 이동
                    q.add(new Infor(now.r - 2, now.c, now.holdCount + 1));
                }
            }

            if (now.r - 1 >= 0) {
                if (now.c + 1 < wallC) {
                    if (map[now.r][now.c + 1] == '.' && map[now.r - 1][now.c] == '.' && map[now.r - 1][now.c + 1] == 'H') {//오른쪽 위 홀드 이동
                        q.add(new Infor(now.r - 1, now.c + 1, now.holdCount + 1));
                    }
                }

                if (now.c - 1 >= 0) {
                    if (map[now.r][now.c - 1] == '.' && map[now.r - 1][now.c] == '.' && map[now.r - 1][now.c - 1] == 'H') {//왼쪽 위 홀드 이동
                        q.add(new Infor(now.r - 1, now.c - 1, now.holdCount + 1));
                    }
                }

                if (now.c + 2 < wallC) {//오른쪽 2, 3칸 홀드 이동
                    if (map[now.r][now.c + 1] == '.' && map[now.r - 1][now.c] == '.' && map[now.r - 1][now.c + 1] == '.' && map[now.r - 1][now.c + 2] == '.') {
                        if (map[now.r][now.c + 2] == 'H') {
                            q.add(new Infor(now.r, now.c + 2, now.holdCount + 1));
                        }

                        if (now.c + 3 < wallC && map[now.r][now.c + 2] == '.' && map[now.r - 1][now.c + 3] == '.' && map[now.r][now.c + 3] == 'H') {
                            q.add(new Infor(now.r, now.c + 3, now.holdCount + 1));
                        }
                    }
                }

                if (now.c - 2 >= 0) {//왼쪽 2, 3칸 홀드 이동
                    if (map[now.r][now.c - 1] == '.' && map[now.r - 1][now.c] == '.' && map[now.r - 1][now.c - 1] == '.' && map[now.r - 1][now.c - 2] == '.') {
                        if (map[now.r][now.c - 2] == 'H') {
                            q.add(new Infor(now.r, now.c - 2, now.holdCount + 1));
                        }

                        if (now.c - 3 >= 0 && map[now.r][now.c - 2] == '.' && map[now.r - 1][now.c - 3] == '.' && map[now.r][now.c - 3] == 'H') {
                            q.add(new Infor(now.r, now.c - 3, now.holdCount + 1));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < wallR; i++) {//다시 돌며 값 수정
            for (int j = 0; j < wallC; j++) {
                if (answer[i][j] == 987654321) {
                    if (map[i][j] == '.' || map[i][j] == 'X') {
                        answer[i][j] = 0;
                    } else if (map[i][j] == 'H') {
                        answer[i][j] = -1;
                    }
                }
            }
        }

        return answer;
    }

    class Infor {//위치 정보
        int r, c, holdCount;

        public Infor(int r, int c, int holdCount) {
            this.r = r;
            this.c = c;
            this.holdCount = holdCount;
        }
    }
}