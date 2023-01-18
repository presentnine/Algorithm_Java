package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon_1501 {

    static int N, M;
    static HashMap<String, Integer> map = new HashMap<>();
    static StringBuilder answer = new StringBuilder();

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {//사전에 있는 단어 입력
            String s = br.readLine();
            s = convert(s);

            if(map.containsKey(s))//이미 동일한 형태가 존재 -> 개수 + 1
                map.replace(s, map.get(s) + 1);
            else//아니면 새로 생성
                map.put(s, 1);
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {//각 문장에 대해
            int result = 1;
            String sentence = br.readLine();
            String[] words = sentence.split(" ");//문장 파싱

            for(int j=0;j< words.length;j++){
                String s = words[j];
                s = convert(s);

                if(map.containsKey(s))//해당 단어가 사전에 존재
                    result*=map.get(s).intValue();
                else{//없는 단어
                    result = 0;
                    break;
                }
            }

            answer.append(result);
            answer.append('\n');
        }

        System.out.println(answer.toString());
    }

    static String convert(String s){//단어 가공
        int[] alphabets = new int[52];//소문자 + 대문자 52개
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        if (s.length() > 1){//입력받은 단어의 길이가 1보다 크면 추가 작업
            sb.append(s.charAt(s.length() - 1));

            for(int i=1;i<s.length()-1;i++){//알파벳 카운트
                int alphabet = s.charAt(i) - 'a';

                if(alphabet<0)
                    ++alphabets[alphabet+58];
                else
                    ++alphabets[alphabet];
            }
        }

        for(int i=0;i<52;i++){//알파벳 종류+개수 붙이기
            if(alphabets[i]>0){
                if(i<26){
                    sb.append((char)('a' + i));
                    sb.append(alphabets[i]);
                }
                else{
                    sb.append((char) ('A' + i - 26));
                    sb.append(alphabets[i]);
                }
            }
        }

        return sb.toString();
    }
}
