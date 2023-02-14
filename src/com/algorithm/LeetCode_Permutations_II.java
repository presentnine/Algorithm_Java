package com.algorithm;

//https://leetcode.com/problems/permutations-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeetCode_Permutations_II {
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();//리턴용 답안 배열
    HashSet<String> permutationString = new HashSet<>();//순열 집합 저장용 set

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
        permutation(nums, 0, arr);
        return result;
    }

    void permutation(int[] nums, int index, int[] arr) {//순열 생성
        if (index == nums.length) {//nums 배열 모두 사용했으면
            StringBuilder key = new StringBuilder();

            for (int i = 0; i < arr.length; i++) {//해당 순열에 대한 문자열 key 생성
                key.append(nums[arr[i]]);
                key.append('.');
            }

            if (!permutationString.contains(key.toString())) {//기존에 없는 순열이라면 답에 추가
                List<Integer> set = new ArrayList<>();
                for (int i = 0; i < arr.length; i++) {//해당 순열 List 생성
                    set.add(nums[arr[i]]);
                }
                result.add(set);//답에 추가
                permutationString.add(key.toString());
            }

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