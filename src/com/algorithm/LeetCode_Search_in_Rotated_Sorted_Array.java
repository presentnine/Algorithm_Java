package com.algorithm;

//https://leetcode.com/problems/search-in-rotated-sorted-array/

public class LeetCode_Search_in_Rotated_Sorted_Array {
}

class Solution_LeetCode_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);

        if (pivot == -1) {//중간에 pivot이 없는 경우
            return binarySearch(nums, target, 0, nums.length - 1);
        } else {//중간 pivot 위치
            int answer1 = binarySearch(nums, target, 0, pivot);
            int answer2 = binarySearch(nums, target, pivot + 1, nums.length - 1);

            if (answer1 == -1 && answer2 == -1) {//target이 양쪽 모두 없다면
                return -1;
            } else {//한쪽에 존재
                if (answer1 != -1) {
                    return answer1;
                } else {
                    return answer2;
                }
            }
        }
    }

    int findPivot(int[] nums, int start, int end) {//나뉘어진 pivot find
        int middle = (start + end) / 2;

        if (nums[start] > nums[middle]) {
            return findPivot(nums, start, middle);
        } else if (nums[middle] > nums[end]) {
            if (start == middle) {//start와 end가 하나 차이인 경우
                return middle;
            }

            return findPivot(nums, middle, end);
        } else {
            return -1;
        }
    }

    int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {//못찾은 경우
            return -1;
        }

        int middle = (start + end) / 2;

        if (nums[middle] == target) {//찾은 경우
            return middle;
        } else if (nums[middle] > target) {//목표가 중앙보다 오른쪽에
            return binarySearch(nums, target, start, middle - 1);
        } else {//목표가 중앙보다 왼쪽에
            return binarySearch(nums, target, middle + 1, end);
        }
    }
}