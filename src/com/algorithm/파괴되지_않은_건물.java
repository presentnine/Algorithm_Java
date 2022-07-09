package com.algorithm;

public class 파괴되지_않은_건물 {
    public static void main(String[] args) {
        int[][] board =
                {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill =
                {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};

        Solution_파괴되지_않은_건물 s = new Solution_파괴되지_않은_건물();
        s.solution(board, skill);
    }
}

class Solution_파괴되지_않은_건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0, N = board.length, M = board[0].length;
        int[][] imosBoard = new int[N][M];//IMOS용 2차원 배열

        for (int i = 0; i < skill.length; i++) {//주어진 skill 배열을 모두 표시
            int type = skill[i][0], r1 = skill[i][1], c1 = skill[i][2], r2 = skill[i][3], c2 = skill[i][4], degree = skill[i][5];

            if (type == 1)
                degree *= -1;

            imosBoard[r1][c1] += degree;
            if (r2 < N - 1) //표시를 할 곳이 배열 내부라면
                imosBoard[r2 + 1][c1] -= degree;
            if (c2 < M - 1) //표시를 할 곳이 배열 내부라면
                imosBoard[r1][c2 + 1] -= degree;
            if (r2 < N - 1 && c2 < M - 1) //표시를 할 곳이 배열 내부라면
                imosBoard[r2 + 1][c2 + 1] += degree;
        }

        for (int r = 0; r < N; r++) { //행 순서대로 좌측 -> 우측
            int acc = imosBoard[r][0];

            for (int c = 1; c < M; c++) {
                imosBoard[r][c] += acc;
                acc = imosBoard[r][c];
            }
        }

        for (int c = 0; c < M; c++) { //열 순서대로 상단 -> 하단
            int acc = imosBoard[0][c];

            for (int r = 1; r < N; r++) {
                imosBoard[r][c] += acc;
                acc = imosBoard[r][c];
            }
        }

        for (int r = 0; r < N; r++) { //각 위치 결과 값 계산
            for (int c = 0; c < M; c++) {
                if (imosBoard[r][c] + board[r][c] > 0) {
                    ++answer;
                }
            }
        }

        return answer;
    }
}