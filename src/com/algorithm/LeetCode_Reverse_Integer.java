package com.algorithm;

//https://leetcode.com/problems/reverse-integer/
public class LeetCode_Reverse_Integer {
}

class Solution_LeetCode_Reverse_Integer {
    static int MAX_INTEGER_VALUE = 2147483647, MIN_INTEGER_VALUE = -2147483648;
    public int reverse(int x) {
        boolean isMinus = false;
        long reverseX = 0;

        if (x < 0) {
            isMinus = true;
            x = x * -1;
        }

        while (x != 0) {
            reverseX = reverseX * 10 + x % 10;
            x = x / 10;
        }

        if (isMinus) {
            reverseX = reverseX * -1;
        }

        if (reverseX < MIN_INTEGER_VALUE || MAX_INTEGER_VALUE < reverseX) {
            return 0;
        } else {
            return (int) reverseX;
        }
    }
}