package com.algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 비타알고_불이야 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Point> q = new LinkedList<>();

        int answer = 0;
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();

            for (int j = 0; j < C; j++) {
                char c = input.charAt(j);
                map[i][j] = c;

                if (c == '@') {
                    q.add(new Point(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.r < 0 || p.r >= R || p.c < 0 || p.c >= C || map[p.r][p.c] == '#')
                continue;

            if (map[p.r][p.c] == '&') {
                answer = p.time;
                break;
            }

            map[p.r][p.c] = '#';

            q.add(new Point(p.r + 1, p.c, p.time + 1));
            q.add(new Point(p.r - 1, p.c, p.time + 1));
            q.add(new Point(p.r, p.c + 1, p.time + 1));
            q.add(new Point(p.r, p.c - 1, p.time + 1));
        }

        System.out.println(answer - 1);
    }
}

class Point{
    int r, c, time;

    public Point(int r, int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }
}
