package com.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class 라인_2022_하반기_5 {
}

class Solution_라인_2022_하반기_5 {
    public long[] solution(int[][] fees, int t) {
        long[] answer = {};
        PriorityQueue<FeeInfor> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> candidates = new HashMap<>();
        HashSet<Integer> temp = new HashSet<>();

        for (int i = 0; i < fees.length; i++) {
            pq.add(new FeeInfor(fees[i][0], fees[i][1]));
        }

        //첫 번째 정보로 후보군 생성
        FeeInfor init = pq.poll();
        candidates.put(-1, init.fee);
        for (int i = 1; i < init.parkingTime; i++) {
            if (init.fee % ((init.parkingTime / i) + 1) == 0) {
                candidates.put(i, init.fee / (init.parkingTime / i + 1));
            }
        }

        //이후 정보들로 후보군 압축
        while (!pq.isEmpty()) {
            FeeInfor infor = pq.poll();

            for (Map.Entry<Integer, Integer> entry : candidates.entrySet()) {
                if (entry.getKey() == -1) {
                    if (entry.getValue() != infor.fee) {

                    }
                }


            }
        }

        return answer;
    }

    //요금 정보
    class FeeInfor implements Comparable<FeeInfor> {
        int parkingTime, fee;

        public FeeInfor(int parkingTime, int fee) {
            this.parkingTime = parkingTime;
            this.fee = fee;
        }

        @Override
        public int compareTo(FeeInfor o) {
            if (this.parkingTime < o.parkingTime) {
                return -1;
            } else if (this.parkingTime == o.parkingTime) {
                if (this.fee < o.parkingTime) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }
}
