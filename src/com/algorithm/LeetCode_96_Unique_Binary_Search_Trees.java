package com.algorithm;

//https://leetcode.com/problems/unique-binary-search-trees/

import java.util.HashSet;
import java.util.Set;

public class LeetCode_96_Unique_Binary_Search_Trees {
}

class Solution_LeetCode_96_Unique_Binary_Search_Trees {
    int[] dp;

    public int numTrees(int n) {
        dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {//bottom-up dp
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }
}
