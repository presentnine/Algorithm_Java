package com.algorithm;

import java.util.HashMap;
import java.util.HashSet;

public class 보석_쇼핑 {
    public static void main(String[] args) {
        String[] gems = new String[]
                {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        Solution_보석_쇼핑 s = new Solution_보석_쇼핑();
        s.solution(gems);
    }
}

class Solution_보석_쇼핑 {
    int startIndex = 0, endIndex, answerLength = 999999, gemKinds;
    HashMap<String, Integer> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        for (int i = 0; i < gems.length; i++)//전체 보석 종류를 파악
            set.add(gems[i]);

        gemKinds = set.size();//전체 보석 가짓수 저장

        for (int i = 0; i < gems.length; i++) {//하나씩 지나가며
            String gem = gems[i];

            if(map.containsKey(gem))//개수 파악용 Hashset에 종류의 개수 추가
                map.put(gem, map.get(gem) + 1);
            else
                map.put(gem, 1);

            if (map.size() == gemKinds) {//gems의 0부터 현재까지 모든 보석 종류가 들어가 있다면
                endIndex = i;
                cutTail(gems);//시작부분의 0을 최대한 줄여나감

                if (endIndex - startIndex < answerLength) {//길이 비교 후 저장
                    answerLength = endIndex - startIndex;
                    answer[1] = endIndex + 1;
                    answer[0] = startIndex + 1;
                }
            }
        }

        return answer;
    }

    private void cutTail(String[] gems) {//0부터 주어진 인덱스까지의 구간에서 시작부분을 잘라나감
        while (true) {//구간 속 보석 가짓수가 전체 보석 가짓수와 동일할 때까지 반복
            String gem = gems[startIndex];
            int count = map.get(gem);

            if (count > 1) {
                map.put(gem, count - 1);
                ++startIndex;
            }
            else
                break;
        }
    }
}