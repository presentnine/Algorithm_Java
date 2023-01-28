package com.algorithm;

//https://leetcode.com/problems/first-missing-positive/

public class LeetCode_First_Missing_Positive {
}

class Solution_LeetCode_First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, ans = nums.length + 1;

        for (int i = 0; i < n; i++) {//우선 범위밖의 수는 -1 처리
            if (nums[i] < 1 || nums[i] > n) {
                nums[i] = -1;
            }
        }

        for (int i = 0; i < n; i++) {//탐색 후 처리
            check(nums, nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                return (i + 1);
            }
        }

        return ans;
    }

    void check(int[] nums, int num) {
        if (num > 0) {//주어진 값이 범위내 숫자라면
            int temp = nums[num - 1];
            nums[num - 1] = 0;
            check(nums, temp);
        }
    }
}