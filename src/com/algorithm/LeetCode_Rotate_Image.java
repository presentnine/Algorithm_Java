package com.algorithm;

//https://leetcode.com/problems/rotate-image/

public class LeetCode_Rotate_Image {
}

class Solution_LeetCode_Rotate_Image {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        if (n % 2 == 0) {//이차원 배열이 짝수라면 전체의 1/4로 회전을 진행
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    swap(matrix, n, i, j, i, j, matrix[i][j]);
                }
            }
        } else {//이차원 배열이 홀수라면 정가운데를 제외한 나머지 1/4로 회전을 진행
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j <= n / 2; j++) {
                    swap(matrix, n, i, j, i, j, matrix[i][j]);
                }
            }
        }
    }

    void swap(int[][] matrix, int n, int startR, int startC, int r, int c, int value) {
        int nextR = c, nextC = n - r - 1;
        int nextValue = matrix[nextR][nextC];
        matrix[nextR][nextC] = value;

        if (!(startR == nextR && startC == nextC)) {//4번의 회전에 도달한게 아니면 다음 회전 진행
            swap(matrix, n, startR, startC, nextR, nextC, nextValue);
        }
    }
}