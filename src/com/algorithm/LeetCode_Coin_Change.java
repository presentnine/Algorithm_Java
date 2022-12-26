package com.algorithm;

//https://leetcode.com/problems/coin-change/

import java.util.Arrays;

public class LeetCode_Coin_Change {
}

class Solution_LeetCode_Coin_Change {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int answer;

        for (int i = 0; i < coins.length; i++) {//기존 coin 값과 동일한 amount는 1로 초기화
            if (coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }

        answer = count(coins, amount);

        if (answer == 987654322) {//불가능한 상황인 경우
            return -1;
        } else {
            return answer;
        }
    }

    int count(int[] coins, int remainAmount) {
        int result = 987654321;

        if (dp[remainAmount] != -1) {//이미 계산된 값인 경우
            return dp[remainAmount];
        }

        for (int i = 0; i < coins.length; i++) {//현재 값에서 코인값만큼 뺀 값의 dp값들 중 최소값 찾기
            if (remainAmount - coins[i] >= 0) {
                result = Math.min(result, count(coins, remainAmount - coins[i]));
            }
        }

        return dp[remainAmount] = result + 1;//결과 + 1 저장
    }
}
