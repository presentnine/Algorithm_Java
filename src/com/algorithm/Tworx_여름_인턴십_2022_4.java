package com.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Tworx_여름_인턴십_2022_4 {
    public static void main(String[] args) {
        String[] grid =
                {".F.FFFFF.F", ".########.", ".########F", "...######F", "##.######F", "...######F", ".########F", ".########.", ".#...####F", "...#......"};
        int k = 6;

        Solution_Tworx_여름_인턴십_2022_4 s = new Solution_Tworx_여름_인턴십_2022_4();

        System.out.println(s.solution(grid, k));
    }
}
class Solution_Tworx_여름_인턴십_2022_4 {
    public int solution(String[] grid, int k) {
        int answer = 987654321;
        int n = grid.length, m = grid[0].length();
        char[][] map = new char[n][m];
        int[][][] visited = new int[n][m][k + 1];
        Queue<Infor> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {//지도 초기화
            for (int j = 0; j < m; j++) {
                map[i][j] = grid[i].charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {//방문 배열 초기화
            for (int j = 0; j < m; j++) {
                Arrays.fill(visited[i][j], 987654321);
            }
        }

        q.add(new Infor(0, 0, 0, 0));

        while (!q.isEmpty()) {//bfs 탐색
            Infor now = q.poll();

            if (now.r < 0 || now.r >= n || now.c < 0 || now.c >= m
                    || map[now.r][now.c] == '#' || now.moveCount > k) {//허용 위치 x
                continue;
            }

            if (map[now.r][now.c] == 'F' && now.moveCount == k) {//숲에서 이동 불가인 경우
                continue;
            }

            if (now.r == n - 1 && now.c == m - 1) {//목적지 도착
                answer = Math.min(answer, now.campCount);
            }

            if (now.campCount >= visited[now.r][now.c][now.moveCount]) {//동일한 상태에서 야영 횟수가 더 많은 경우
                continue;
            }

            visited[now.r][now.c][now.moveCount] = now.campCount;//현재 상태에 대한 야영횟수로 초기화

            if (map[now.r][now.c] == '.') {//현재 위치가 평지라면 야영
                q.add(new Infor(now.r, now.c, 0, now.campCount + 1));
            }
            q.add(new Infor(now.r + 1, now.c, now.moveCount + 1, now.campCount));
            q.add(new Infor(now.r - 1, now.c, now.moveCount + 1, now.campCount));
            q.add(new Infor(now.r, now.c + 1, now.moveCount + 1, now.campCount));
            q.add(new Infor(now.r, now.c - 1, now.moveCount + 1, now.campCount));
        }

        return answer;
    }

    class Infor{
        int r, c, moveCount, campCount;

        public Infor(int r, int c, int moveCount, int campCount) {
            this.r = r;
            this.c = c;
            this.moveCount = moveCount;
            this.campCount = campCount;
        }
    }
}
