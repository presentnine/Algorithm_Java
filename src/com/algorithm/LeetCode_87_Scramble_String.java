package com.algorithm;

//https://leetcode.com/problems/scramble-string/

import java.util.HashMap;
import java.util.Map;

public class LeetCode_87_Scramble_String {
}

class Solution_LeetCode_87_Scramble_String {
    Map<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        return check(s1, s2);
    }

    public boolean check(String a, String b) {
        if(a.equals(b)){
            return true;
        }

        if(a.length() <= 1) {
            return false;
        }

        boolean result = false;
        String key = a + "/" + b;//메모제이션을 위한 키값 설정

        if(map.containsKey(key)) {//결과가 존재한다면
            return map.get(key);
        }

        for (int i = 1; i < a.length(); i++) {//a 길이만큼의 경우의 수 모두 탐색
            boolean swap = check(a.substring(0, i), b.substring(a.length() - i)) && check(a.substring(i), b.substring(0, a.length() - i));
            boolean unswap = check(a.substring(0, i), b.substring(0, i)) && check(a.substring(i), b.substring(i));

            if (swap || unswap) {//둘 중 하나라도 true라면
                result = true;
                break;
            }
        }

        map.put(key, result);//탐색 결과 저장

        return result;
    }
}