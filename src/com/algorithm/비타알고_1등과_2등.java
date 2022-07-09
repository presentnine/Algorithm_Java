package com.algorithm;

import java.io.*;

public class 비타알고_1등과_2등 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input.matches(".*12.*21.*") || input.matches(".*21.*12.*")) {//문자열 탐색
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
