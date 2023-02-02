package com.algorithm;

//https://leetcode.com/problems/wildcard-matching/
public class LeetCode_Wildcard_Matching {
}

class Solution_LeetCode_Wildcard_Matching {
    int[][] dp;//dp용 배열
    public boolean isMatch(String s, String p) {
        dp = new int[s.length() + 1][p.length() + 1];

        if (check(s, 0, p, 0) == 1) {//결과 반환
            return true;
        } else {
            return false;
        }
    }

    int check(String s, int indexS, String p, int indexP) {
        if (dp[indexS][indexP] != 0) {//dp값이 존재한다면
            return dp[indexS][indexP];
        }

        if (indexS == s.length() && indexP == p.length()) {//양쪽 문자열 모두 소모
            return dp[indexS][indexP] = 1;
        }

        if (indexP == p.length()) {//패턴만 먼저 소모
            return dp[indexS][indexP] = -1;
        }

        if (indexS == s.length()) {//문자열 먼저 소모
            if (p.charAt(indexP) == '*') {//패턴이 *이라면
                return dp[indexS][indexP] = check(s, indexS, p, indexP + 1);
            } else {
                return dp[indexS][indexP] = -1;
            }
        }

        int result = -1;

        if (p.charAt(indexP) == '*') {
            for (int i = indexS; i <= s.length(); i++) {//현재부터 끝까지 s를 잘라 탐색
                if (check(s, i, p, indexP + 1) == 1) {
                    result = 1;
                    break;
                }
            }
        } else if (p.charAt(indexP) == '?') {
            result = check(s, indexS + 1, p, indexP + 1);
        } else {
            if (s.charAt(indexS) == p.charAt(indexP)) {//서로 앞의 문자가 맞다면
                result = check(s, indexS + 1, p, indexP + 1);
            }
        }

        return dp[indexS][indexP] = result;
    }
}