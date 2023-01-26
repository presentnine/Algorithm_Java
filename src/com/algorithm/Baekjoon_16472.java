package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] check = new int[26];//문자 개수 파악용 배열
        int start = 0, end, answer = 1;
        ++check[(s.charAt(start) - 'a')];//문자열 가장 첫 문자 미리 대입

        for (end = 1; end < s.length(); end++) {//end 끝까지
            ++check[s.charAt(end) - 'a'];

            if (usedChar(check) > N) {//현 구간동안 사용된 문자 종류가 N을 넘는다면
                answer = Math.max(answer, end - start);
                
                while (usedChar(check) > N) {//사용된 문자 종류가 N 이하가 되도록 start를 땡김
                    --check[s.charAt(start++) - 'a'];
                }
            }
        }

        answer = Math.max(answer, end - start);
        System.out.println(answer);
    }

    static int usedChar(int[] check) {//구간동안 사용된 문자 개수 반환
        int result = 0;

        for (int i = 0; i < check.length; i++) {
            if (check[i] != 0) {
                ++result;
            }
        }

        return result;
    }
}
