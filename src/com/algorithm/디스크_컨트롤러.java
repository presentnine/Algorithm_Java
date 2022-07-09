package com.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {

    public static void main(String[] args) {
        int jobs[][] = new int[][]{{0, 3}, {1, 9}, {2, 6}};
    }

    class Solution {
        public int solution(int[][] jobs) {
            int time = 0, totalTurnAroundTime = 0;

            PriorityQueue<Pair> pq = new PriorityQueue<>();
            Arrays.sort(jobs, new Comparator<int[]>() {//우선 요청 시간 순 정렬
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            for (int i = 0; i < jobs.length;) {//들어와 있는 모든 요청이 될 때까지
                while (i < jobs.length && time >= jobs[i][0]) {//현 시간보다 빠른 요청들은 모두 우선순위 큐에
                    pq.add(new Pair(jobs[i][0], jobs[i][1]));
                    i++;
                }

                if (!pq.isEmpty()) {//하나를 빼 계산 진행
                    Pair pair = pq.poll();
                    time += pair.processingTime;
                    totalTurnAroundTime += time - pair.startTime;
                } else {//큐가 비어있다면
                    time = jobs[i][0];//다음 요청에 시간 조정
                }
            }

            while (!pq.isEmpty()) {//큐에 남아있는 시간들 모두 처리
                Pair pair = pq.poll();
                time += pair.processingTime;
                totalTurnAroundTime += time - pair.startTime;
            }

            return totalTurnAroundTime / jobs.length;
        }

        class Pair implements Comparable<Pair> {// Pair 클래스 끼리의 비교
            int startTime, processingTime;

            public Pair(int startTime, int processingTime) {
                this.startTime = startTime;
                this.processingTime = processingTime;
            }

            @Override
            public int compareTo(Pair p) {
                if(this.processingTime < p.processingTime)
                    return -1;
                else if (this.processingTime == p.processingTime) {
                    if(this.startTime < p.startTime)
                        return -1;
                }

                return 1;
            }
        }
    }
}
