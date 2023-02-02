package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class LeetCode_Permutations {
}

class Solution_LeetCode_Permutations {
    List<List<Integer>> result = new ArrayList<>();//리턴용 답안 배열
    public List<List<Integer>> permute(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
        permutation(nums, 0, arr);
        return result;
    }

    void permutation(int[] nums, int index, int[] arr) {//순열 생성
        if (index == nums.length) {//nums 배열 모두 사용했으면
            List<Integer> set = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {//해당 순열 List 생성
                set.add(nums[arr[i]]);
            }

            result.add(set);//답에 추가
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {//배열의 빈 곳이면
                arr[i] = index;
                permutation(nums, index + 1, arr);
                arr[i] = -1;//백트래킹을 위해 다시 빈 곳으로 표시
            }
        }
    }
}