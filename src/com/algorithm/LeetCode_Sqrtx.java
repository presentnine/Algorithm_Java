package com.algorithm;

//https://leetcode.com/problems/sqrtx/

public class LeetCode_Sqrtx {
}

class Solution_LeetCode_Sqrtx {
    public int mySqrt(int x) {
        int start = 0, end = x, mid;

        while (start <= end) {//이분탐색
            mid = (start + end) / 2;

            if ((long) mid * mid < x) {
                start = mid + 1;
            } else if ((long) mid * mid == x) {
                return mid;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }
}