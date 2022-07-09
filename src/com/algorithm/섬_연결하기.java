package com.algorithm;

import java.util.*;

public class 섬_연결하기 {
}

class Solution_섬_연결하기 {
    int[] union;

    public int solution(int n, int[][] costs) {
        PriorityQueue<Infor> pq = new PriorityQueue<>(); //크루스칼 알고리즘을 위한 우선순위 큐
        int answer = 0;
        union = new int[n];
        Arrays.fill(union, -1);

        for (int i = 0; i < costs.length; i++) {
            Infor infor = new Infor(costs[i][0], costs[i][1], costs[i][2]);
            pq.add(infor);
        }

        for (int i = 0; i < n - 1; ) { //n 개 섬의 최소 신장 트리기 때문에 n-1번만 하면 된다.
            Infor infor = pq.poll();
            int islandAParent = findParent(infor.islandA), islandBParent = findParent(infor.islandB);

            if (islandAParent != islandBParent) {//집합이 같으면 사이클이기에 넘어간다.
                answer += infor.cost;
                union[islandBParent] = islandAParent;
                ++i;
            }
        }

        return answer;
    }

    int findParent(int island) {//집합(부모) find 함수
        if (union[island] == -1) {
            return island;
        } else {
            return union[island] = findParent(union[island]);
        }
    }

    class Infor implements Comparable<Infor> {//정보 클래스 
        int islandA, islandB, cost;

        public Infor(int islandA, int islandB, int cost) {
            this.islandA = islandA;
            this.islandB = islandB;
            this.cost = cost;
        }

        @Override
        public int compareTo(Infor o) {//우선 순위 큐에 적용하기 위한 비교 함수
            return this.cost < o.cost ? -1 : 1;
        }
    }
}

