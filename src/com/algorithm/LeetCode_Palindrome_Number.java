package com.algorithm;

public class LeetCode_Palindrome_Number {

}

class Solution_LeetCode_Palindrome_Number {
    public boolean isPalindrome(int x) {
        int length = 1;

        if (x < 0) {//음수인 경우
            return false;
        } else if (x < 10) {//한자릿수인 경우
            return true;
        }

        String s = String.valueOf(x);//변환

        if (s.length() % 2 == 0) {//숫자의 길이가 짝수인 경우
            int left = s.length() / 2 - 1, right = s.length() / 2;

            while (left >= 0) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }

                --left;
                ++right;
            }
        } else {//숫자의 길이가 홀수인 경우
            int left = s.length() / 2 - 1, right = s.length() / 2 + 1;

            while (left >= 0) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }

                --left;
                ++right;
            }
        }

        return true;
    }
}
