package com.algorithm;

//https://programmers.co.kr/learn/courses/30/lessons/12987

import java.util.PriorityQueue;

public class 숫자_게임 {
}

class Solution_숫자_게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0, tempA, tempB;

        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>();

        for (int i = 0; i < A.length; i++) { //주어진 숫자 오름차순 정렬
            pqA.add(A[i]);
            pqB.add(B[i]);
        }

        while (!pqB.isEmpty()) {//모든 수열 B 속 숫자들에 대하여
            tempA = pqA.poll();
            tempB = pqB.poll();

            if (tempA < tempB) {//각각 뽑은 숫자에 대해 B 쪽이 더 크면
                ++answer;
            } else {//안되면 B쪽이 클때까지 반복 
                while (!pqB.isEmpty()) {
                    tempB = pqB.poll();

                    if (tempA < tempB) {
                        ++answer;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}