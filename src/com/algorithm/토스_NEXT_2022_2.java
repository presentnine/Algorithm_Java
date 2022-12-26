package com.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 토스_NEXT_2022_2 {

}

class Solution_토스_NEXT_2022_2 {
    public int solution(int[] levels) {
        if (levels.length < 4) {
            return -1;
        }

        int top25Index = levels.length - levels.length / 4;

        Arrays.sort(levels);

        return levels[top25Index];
    }
}

//class Solution_토스_NEXT_2022_2 {
//    public int solution(int[] levels) {
//        int top25Count = levels.length / 4;
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//
//        for (int i = 0; i < levels.length; i++) {
//            pq.add(levels[i]);
//        }
//
//        for (int i = 0; i < top25Count - 1; i++) {
//            pq.poll();
//        }
//
//        return pq.poll();
//    }
//}