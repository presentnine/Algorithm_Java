package com.algorithm;

import java.util.*;

public class 토스_NEXT_2022_6 {
}

class Solution_토스_NEXT_2022_6 {
    public String[] solution(int[] steps_one, String[] names_one, int[] steps_two, String[] names_two, int[] steps_three, String[] names_three) {
        List<String> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        HashMap<String, Long> firstDay = countWalkOfOneDay(steps_one, names_one);
        HashMap<String, Long> secondDay = countWalkOfOneDay(steps_two, names_two);
        HashMap<String, Long> thirdDay = countWalkOfOneDay(steps_three, names_three);
        HashMap<String, Long> total = new HashMap<>();
        PriorityQueue<Infor> pq = new PriorityQueue<>();

        for (Map.Entry<String, Long> entry : firstDay.entrySet()) {
            String name = entry.getKey();
            long walk = entry.getValue();

            if (total.containsKey(name)) {
                total.replace(name, total.get(name) + walk);
            } else {
                total.put(name, walk);
            }
        }

        for (Map.Entry<String, Long> entry : secondDay.entrySet()) {
            String name = entry.getKey();
            long walk = entry.getValue();

            if (total.containsKey(name)) {
                total.replace(name, total.get(name) + walk);
            } else {
                total.put(name, walk);
            }
        }

        for (Map.Entry<String, Long> entry : thirdDay.entrySet()) {
            String name = entry.getKey();
            long walk = entry.getValue();

            if (total.containsKey(name)) {
                total.replace(name, total.get(name) + walk);
            } else {
                total.put(name, walk);
            }
        }

        for (Map.Entry<String, Long> entry : total.entrySet()) {
            String name = entry.getKey();
            long walk = entry.getValue();

            pq.add(new Infor(name, walk));
        }

        while (!pq.isEmpty()) {
            String name = pq.poll().name;
            answer.add(name);
        }

        return answer.stream().toArray(String[]::new);
    }

    HashMap<String, Long> countWalkOfOneDay(int[] steps, String[] names) {
        HashMap<String, Long> hashMap = new HashMap<>();

        for (int i = 0; i < steps.length; i++) {
            if (hashMap.containsKey(names[i])) {
                hashMap.replace(names[i], Math.max(hashMap.get(names[i]), steps[i]));
            } else {
                hashMap.put(names[i], (long) steps[i]);
            }
        }

        return hashMap;
    }

    class Infor implements Comparable<Infor> {
        String name;
        long walk;

        public Infor(String name, long walk) {
            this.name = name;
            this.walk = walk;
        }

        @Override
        public int compareTo(Infor o) {
            if (this.walk > o.walk) {
                return -1;
            } else if (this.walk == o.walk) {
                o.name.compareTo(this.name);
            }
            return 1;
        }
    }
}