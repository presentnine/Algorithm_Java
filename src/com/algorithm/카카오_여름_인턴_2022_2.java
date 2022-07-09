package com.algorithm;

public class 카카오_여름_인턴_2022_2 {
    
}

class Solution_카카오_여름_인턴_2022_2 {
    public int solution(int[] queue1, int[] queue2) {
        int answer1 = -1, answer2 = -1;
        long totalSum = 0, q1TotalSum = 0, q2TotalSum = 0;
        int[] longQueue1 = new int[queue1.length * 2], longQueue2 = new int[queue1.length * 2];
        int q1Index1 = 0, q2Index1 = 0, q1Index2 = queue1.length, q2Index2 = queue1.length;

        for (int i = 0; i < queue1.length; i++) {
            totalSum += queue1[i] + queue2[i];
            q1TotalSum += queue1[i];
            q2TotalSum += queue2[i];
            longQueue1[i] = queue1[i];
            longQueue1[queue1.length + i] = queue2[i];
            longQueue2[i] = queue2[i];
            longQueue2[queue1.length + i] = queue1[i];
        }

        if (totalSum % 2 != 0) {
            return -1;
        }

        long half = totalSum / 2;

        while (q1Index2 != queue1.length * 2 || q2Index2 != queue1.length * 2) {
            if (q1Index2 != queue1.length * 2) {
                if (q1TotalSum < half) {
                    q1TotalSum += longQueue1[q1Index2++];
                } else if (q1TotalSum > half) {
                    q1TotalSum -= longQueue1[q1Index1++];
                } else {
                    answer1 = q1Index1 + q1Index2 - queue1.length;
                    break;
                }
            }

            if (q2Index2 != queue1.length * 2) {
                if (q2TotalSum < half) {
                    q2TotalSum += longQueue2[q2Index2++];
                } else if (q2TotalSum > half) {
                    q2TotalSum -= longQueue2[q2Index1++];
                } else {
                    answer2 = q2Index1 + q2Index2 - queue1.length;
                    break;
                }
            }
        }

        if (answer1 == -1 && answer2 == -1) {
            return -1;
        } else if (answer1 == -1) {
            return answer2;
        } else if (answer2 == -1) {
            return answer1;
        } else {
            return Math.min(answer1, answer2);
        }
    }
}