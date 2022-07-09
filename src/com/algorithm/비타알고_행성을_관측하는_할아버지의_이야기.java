package com.algorithm;

import java.io.*;
import java.util.*;

public class 비타알고_행성을_관측하는_할아버지의_이야기 {
    static ArrayList<Integer>[] smallerThan, biggerThan;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        smallerThan = new ArrayList[N + 1];
        biggerThan = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            smallerThan[i] = new ArrayList<>();
            biggerThan[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());

            smallerThan[big].add(small);
            biggerThan[small].add(big);
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            checkBigger(i);
            answer.append(count() + " ");
            Arrays.fill(visited, false);
            checkSmaller(i);
            answer.append(count() + "\n");
        }

        System.out.println(answer);
    }

    static void checkBigger(int num) {
        if (visited[num]) {
            return;
        } else {
            visited[num] = true;

            for (int i = 0; i < biggerThan[num].size(); i++) {
                checkBigger(biggerThan[num].get(i));
            }
        }
    }

    static void checkSmaller(int num) {
        if (visited[num]) {
            return;
        } else {
            visited[num] = true;

            for (int i = 0; i < smallerThan[num].size(); i++) {
                checkSmaller(smallerThan[num].get(i));
            }
        }
    }

    static int count() {
        int result = 0;

        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) {
                ++result;
            }
        }

        return result - 1;
    }
}
