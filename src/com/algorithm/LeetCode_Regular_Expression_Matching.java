package com.algorithm;

public class LeetCode_Regular_Expression_Matching {
    public static void main(String[] args) {
        Solution_LeetCode_Regular_Expression_Matching s = new Solution_LeetCode_Regular_Expression_Matching();

        System.out.println(s.isMatch("mississippi", "mis*is*ip*"));
    }
}

class Solution_LeetCode_Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        return check(s, p);
    }

    boolean check(String s, String p) {
        if (p.length() == 0) {//기저조건
            if (s.length() != 0) {
                return false;
            } else {
                return true;
            }
        }

        char c = p.charAt(0);//패턴의 앞 문자 추출

        if (p.length() >= 2 && p.charAt(1) == '*') {//문자 + '*' 인 경우
            if (c == '.') {//'.*'인 경우
                for (int i = 0; i <= s.length(); i++) {
                    if (check(s.substring(i), p.substring(2))) {
                        return true;
                    }
                }
            } else {//'문자*'인 경우
                for (int i = 0; i <= s.length(); i++) {
                    if (i == 0) {//문자는 그대로 '문자*'만 없애서 다음 재귀함수 호출
                        if (check(s, p.substring(2))) {
                            return true;
                        }
                    } else {//문자가 맞는 부분까지 호출
                        if (c == s.charAt(i - 1)) {
                            if (check(s.substring(i), p.substring(2))) {
                                return true;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        } else {//단순 문자만 존재
            if (c == '.') {// '.'인 경우
                if (s.length() == 0) {//주어진 문장이 없는 경우
                    return false;
                } else {//어떠한 문자든
                    return check(s.substring(1), p.substring(1));
                }
            } else {//문자인 경우
                if (s.length() == 0 || s.charAt(0) != c) {//주어진 문장이 없거나 안맞는 경우
                    return false;
                } else {//맞는 경우
                    return check(s.substring(1), p.substring(1));
                }
            }
        }

        return false;
    }
}
