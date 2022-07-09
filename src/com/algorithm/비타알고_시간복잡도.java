package com.algorithm;

import java.io.*;

public class 비타알고_시간복잡도 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long countOf5 = 0, n, count;

        for (int i = 1; i <= N; i++) {
            n = i;
            count = 0;

            while (n % 5 == 0) {
                count++;
                n = n / 5;
            }

            countOf5 += count;
        }

        System.out.println(countOf5);
    }
}
