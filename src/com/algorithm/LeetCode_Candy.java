package com.algorithm;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/candy/
public class LeetCode_Candy {

}

class Solution_LeetCode_Candy {
    int[] candies;//각 아이마다 candy 저장 배열
    boolean[] visited;//방문 배열

    public int candy(int[] ratings) {
        candies = new int[ratings.length];
        visited = new boolean[ratings.length];
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;

        if (ratings.length == 1) {//전체 ratings 배열 길이가 1이면 단순 1반환
            return 1;
        }

        //전체 요소를 훑으며 오목한 구간의 가장 작은 지점을 큐에 저장
        if (ratings[0] <= ratings[1]) {
            q.add(0);
        }
        for (int i = 1; i < ratings.length - 1; i++) {
            int prev = ratings[i - 1], now = ratings[i], post = ratings[i + 1];

            if (prev >= now && now <= post) {
                q.add(i);
            }
        }
        if (ratings[ratings.length - 2] >= ratings[ratings.length - 1]) {
            q.add(ratings.length - 1);
        }

        while (!q.isEmpty()) {//해당 지점을 시작으로 dfs
            dfs(q.poll(), 1, ratings);
        }

        for (int i = 0; i < candies.length; i++) {//전체 candy 누적합 계산
            answer += candies[i];
        }

        return answer;
    }

    void dfs(int index, int candy, int[] ratings) {
        if (index < 0 || index >= candies.length) {//구간 외면 return
            return;
        }

        if (visited[index]) {//이미 방문한 곳이면 pass
            if (candies[index] < candy) {//다만 지금 candy값이 기존보다 크다면 최신화
                candies[index] = candy;
            }
            return;
        }

        visited[index] = true;
        candies[index] = candy;

        if (index - 1 >= 0 && (ratings[index - 1] > ratings[index])) {//왼쪽
            dfs(index - 1, candy + 1, ratings);
        }

        if (index + 1 < ratings.length && (ratings[index + 1] > ratings[index])) {//오른쪽
            dfs(index + 1, candy + 1, ratings);
        }
    }
}