package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 비타알고_앵무새_꼬꼬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String result = "";

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                switch (c) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        result += c;
                        break;
                }
            }

            if (result.equals("")) {
                answer.append("???");
            } else {
                answer.append(result);
            }

            answer.append('\n');
        }

        System.out.println(answer);
    }
}
