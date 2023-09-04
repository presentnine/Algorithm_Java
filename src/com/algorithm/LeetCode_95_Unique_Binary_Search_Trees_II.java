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

    void generateTreesWithPermutation(int[] arr, boolean[] visited, int count, int n) {//순열 생성 및 트리 생성
        if (count == n) {
            TreeNode root = new TreeNode(arr[0]);

            for (int i = 1; i < arr.length; i++) {
                insertNode(root, arr[i]);
            }

            String key = makeKey(root);//만들어진 트리에 대한 키 생성

            if (!duplicatedSet.contains(key)) {//기존에 없던 새로운 트리 형태라면 추가
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

    void insertNode(TreeNode node, int val) {//트리에 노드 삽입
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

    String makeKey(TreeNode node) {//트리에 대한 키 생성
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