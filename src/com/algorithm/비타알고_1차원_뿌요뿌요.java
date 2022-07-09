package com.algorithm;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 비타알고_1차원_뿌요뿌요 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String answer = "CLEAR!";
        Stack<Infor> stack = new Stack<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        stack.push(new Infor(s.charAt(0), 1));

        for (int i = 1; i < N; ) {
            char now = s.charAt(i);
            Infor before = null;

            if (!stack.isEmpty()) {
                before = stack.peek();
            }

            if (before != null && now == before.c && before.count == M - 1) {
                while (i < N && now == s.charAt(i)) {
                    ++i;
                }

                for (int j = 0; j < M - 1; j++) {
                    stack.pop();
                }
            } else {
                if (before != null && now == before.c) {
                    stack.add(new Infor(now, before.count + 1));
                } else {
                    stack.add(new Infor(now, 1));
                }
                ++i;
            }
        }

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                sb.append(stack.pop().c).toString();
            }

            answer = sb.reverse().toString();
        }

        System.out.println(answer);
    }
}

class Infor{
    char c;
    int count;

    public Infor(char c, int count) {
        this.c = c;
        this.count = count;
    }
}
