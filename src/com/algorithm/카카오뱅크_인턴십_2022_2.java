package com.algorithm;

public class 카카오뱅크_인턴십_2022_2 {
}

class Solution_카카오뱅크_인턴십_2022_2 {
    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        int answer = money;

        for (int i = 0; i < months; i++) {
            answer -= calculationTax(answer, minratio, maxratio, ranksize, threshold);
        }

        return answer;
    }

    int calculationTax(int money, int minratio, int maxratio, int ranksize, int threshold) {
        int trimMoney = (money / 100) * 100, taxRatio = 0;//버림 적용

        if (trimMoney >= threshold) {//threshold 이상
            taxRatio = minratio;
            taxRatio += (trimMoney - threshold) / ranksize;//추가 세율 계산

            if (taxRatio > maxratio) {//maxratio 여부 확인
                taxRatio = maxratio;
            }
        }

        return trimMoney / 100 * taxRatio;//세금 반환
    }
}