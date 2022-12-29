package com.algorithm;

//https://www.acmicpc.net/problem/14908

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_14908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Infor> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {//각 작업 생성해 우선순위 큐에 삽입
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            pq.add(new Infor(i + 1, T, S));
        }

        while (!pq.isEmpty()) {//차례대로 꺼내 print
            System.out.print(pq.poll().workNum + " ");
        }

        return;
    }

    static class Infor implements Comparable<Infor>{
        int workNum, workDay, compensation;

        public Infor(int workNum, int workDay, int compensation) {
            this.workNum = workNum;
            this.workDay = workDay;
            this.compensation = compensation;
        }

        @Override
        public int compareTo(Infor o) {//compareTo 구현
            int compensationA = o.workDay * this.compensation, compensationB = this.workDay * o.compensation;

            if (compensationA > compensationB) {//현 작업을 먼저 처리하는게 더 싸다면
                return -1;
            } else if (compensationA < compensationB) {//현 작업을 먼저 처리하는게 비싸다면
                return 1;
            } else {//같다면 오름차순이 되도록 작업 번호 기준 정렬
                if (this.workNum < o.workNum) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
}
