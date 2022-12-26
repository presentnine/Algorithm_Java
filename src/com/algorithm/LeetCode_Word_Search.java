package com.algorithm;

//https://leetcode.com/problems/word-search/

public class LeetCode_Word_Search {
}

class Solution_LeetCode_Word_Search {
    boolean answer = false;
    boolean[][] visited;
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && !answer) {//word의 첫 알파벳과 동일하며 기존 답이 없는 경우
                    visited = new boolean[m][n];
                    check(i, j, 0, board, word);
                }
            }
        }

        return answer;
    }

    void check(int r, int c, int index, char[][] board, String word) {//dfs 탐색
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) {//맵밖, 중복 방문인 경우
            return;
        }

        if (board[r][c] != word.charAt(index)) {//알파벳이 맞지 않는 경우
            return;
        }

        if (index == word.length() - 1 && board[r][c] == word.charAt(index)) {//끝까지 동일하다면
            answer = true;
            return;
        }

        visited[r][c] = true;//방문 표시

        check(r + 1, c, index + 1, board, word);
        check(r - 1, c, index + 1, board, word);
        check(r, c + 1, index + 1, board, word);
        check(r, c - 1, index + 1, board, word);

        visited[r][c] = false;//방문 표시 해제
    }
}