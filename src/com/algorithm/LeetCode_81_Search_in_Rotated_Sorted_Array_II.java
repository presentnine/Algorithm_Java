package com.algorithm;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

public class LeetCode_81_Search_in_Rotated_Sorted_Array_II {
}

class Solution_LeetCode_81_Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        int pivot = -1;

        for (int i = 0; i < nums.length - 1; i++) {//앞에서부터 탐색하며 pivot 위치 탐색
            if (nums[i] > nums[i + 1]) {
                pivot = i;
            }
        }

        if (pivot == -1) {//pivot이 없다면
            return binarySearch(nums, target, 0, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, pivot) ||
                    binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
    }

//    boolean binarySearch(int[] nums, int target, int start, int end) {
//        int mid;
//
//        while (start <= end) {
//            mid = (start + end) / 2;
//
//            if (nums[mid] == target) {
//                return true;
//            } else if (nums[mid] > target) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//
//        return false;
//    }

    boolean binarySearch(int[] nums, int target, int start, int end) {//재귀 기반 이진 탐색
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, start, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, end);
        }
    }
}