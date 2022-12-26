package com.algorithm;

import java.util.Arrays;
import java.util.HashSet;

public class 카카오_여름_인턴_2022_3 {
    
}

class Solution_카카오_여름_인턴_2022_3 {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;

        for (int i = 0; i < problems.length; i++) {
            maxAlp = Math.max(maxAlp, problems[i][0]);
            maxCop = Math.max(maxCop, problems[i][1]);
        }

        int[][] dp = new int[maxAlp + 1][maxCop + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 987654321);
        }

        dp[alp][cop] = 0;

        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                if (i + 1 <= maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }

                if (j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }

                for (int k = 0; k < problems.length; k++) {
                    int alp_rwd = problems[k][2], cop_rwd = problems[k][3];

                    if (i >= problems[k][0] && j >= problems[k][1] && i + alp_rwd <= maxAlp && j + cop_rwd <= maxCop) {
                        dp[i + alp_rwd][j + cop_rwd] = Math.min(dp[i + alp_rwd][j + cop_rwd], dp[i][j] + problems[k][4]);
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}