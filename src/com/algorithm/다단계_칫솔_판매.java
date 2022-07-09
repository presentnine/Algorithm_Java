package com.algorithm;

import java.util.HashMap;

//https://programmers.co.kr/learn/courses/30/lessons/77486
public class 다단계_칫솔_판매 {
}
class Solution_다단계_칫솔_판매 {
    int[] answer, parent;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int index = 1;
        answer = new int[enroll.length];
        parent = new int[enroll.length + 1];

        hashMap.put("-", 0);

        for (int i = 0; i < enroll.length; i++) {//이름 인덱스화, 부모 노드 저장
            hashMap.put(enroll[i], index++);
            parent[i + 1] = hashMap.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {//이익금 계산
            calculate(hashMap.get(seller[i]), amount[i] * 100);
        }
        
        return answer;
    }

    void calculate(int seller, int profit) {
        int person = seller, price = profit;

        while (person!=0) {//루트 노드가 아니라면
            int remain = price / 10;
            int quotient = price - remain;

            answer[person - 1] += quotient;//값 누적

            if (remain == 0) {//더 이상 나눌 금액이 없으면
                break;
            } else {
                person = parent[person];
                price = remain;
            }
        }
    }
}
