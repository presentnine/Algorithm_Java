package com.algorithm;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/

public class LeetCode_Maximum_Depth_of_Binary_Tree {
}

class Solution_LeetCode_Maximum_Depth_of_Binary_Tree {
    int answer = 0;

    public int maxDepth(TreeNode root) {
        traversal(root, 1);
        return answer;
    }

    void traversal(TreeNode node, int depth) {
        if (node != null) {
            answer = Math.max(answer, depth);

            traversal(node.left, depth + 1);
            traversal(node.right, depth + 1);
        }
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}