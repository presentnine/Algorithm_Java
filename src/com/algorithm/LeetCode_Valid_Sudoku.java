package com.algorithm;

//https://leetcode.com/problems/valid-sudoku/

import java.util.HashSet;

public class LeetCode_Valid_Sudoku {
}

class Solution_LeetCode_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean answer = true;
        HashSet<Integer>[] rowSets = new HashSet[9], colSets = new HashSet[9];
        HashSet<Integer>[][] boxSets = new HashSet[3][3];

        for (int i = 0; i < 9; i++) {//초기화
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i / 3][i % 3] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.') {//숫자인 경우 위치 확인
                    int num = board[i][j];

                    if (!rowSets[i].contains(num) && !colSets[j].contains(num) && !boxSets[i / 3][j / 3].contains(num)) {
                        rowSets[i].add(num);
                        colSets[j].add(num);
                        boxSets[i / 3][j / 3].add(num);
                    } else {
                        answer = false;
                        break;
                    }
                }
            }

            if (!answer) {//2중 for문 탈출
                break;
            }
        }

        return answer;
    }
}