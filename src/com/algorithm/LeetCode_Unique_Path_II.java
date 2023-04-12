package com.algorithm;

//https://leetcode.com/problems/unique-paths-ii/description/

public class LeetCode_Unique_Path_II {
}

class Solution_LeetCode_Unique_Path_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1){
            return 0;
        }

        for(int r = 0;r<m;r++){
            for(int c = 0; c<n;c++){
                if(obstacleGrid[r][c]==1){
                    obstacleGrid[r][c] = -1;
                }
            }
        }

        obstacleGrid[0][0] = 1;

        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]!=-1 && obstacleGrid[i-1][0]==1){
                obstacleGrid[i][0] = 1;
            }
        }

        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]!=-1 && obstacleGrid[0][i-1]==1){
                obstacleGrid[0][i] = 1;
            }
        }

        for(int r = 1;r<m;r++){
            for(int c = 1; c<n;c++){
                if(obstacleGrid[r][c]!=-1){
                    if(obstacleGrid[r-1][c]!=-1){
                        obstacleGrid[r][c]+=obstacleGrid[r-1][c];
                    }

                    if(obstacleGrid[r][c-1]!=-1){
                        obstacleGrid[r][c]+=obstacleGrid[r][c-1];
                    }
                }
            }
        }

        return obstacleGrid[m-1][n-1];
    }
}