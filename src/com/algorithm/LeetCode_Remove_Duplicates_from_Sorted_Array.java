package com.algorithm;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class LeetCode_Remove_Duplicates_from_Sorted_Array {
}

class Solution_LeetCode_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int k = 1, temp = nums[0], index = 1, i, swap;

        for (i = 1; i < nums.length; i++) {//전체 숫자 종류 파악
            if (temp != nums[i]) {
                k++;
                temp = nums[i];
            }
        }

        temp = nums[0];//첫 숫자
        i = 1;

        while (index < k) {
            if (temp < nums[i]) {//기존 temp와 다른 숫자라면
                //해당 숫자의 순서(index)와 swap 시도
                swap = nums[index];
                nums[index] = nums[i];
                nums[i] = swap;

                //temp 최신화
                temp = nums[index];
                ++index;
            }
            ++i;
        }

        return k;
    }
}

