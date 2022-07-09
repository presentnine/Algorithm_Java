package com.algorithm;

//https://programmers.co.kr/learn/courses/30/lessons/68646

public class 풍선_터트리기 {
}

class Solution_풍선_터트리기 {
    public int solution(int[] a) {
        int answer, arrayLength = a.length;
        int[] leftToRight = new int[arrayLength], rightToLeft = new int[arrayLength];

        if (a.length == 1) {//길이 1개짜리
            return 1;
        }else {
            answer = 2;
        }

        leftToRight[0] = a[0];
        for (int i = 1; i < arrayLength; i++) {//왼쪽 -> 오른쪽으로 가며 최소값 저장
            leftToRight[i] = Math.min(a[i], leftToRight[i - 1]);
        }

        rightToLeft[arrayLength - 1] = a[arrayLength - 1];
        for (int i = arrayLength - 2; i >= 0; i--) {//오른쪽 -> 왼쪽으로 가며 최소값 저장
            rightToLeft[i] = Math.min(a[i], rightToLeft[i + 1]);
        }

        //각 위치(i)에 대해 a[i], 0~i-1까지 중 최소값, i+1~마지막까지 중 최소값에서 비교
        for (int i = 1; i < arrayLength - 1; i++) {
            if (!(a[i] > leftToRight[i - 1] && a[i] > rightToLeft[i + 1])) {//a[i]가 그 중 최대값만 아니라면
                ++answer;
            }
        }

        return answer;
    }
}