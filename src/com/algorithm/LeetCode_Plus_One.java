package com.algorithm;

//https://leetcode.com/problems/plus-one/

import java.util.LinkedList;

public class LeetCode_Plus_One {
}

class Solution_LeetCode_Plus_One {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<>();
        int acc = 1; //시작 +1

        for (int i = digits.length - 1; i >= 0; i--) {//끝에서부터 순서대로
            list.addFirst((digits[i] + acc) % 10);//현재값 계산 후 추가
            acc = (digits[i] + acc) / 10;//다음 위치에 반영할 누적값 초기화
        }

        if (acc != 0) {//최종 누적값 반영
            list.addFirst(acc);
        }

        return list.stream().mapToInt(i -> i).toArray();//list -> array
    }
}