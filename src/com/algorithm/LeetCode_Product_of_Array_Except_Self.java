package com.algorithm;

//https://leetcode.com/problems/product-of-array-except-self/
public class LeetCode_Product_of_Array_Except_Self {
}

class Solution_LeetCode_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length], leftToRight = new int[nums.length], rightToLeft =new int[nums.length];

        //왼쪽부터 오른쪽으로 누적 곱 저장
        leftToRight[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftToRight[i] = nums[i] * leftToRight[i - 1];
        }

        //오른쪽부터 왼쪽으로 누적 곱 저장
        rightToLeft[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightToLeft[i] = nums[i] * rightToLeft[i + 1];
        }

        //정답 배열 초기화
        answers[0] = rightToLeft[1];
        answers[nums.length - 1] = leftToRight[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            answers[i] = leftToRight[i - 1] * rightToLeft[i + 1];
        }

        return answers;
    }
}