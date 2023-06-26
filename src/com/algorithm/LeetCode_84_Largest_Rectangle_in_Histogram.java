package com.algorithm;

//https://leetcode.com/problems/largest-rectangle-in-histogram/

//NSR/NSL 알고리즘

import java.util.Stack;

public class LeetCode_84_Largest_Rectangle_in_Histogram {
}

class Solution_LeetCode_84_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        int answer = 0;
        int[] nearestMinLeft = new int[heights.length], nearestMinRight = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {//본인의 왼쪽 부분 그래프 요소들 중 본인보다 가장 가까운 작은 값을 찾아 해당 인덱스를 저장
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nearestMinLeft[i] = -1;
            } else {
                nearestMinLeft[i] = stack.peek();
            }
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {//본인의 오른쪽 부분 그래프 요소들 중 본인보다 가장 가까운 작은 값을 찾아 해당 인덱스를 저장
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nearestMinRight[i] = heights.length;
            } else {
                nearestMinRight[i] = stack.peek();
            }
            stack.push(i);
        }

        //자신의 높이 * (오른쪽의 가장 가까운 작은 값 인덱스 - 왼쪽의 가장 가까운 작은 값 인덱스 - 1)
        //이 경우 자기 자신을 높이로 갖는 최적의 직사각형 크기를 구함
        for (int i = 0; i < heights.length; i++) {
            answer = Math.max(answer, (nearestMinRight[i] - nearestMinLeft[i] - 1) * heights[i]);
        }

        return answer;
    }
}