package com.algorithm;

//https://leetcode.com/problems/merge-intervals/

import java.util.ArrayList;
import java.util.List;

public class LeetCode_Merge_Intervals {
}

class Solution_LeetCode_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        int minNum = 100000, maxNum = 0;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {//구간의 최소, 최대 확인
            minNum = Math.min(minNum, intervals[i][0]);
            maxNum = Math.max(maxNum, intervals[i][1]);
        }

        int[] imos = new int[(maxNum - minNum + 1) * 2];//특정 구간+1의 2배 크기를 누적합 구간으로 설정

        for (int i = 0; i < intervals.length; i++) {//주어진 시작과 끝의 비율을 조절하여 누적합 구간에 표시
            imos[(intervals[i][0] - minNum) * 2] += 1;
            imos[(intervals[i][1] - minNum) * 2 + 1] -= 1;
        }

        for (int i = 1; i < imos.length; i++) {//누적합 연산
            imos[i] = imos[i] + imos[i - 1];
        }

        int sectionStart = 0, sectionEnd;

        for (int i = 0; i < imos.length - 1; i++) {//구간 체크
            if ((i == 0 && imos[i] > 0) || (i > 0 && imos[i] > 0 && imos[i - 1] == 0)) {//시작 체크
                sectionStart = i;
            }

            if (imos[i] > 0 && imos[i + 1] == 0) {//끝 체크 후 저장
                sectionEnd = i + 1;
                result.add(List.of(sectionStart / 2 + minNum, sectionEnd / 2 + minNum));
            }
        }

        int[][] answer = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {//답을 반환할 타입에 맞게 변환
            answer[i][0] = result.get(i).get(0);
            answer[i][1] = result.get(i).get(1);
        }

        return answer;
    }
}