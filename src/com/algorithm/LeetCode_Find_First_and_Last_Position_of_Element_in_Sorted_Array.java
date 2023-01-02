package com.algorithm;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

import java.util.Arrays;

public class LeetCode_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
}

class Solution_LeetCode_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {//배열이 없는 경우
            return new int[]{-1, -1};
        }

        double floor = target - 0.5, ceiling = target + 0.5;
        int floorIndex, ceilingIndex;

        floorIndex = binarySearch(nums, floor, 0, nums.length - 1);
        ceilingIndex = binarySearch(nums, ceiling, 0, nums.length - 1) - 1;

        if (floorIndex > ceilingIndex) {//범위 시작과 끝이 역전된 경우 -> target값이 없음
            return new int[]{-1, -1};
        }

        return new int[]{floorIndex, ceilingIndex};
    }

    int binarySearch(int[] nums, double target, int start, int end) {
        if (start > end) {
            return start;
        }

        int mid = (start + end) / 2;

        if ((double) nums[mid] < target) {//중간값보다 target이 크다면
            if (start == end) {//한 개인 경우
                return mid + 1;
            }

            return binarySearch(nums, target, mid + 1, end);
        } else {//nums[mid] >= target
            if (start == end) {//한 개인 경우
                return mid;
            }

            return binarySearch(nums, target, start, mid - 1);
        }
    }
}