package com.algorithm;

//https://leetcode.com/problems/path-sum/

public class LeetCode_112_Path_Sum {
}

class Solution_LeetCode_112_Path_Sum {
    boolean answer = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        checkPathSum(root, 0, targetSum);

        return answer;
    }

    void checkPathSum(TreeNode node, int acc, int targetSum) {
        if (node == null) {
            return;
        }

        if (isLeafNode(node)) {
            if (acc + node.val == targetSum) {
                answer = true;
            }
        }

        checkPathSum(node.left, acc + node.val, targetSum);
        checkPathSum(node.right, acc + node.val, targetSum);
    }

    boolean isLeafNode(TreeNode node) {
        return (node.left == null) && (node.right == null);
    }
}