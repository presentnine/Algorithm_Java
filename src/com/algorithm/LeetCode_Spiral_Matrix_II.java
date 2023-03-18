package com.algorithm;

//https://leetcode.com/problems/spiral-matrix-ii/

public class LeetCode_Spiral_Matrix_II {
}

class Solution_LeetCode_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        int size = n, r = 0, c = -1, move = 1, count = 0;

        while (size > 0) {//이동거리가 0보다 큰 동안
            for (int i = 0; i < size; i++) {//이동거리만큼
                c += move;//열 이동
                answer[r][c] = ++count;//그때마다 증가된 값 저장
            }
            --size;//이동거리 감소

            for (int i = 0; i < size; i++) {//이동거리만큼
                r += move;//행 이동
                answer[r][c] = ++count;//그때마다 증가된 값 저장
            }
            move *= -1;//이동방향 변경

        }

        return answer;
    }
}