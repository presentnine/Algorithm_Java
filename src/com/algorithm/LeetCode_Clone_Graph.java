package com.algorithm;

//https://leetcode.com/problems/clone-graph/

import java.util.ArrayList;
import java.util.List;

public class LeetCode_Clone_Graph {
}

class Solution_LeetCode_Clone_Graph {
    Node[] nodes;

    public Node cloneGraph(Node node) {
        nodes = new Node[101];

        if (node == null) {
            return null;
        } else {
            return clone(node);
        }
    }

    Node clone(Node node) {//dfs 기반 복제
        if (nodes[node.val] != null) {//이미 복제한 노드가 있으면
            return nodes[node.val];
        }

        nodes[node.val] = new Node(node.val);//초기화

        for (int i = 0; i < node.neighbors.size(); i++) {//neighbors 구성
            nodes[node.val].neighbors.add(clone(node.neighbors.get(i)));
        }

        return nodes[node.val];
    }

//    Node clone(Node node, Node[] nodes) {//실패 케이스
//        if (nodes[node.val] != null) {
//            return nodes[node.val];
//        }
//
//        ArrayList<Node> cloneNeighbors = new ArrayList<>();
//        for (int i = 0; i < node.neighbors.size(); i++) {
//            cloneNeighbors.add(clone(node.neighbors.get(i), nodes));
//        }
//
//        return nodes[node.val] = new Node(node.val, cloneNeighbors);
//    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}