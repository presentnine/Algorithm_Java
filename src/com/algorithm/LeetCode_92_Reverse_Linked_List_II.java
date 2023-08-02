package com.algorithm;

//https://leetcode.com/problems/reverse-linked-list-ii/

public class LeetCode_92_Reverse_Linked_List_II {
}

class Solution_LeetCode_92_Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {//바꿔야할 부분의 위치가 동일하다면 그대로 반환
            return head;
        }

        ListNode tempHead = new ListNode(-1, head); //리스트 앞단의 임시 헤더 추가
        ListNode temp = tempHead, previousReverseStart = null;
        ListNode reverseListHead = null, reverseStart = null;
        int positionCount = 0;

        while (temp != null) {
            if (positionCount == left - 1) {//바꿀 부분의 직전 노드를 따로 저장
                previousReverseStart = temp;
            }

            if (left <= positionCount && positionCount <= right) {//바꿔야할 구간
                ListNode copyNode = new ListNode(temp.val);
                copyNode.next = reverseListHead;
                reverseListHead = copyNode;

                if (positionCount == left) {//구간의 시작 노드는 따로 저장
                    reverseStart = reverseListHead;
                }

                if (positionCount == right) {//구간의 끝 노드 도착시 뒤집은 리스트를 이어붙이는 작업 진행
                    previousReverseStart.next = reverseListHead;
                    reverseStart.next = temp.next;
                    break;
                }
            }

            ++positionCount;
            temp = temp.next;
        }

        return tempHead.next;
    }
}