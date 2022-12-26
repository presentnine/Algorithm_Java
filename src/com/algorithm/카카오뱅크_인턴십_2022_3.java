package com.algorithm;

public class 카카오뱅크_인턴십_2022_3 {
}

class Solution_카카오뱅크_인턴십_2022_3 {
    int totalCycleCount = 0;//사이클 개수 파악
    boolean[] visited;//방문 배열

    public int solution(int[] rooms) {
        visited = new boolean[rooms.length + 1];

        for (int i = 1; i <= rooms.length; i++) {
            if (!visited[i]) {
                dfs(i, rooms);//사이클 파악
            }
        }

        return Math.max(1, totalCycleCount - 1);//1개 혹은 최대-1 중 큰 값 반환
    }

    void dfs(int roomNum, int[] rooms) {
        if (visited[roomNum]) {//사이클 시작점으로 다시 돌아온 경우
            ++totalCycleCount;
            return;
        }

        visited[roomNum] = true;
        dfs(rooms[roomNum - 1], rooms);
    }
}