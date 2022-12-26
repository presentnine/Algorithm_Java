package com.algorithm;

//https://leetcode.com/problems/course-schedule/

import java.util.ArrayList;

public class LeetCode_Course_Schedule {
}

class Solution_LeetCode_Course_Schedule {
    boolean[] visited, cycle;
    ArrayList<Integer>[] adj;
    boolean result = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        cycle = new boolean[numCourses];
        adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {//연결관계 설정
            int a = prerequisites[i][0], b = prerequisites[i][1];
            adj[b].add(a);
        }

        for (int i = 0; i < numCourses; i++) {//전체 강의 dfs 탐색
            dfs(i);

            if (!result) {//사이클 탐지 시
                break;
            }
        }

        return result;
    }

    void dfs(int numCourse) {//dfs 탐색
        if (visited[numCourse]) {//중복 방문인 경우
            if (cycle[numCourse]) {//하나의 분기에 속한 경우라면 사이클이므로
                result = false;
            }

            return;
        }

        visited[numCourse] = true;//방문 표시
        cycle[numCourse] = true;//분기 표시

        for (int i = 0; i < adj[numCourse].size(); i++) {//다음 노드들 dfs 탐색
            dfs(adj[numCourse].get(i));
        }

        cycle[numCourse] = false;//분기 표시 초기화
    }
}