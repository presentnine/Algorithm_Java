package com.algorithm;

import java.util.Stack;

public class LeetCode_Add_Two_Numbers {
}
class Solution_LeetCode_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack = new Stack<>();
        ListNode answer;
        int acc = 0;

        while (l1 != null || l2 != null) {
            int l1Num = 0, l2Num = 0, result;

            if (l1 != null) {
                l1Num = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                l2Num = l2.val;
                l2 = l2.next;
            }

            result = (l1Num + l2Num + acc) % 10;
            acc = (l1Num + l2Num + acc) / 10;

            stack.add(result);
        }

        if (acc != 0) {
            stack.add(acc);
        }

        ListNode next = new ListNode(stack.pop());
        answer = next;
        while (!stack.isEmpty()) {
            answer = new ListNode(stack.pop(), next);
            next = answer;
        }

        return answer;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
