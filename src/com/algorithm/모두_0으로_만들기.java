package com.algorithm;

import java.util.*;

public class 모두_0으로_만들기 {
    public static void main(String[] args) {
        int[] a = new int[]{-5, 0, 2, 1, 2};
        int[][] edges = new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}};

        Solution_모두_0으로_만들기 s = new Solution_모두_0으로_만들기();
        System.out.println(s.solution(a, edges));
    }

}

class Solution_모두_0으로_만들기 {
    public long solution(int[] a, int[][] edges) {
        long answer = 0, sum = 0;
        int totalNodesCount = a.length; //전체 노드 개수
        long[] copyA = new long[totalNodesCount]; //int 배열 a -> long 배열로 복사
        Queue<Integer> q = new LinkedList<>(); //BFS 탐색용 큐

        for (int i = 0; i < totalNodesCount; i++)//long 배열로 옮기며 노드 값 총합도 계산
            sum += copyA[i] = a[i];

        if (sum != 0) //0이 아니면 애초에 과정이 불가능
            return -1;

        ArrayList<Integer>[] adjacentNodes = new ArrayList[totalNodesCount]; //인접 노드 리스트
        int[] adjacentNodesCount = new int[totalNodesCount]; //인접 노드 개수
        boolean[] visited = new boolean[totalNodesCount]; //중복 방문 방지용

        for (int i = 0; i < totalNodesCount; i++) //인접 노드 리스트 초기화
            adjacentNodes[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) { //값 채우기
            ++adjacentNodesCount[edges[i][0]];
            ++adjacentNodesCount[edges[i][1]];
            adjacentNodes[edges[i][0]].add(edges[i][1]);
            adjacentNodes[edges[i][1]].add(edges[i][0]);
        }

        for (int i = 0; i < totalNodesCount; i++) { //리프노드(인접 노드 1개)만 큐에 입력
            if (adjacentNodesCount[i] == 1)
                q.add(i);
        }

        while (!q.isEmpty()) { //BFS 탐색
            int nowNode = q.remove();

            visited[nowNode] = true;
            long value = copyA[nowNode];

            for (int i = 0; i < adjacentNodes[nowNode].size(); i++) { //인접 노드에 값 전달
                int nextNode = adjacentNodes[nowNode].get(i);

                if (!visited[nextNode]) {
                    --adjacentNodesCount[nextNode];
                    copyA[nextNode] += value;
                    copyA[nowNode] = 0;
                    answer += Math.abs(value);

                    if (adjacentNodesCount[nextNode] == 1) {
                        q.add(adjacentNodes[nowNode].get(i));
                    }

                    break;
                }
            }
        }

        return answer;
    }
}
