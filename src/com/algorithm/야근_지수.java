package com.algorithm;

//https://programmers.co.kr/learn/courses/30/lessons/12927

import java.util.Arrays;

public class 야근_지수 {

}

class Solution_야근_지수 {
    public long solution(int n, int[] works) {
        long answer = 0, totalWork = 0, diffWorkSum = 0;
        int minWork, minIndex;

        Arrays.sort(works); //정렬
        minIndex = 0;
        minWork = works[0];

        for (int i = 0; i < works.length; i++) {//총 작업량과 기준 과의 차이 누적값을 계산
            totalWork += works[i];
            diffWorkSum += works[i] - minWork;
        }

        if (n >= totalWork) {//총 작업량이 커버가능하다면
            return 0;
        }

        while (n < diffWorkSum) {//현재 누적값이 n으로 커버 불가능하다면 minIndex와 minWork를 높여 계산
            ++minIndex;
            diffWorkSum = diffWorkSum - (works.length - minIndex) * (works[minIndex] - works[minIndex - 1]);
        }

        minWork = works[minIndex];

        //목과 나머지 계산
        long quotient = (n - diffWorkSum) / (works.length - minIndex);
        long remain = (n - diffWorkSum) - quotient * (works.length - minIndex);

        for (int i = 0; i < minIndex; i++) {//과정 1
            answer += works[i] * works[i];
        }

        answer += (minWork - quotient) * (minWork - quotient) * (works.length - minIndex - remain);//과정2
        answer += (minWork - quotient - 1) * (minWork - quotient - 1) * remain;//과정 3

        return answer;
    }
}