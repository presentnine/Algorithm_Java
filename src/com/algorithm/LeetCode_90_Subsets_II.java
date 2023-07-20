package com.algorithm;

//https://leetcode.com/problems/subsets-ii/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode_90_Subsets_II {
}

class Solution_LeetCode_90_Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {//전체 nums를 돌며 숫자와 숫자의 개수를 count
            if (hashMap.containsKey(num)) {
                hashMap.replace(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }

        for (Integer num : hashMap.keySet()) {//전체 숫자 종류를 돌며
            int count = hashMap.get(num);
            int beforeSize = result.size();//현재까지의 List 개수를 파악

            for (int i = 0; i < beforeSize; i++) {//각 부분집합에 대해
                for (int j = 1; j <= count; j++) {//해당 숫자의 출현 개수만큼
                    List<Integer> temp = new ArrayList<>(result.get(i));//기존 부분집합을 복제한 다음

                    for (int k = j; k > 0; k--) {//해당 숫자를 추가
                        temp.add(num);
                    }

                    result.add(temp);//결과에 새로운 부분집합을 추가
                }
            }
        }

        return result;
    }
}