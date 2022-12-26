package com.algorithm;

//https://leetcode.com/problems/remove-element/

public class LeetCode_Remove_Element {
}

class Solution_LeetCode_Remove_Element {
    public int removeElement(int[] nums, int val) {
        int k = 0, start = 0, end = nums.length - 1, swap;

        while (start < end) {
            while (start < nums.length && nums[start] != val) {//앞에서부터 val값이 나올때까지 증가
                start++;
            }

            while (end >= 0 && nums[end] == val) {//뒤에서부터 val이 아닌 값이 나올때까지 감소
                end--;
            }

            if (start < end) {//둘의 순서가 맞다면 교체
                swap = nums[start];
                nums[start] = nums[end];
                nums[end] = swap;
            }
        }

        for (int i = 0; i <= end; i++) {//처음부터 마지막 end 위치까지만 탐색해 val이 아닌 원소 개수 파악
            if (nums[i] != val) {
                k++;
            }
        }

        return k;
    }
}