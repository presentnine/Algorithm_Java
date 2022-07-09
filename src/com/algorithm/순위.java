package com.algorithm;

import java.util.ArrayList;
import java.util.HashSet;

public class 순위 {
    class Solution {

        ArrayList<Integer> isWin[], isLose[];//승패 관계 저장 ArrayList
        HashSet<Integer> winnerSet, loserSet; //순위 파악용 HashSet
        boolean winnerVisited[], loserVisited[]; //dfs 방문 체크 배열

        public int solution(int n, int[][] results) {
            int answer = 0;
            //배열 초기화
            isWin = new ArrayList[n + 1];
            isLose = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                isWin[i] = new ArrayList<>();
                isLose[i] = new ArrayList<>();
            }
            //승패 관계 저장 (양방향)
            for (int i = 0; i < results.length; i++) {
                int winner = results[i][0], loser = results[i][1];
                isWin[winner].add(loser);
                isLose[loser].add(winner);
            }

            for (int i = 1; i <= n; i++) {//각 선수에 대해 승자, 패자를 구해서 순위 파악
                winnerSet = new HashSet<>();
                loserSet = new HashSet<>();
                winnerVisited = new boolean[n + 1];
                loserVisited = new boolean[n + 1];

                checkWinner(i);
                checkLoser(i);
                
                //양쪽 합해 정확히 n-1이면 순위 파악 가능
                if (winnerSet.size() + loserSet.size() == n - 1)
                    ++answer;
            }

            return answer;
        }

        public void checkWinner(int player) {//dfs 기반 승자 탐색
            for (Integer winner : isLose[player]) {
                if (winnerVisited[winner] == false) {
                    winnerSet.add(winner);
                    winnerVisited[winner] = true;
                    checkWinner(winner);
                }
            }
        }

        public void checkLoser(int player) {//dfs 기반 패자 탐색
            for (Integer loser : isWin[player]) {
                if (loserVisited[loser] == false) {
                    loserSet.add(loser);
                    loserVisited[loser] = true;
                    checkLoser(loser);
                }
            }
        }
    }
}
