package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class P9342 {

    static int T;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        Pattern pattern = Pattern.compile("^[A-F]?A+F+C+[A-F]?$");//정규표현식 등록

        for (int i = 0; i < T; i++) {
            String testCase = br.readLine();

            if(pattern.matcher(testCase).matches())//표현식 비교
                answer.append("Infected!\n");
            else
                answer.append("Good\n");
        }

        System.out.println(answer.toString());
    }
}
