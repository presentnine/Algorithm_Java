package com.algorithm;

//https://leetcode.com/problems/validate-binary-search-tree/

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_98_Validate_Binary_Search_Tree {
}

class Solution_LeetCode_98_Validate_Binary_Search_Tree {
    Queue<Integer> q = new LinkedList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        inorderTraversal(root);

        int prevValue = q.poll();//최초값 pop

        while (!q.isEmpty()) {//모든 값을 돌며
            int nowValue = q.poll();

            if (prevValue >= nowValue) {//순서가 맞지 않는다면
                return false;
            }

            prevValue = nowValue;
        }

        return true;
    }

    void inorderTraversal(TreeNode node) {//중위 순회
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        q.add(node.val);
        inorderTraversal(node.right);
    }
}
