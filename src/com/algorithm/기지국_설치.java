package com.algorithm;

//https://programmers.co.kr/learn/courses/30/lessons/12979
public class 기지국_설치 {
}
class Solution_기지국_설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0, sectionLength;

        for (int i = 0; i <= stations.length; i++) {
            if(i == 0){//구간 시작부터 ~ 첫번째 기지국 구간
                sectionLength = stations[i] - 1 - w;
            } else if (i == stations.length) {//마지막 기지국 ~ 구간 끝 구간
                sectionLength = n - stations[i - 1] - w;
            } else {//기지국들 사이의 구간
                sectionLength = stations[i] - stations[i - 1] - 2 * w - 1;
            }

            if (sectionLength >= 0) {
                answer += sectionLength / (2 * w + 1);

                if (sectionLength % (2 * w + 1) != 0) {
                    ++answer;
                }
            }
        }

        return answer;
    }
}