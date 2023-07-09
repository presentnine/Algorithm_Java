package com.algorithm;

//https://leetcode.com/problems/gray-code/

import java.util.ArrayList;
import java.util.List;

public class LeetCode_89_Gray_Code {
}

class Solution_LeetCode_89_Gray_Code {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);//기본 0 추가

        for (int i = 0; i < n; i++) {//총 n번에 대해 반복
            int size = result.size();//기존의 list 사이즈

            for (int j = size - 1; j >= 0; j--) {//기존 list 요소를 반대로하면서, 해당 숫자의 n번 비트를 1로 변경
                result.add(result.get(j) | 1 << i);
            }
        }

        return result;
    }
}