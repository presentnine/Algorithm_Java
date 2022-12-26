package com.algorithm;

//https://leetcode.com/problems/divide-two-integers/

public class LeetCode_Divide_Two_Integers {
    public static void main(String[] args) {
        Solution_LeetCode_Divide_Two_Integers s = new Solution_LeetCode_Divide_Two_Integers();

//        System.out.println(s.divide(-2147483648, -1));
        System.out.println(s.divide(2, 2));
    }
}

class Solution_LeetCode_Divide_Two_Integers {
    long acc = 0, answer = 0;
    boolean closeToDividend = false;

    public int divide(int dividend, int divisor) {
        boolean isDividendMinus = false, isDivisorMinus = false;
        long dividendTemp = dividend, divisorTemp = divisor;

        if (dividend < 0) {//dividend 음수 여부
            isDividendMinus = true;
            dividendTemp = -dividendTemp;
        }

        if (divisor < 0) {//divisor 음수 여부
            isDivisorMinus = true;
            divisorTemp = -divisorTemp;
        }

        while (!closeToDividend) {//dividend에 다다를 때까지
            shiftCal(dividendTemp - acc, divisorTemp);
        }

        if (isDividendMinus ^ isDivisorMinus) {//결과에 마이너스 추가 여부
            answer = -answer;
        }

        if (answer >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (answer <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) answer;
        }
    }

    void shiftCal(long num, long divisor) {//시프트 연산 기반 나누기
        if (num < divisor) {
            closeToDividend = true;
            return;
        }

        long quotient = 1, temp = divisor;

        do {
            temp = temp << 1;
            quotient = quotient << 1;
        } while (temp <= num);
        temp = temp >> 1;
        quotient = quotient >> 1;

        acc += temp;
        answer += quotient;
    }
}