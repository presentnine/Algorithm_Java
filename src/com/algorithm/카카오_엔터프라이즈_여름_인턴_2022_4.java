package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카카오_엔터프라이즈_여름_인턴_2022_4 {

    static ArrayList<Integer>[] winnersOf, losersOf;
    static boolean[] visitedWinners, visitedLosers;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        winnersOf = new ArrayList[N + 1];
        losersOf = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            winnersOf[i] = new ArrayList<>();
            losersOf[i] = new ArrayList<>();
        }

        visitedWinners = new boolean[N + 1];
        visitedLosers = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int winner = Integer.parseInt(st.nextToken());
            int loser = Integer.parseInt(st.nextToken());

            winnersOf[loser].add(winner);
            losersOf[winner].add(loser);
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(visitedWinners, false);
            Arrays.fill(visitedLosers, false);

            int totalWinners = -1, totalLosers = -1;

            checkWinners(i);
            checkLosers(i);

            for (int j = 1; j <= N; j++) {
                if (visitedWinners[j]) {
                    ++totalWinners;
                }
                if (visitedLosers[j]) {
                    ++totalLosers;
                }
            }

            if ((totalWinners + totalLosers) == N - 1) {
                ++answer;
            }
        }

        System.out.println(answer);
    }

    static void checkWinners(int person) {
        if (visitedWinners[person]) {
            return;
        }

        visitedWinners[person] = true;
        for (int i = 0; i < winnersOf[person].size(); i++) {
            checkWinners(winnersOf[person].get(i));
        }
    }

    static void checkLosers(int person){
        if (visitedLosers[person]) {
            return;
        }

        visitedLosers[person] = true;
        for (int i = 0; i < losersOf[person].size(); i++) {
            checkLosers(losersOf[person].get(i));
        }
    }


}
