package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class 토스_NEXT_2022_5 {
}

class Solution_토스_NEXT_2022_5 {
    public int solution(int[] tasks) {
        int answer = 0;

        HashMap<Integer, Integer> taskCounts = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            if (taskCounts.containsKey(tasks[i])) {
                taskCounts.replace(tasks[i], taskCounts.get(tasks[i]) + 1);
            } else {
                taskCounts.put(tasks[i], 1);
            }
        }

        for (Integer taskCount : taskCounts.values()) {
            if (taskCount == 1) {
                return -1;
            } else {
                if (taskCount % 3 == 0) {
                    answer += taskCount / 3;
                } else {//나머지가 1 또는 2
                    answer += taskCount / 3 + 1;
                }
            }
        }

        return answer;
    }
}
