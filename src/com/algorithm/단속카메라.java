package com.algorithm;

import java.util.PriorityQueue;

public class 단속카메라 {

}

class Solution_단속카메라 {
    PriorityQueue<CarMoveInfor> pq = new PriorityQueue<>();

    public int solution(int[][] routes) {
        int answer = 0;

        for (int i = 0; i < routes.length; i++) { //우선순위큐에 차량 정보 삽입
            pq.add(new CarMoveInfor(routes[i][0], routes[i][1]));
        }

        while (!pq.isEmpty()) {//한 번의 탐색 당 답+1
            checkSection();
            ++answer;
        }

        return answer;
    }

    void checkSection() { //한 번의 탐색
        CarMoveInfor firstCar = pq.poll();
        int sectionStart = firstCar.start, sectionEnd = firstCar.end; //가장 첫 차량의 구간

        while (!pq.isEmpty()) { //다음 차량이 구간에 포함이 되는 가능한지 확인
            CarMoveInfor car = pq.peek();
            int carStart = car.start, carEnd = car.end;

            //구간에 속한다면 앞선 차량들이 모두 포함되도록 구간을 좁힌다.
            if (sectionStart <= carStart && carStart <= sectionEnd || sectionStart <= carEnd && carEnd <= sectionEnd) {
                if (sectionStart <= carStart) {
                    sectionStart = carStart;
                }

                if (carEnd <= sectionEnd) {
                    sectionEnd = carEnd;
                }

                pq.poll();
            } else {
                return;
            }
        }
    }


    class CarMoveInfor implements Comparable<CarMoveInfor>{ //자동차의 진입, 진출 정보
        int start, end;

        public CarMoveInfor(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(CarMoveInfor o) {//정렬 (진입, 진출이 더 빠를수록 우선순위가 높게)
            if (this.start < o.start) {
                return -1;
            } else if (this.start == o.start) {
                if (this.end < o.end) {
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