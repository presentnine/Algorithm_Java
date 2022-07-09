package com.algorithm;

//https://programmers.co.kr/learn/courses/30/lessons/12904

public class 가장_긴_팰린드롬 {

}

class Solution_가장_긴_팰린드롬 {
    public int solution(String s) {
        int answer = 1;

        if (s.length() <= 1)
            return 1;

        for (int i = 1; i < s.length(); i++) { //각 지점에서 확인
            if (s.charAt(i) == s.charAt(i - 1)) { // 팰린드롬이 짝수개인 경우 (...@@...)
                answer = Math.max(answer, countPalindrome(s, i - 1, i));
            }

            if (i > 1 && s.charAt(i) == s.charAt(i - 2)) { //팰린드롬이 홀수 개인 경우 (...@#@...)
                answer = Math.max(answer, countPalindrome(s, i - 2, i));
            }
        }

        return answer;
    }

    int countPalindrome(String s, int index1, int index2) {//팰린드롬 길이 확인
        while (index1 >= 0 && index2 < s.length() && s.charAt(index1) == s.charAt(index2)) {
            --index1;
            ++index2;
        }

        return index2 - index1 - 1;
    }
}