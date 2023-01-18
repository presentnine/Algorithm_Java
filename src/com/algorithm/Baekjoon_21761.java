package com.algorithm;

//https://www.acmicpc.net/problem/21761

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_21761 {
    static long[] point = new long[4];//현재의 각 좌표 저장용
    static long[] increments = new long[4];//각 좌표 증가분

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {//좌표 저장
            point[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer>[] pqs = new PriorityQueue[4];
        for (int i = 0; i < 4; i++) {//각 좌표에 대한 우선순위 큐 생성
            pqs[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < N; i++) {//카드 속 좌표, 증가분 처리 후 우선순위 큐 삽입
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            pqs[c - 'A'].add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            int bestCard = 0;

            for (int j = 0; j < 4; j++) {//각 좌표의 증가분 저장
                if (!pqs[j].isEmpty()) {
                    increments[j] = pqs[j].peek();
                } else {//더 이상의 증가분이 없다면
                    increments[j] = 0;
                }
            }

            for (int j = 1; j < 4; j++) {//각 좌표에 대한 카드 중 가장 부피가 많이 늘어나는 카드 계산
                if (!pqs[j].isEmpty() && (increments[bestCard] * point[j] < increments[j] * point[bestCard])) {
                    bestCard = j;
                }
            }

            //해당 카드 좌표 우선순위 큐에서 제거 후 좌표 최신화
            pqs[bestCard].poll();
            point[bestCard] += increments[bestCard];
            answer.append((char) (bestCard + 'A') + " " + increments[bestCard] + "\n");
        }

        System.out.println(answer);
    }
}
