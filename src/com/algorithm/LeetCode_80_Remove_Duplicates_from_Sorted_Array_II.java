package com.algorithm;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class LeetCode_80_Remove_Duplicates_from_Sorted_Array_II {
}

class Solution_LeetCode_80_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int nowNum = nums[0], nowNumCount = 1, changedIndex = 1;//초기값

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nowNum) {//숫자가 같다면 개수 카운트
                ++nowNumCount;
            }else {//다르다면 새롭게 설정
                nowNum = nums[i];
                nowNumCount = 1;
            }

            if (nowNumCount <= 2) {//현재까지의 숫자 개수가 2개 이하인 경우
                if (changedIndex < i){//바꿔야하는 숫자 위치가 지금부터 앞인 경우 숫자 교체 진행
                    nums[changedIndex] = nums[i];
                }
                ++changedIndex;
            }
        }

        return changedIndex;
    }
}