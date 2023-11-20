package com.algorithm;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

/**
 * preorder -> VLR
 * inorder -> LVR
 * postorder -> LRV
 */

public class LeetCode_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
}

class Solution_LeetCode_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        return makeSubTree(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode makeSubTree(int[] inorder, int[] postorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {//서브트리 구역이 없다면
            return null;
        }

        TreeNode node = new TreeNode(postorder[postorderIndex]);

        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (postorder[postorderIndex] == inorder[i]) {//주어진 inorder 서브트리 구역 중 현재 노드의 위치를 확인
                --postorderIndex;

                node.right = makeSubTree(inorder, postorder, i + 1, inorderEnd);//오른쪽 서브트리 구간을 바탕으로 트리 생성
                node.left = makeSubTree(inorder, postorder, inorderStart, i - 1);//왼쪽 서브트리 구간을 바탕으로 트리 생성

                break;
            }
        }

        return node;
    }
}