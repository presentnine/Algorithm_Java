package com.algorithm;

//https://leetcode.com/problems/pacific-atlantic-water-flow/

import java.util.*;

public class LeetCode_Pacific_Atlantic_Water_Flow {
}

class Solution_LeetCode_Pacific_Atlantic_Water_Flow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        boolean[][] visitedFromPacificOcean = new boolean[m][n],
                visitedFromAtlanticOcean = new boolean[m][n];

        List<List<Integer>> answer = new ArrayList<>();

        //Pacfic Ocean에서 거슬러 올라가며 탐색
        Queue<Position> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {//바다와 인접한 부분 추가
            q.add(new Position(i, 0, -1));
        }

        for (int i = 0; i < n; i++) {//바다와 인접한 부분 추가
            q.add(new Position(0, i, -1));
        }

        while (!q.isEmpty()) {
            Position point = q.poll();

            if (point.r < 0 || point.r >= m || point.c < 0 || point.c >= n
                    || visitedFromPacificOcean[point.r][point.c]) {//맵 밖이거나 중복 방문인 경우
                continue;
            }

            if (heights[point.r][point.c] < point.postHeight) {//이전 높이보다 낮은 경우
                continue;
            }

            visitedFromPacificOcean[point.r][point.c] = true;

            q.add(new Position(point.r + 1, point.c, heights[point.r][point.c]));
            q.add(new Position(point.r - 1, point.c, heights[point.r][point.c]));
            q.add(new Position(point.r, point.c + 1, heights[point.r][point.c]));
            q.add(new Position(point.r, point.c - 1, heights[point.r][point.c]));
        }

        //Atlantic Ocean에서 거슬러 올라가며 탐색
        q = new LinkedList<>();

        for (int i = 0; i < m; i++) {//바다와 인접한 부분 추가
            q.add(new Position(i, n - 1, -1));
        }

        for (int i = 0; i < n; i++) {//바다와 인접한 부분 추가
            q.add(new Position(m - 1, i, -1));
        }

        while (!q.isEmpty()) {
            Position point = q.poll();

            if (point.r < 0 || point.r >= m || point.c < 0 || point.c >= n
                    || visitedFromAtlanticOcean[point.r][point.c]) {//맵 밖이거나 중복 방문인 경우
                continue;
            }

            if (heights[point.r][point.c] < point.postHeight) {//이전 높이보다 낮은 경우
                continue;
            }

            visitedFromAtlanticOcean[point.r][point.c] = true;

            q.add(new Position(point.r + 1, point.c, heights[point.r][point.c]));
            q.add(new Position(point.r - 1, point.c, heights[point.r][point.c]));
            q.add(new Position(point.r, point.c + 1, heights[point.r][point.c]));
            q.add(new Position(point.r, point.c - 1, heights[point.r][point.c]));
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedFromPacificOcean[i][j] && visitedFromAtlanticOcean[i][j]) {//조건에 해당하는 경우
                    answer.add(List.of(i, j));
                }
            }
        }

        return answer;
    }

    class Position{//데이터 클래스
        int r, c, postHeight;

        public Position(int r, int c, int postHeight) {
            this.r = r;
            this.c = c;
            this.postHeight = postHeight;
        }
    }
}
