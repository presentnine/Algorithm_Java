package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_Combination_Sum {

}
class Solution_LeetCode_Combination_Sum {
    ArrayList<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();//clone() 함수 활용

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        generateComb(candidates, target, 0);
        return result;
    }

    void generateComb(int[] candidates, int remain, int index) {
        if (remain == 0) {//조합이 완성된 경우
            result.add((ArrayList<Integer>) list.clone());
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= remain) {//백트래킹 기반 탐색
                list.add(candidates[i]);
                generateComb(candidates, remain - candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
}
