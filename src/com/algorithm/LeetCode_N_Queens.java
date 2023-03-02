package com.algorithm;

//https://leetcode.com/problems/n-queens/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_N_Queens {
}

class Solution_LeetCode_N_Queens {
    char[][] chessboard;
    boolean[] usedRow, usedCol;
    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chessboard[i], '.');
        }
        usedRow = new boolean[n];
        usedCol = new boolean[n];

        simulation(0, n);
        return answer;
    }

    void simulation(int nextRow, int n) {
        if (nextRow == n) {//모든 퀸 배정 완료
            if (check(n)) {//유니크한 상태라면 답에 추가
                List<String> temp = new ArrayList<>();
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < n; i++) {
                    sb.setLength(0);
                    for (int j = 0; j < n; j++) {
                        sb.append(chessboard[i][j]);
                    }
                    temp.add(sb.toString());
                }

                answer.add(temp);
            }
            return;
        }

        for (int i = 0; i < n; i++) {//해당 행에 속한 열을 모두 돌며
            usedRow[nextRow] = true;
            if (!usedCol[i]) {//퀸을 놓을 수 있는 자리면 퀸을 놓고 다음 행 탐색(백트래킹)
                usedCol[i] = true;
                chessboard[nextRow][i] = 'Q';
                simulation(nextRow + 1, n);
                chessboard[nextRow][i] = '.';
                usedCol[i] = false;
            }
            usedRow[nextRow] = false;
        }
    }

    boolean check(int n) {
        for (int i = 0; i < n - 1; i++) {//마지막을 제외한 전체 행을 돌며
            for (int j = 0; j < n; j++) {
                if (chessboard[i][j] == 'Q') {//퀸 위치면
                    int step = 1;

                    while (i + step < n) {//해당 퀸부터 대각선으로 내려오는 방향의 위치들에 대해
                        if (j - step >= 0) {//왼쪽 아래 방향
                            if (chessboard[i + step][j - step] == 'Q') {//퀸이 중복
                                return false;
                            }
                        }

                        if (j + step < n) {//오른쪽 아래 방향
                            if (chessboard[i + step][j + step] == 'Q') {//퀸이 중복
                                return false;
                            }
                        }
                        ++step;
                    }

                    continue;//해당 행 건너뛰기
                }
            }
        }

        return true;
    }
}
