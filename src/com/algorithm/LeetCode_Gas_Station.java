package com.algorithm;

//https://leetcode.com/problems/gas-station/

public class LeetCode_Gas_Station {
}

class Solution_LeetCode_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length, acc = 0, startIndex, endIndex;

        startIndex = 0;
        endIndex = 0;

        do {
            acc = acc - cost[endIndex] + gas[endIndex];//현 남는 가스가 있다면
            endIndex = (endIndex + 1) % length;//뒤로 이동

            while (acc < 0 && startIndex != endIndex) {//현재 남는 가스가 없다면
                --startIndex;//앞으로 이동

                if (startIndex < 0) {
                    startIndex += length;
                }

                acc = acc - cost[startIndex] + gas[startIndex];
            }
        } while (startIndex != endIndex);

        if (acc < 0) {//최종 결과가 음수라면
            return -1;
        }

        return startIndex;
    }
}
