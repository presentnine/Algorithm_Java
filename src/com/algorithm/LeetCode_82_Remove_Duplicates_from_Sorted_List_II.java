package com.algorithm;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

public class LeetCode_82_Remove_Duplicates_from_Sorted_List_II {
}

class Solution_LeetCode_82_Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        int prev = -9999;

        while (temp != null) {//전체 노드를 한 번 돌며, 이전과 중복되는 노드의 값을 변경
            if (temp.val == prev) {
                temp.val = -9999;
            } else {
                prev = temp.val;
            }
            temp = temp.next;
        }

        ListNode answer = findNext(head);//헤드에 대한 체크 진행
        temp = answer;

        while (temp != null) {//다음 노드들에 대해서도 중복 제거 진행
            temp.next = findNext(temp.next);
            temp = temp.next;
        }

        return answer;
    }

    ListNode findNext(ListNode node) {//다음에 올 노드를 탐색하는 함수
        if (node == null || node.next == null) {//현재 혹은 다음 노드가 null이라면
            return node;
        }

        if (node.next.val != -9999) {//다음 노드 값이 -9999가 아닌, 실제 값이 온다면 현재 노드는 유일한 노드
            return node;
        }

        ListNode next = node.next;

        while (next != null && next.val == -9999) {//-9999가 아닌 노드가 올 때까지 반복
            next = next.next;
        }

        return findNext(next);//해당 다음 노드에 대해서도 재귀로 다시 처리를 진행
    }
}