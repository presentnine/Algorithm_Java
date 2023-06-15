package com.algorithm;

public class LeetCode_83_Remove_Duplicates_from_Sorted_List {
}

class Solution_LeetCode_83_Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp != null) {//temp가 null이 아닌 동안
            while (temp.next != null && temp.next.val == temp.val) {//다음 노드가 null이 아니고 값이 같다면 그 다음 노드 탐색
                temp.next = temp.next.next;
            }

            temp = temp.next;
        }

        return head;
    }
}
