package com.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로_건설 {
    public static void main(String[] args) {
        int[][] board = new int[][]
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        Solution_경주로_건설 s = new Solution_경주로_건설();

        System.out.println(s.solution(board));

    }
}

class Solution_경주로_건설 {
    int[][][] pointCost;
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(int[][] board) {
        int answer = 999999999, length = board.length;
        Queue<Point> q = new LinkedList<>(); //bfs용 큐

        pointCost = new int[length][length][4]; //각 위치별 값 저장(방향 포함)
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Arrays.fill(pointCost[i][j], 999999999);
            }
        }
        Arrays.fill(pointCost[0][0], 999999999);

        q.add(new Point(0, 0, 0, 4)); //bfs 탐색 시작

        while (!q.isEmpty()) {
            Point p = q.poll();

            //지정된 위치 밖 or 벽
            if (p.row >= length || p.row < 0 || p.col >= length || p.col < 0 || board[p.row][p.col] == 1)
                continue;

            //목표 지점 도달
            if (p.row == length - 1 && p.col == length - 1)
                answer = Math.min(answer, p.cost);

            //시작 제외 현재 비용이 해당 위치 최소값보다 크다면
            if (p.direction != 4 && p.cost >= pointCost[p.row][p.col][p.direction])
                continue;

            //해당 위치 가격 최신화
            if (p.direction != 4)
                pointCost[p.row][p.col][p.direction] = p.cost;

            for (int i = 0; i < 4; i++) {
                Point point = new Point(p.row + dir[i][0], p.col + dir[i][1], 0, i);

                if (p.direction == 4) {//시작인 경우 방향 상관없이 모두 +100원
                    point.cost = p.cost + 100;
                } else {
                    if (p.direction == i) {//방향이 동일한 경우 = 직선 도로
                        point.cost = p.cost + 100;
                    } else {//방향이 다른 경우 = 직선 도로 and 코너
                        point.cost = p.cost + 600;
                    }
                }

                q.add(point);
            }
        }

        return answer;
    }

    class Point {//위치 정보 클래스
        int row, col, cost, direction;

        public Point(int row, int col, int cost, int direction) {
            this.row = row;
            this.col = col;
            this.cost = cost;
            this.direction = direction;
        }
    }
}