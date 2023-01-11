package com.algorithm;

//https://leetcode.com/problems/two-sum/

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_Two_Sum {
}

class Solution_LeetCode_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]) && i != hashMap.get(target - nums[i])) {
                answer[0] = i;
                answer[1] = hashMap.get(target - nums[i]);
                break;
            }
        }

        return answer;
    }
}