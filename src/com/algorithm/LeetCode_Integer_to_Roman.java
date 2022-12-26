package com.algorithm;

public class LeetCode_Integer_to_Roman {
}

class Solution_LeetCode_Integer_to_Roman {
    public String intToRoman(int num) {
        int remainder = num, quotient;
        StringBuilder sb = new StringBuilder();

        quotient = remainder / 1000;
        remainder = remainder - quotient * 1000;
        for (int i = 0; i < quotient; i++) {//1000의 자리 formatting
            sb.append('M');
        }

        quotient = remainder / 100;
        remainder = remainder - quotient * 100;

        sb.append(formatting(quotient, 'C', 'D', 'M'));//100의 자리 formatting

        quotient = remainder / 10;
        remainder = remainder - quotient * 10;

        sb.append(formatting(quotient, 'X', 'L', 'C'));//10의 자리 formatting
        sb.append(formatting(remainder, 'I', 'V', 'X'));//1의 자리 formatting

        return sb.toString();
    }

    String formatting(int count, char formatFor1, char formatFor5, char formatFor10) {//특정 대역의 포메팅 함수
        StringBuilder sb = new StringBuilder();

        if (count <= 3) {
            for (int i = 0; i < count; i++) {
                sb.append(formatFor1);
            }
        } else if (count == 4) {
            sb.append(formatFor1);
            sb.append(formatFor5);
        } else if (count < 9) {
            sb.append(formatFor5);
            for (int i = 0; i < count - 5; i++) {
                sb.append(formatFor1);
            }
        } else {
            sb.append(formatFor1);
            sb.append(formatFor10);
        }

        return sb.toString();
    }
}
