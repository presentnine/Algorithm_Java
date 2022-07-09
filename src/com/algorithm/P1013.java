package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P1013 {

    static int T;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        Pattern pattern = Pattern.compile("(100+1+|01)+");//정규표현식 등록

        for (int i = 0; i < T; i++) {
            String signal = br.readLine();
            Matcher matcher = pattern.matcher(signal);//문자열 등록

            if (matcher.matches()) {//매칭 결과 확인
                answer.append("YES\n");
            } else {
                answer.append("NO\n");
            }
        }

        System.out.println(answer.toString());
    }
}
