package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Baekjoon_14906 {

    static int N;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String s1 = "", s2 = "";

            for (int j = s.length() - 1; j >= 0; j--) {//문자열 분리
                if(s.charAt(j)=='C'||s.charAt(j)=='H'){
                    s1 = s.substring(0, j + 1);
                    s2 = s.substring(j + 1);
                    break;
                }
            }

            if (isSlimp(s1) && isSlump(s2)) {//앞쪽은 '스림프'인지, 뒷쪽은 '스럼프'인지
                answer.append("YES\n");
            } else {
                answer.append("NO\n");
            }
        }

        System.out.println("SLURPYS OUTPUT\n" + answer.toString() + "END OF OUTPUT\n");
    }

    public static boolean isSlimp(String s) {//'스림프' 판별 함수
        if(s.length()==0)
            return false;

        if (s.length() == 2) {
            if (s.equals("AH")) {
                return true;
            } else {
                return false;
            }
        }

        if (s.length() >= 3) {
            if(s.charAt(s.length()-1)!='C')
                return false;

            if(s.charAt(0)=='A' && s.charAt(1)=='B')
                return isSlimp(s.substring(2, s.length() - 1));

            if(s.charAt(0)=='A')
                return isSlump(s.substring(1, s.length() - 1));
        }

        return false;
    }

    public static boolean isSlump(String s) {//'스럼프' 판별 함수
        Pattern Slump = Pattern.compile("((D|E)F+)+G");

        return Slump.matcher(s).matches();
    }
}
