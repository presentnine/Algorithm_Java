package com.algorithm;

//https://leetcode.com/problems/maximal-rectangle/

import java.util.Stack;

public class LeetCode_85_Maximal_Rectangle {
}

class Solution_LeetCode_85_Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length, answer = 0;
        int[][] accs = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    accs[i][j] = 1;

                    if (i != 0) {
                        accs[i][j] += accs[i - 1][j];
                    }
                } else {
                    accs[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            answer = Math.max(answer, getLargestRectangle(accs[i]));
        }

        return answer;
    }

    int getLargestRectangle(int[] acc) {//LeetCode 84번 문제와 해결방법이 동일
        int answer = 0;
        int[] nearestMinLeft = new int[acc.length], nearestMinRight = new int[acc.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < acc.length; i++) {//본인의 왼쪽 부분 그래프 요소들 중 본인보다 가장 가까운 작은 값을 찾아 해당 인덱스를 저장
            while (!stack.isEmpty() && acc[stack.peek()] >= acc[i]) {
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
        for (int i = acc.length - 1; i >= 0; i--) {//본인의 오른쪽 부분 그래프 요소들 중 본인보다 가장 가까운 작은 값을 찾아 해당 인덱스를 저장
            while (!stack.isEmpty() && acc[stack.peek()] >= acc[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nearestMinRight[i] = acc.length;
            } else {
                nearestMinRight[i] = stack.peek();
            }
            stack.push(i);
        }

        for (int i = 0; i < acc.length; i++) {
            answer = Math.max(answer, (nearestMinRight[i] - nearestMinLeft[i] - 1) * acc[i]);
        }

        return answer;
    }
}