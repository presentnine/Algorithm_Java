package com.algorithm;

//https://leetcode.com/problems/search-insert-position/

public class LeetCode_Search_Insert_Position {
}

class Solution_LeetCode_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;

        while (start <= end) {//start==end가 될 때까지
            mid = (start + end) / 2;

            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {//중간값보다 target이 크다면
                if (start == end) {//한 개인 경우
                    mid += 1;
                    break;
                }

                start = mid + 1;
            } else {
                if (start == end) {//한 개인 경우
                    break;
                }

                end = mid - 1;
            }
        }

        return mid;
    }
}