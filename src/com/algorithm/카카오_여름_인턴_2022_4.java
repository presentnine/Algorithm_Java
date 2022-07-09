package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class 카카오_여름_인턴_2022_4 {
    public static void main(String[] args) {
        int n = 7;
        int[][] paths = new int[][]{
                {1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}
        };
        int[] gates = new int[]{
                3,7
        };
        int[] summits = new int[]{
                1,5
        };

        Solution_카카오_여름_인턴_2022_4 s = new Solution_카카오_여름_인턴_2022_4();

        int[] solution = s.solution(n, paths, gates, summits);
        System.out.println(solution[0] + ", " + solution[1]);
    }
    
}

class Solution_카카오_여름_인턴_2022_4 {
    ArrayList<moveInfor>[] adjPoints;
    boolean[] isSummit, visited;
    int answerSummit = 50000, answerIntensity = 10000000;
    int[] dp;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        dp = new int[n + 1];
        Arrays.fill(dp, 987654321);
        visited = new boolean[n + 1];

        adjPoints = new ArrayList[n + 1];//인접 지점 자료구조 생성
        for (int i = 1; i <= n; i++) {
            adjPoints[i] = new ArrayList<>();
        }

        for (int i = 0; i < gates.length; i++) {
            dp[gates[i]] = 0;
        }

        isSummit = new boolean[n + 1];//산봉우리 배열
        for (int i = 0; i < summits.length; i++) {
            isSummit[summits[i]] = true;
        }

        for (int i = 0; i < paths.length; i++) {//경로 저장
            int p1 = paths[i][0], p2 = paths[i][1], w = paths[i][2];

            adjPoints[p1].add(new moveInfor(p2, w));
            adjPoints[p2].add(new moveInfor(p1, w));
        }

        for (int i = 0; i < summits.length; i++) {
            calDp(summits[i]);
        }

        for (int i = 0; i < summits.length; i++) {
            if (dp[summits[i]] < answerIntensity) {
                answerSummit = summits[i];
                answerIntensity = dp[summits[i]];
            } else if (dp[summits[i]] == answerIntensity) {
                answerSummit = Math.min(answerSummit, summits[i]);
            }
        }

        return new int[]{answerSummit, answerIntensity};
    }

    int calDp(int point) {
        if (dp[point] != 987654321) {
            return dp[point];
        }

        int result = dp[point];

        if(!visited[point]){
            visited[point] = true;
            for (int i = 0; i < adjPoints[point].size(); i++) {
                int nextPoint = adjPoints[point].get(i).point;
                int nextIntensity = adjPoints[point].get(i).intensity;

                if (!isSummit[nextPoint]) {
                    result = Math.min(result, Math.max(calDp(nextPoint), nextIntensity));
                }
            }
            visited[point] = false;
        }

        return dp[point] = result;
    }

    class moveInfor {
        int point, intensity;

        public moveInfor(int point, int intensity) {
            this.point = point;
            this.intensity = intensity;
        }
    }
}
