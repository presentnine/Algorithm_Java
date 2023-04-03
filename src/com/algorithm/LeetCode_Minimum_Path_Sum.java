package com.algorithm;

//https://leetcode.com/problems/minimum-path-sum/

public class LeetCode_Minimum_Path_Sum {
}

class Solution_LeetCode_Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 1; i < m; i++) {//행따라 숫자값 누적
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < n; i++) {//열따라 숫자값 누적
            grid[0][i] += grid[0][i - 1];
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {//현 위치의 값에 직전 왼쪽 값과 직전 위쪽 값중 최소를 더함 
                grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]);
            }
        }

        return grid[m - 1][n - 1];//최종 위치 값 반환
    }
}