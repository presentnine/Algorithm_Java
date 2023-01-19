package com.algorithm;

//https://www.acmicpc.net/problem/1676

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(counting5(N, 0));
    }

    static int counting5(int n, int acc) {
        if (n < 5) {
            return acc;
        }

        int temp = n, count = 0;

        while (temp % 5 == 0) {
            ++count;
            temp /= 5;
        }

        return counting5(n - 1, acc + count);
    }
}
