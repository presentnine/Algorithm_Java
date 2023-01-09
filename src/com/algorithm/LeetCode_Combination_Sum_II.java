package com.algorithm;

//https://leetcode.com/problems/combination-sum-ii/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LeetCode_Combination_Sum_II {
}

class Solution_LeetCode_Combination_Sum_II {
    List<List<Integer>> answer = new ArrayList<>();
    HashMap<Integer, Integer> candidateCount = new HashMap<>();
    List<Integer> candidatesList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for (int i = 0; i < candidates.length; i++) {//candidates 배열 정리 -> 중복 & 큰 수 제거
            if (candidates[i] <= target) {
                if (!candidateCount.containsKey(candidates[i])) {
                    candidateCount.put(candidates[i], 1);
                    candidatesList.add(candidates[i]);
                } else {
                    candidateCount.replace(candidates[i], candidateCount.get(candidates[i]) + 1);
                }
            }
        }

        Collections.sort(candidatesList);

        search(0, target, new ArrayList<>());//탐색

        return answer;
    }

    void search(int index, int remain, List<Integer> set) {
        if (remain <= 0 || index >= candidatesList.size()) {//탐색 종료 조건
            if (remain == 0) {
                answer.add(new ArrayList<>(set));
            }
            return;
        }

        int candidate = candidatesList.get(index);
        int count = candidateCount.get(candidate);

        for (int i = 0; i <= count; i++) {//중복되는 개수 만큼 탐색
            for (int j = 1; j <= i; j++) {
                set.add(candidate);
            }

            search(index + 1, remain - candidate * i, set);

            for (int j = 1; j <= i; j++) {
                set.remove((Integer) candidate);
            }
        }
    }
}