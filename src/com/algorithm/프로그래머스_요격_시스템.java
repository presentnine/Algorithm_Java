package com.algorithm;

//https://school.programmers.co.kr/learn/courses/30/lessons/181188

import java.util.Arrays;
import java.util.PriorityQueue;

public class 프로그래머스_요격_시스템 {

}

class Solution_프로그래머스_요격_시스템 {
    public int solution(int[][] targets) {
        int answer = 1, s, e;

        //풀이 1 => 단순 이차원 배열 정렬
         Arrays.sort(targets, (o1, o2) -> {//이차원 배열 정렬
             if(o1[0]==o2[0]){
                 return o1[1] - o2[1];
             }
             return o1[0] - o2[0];
         });

         //시작 요소를 s와 e로 초기화 
         s = targets[0][0];
         e = targets[0][1];

         for(int i=1;i<targets.length;i++){//이후 배열을 돌며
             if(targets[i][0]<e){//현재 s~e 범위내라면
                 s = Math.max(s, targets[i][0]);
                 e = Math.min(e, targets[i][1]);
             }else{//현재 범위 밖이라면
                 ++answer;
                 s = targets[i][0];
                 e = targets[i][1];
             }
         }

//        return answer;

         //풀이 2 => 우선순위 큐 활용
         PriorityQueue<Infor> pq = new PriorityQueue<>();
         for(int i=0;i<targets.length;i++){
             pq.add(new Infor(targets[i][0], targets[i][1]));
         }

         Infor start = pq.poll();
         s = start.s;
         e = start.e;

         while(!pq.isEmpty()){
             Infor now = pq.poll();
             if(now.s < e){
                 s = Math.max(s, now.s);
                 e = Math.min(e, now.e);
             }else{
                 ++answer;
                 s = now.s;
                 e = now.e;
             }
         }
         return answer;
    }

    class Infor implements Comparable<Infor>{
        int s, e;

        public Infor(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Infor o){//시작과 끝이 더 빠른 순으로
            if(this.s == o.s){
                return this.e - o.e;
            }
            return this.s - o.s;
        }
    }
}