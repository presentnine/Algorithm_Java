package com.algorithm;


//https://leetcode.com/problems/longest-valid-parentheses/

import java.util.Stack;

public class LeetCode_Longest_Valid_Parentheses {
    public static void main(String[] args) {
        Solution_LeetCode_Longest_Valid_Parentheses s = new Solution_LeetCode_Longest_Valid_Parentheses();

        System.out.println(s.longestValidParentheses("()(()"));
    }
}

class Solution_LeetCode_Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        int answer = 0, length = 0;
        Stack<Infor> stack = new Stack<>();
        boolean[] isValid = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            Character now = s.charAt(i);

            if (now.equals(')')) {
                if (!stack.isEmpty()) {
                    Infor prev = stack.peek();

                    if (prev.c.equals('(')) {
                        isValid[i] = true;
                        isValid[prev.pos] = true;
                    }

                    stack.pop();
                }
            } else {
                stack.push(new Infor(now, i));
            }
        }

        for (int i = 0; i < isValid.length; i++) {
            System.out.print(isValid[i] + " ");
            if (!isValid[i]) {
                answer = Math.max(answer, length);
                length = 0;
            } else {
                ++length;
            }
        }
        answer = Math.max(answer, length);

        return answer;
    }

    class Infor {
        Character c;
        int pos;

        public Infor(Character c, int pos) {
            this.c = c;
            this.pos = pos;
        }
    }
}