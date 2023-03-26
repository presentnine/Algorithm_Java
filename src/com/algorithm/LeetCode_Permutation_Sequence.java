package com.algorithm;

//https://leetcode.com/problems/permutation-sequence/

import java.util.LinkedList;

public class LeetCode_Permutation_Sequence {
}

class Solution_LeetCode_Permutation_Sequence {
    public String getPermutation(int n, int k) {
        LinkedList<Integer> numbers = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int factorial = 1, order;

        for (int i = 1; i <= n; i++) {
            numbers.add(i);//사용할 숫자들을 순서대로 list에 추가
            factorial *= i;//n에 대한 factorial 계산
        }

        while (n > 0) {//가장 앞의 숫자부터 순서대로
            factorial /= n;//현재 위치를 제외한 뒷 부분의 순열 길이 
            order = 0;

            while (k > factorial) {//순서 계산
                k -= factorial;
                ++order;
            }

            res.append(numbers.remove(order));//남은 숫자들 중 해당 순서에 해당하는 숫자를 가져와 추가
            --n;
        }

        return res.toString();
    }
}

