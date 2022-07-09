package com.algorithm;

import java.util.PriorityQueue;

//https://leetcode.com/problems/container-with-most-water/
public class LeetCode_Container_With_Most_Water {

}

class Solution_LeetCode_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int answer = 0;

        for (int i = 0, j = height.length - 1; i < j; ) {
            answer = Math.max(answer, (j - i) * Math.min(height[i], height[j]));

            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }

        return answer;
    }
}
