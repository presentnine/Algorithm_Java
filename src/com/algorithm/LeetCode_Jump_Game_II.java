package com.algorithm;

//https://leetcode.com/problems/jump-game-ii/

import java.util.Arrays;

public class LeetCode_Jump_Game_II {
}

class Solution_LeetCode_Jump_Game_II {
    int[] dp;//dp 배열

    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, 987654321);
        dp[dp.length - 1] = 0;//목적지의 경우 횟수 0

        return search(0, nums);
    }

    int search(int index, int[] nums){
        if (index >= dp.length) {//인덱스 밖
            return 987654321;
        }

        if (dp[index] != 987654321) {//기존 결과값이 존재한다면
            return dp[index];
        }

        int result = 987654321;

        for (int i = 1; i <= nums[index]; i++) {//갈 수 있는 곳 중 최대
            result = Math.min(result, search(index + i, nums));
        }

        return dp[index] = result + 1;
    }
}