package com.algorithm;

//https://leetcode.com/problems/swap-nodes-in-pairs/

public class LeetCode_Swap_Nodes_in_Pairs {

}

class Solution_LeetCode_Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    ListNode swap(ListNode node) {
        if (node == null) {//null인 경우
            return null;
        }

        if (node.next == null) {//swap할 다음 노드가 없는 경우
            return node;
        }

        ListNode first = node, second = node.next;

        first.next = swap(second.next);//그 다음 노드들의 swap 결과
        second.next = first;//처음 노드

        return second;//바뀐 순서의 노드
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
