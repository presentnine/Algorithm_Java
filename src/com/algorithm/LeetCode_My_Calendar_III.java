package com.algorithm;


//https://leetcode.com/problems/my-calendar-iii/

import java.util.TreeMap;

public class LeetCode_My_Calendar_III {
}

class MyCalendarThree {
    TreeMap<Integer, Integer> treeMap;

    public MyCalendarThree() {
        treeMap = new TreeMap<>();
    }

    public int book(int start, int end) {//누적합 활용
        if (treeMap.containsKey(start)) {//start 쪽에 +1 체크
            treeMap.put(start, treeMap.get(start) + 1);
        } else {
            treeMap.put(start, 1);
        }

        if (treeMap.containsKey(end)) {//end 쪽에 -1 체크
            treeMap.put(end, treeMap.get(end) - 1);
        } else {
            treeMap.put(end, -1);
        }

        int temp = 0, result = 0;
        for (Integer value : treeMap.values()) {//전체를 돌며 누적합 중 가장 큰 값을 반환
            temp += value;

            result = Math.max(result, temp);
        }

        return result;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
