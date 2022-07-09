package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Tworx_여름_인턴십_2022_3 {
}

class Solution_Tworx_여름_인턴십_2022_3 {
    int[] extraServiceAppearPlans, justDataInPlans;//부가서비스 최초 등장 플랜, 데이터들만 저장한 배열

    public int[] solution(int n, String[] plans, String[] clients) {
        int[] answer = new int[clients.length];
        extraServiceAppearPlans = new int[n + 1];
        justDataInPlans = new int[plans.length];

        Arrays.fill(extraServiceAppearPlans, plans.length);

        for (int i = 0; i < plans.length; i++) {
            String plan = plans[i];
            String[] splitPlan = plan.split(" ");

            justDataInPlans[i] = Integer.parseInt(splitPlan[0]);//데이터 저장

            for (int j = 1; j < splitPlan.length; j++) {//추가된 부가서비스들에 현재 플랜 저장
                int extraService = Integer.parseInt(splitPlan[j]);
                extraServiceAppearPlans[extraService] = i;
            }
        }

        for (int i = 0; i < clients.length; i++) {//고객에 맞는 플랜 find
            String requiredPlan = clients[i];
            String[] splitRequiredPlan = requiredPlan.split(" ");
            int requiredDataAmount = Integer.parseInt(splitRequiredPlan[0]);
            int minPlanIndex = findIndexWithCeilBinarySearch(requiredDataAmount);//최소 데이터 충족 요금제 find

            for (int j = 1; j < splitRequiredPlan.length; j++) {//부가서비스 충족 요금제들 find
                int theFirstPlan = extraServiceAppearPlans[Integer.parseInt(splitRequiredPlan[j])];
                minPlanIndex = Math.max(minPlanIndex, theFirstPlan);
            }

            if (minPlanIndex == justDataInPlans.length) {
                answer[i] = 0;
            } else {
                answer[i] = minPlanIndex + 1;
            }
        }

        return answer;
    }

    int findIndexWithCeilBinarySearch(int clientData) {//인덱스 반환 이진트리 with ceil
        int start = 0, end = justDataInPlans.length - 1;
        int ceil = justDataInPlans.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (clientData == justDataInPlans[mid]) {
                return mid;
            } else if (clientData < justDataInPlans[mid]) {
                ceil = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ceil;
    }
}
