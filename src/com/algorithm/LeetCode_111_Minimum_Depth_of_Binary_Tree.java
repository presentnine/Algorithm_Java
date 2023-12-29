package com.algorithm;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/

public class LeetCode_111_Minimum_Depth_of_Binary_Tree {
}

class Solution_LeetCode_111_Minimum_Depth_of_Binary_Tree {
    int answer = 100000;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        checkMinimumDepth(root, 1);
        return answer;
    }

    void checkMinimumDepth(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (isLeafNode(node)) {
            answer = Math.min(answer, depth);
        } else {
            checkMinimumDepth(node.left, depth+1);
            checkMinimumDepth(node.right, depth+1);
        }
    }

    boolean isLeafNode(TreeNode node) {
        return (node.left == null) && (node.right == null);
    }
}