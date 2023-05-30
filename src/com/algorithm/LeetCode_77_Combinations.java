package com.algorithm;

//https://leetcode.com/problems/combinations/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_77_Combinations {
}

class Solution_LeetCode_77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        combinations(result, new LinkedList<>(), 1, 0, n, k);
        return result;
    }

    public void combinations(List<List<Integer>> result, LinkedList<Integer> temp, int now, int count, int n, int k) {
        if (count == k) {//지정한 k만큼 다 채워 넣었으면 결과에 추가
            result.add(new LinkedList<>(temp));
            return;
        }

        for (int i = now; i <= n; i++) {//주어진 숫자부터 n까지 중 하나를 선택해 추가 후 재귀호출
            temp.add(i);
            combinations(result, temp, i + 1, count + 1, n, k);
            temp.removeLast();
        }
    }
}

class Solution_LeetCode_77_Combinations_2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(result, new ArrayList<>(), 1, 0, n, k);
        return result;
    }

    public void combinations(List<List<Integer>> result, List<Integer> temp, int now, int count, int n, int k) {
        if (count == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = now; i <= n; i++) {
            temp.add(i);
            combinations(result, temp, i + 1, count + 1, n, k);
            temp.remove(temp.size() - 1);
        }
    }
}