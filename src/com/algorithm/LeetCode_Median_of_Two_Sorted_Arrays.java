package com.algorithm;

//https://leetcode.com/problems/median-of-two-sorted-arrays/

public class LeetCode_Median_of_Two_Sorted_Arrays {
}

class Solution_LeetCode_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int nums1Index = 0, nums2Index = 0, index=0;

        while (nums1Index < nums1.length && nums2Index < nums2.length) {//두 배열을 통함
            if (nums1[nums1Index] < nums2[nums2Index]) {
                merge[index++] = nums1[nums1Index++];
            } else {
                merge[index++] = nums2[nums2Index++];
            }
        }

        if (nums1Index == nums1.length) {//첫 번째 배열에 남은게 없다면
            while (nums2Index < nums2.length) {
                merge[index++] = nums2[nums2Index++];
            }
        }

        if (nums2Index == nums2.length) {//두 번째 배열에 남은게 없다면
            while (nums1Index < nums1.length) {
                merge[index++] = nums1[nums1Index++];
            }
        }
        
        if (merge.length % 2 == 0) {//중위값 계산
            return (double) (merge[merge.length / 2 - 1] + merge[merge.length / 2]) / 2.0;
        } else {
            return (double) merge[merge.length / 2];
        }
    }
}

