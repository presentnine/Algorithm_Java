package com.algorithm;

//https://leetcode.com/problems/trapping-rain-water/

public class LeetCode_Trapping_Rain_Water {
}

class Solution_LeetCode_Trapping_Rain_Water {
    public int trap(int[] height) {
        int waterAmount = 0;
        int[] leftToRight = new int[height.length], rightToLeft = new int[height.length];
        leftToRight[0] = height[0];
        rightToLeft[height.length - 1] = height[height.length - 1];

        //왼쪽에서 오른쪽으로 가며 현재 구간이 접하는 가장 긴 벽을 표시
        for (int i = 1; i < height.length; i++) {
            leftToRight[i] = Math.max(height[i], leftToRight[i - 1]);
        }

        //오른쪽에서 왼쪽으로 가며 현재 구간이 접하는 가장 긴 벽을 표시
        for (int i = height.length - 2; i >= 0; i--) {
            rightToLeft[i] = Math.max(height[i], rightToLeft[i + 1]);
        }

        //현재의 위치에서 자신의 왼쪽과 오른쪽 중 짧은 벽을 찾아 현 위치와 차이만큼을 물의 양으로 계산
        for (int i = 0; i < height.length; i++) {
            waterAmount += Math.min(leftToRight[i], rightToLeft[i]) - height[i];
        }

        return waterAmount;
    }
}