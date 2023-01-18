package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Baekjoon_12757 {

    static int N, M, K;
    static TreeMap<Integer, Integer> DB = new TreeMap<>();
    static StringBuilder answer = new StringBuilder();

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());

        N = Integer.parseInt(s.nextToken());
        M = Integer.parseInt(s.nextToken());
        K = Integer.parseInt(s.nextToken());

        DB.put(-2000000001, -1);//null 방지 최소값 삽입
        DB.put(2000000001, -1);//null 방지 최대값 삽입

        for (int i = 0; i < N; i++) {
            s = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(s.nextToken());
            int value = Integer.parseInt(s.nextToken());

            DB.put(key, value);
        }

        for (int i = 0; i < M; i++) {
            s = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(s.nextToken());
            int key = Integer.parseInt(s.nextToken());
            int value;

            if (query == 1) {//명령 1
                value = Integer.parseInt(s.nextToken());
                DB.put(key, value);
            } else if (query == 2) {//명령 2
                value = Integer.parseInt(s.nextToken());
                int nextKey = find(key);

                if (nextKey >= 0) {
                    DB.replace(nextKey, value);
                }

            } else {//명령 3
                int nextKey = find(key);

                if (nextKey == -1) {
                    answer.append("-1\n");
                } else if (nextKey == -2) {
                    answer.append("?\n");
                } else {
                    answer.append(DB.get(nextKey) + "\n");
                }
            }
        }

        System.out.println(answer.toString());
    }

    static public int find(int key) {//없으면 -1, 2개 이상이면 -2 반환
        Integer upKey, downKey;

        if(DB.containsKey(key)){//입력 받은 key에서 바로 존재
            return key;
        }
        else {
            upKey = DB.higherKey(key);//가장 가까운 큰 키
            downKey = DB.lowerKey(key);//가장 가까운 작은 키

            if (upKey - key > K && key - downKey > K) {//둘 다 K 밖
                return -1;
            }else {
                if (upKey - key <= K && key - downKey <= K) {//둘 다 K 안
                    if (upKey - key == key - downKey) {//둘 다 동일한 차이
                        return -2;
                    } else if (upKey - key < key - downKey) {//upKey 쪽이 더 작음
                        return upKey;
                    }else {//downKey 쪽이 더 작음
                        return downKey;
                    }
                }else if(upKey - key > K){//upKey만 범위 밖
                    return downKey;
                }else {//downKey만 범위 밖
                    return upKey;
                }
            }
        }
    }
}
