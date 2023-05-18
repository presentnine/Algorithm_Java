package com.algorithm;

//https://leetcode.com/problems/search-a-2d-matrix/

public class LeetCode_Search_a_2d_matrix {
}

class Solution_LeetCode_Search_a_2d_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {//너무 크거나 작다면
            return false;
        }

        int startRow = 0, endRow = m - 1;

        while (startRow <= endRow) {//해당 숫자가 존재할 행을 이진탐색
            int midRow = (startRow + endRow) / 2;

            if (matrix[midRow][0] < target) {
                startRow = midRow + 1;
            } else if (matrix[midRow][0] == target) {
                return true;
            } else {
                endRow = midRow - 1;
            }
        }

        int startCol = 0, endCol = n - 1;

        while (startCol <= endCol) {//해당 숫자가 존재할 열을 이진탐색
            int midCol = (startCol + endCol) / 2;

            if (matrix[endRow][midCol] < target) {
                startCol = midCol + 1;
            } else if (matrix[endRow][midCol] == target) {
                return true;
            } else {
                endCol = midCol - 1;
            }
        }

        return false;
    }
}