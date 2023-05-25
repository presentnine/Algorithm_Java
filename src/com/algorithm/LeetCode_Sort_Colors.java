package com.algorithm;

//https://leetcode.com/problems/sort-colors/

public class LeetCode_Sort_Colors {
}

class Solution_LeetCode_Sort_Colors {
    public void sortColors(int[] nums) {
        int start = 0, end;

        for (int i = 0; i < 2; i++) {//0과 1에 대해
            end = nums.length - 1;

            while (start < end) {//배열의 시작과 끝에서 비교해가며 0(혹은 1)을 이동
                if (nums[start] == i) {
                    ++start;
                } else {
                    if (nums[end] == i) {
                        nums[end] = nums[start];
                        nums[start] = i;
                        ++start;
                    } else {
                        --end;
                    }
                }
            }
        }
    }
}