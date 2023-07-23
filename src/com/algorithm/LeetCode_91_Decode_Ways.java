package com.algorithm;

//https://leetcode.com/problems/decode-ways/

import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetCode_91_Decode_Ways {
}

class Solution_LeetCode_91_Decode_Ways {
    int[] acc;

    public int numDecodings(String s) {
        acc = new int[s.length()];
        Arrays.fill(acc, -1);
        return recursive(0, s);
    }

    public int recursive(int index, String s) {//재귀 기반 판별
        if (index >= s.length()) {//인덱스가 문자열의 길이를 넘으면
            return 1;
        }

        if (acc[index] != -1) {//기존 탐색 결과가 있다면
            return acc[index];
        }

        int result = 0;

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(index));

        if (!sb.toString().equals("0")) {//현재 위치의 문자가 0이 아니라면
            result += recursive(index + 1, s);
        } else {//0이면 이후엔 더 이상 불가
            return acc[index] = 0;
        }

        if (index + 1 < s.length()) {//다음 위치의 문자를 추가
            sb.append(s.charAt(index + 1));
            int num = Integer.parseInt(sb.toString());

            if (10 <= num && num <= 26) {//10~26 사이의 숫자라면
                result += recursive(index + 2, s);
            }
        }

        return acc[index] = result;
    }
}