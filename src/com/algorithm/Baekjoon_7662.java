package com.algorithm;

//https://www.acmicpc.net/problem/7662

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Baekjoon_7662 {
    static PriorityQueue<Integer> ascPq, descPq;
    static HashMap<Integer, Integer> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {//테스트케이스마다
            int k = Integer.parseInt(br.readLine());
            ascPq = new PriorityQueue<>();
            descPq = new PriorityQueue<>(Collections.reverseOrder());
            hashMap = new HashMap<>();

            for (int j = 0; j < k; j++) {//각 명령에 대해
                String[] command = br.readLine().split(" ");

                if (command[0].equals("I")) {//값 삽입
                    insert(Integer.parseInt(command[1]));
                } else {//"D" -> 값 삭제
                    if (command[1].equals("-1")) {//최대값 삭제
                        deleteMin();
                    } else {//"-1" -> 최소값 삭제
                        deleteMax();
                    }
                }
            }

            if (ascPq.isEmpty()) {//비어있는 큐
                System.out.println("EMPTY");
            } else {
                System.out.println(descPq.poll() + " " + ascPq.poll());
            }
        }
    }

    static void insert(int num){//값 삽입
        if (hashMap.containsKey(num)) {//기존에 있는 값
            hashMap.replace(num, hashMap.get(num) + 1);
        } else {//새로운 값
            hashMap.put(num, 1);
            ascPq.add(num);
            descPq.add(num);
        }
    }

    static void deleteMax() {//최대값 삭제
        if (!descPq.isEmpty()) {//삭제할 값이 존재한다면
            int deleteNum = descPq.peek();

            if (hashMap.get(deleteNum) == 1) {//해당 값이 하나만 있는 경우
                hashMap.remove(deleteNum);
                descPq.poll();
                ascPq.remove(deleteNum);
            } else {//해당 값이 여러 개 있다면
                hashMap.replace(deleteNum, hashMap.get(deleteNum) - 1);
            }
        }
    }

    static void deleteMin() {//최소값 삭제
        if (!ascPq.isEmpty()) {//삭제할 값이 존재한다면
            int deleteNum = ascPq.peek();

            if (hashMap.get(deleteNum) == 1) {//해당 값이 하나만 있는 경우
                hashMap.remove(deleteNum);
                ascPq.poll();
                descPq.remove(deleteNum);
            } else {//해당 값이 여러 개 있다면
                hashMap.replace(deleteNum, hashMap.get(deleteNum) - 1);
            }
        }
    }
}