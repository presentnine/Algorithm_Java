package com.algorithm;

//https://www.acmicpc.net/problem/12869

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_12869 {

    static int[] hps = new int[3];
    static int[][][] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            hps[i] = Integer.parseInt(st.nextToken());
        }

        memory = new int[hps[0] + 1][hps[1] + 1][hps[2] + 1];

        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory[i].length; j++) {
                Arrays.fill(memory[i][j], -1);
            }
        }

        System.out.println(check(hps[0], hps[1], hps[2]));
    }

    static int check(int hp1, int hp2, int hp3) {
        hp1 = Math.max(hp1, 0);
        hp2 = Math.max(hp2, 0);
        hp3 = Math.max(hp3, 0);

        if (hp1 == 0 && hp2 == 0 && hp3 == 0) {
            return 0;
        }

        if (memory[hp1][hp2][hp3] != -1) {
            return memory[hp1][hp2][hp3];
        }

        int result = 987654321;

        result = Math.min(result, check(hp1 - 9, hp2 - 3, hp3 - 1) + 1);
        result = Math.min(result, check(hp1 - 9, hp2 - 1, hp3 - 3) + 1);
        result = Math.min(result, check(hp1 - 3, hp2 - 9, hp3 - 1) + 1);
        result = Math.min(result, check(hp1 - 3, hp2 - 1, hp3 - 9) + 1);
        result = Math.min(result, check(hp1 - 1, hp2 - 3, hp3 - 9) + 1);
        result = Math.min(result, check(hp1 - 1, hp2 - 9, hp3 - 3) + 1);

        return memory[hp1][hp2][hp3] = result;
    }
}
