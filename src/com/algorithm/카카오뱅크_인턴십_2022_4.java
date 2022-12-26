package com.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오뱅크_인턴십_2022_4 {
}

class Solution_카카오뱅크_인턴십_2022_4 {
    int nowTime, nowClassificationNum;
    int[] classificationImportanceScore = new int[101];
    Queue<Integer>[] workQueue = new Queue[101];

    public int[] solution(int[][] jobs) {
        Queue<Integer> answerQueue = new LinkedList<>();
        ArrayList<Integer> answerArrayList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            workQueue[i] = new LinkedList<>();
        }

        nowTime = 0;
        int nextClassificationNum, maxScore;

        for (int i = 0; i < jobs.length; ) {
            nextClassificationNum = -1;
            maxScore = 0;

            for (int j = 1; j <= 100; j++) {//다음 작업할 분류 계산
                if (classificationImportanceScore[j] > maxScore) {
                    nextClassificationNum = j;
                    maxScore = classificationImportanceScore[j];
                }
            }

            if (nextClassificationNum != -1) {//다음 작업할 분류 존재
                nowClassificationNum = nextClassificationNum;
                answerQueue.add(nowClassificationNum);
                while (!workQueue[nowClassificationNum].isEmpty()) {//큐에서 꺼내 작업
                    int work = workQueue[nowClassificationNum].poll();
                    nowTime += jobs[work][1];
                    classificationImportanceScore[nowClassificationNum] -= jobs[work][3];

                    while (i < jobs.length && jobs[i][0] <= nowTime) {//지나간 시간만큼 작업 추가
                        workQueue[jobs[i][2]].add(i);
                        classificationImportanceScore[jobs[i][2]] += jobs[i][3];
                        ++i;
                    }
                }
            } else {
                nowTime = jobs[i][0];
                workQueue[jobs[i][2]].add(i);
                classificationImportanceScore[jobs[i][2]] += jobs[i][3];
                ++i;
            }
        }

        do {
            nextClassificationNum = -1; maxScore = 0;

            for (int j = 1; j <= 100; j++) {//
                if (classificationImportanceScore[j] > maxScore) {
                    nextClassificationNum = j;
                    maxScore = classificationImportanceScore[j];
                }
            }

            if (nextClassificationNum != -1) {
                nowClassificationNum = nextClassificationNum;
                answerQueue.add(nowClassificationNum);
                while (!workQueue[nowClassificationNum].isEmpty()) {
                    int work = workQueue[nowClassificationNum].poll();
                    nowTime += jobs[work][1];
                    classificationImportanceScore[nowClassificationNum] -= jobs[work][3];
                }
            }
        } while (nextClassificationNum != -1);

        //반환할 array 초기화
        answerArrayList.add(answerQueue.poll());

        while (!answerQueue.isEmpty()) {//중복 작업 제거
            int work = answerQueue.poll();

            if (answerArrayList.get(answerArrayList.size() - 1) != work) {
                answerArrayList.add(work);
            }
        }

        int[] answer = new int[answerArrayList.size()];
        for (int i = 0; i < answerArrayList.size(); i++) {
            answer[i] = answerArrayList.get(i);
        }

        return answer;
    }
}