package com.algorithm;

//https://leetcode.com/problems/unique-binary-search-trees-ii/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_95_Unique_Binary_Search_Trees_II {
}

class Solution_LeetCode_95_Unique_Binary_Search_Trees_II {
    Set<String> duplicatedSet = new HashSet<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {
        generateTreesWithPermutation(new int[n], new boolean[n + 1], 0, n);
        return result;
    }

    void generateTreesWithPermutation(int[] arr, boolean[] visited, int count, int n) {
        if (count == n) {
            TreeNode root = new TreeNode(arr[0]);

            for (int i = 1; i < arr.length; i++) {
                insertNode(root, arr[i]);
            }

            String key = makeKey(root);

            if (!duplicatedSet.contains(key)) {
                duplicatedSet.add(key);
                result.add(root);
                return;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[count] = i;
                generateTreesWithPermutation(arr, visited, count + 1, n);
                visited[i] = false;
            }
        }
    }

    void insertNode(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                insertNode(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                insertNode(node.right, val);
            }
        }
    }

    String makeKey(TreeNode node) {
        if (node == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("/");
        sb.append(makeKey(node.left));
        sb.append("/");
        sb.append(makeKey(node.right));

        return sb.toString();
    }
}