package com.algorithm;

//https://www.acmicpc.net/problem/1043

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1043 {
    static ArrayList<Integer>[] parties, participantsIn;
    static int[] knownPeople;
    static boolean[] canLie;

    public static void main(String[] args) throws IOException{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //사람 - 참가 파티, 파티 - 참가자, 파티 결과 자료구조 초기화
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parties = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            parties[i] = new ArrayList<>();
        }
        participantsIn = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            participantsIn[i] = new ArrayList<>();
        }
        canLie = new boolean[M];

        //진실을 아는 사람 저장
        st = new StringTokenizer(br.readLine());
        int knownPeopleNum = Integer.parseInt(st.nextToken());
        knownPeople = new int[knownPeopleNum];

        for (int i = 0; i < knownPeopleNum; i++) {
            knownPeople[i] = Integer.parseInt(st.nextToken());
        }
        
        //파티-참가자, 참가자-파티 저장
        for (int party = 0; party < M; party++) {
            st = new StringTokenizer(br.readLine());
            int peopleNum = Integer.parseInt(st.nextToken());

            for (int j = 0; j < peopleNum; j++) {
                int person = Integer.parseInt(st.nextToken());

                parties[person].add(party);
                participantsIn[party].add(person);
            }
        }

        //dfs
        for (int i = 0; i < knownPeople.length; i++) {
            dfs(knownPeople[i]);
        }

        for (int i = 0; i < canLie.length; i++) {
            if (!canLie[i]) {
                ++answer;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int person) {//dfs 기반 탐색
        for (int i = 0; i < parties[person].size(); i++) {
            int party = parties[person].get(i);

            if (!canLie[party]) {
                canLie[party] = true;

                for (int j = 0; j < participantsIn[party].size(); j++) {
                    int nextPerson = participantsIn[party].get(j);
                    dfs(nextPerson);
                }
            }
        }
    }
}
