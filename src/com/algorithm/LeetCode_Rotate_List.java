package com.algorithm;

//https://leetcode.com/problems/rotate-list/

public class LeetCode_Rotate_List {
}

class Solution_LeetCode_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {//주어진 노드 자체가 null인 경우
            return head;
        }

        ListNode now = head, end = head;
        int nodeLength = 0;

        while (now != null) {//주어진 리스트를 한 번 순회
            ++nodeLength;//전체 길이 계산

            if (now.next == null) {//리스트의 마지막인 경우 따로 저장
                end = now;
            }
            now = now.next;
        }
        end.next = head;//리스트의 마지막 노드에 head를 추가해 전체 리스트를 연결
        k = nodeLength - (k % nodeLength);//이동해야할 횟수 계산

        now = head;
        for (int i = 0; i < k; i++) {//계산한 횟수 k만큼 회전
            if (i == k - 1) {//마지막 횟수 직전의 노드를 따로 저장
                end = now;
            }

            now = now.next;
        }
        end.next = null;//현재 순환 리스트 형태의 노드의 연결을 끊기

        return now;
    }
}

class ListNode {
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