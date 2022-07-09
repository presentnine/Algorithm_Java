package com.algorithm;

import java.util.Collections;
import java.util.PriorityQueue;

public class 라인5 {
    public static void main(String[] args) {
        int[] abilities = {7, 6, 8, 9, 10};
        Solution_라인5 s = new Solution_라인5();
        System.out.println(s.solution(abilities, 1));
    }

}

class Solution_라인5 {
    public long solution(int[] abilities, int k) {
        long answer = 0;
        int round = abilities.length / 2;
        PriorityQueue<Pair> pairPQ = new PriorityQueue<>();
        PriorityQueue<Integer> abilityPQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<abilities.length; i++) {
            abilityPQ.add(abilities[i]);
        }

        for(int i=0;i<round;i++){
            int num1 = abilityPQ.poll(), num2 = abilityPQ.poll();
            pairPQ.add(new Pair(num2, num1-num2));
        }

        if(!abilityPQ.isEmpty()){
            pairPQ.add(new Pair(0, abilityPQ.poll()));
            ++round;
        }

        for (int i = 0; i < k; i++) {
            Pair pair = pairPQ.poll();
            answer+=pair.base+pair.diff;
        }

        while(!pairPQ.isEmpty()){
            answer += pairPQ.poll().base;
        }

        return answer;
    }

    class Pair implements Comparable<Pair>{
        int base, diff;

        public Pair(int base, int diff) {
            this.base = base;
            this.diff = diff;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.diff>o.diff){
                return -1;
            }else if(this.diff==o.diff){
                return 0;
            }else{
                return 1;
            }
        }
    }
}