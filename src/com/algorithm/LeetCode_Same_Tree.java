package com.algorithm;

//https://leetcode.com/problems/same-tree/

public class LeetCode_Same_Tree {
}

class Solution_LeetCode_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traversal(p, q);
    }

    boolean traversal(TreeNode p, TreeNode q) {
        if (p == null && q == null) {//두 노드 다 null
            return true;
        } else if (p != null && q != null) {//모두 다 존재
            if (p.val == q.val) {//둘의 값이 같다면 다음 노드들
                return traversal(p.left, q.left) && traversal(p.right, q.right);
            } else {//다르면 false
                return false;
            }
        } else {//한 쪽만 null
            return false;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}