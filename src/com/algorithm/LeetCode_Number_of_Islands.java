package com.algorithm;

//https://leetcode.com/problems/number-of-islands/

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Number_of_Islands {
    public static void main(String[] args) {

    }
}

class Solution_LeetCode_Number_of_Islands {
    Queue<Point> q = new LinkedList<>();

    public int numIslands(char[][] grid) {
        int answer = 0, r = grid.length, c = grid[0].length;

        for (int i = 0; i < r; i++) {//전체 grid를 돌며
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {//지상인 경우(+ 방문하지 않은 경우)
                    q.add(new Point(i, j));

                    while (!q.isEmpty()) {//bfs 탐색
                        Point now = q.poll();

                        if (now.r < 0 || now.r >= r || now.c < 0 || now.c >= c
                                 || grid[now.r][now.c] == '0') {//예외 사항
                            continue;
                        }

                        grid[now.r][now.c] = '0';//방문 표시

                        q.add(new Point(now.r + 1, now.c));
                        q.add(new Point(now.r - 1, now.c));
                        q.add(new Point(now.r, now.c + 1));
                        q.add(new Point(now.r, now.c - 1));
                    }

                    ++answer;
                }
            }
        }

        return answer;
    }

    class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}