package com.algorithm;

//https://leetcode.com/problems/count-and-say/

public class LeetCode_Count_and_Say {

}
class Solution_LeetCode_Count_and_Say {
    String[] countAndSayResult;

    public String countAndSay(int n) {
        countAndSayResult = new String[n + 1];
        countAndSayResult[1] = "1";

        if (n > 1) {//1 보다 큰 숫자들에 대해
            makeDigitString(n);
        }
        
        return countAndSayResult[n];
    }

    void makeDigitString(int n) {
        if (countAndSayResult[n - 1] == null) {//이전 결과가 없다면
            makeDigitString(n - 1);
        }

        String digitString = countAndSayResult[n - 1];
        StringBuilder result = new StringBuilder();
        int digitCount = 0;

        for (int i = 0; i < digitString.length(); i++) {
            char digit = digitString.charAt(i);
            ++digitCount;

            if (i + 1 >= digitString.length() || digitString.charAt(i + 1) != digit) {//마지막 or 다음 숫자와 다르면 결과 출력
                result.append(digitCount);
                result.append(digit);
                digitCount = 0;
            }
        }

        countAndSayResult[n] = result.toString();
    }
}
