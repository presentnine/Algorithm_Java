package com.algorithm;

//https://leetcode.com/problems/add-binary/

public class LeetCode_Add_Binary {
}

class Solution_LeetCode_Add_Binary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLength = a.length(), bLength = b.length(), maxLength = Math.max(a.length(), b.length());
        int acc = 0, index = 0;

        for (; index < maxLength; index++) {
            int calResult = acc;//이전 계산에 대한 현 위치 누적값

            if (index < aLength) {//a에서 해당 위치의 값이 존재
                calResult += a.charAt(aLength - 1 - index) - '0';
            }

            if (index < bLength) {//b에서 해당 위치의 값이 존재
                calResult += b.charAt(bLength - 1 - index) - '0';
            }

            acc = calResult / 2;
            sb.append(calResult % 2);
        }

        if (acc != 0) {//마지막으로 acc 확인
            sb.append(acc);
        }

        return sb.reverse().toString();
    }
}