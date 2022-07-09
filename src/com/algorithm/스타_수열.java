package com.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/70130
public class 스타_수열 {
}

class Solution_스타_수열 {
    public int solution(int[] a) {
        int answer = 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<Infor> pq = new PriorityQueue<>();

        if (a.length < 2) {
            return 0;
        } else if (a.length == 2) {
            return 2;
        }

        for (int i = 0; i < a.length; i++) {//숫자들의 개수 카운트
            if (hashMap.containsKey(a[i])) {
                hashMap.replace(a[i], hashMap.get(a[i]) + 1);
            } else {
                hashMap.put(a[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> elem : hashMap.entrySet()) {//우선순위 큐를 통해 내림차순
            pq.add(new Infor(elem.getKey(), elem.getValue()));
        }

        while (!pq.isEmpty()) {//개수가 많은 숫자 순서대로
            int result = 0, lastIndex = -1;
            Infor infor = pq.poll();

            if (answer >= infor.count * 2) {//최대 길이가 답을 못 넘는 경우
                break;
            }

            for (int i = 0; i < a.length; i++) {
                if (a[i] == infor.num) {//해당 숫자인 상태
                    if (i == 0) {//수열의 처음인 경우
                        if (a[i] != a[i + 1]) {
                            lastIndex = 1;
                            result += 2;
                        }
                    } else if (i == a.length - 1) {//수열의 마지막인 경우
                        if (lastIndex < i - 1 && a[i] != a[i - 1]) {//앞이 부분 수열에 포함 x
                            lastIndex = i;
                            result += 2;
                        }
                    } else {//수열의 중간인 경우
                        if (lastIndex < i - 1) {
                            if (a[i] != a[i - 1]) {//i 이전 인덱스 숫자를 부분 수열에 포함할 수 있는 경우
                                lastIndex = i;
                                result += 2;
                            } else if (a[i] != a[i + 1]) {//i 다음 인덱스 숫자를 부분 수열에 포함할 수 있는 경우
                                lastIndex = i + 1;
                                result += 2;
                            }
                        } else if (lastIndex == i - 1 && a[i] != a[i + 1]) {//i 다음 인덱스 숫자를 부분 수열에 포함할 수 있는 경우
                            lastIndex = i + 1;
                            result += 2;
                        }
                    }
                }
            }

            answer = Math.max(answer, result); //최대값을 답으로 최신화
        }

        return answer;
    }

    class Infor implements Comparable<Infor>{//우선순위 큐 삽입용 클래스
        int num, count;

        public Infor(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Infor o) {
            if (this.count > o.count) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}