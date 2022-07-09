package com.algorithm;

import java.util.*;
import java.io.*;

public class 라인2 {
    public static void main(String[] args) {
        String[] sentences = {"line in line", "LINE", "in lion"};
        Solution_라인2 s = new Solution_라인2();
        s.solution(sentences, 5);
    }
}

class Solution_라인2 {
    HashSet<Character> hs[];
    int[] scores;
    int answer = 0, stLength;

    public int solution(String[] sentences, int n) {
        hs = new HashSet[sentences.length];
        scores = new int[sentences.length];
        stLength = sentences.length;

        for(int i=0;i<sentences.length;i++){
            hs[i] = new HashSet<>();
            int score = 0;

            for(int j=0;j<sentences[i].length();j++){
                if('A' <= sentences[i].charAt(j)&&sentences[i].charAt(j) <= 'Z' ){
                    hs[i].add('-');
                    hs[i].add((char)(sentences[i].charAt(j)+32));
                    score+=2;
                }else if(sentences[i].charAt(j)== ' ') {
                    ++score;
                }else{
                    hs[i].add(sentences[i].charAt(j));
                    ++score;
                }
            }

            scores[i] = score;
        }

        for(int i=0;i<stLength;i++){
            dfs(i, n, hs[i], scores[i]);
        }

        return answer;
    }

    void dfs(int index, int n, HashSet<Character> keys, int endScore){
        if(keys.size() > n){
            return;
        }

        if(index==stLength){
            answer = Math.max(answer, endScore);
            return;
        }

        for(int i=index+1;i<stLength;i++){
            HashSet<Character> newKeys = (HashSet)keys.clone();

            for(Character c:hs[i]){
                newKeys.add(c);
            }

            dfs(i, n, newKeys, endScore+scores[i]);
        }

        dfs(stLength, n, keys, endScore);
    }
}