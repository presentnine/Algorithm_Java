package com.algorithm;

//https://leetcode.com/problems/set-matrix-zeroes/

import java.util.HashSet;

public class LeetCode_Set_Matrix_Zeroes {
}
class Solution_LeetCode_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length], col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {//0이라면
                    row[i] = true;//해당 행 표시
                    col[j] = true;//해당 열 표시

                    for (int k = j - 1; k >= 0; k--) {//그 이전 열 0표시
                        matrix[i][k] = 0;
                    }

                    for (int k = i - 1; k >= 0; k--) {//그 이전 행 0 표시
                        matrix[k][j] = 0;
                    }
                } else {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}