package com.algorithm;

//https://leetcode.com/problems/longest-increasing-subsequence/

public class LeetCode_Longest_Increasing_Subsequence {

}

class Solution_LeetCode_Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];//dp용 배열
        dp[dp.length - 1] = 1;//nums 배열의 마지막 요소 -> 길이가 1
        int answer = 1;

        for (int i = nums.length - 2; i >= 0; i--) {//마지막의 앞에서부터 맨앞까지
            dp[i] = 0;
            int maxIndex = i;

            for (int j = i + 1; j < nums.length; j++) {//i부터 마지막사이
                if (nums[i] < nums[j] && dp[maxIndex] < dp[j]) {//i보다 값이 크며 dp값이 최대인 것 찾기
                    maxIndex = j;
                }
            }

            dp[i] = dp[maxIndex] + 1;//해당 dp값 초기화
        }

        for (int i = 0; i < dp.length; i++) {//전체에서 dp 최대 값 찾기
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}