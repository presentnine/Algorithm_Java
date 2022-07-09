package com.algorithm;

public class Tworx_여름_인턴십_2022_2 {
}
class Solution_Tworx_여름_인턴십_2022_2 {
    public int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] answer = new int[2];
        int customerCount = periods.length;

        for (int i = 0; i < customerCount; i++) {
            int period = periods[i], nowTotalPayments = 0, nextTotalPayments;
            boolean nowVipStatus, nextVipStatus;

            for (int j = 0; j < 12; j++) {
                nowTotalPayments += payments[i][j];
            }

            nextTotalPayments = nowTotalPayments - payments[i][0] + estimates[i];

            nowVipStatus = isVip(period, nowTotalPayments);
            nextVipStatus = isVip(period + 1, nextTotalPayments);

            if (nowVipStatus == false && nextVipStatus == true) {
                ++answer[0];
            }

            if (nowVipStatus == true && nextVipStatus == false) {
                ++answer[1];
            }
        }

        return answer;
    }

    boolean isVip(int period, int totalPayments) {
        if (period < 24) {
            return false;
        } else if (period < 60) {
            if (totalPayments >= 900000) {
                return true;
            } else {
                return false;
            }
        } else {
            if (totalPayments >= 600000) {
                return true;
            } else {
                return false;
            }
        }
    }
}
