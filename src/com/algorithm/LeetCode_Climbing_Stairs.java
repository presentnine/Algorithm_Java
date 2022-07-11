package com.algorithm;

//https://leetcode.com/problems/climbing-stairs/
public class LeetCode_Climbing_Stairs {
}
class Solution_LeetCode_Climbing_Stairs {
    public int climbStairs(int n) {
        if (n == 1) {//계단 한 개
            return 1;
        } else if (n == 2) {//계단 두 개
            return 2;
        }

        int[] acc = new int[n];//누적값 배열
        acc[0] = 1;
        acc[1] = 2;

        for (int i = 2; i < n; i++) {//점화식
            acc[i] = acc[i - 1] + acc[i - 2];
        }

        return acc[n - 1];
    }
}
