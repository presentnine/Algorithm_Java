package com.algorithm;

//https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.ArrayList;
import java.util.List;

public class LeetCode_94_Binary_Tree_Inorder_Traversal {
}

class Solution_LeetCode_94_Binary_Tree_Inorder_Traversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traversalSearch(root);
        return result;
    }

    void traversalSearch(TreeNode node) {
        if (node == null) {
            return;
        }

        traversalSearch(node.left);
        result.add(node.val);
        traversalSearch(node.right);
    }
}