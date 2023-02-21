package com.algorithm;

//https://leetcode.com/problems/powx-n/

public class LeetCode_Pow_x_n {
    class Solution {
        long exponentAcc = 0;
        double answer = 1.0;

        public double myPow(double x, int n) {
            long tempN = n;

            if (n == 0 || x == 1.0) {//지수가 0이거나 밑수가 1인 경우
                return 1.0;
            }

            if (n < 0) {//지수가 음수라면 양수로 바꾸며 x를 수정
                x = 1 / x;
                tempN = -tempN;
            }

            while (exponentAcc < tempN) {//지수의 누적이 수정된 n에 다다를때까지
                approximation(tempN - exponentAcc, x);
            }

            return answer;
        }

        void approximation(long remain, double x) {//남은 remain에 가깝게 지수를 근사
            long exponent = 1;
            double result = x;

            while ((exponent << 1) <= remain) {
                result = result * result;
                exponent = exponent << 1;
            }

            exponentAcc += exponent;
            answer *= result;
        }
    }
}
