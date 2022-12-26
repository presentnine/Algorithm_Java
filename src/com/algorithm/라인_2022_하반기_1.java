package com.algorithm;

import java.util.HashMap;

public class 라인_2022_하반기_1 {
}

class Solution_라인_2022_하반기_1 {
    public int solution(int[][] queries) {
        int answer = 0;

        HashMap<Integer, Integer> arrayElementCounts = new HashMap<>();
        HashMap<Integer, Integer> nowArraySize = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int arrayNum = queries[i][0], addElements = queries[i][1];

            if (!arrayElementCounts.containsKey(arrayNum)) {//처음 추가
                arrayElementCounts.put(arrayNum, addElements);
                nowArraySize.put(arrayNum, (int) Math.pow(2, getMax2Squared(addElements)));
            } else {//기존 존재
                int arrayElementCount = arrayElementCounts.get(arrayNum);
                int arraySize = nowArraySize.get(arrayNum);

                arrayElementCounts.replace(arrayNum, arrayElementCount + addElements);

                if (arraySize < arrayElementCount + addElements) {
                    answer += arrayElementCount;
                    nowArraySize.replace(arrayNum, (int) Math.pow(2, getMax2Squared(arrayElementCount + addElements)));
                }
            } 
        }

        return answer;
    }

    int getMax2Squared(int num) {
        int result = 0;

        while (num > (int) Math.pow(2, result)) {
            ++result;
        }

        return result;
    }
}
