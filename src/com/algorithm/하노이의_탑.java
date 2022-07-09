package com.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class 하노이의_탑 {
    public static void main(String[] args) {
        Solution_하노이의_탑 s = new Solution_하노이의_탑();
        System.out.println(s.solution(2));
    }
}

class Solution_하노이의_탑 {
    Queue<Infor> q = new LinkedList<>();//dfs 탐색의 결과가 저장될 큐
    int[][] midpoint = {{0, 0, 0, 0}, {0, 0, 3, 2}, {0, 3, 0, 1}, {0, 2, 1, 0}}; //남은 위치 찾기용 배열

    public int[][] solution(int n) {
        int[][] answer = new int[((int) Math.pow(2, n)) - 1][2];//답안 배열 초기화
        int index = 0;

        move(n, 1, 3); //n개 원판의 위치 1에서 3으로 이동

        while (!q.isEmpty()) {//결과가 담긴 큐를 비우며 answer 배열 채우기
            Infor infor = q.poll();
            answer[index][0] = infor.from;
            answer[index][1] = infor.to;

            ++index;
        }

        return answer;
    }

    void move(int roundPlateCount, int from, int to) {//dfs 기반 탐색
        if (roundPlateCount == 1) {
            q.add(new Infor(from, to));
            return;
        }

        move(roundPlateCount - 1, from, midpoint[from][to]);
        move(1, from, to);
        move(roundPlateCount - 1, midpoint[from][to], to);
    }

    class Infor{//원판 한 개의 과정이 담기는 클래스
        int from, to;

        public Infor(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}

