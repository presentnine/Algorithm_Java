package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_Generate_Parentheses {
}

class Solution_LeetCode_Generate_Parentheses {
    ArrayList<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int[] array = new int[2 * n];
        generateComb(n, 0, 0, 0, array);
        return ans;
    }

    void generateComb(int n, int now, int leftCount, int rightCount, int[] array) {
        if (now == n * 2) {
            generatePair(array);
            return;
        }

        if (leftCount == rightCount) {//현재 양쪽 괄호 쌍이 동일하다면
            array[now] = -1;
            generateComb(n, now + 1, leftCount + 1, rightCount, array);
        } else if (leftCount < n) {//왼쪽 괄호에 추가 여유가 있다면
            array[now] = -1;
            generateComb(n, now + 1, leftCount + 1, rightCount, array);
            array[now] = 1;
            generateComb(n, now + 1, leftCount, rightCount + 1, array);
        } else if (leftCount == n) {//왼쪽 괄호를 모두 채웠다면
            array[now] = 1;
            generateComb(n, now + 1, leftCount, rightCount + 1, array);
        }
    }

    void generatePair(int[] array) {//결과 String 생성
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                sb.append('(');
            } else {
                sb.append(')');
            }
        }

        ans.add(sb.toString());
    }
}