package com.algorithm;


//https://leetcode.com/problems/largest-number/

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_Largest_Number {
}

class Solution_LeetCode_Largest_Number {
    public String largestNumber(int[] nums) {
        Integer[] numsWrapper = new Integer[nums.length];
        StringBuilder sb = new StringBuilder();
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {//int 배열 -> Integer 배열로 변경
            numsWrapper[i] = nums[i];
            if (nums[i] == 0) {//0의 개수 카운트
                ++zeroCount;
            }
        }

        if (zeroCount == nums.length) {//전부다 0이면
            return "0";
        }

        Arrays.sort(numsWrapper, new Comparator<Integer>() {//배열 sort
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1Length = getLength(o1), o2Length = getLength(o2);
                long a = o1 * (long) Math.pow(10, o2Length) + o2;
                long b = o2 * (long) Math.pow(10, o1Length) + o1;

                if (a >= b) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < numsWrapper.length; i++) {//숫자 모두 합치기
            sb.append(numsWrapper[i]);
        }

        return sb.toString();
    }

    int getLength(int n) {//숫자 자릿수 반환
        int length = 1;

        while (n / 10 != 0) {
            ++length;
            n = n / 10;
        }

        return length;
    }
}