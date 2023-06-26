package com.algorithm;

//https://leetcode.com/problems/partition-list/

public class LeetCode_86_Partition_List {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_LeetCode_86_Partition_List {
    public ListNode partition(ListNode head, int x) {
        //x보다 작은 노드들의 리스트를 위한 임시 헤더, x보다 크거나 같은 노드들의 리스트를 위한 임시 헤더 초기화
        ListNode lessThanHeadNode = new ListNode(), greaterThanOrEqualHeadNode = new ListNode();

        //주어진 리스트, x보다 작은 리스트, x보다 크거나 같은 리스트를 돌기 위한 임시 노드 초기화
        ListNode temp = head, tempLessNode = lessThanHeadNode, tempGreaterThanOrEqualNode = greaterThanOrEqualHeadNode;

        while (temp != null) {//본래 리스트 속 노드를 돌며
            if (temp.val < x) {//해당 값이 x보다 작다면 작은 리스트에 추가
                tempLessNode.next = temp;
                tempLessNode = tempLessNode.next;
            } else {//크거나 같다면 해당 리스트에 추가
                tempGreaterThanOrEqualNode.next = temp;
                tempGreaterThanOrEqualNode = tempGreaterThanOrEqualNode.next;
            }
            temp = temp.next;
        }

        tempLessNode.next = greaterThanOrEqualHeadNode.next;//x보다 작은 리스트의 끝에 크거나 같은 값들로 구성된 리스트의 시작을 추가
        tempGreaterThanOrEqualNode.next = null;//크거나 같은 값들로 구성된 리스트의 마지막을 null로 초기화

        return lessThanHeadNode.next;//임시 헤더의 다음 노드를 반환(진짜 리스트의 헤더)
    }
}