package com.algorithm;

//https://leetcode.com/problems/multiply-strings/

public class LeetCode_Multiply_Strings {
}

class Solution_LeetCode_Multiply_Strings {
    public String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int[] acc = new int[num1.length() * num2.length() + 1];
        int num1Digit, num2Digit;

        for (int i = 0; i < num1.length(); i++) {//각 위치의 숫자를 가져와 곱셉 후 해당 자릿수 배열에 저장
            num1Digit = num1.charAt(num1.length() - 1 - i) - '0';

            for (int j = 0; j < num2.length(); j++) {
                num2Digit = num2.charAt(num2.length() - 1 - j) - '0';
                acc[i + j] += num1Digit * num2Digit;
            }
        }

        for (int i = 0; i < acc.length; i++) {//일의 자리부터 거슬러 올라가며 해당 자리 숫자 계산
            if (acc[i] >= 10) {
                acc[i + 1] += acc[i] / 10;
            }
            result.insert(0, acc[i] % 10);
        }

        while (result.charAt(0) == '0' && result.length() > 1) {//앞 부분의 0 제거
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}