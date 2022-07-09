package com.algorithm;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        Solution_이중우선순위큐 s = new Solution_이중우선순위큐();

        s.solution(operations);
    }
}

class Solution_이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int insertCount = 0, deleteCount = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //최대 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //최소 힙

        for (int i = 0; i < operations.length; i++) { //각 명령
            String[] operation = operations[i].split(" ");

            String instruction = operation[0]; //명령어
            int num = Integer.parseInt(operation[1]); //숫자 (or 1/-1)

            if (instruction.equals("I")) { //삽입 명령인 경우
                ++insertCount;

                maxHeap.add(num);
                minHeap.add(num);

            } else { //삭제 명령인 경우
                if (insertCount > deleteCount) { //삽입 명령이 더 많은 상태에서만
                    ++deleteCount;

                    if (num == 1) {//최대값 제거인 경우
                        Integer deleteNum = maxHeap.poll();
                        minHeap.remove(deleteNum);
                    } else {//최소값 제거인 경우
                        Integer deleteNum = minHeap.poll();
                        maxHeap.remove(deleteNum);
                    }
                }
            }
        }

        if (insertCount == deleteCount) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        return answer;
    }
}