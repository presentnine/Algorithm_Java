package com.algorithm;

//https://leetcode.com/problems/maximum-subarray/

public class LeetCode_Maximum_Subarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1};
        Solution_LeetCode_Maximum_Subarray_2 s = new Solution_LeetCode_Maximum_Subarray_2();
        System.out.println(s.maxSubArray(nums));
    }
}

class Solution_LeetCode_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int answer;
        int[] rightToLeftSectionAcc = new int[nums.length + 1]
                , minRightToLeftSectionAcc = new int[nums.length + 1];
        rightToLeftSectionAcc[nums.length] = 0;
        minRightToLeftSectionAcc[nums.length] = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            rightToLeftSectionAcc[i] = rightToLeftSectionAcc[i + 1] + nums[i];
            minRightToLeftSectionAcc[i] = Math.min(rightToLeftSectionAcc[i], minRightToLeftSectionAcc[i + 1]);
        }

        int totalSum = rightToLeftSectionAcc[0], acc = 0;

        answer = totalSum - minRightToLeftSectionAcc[1];
        for (int i = 0; i < nums.length - 1; i++) {
            acc += nums[i];
            answer = Math.max(answer, totalSum - acc - minRightToLeftSectionAcc[i + 2]);
        }

        return answer;
    }
}

class Solution_LeetCode_Maximum_Subarray_2 {
    public int maxSubArray(int[] nums) {
        int answer = nums[0];
        int minAcc = 0;
        int[] leftToRightAcc = new int[nums.length];
        leftToRightAcc[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            leftToRightAcc[i] = nums[i] + leftToRightAcc[i - 1];//현재까지의 구간 누적합 계산
            minAcc = Math.min(minAcc, leftToRightAcc[i - 1]);//이전까지의 구간 누적값 중 최소 계산
            answer = Math.max(answer, leftToRightAcc[i] - minAcc);//(현재까지 누적합 - 최소 누적값 구간)의 최대
        }

        return answer;
    }
}

class Solution_LeetCode_Maximum_Subarray_3 {//해결방법 2의 최적화 버전
    public int maxSubArray(int[] nums) {
        int answer = nums[0], minAcc = 0, acc = nums[0];

        for (int i = 1; i < nums.length; i++) {
            minAcc = Math.min(minAcc, acc);
            acc += nums[i];
            answer = Math.max(answer, acc - minAcc);
        }

        return answer;
    }
}