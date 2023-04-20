package com.algorithm;

//https://leetcode.com/problems/valid-number/

import java.util.regex.Pattern;

public class LeetCode_Valid_Number {
}

class Solution_LeetCode_Valid_Number {
    public boolean isNumber(String s) {
        String pattern = "^[-+]?([0-9]+(\\.[0-9]*)?|[0-9]*\\.[0-9]+)([eE][-+]?[0-9]+)?$";
        return Pattern.matches(pattern, s);
    }
}