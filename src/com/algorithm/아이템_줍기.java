package com.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템_줍기 {
    public static void main(String[] args) {
        int[][] rectangle = new int[][]
                {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX=1, characterY=3, itemX=7, itemY = 8;

        Solution_아이템_줍기 s = new Solution_아이템_줍기();

        System.out.println(s.solution(rectangle, characterX, characterY, itemX, itemY));
    }
}

class Solution_아이템_줍기 {
    int[][] map = new int[101][101];
    Queue<Point> q = new LinkedList<>();

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 99999999;

        for (int i = 0; i < rectangle.length; i++) {//map에 표시
            int startX = 2 * rectangle[i][0], startY = 2 * rectangle[i][1], endX = 2 * rectangle[i][2], endY = 2 * rectangle[i][3];

            for (int r = startY; r <= endY; r++) {
                for (int c = startX; c <= endX; c++) {
                    if (r == startY || r == endY || c == startX || c == endX) {//현 지점이 모서리라면
                        if (map[r][c] != 2) {//다른 직사각형의 내부가 아니라면
                            map[r][c] = 1;
                        }
                    }
                    else {//현 지점이 직사각형의 내부인 경우
                        map[r][c] = 2;
                    }
                }
            }
        }

        q.add(new Point(characterY * 2, characterX * 2, 0));//큐에 초기값 입력

        while (!q.isEmpty()) {//bfs
            Point here = q.poll();

            if (here.r < 0 || here.r > 100 || here.c < 0 || here.c > 100 || map[here.r][here.c] != 1)
                continue;

            if (here.r == itemY * 2 && here.c == itemX * 2)
                answer = Math.min(answer, here.length);

            map[here.r][here.c] = 3;

            q.add(new Point(here.r + 1, here.c, here.length + 1));
            q.add(new Point(here.r - 1, here.c, here.length + 1));
            q.add(new Point(here.r, here.c + 1, here.length + 1));
            q.add(new Point(here.r, here.c - 1, here.length + 1));
        }

        return answer / 2;//각 좌표를 2배로 늘렸기 때문에 답을 2로 나눠 반환
    }

    class Point {//위치 정보 클래스
        int r, c, length;

        public Point(int r, int c, int length) {
            this.r = r;
            this.c = c;
            this.length = length;
        }
    }
}