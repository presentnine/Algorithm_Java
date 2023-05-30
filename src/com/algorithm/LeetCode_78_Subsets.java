package com.algorithm;

//https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_78_Subsets {
}

class Solution_LeetCode_78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());//기본적인 빈 조합 추가

        for (int i = 0; i < nums.length; i++) {//주어진 nums 배열 길이만큼 반복
            int size = result.size();//현재까지의 result 사이즈 저장

            for (int j = 0; j < size; j++) {//기존에 result에 저장된 조합들에 대해 반복
                List<Integer> temp = new ArrayList<>(result.get(j));//기존 조합을 복사 
                temp.add(nums[i]);//기존 조합에 현재 숫자만을 추가
                result.add(temp);//result에 저장
            }
        }

        return result;
    }
}

class Solution_LeetCode_78_Subsets_2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();

            for (int j = 0; j < size; j++) {
                List<Integer> temp = new LinkedList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }

        return result;
    }
}