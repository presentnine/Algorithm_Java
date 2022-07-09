package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N, answer=0;
    static ArrayList<Long> numbers = new ArrayList<>();
    static HashMap<Long, Integer> map = new HashMap<>();

    public static void main1(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st =  new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            Long number = Long.parseLong(st.nextToken()); //수 입력받음

            if(map.containsKey(number))//이미 중복된 수인 경우
                map.replace(number, map.get(number)+1);
            else{//새로운 수인 경우
                map.put(number, 1);
                numbers.add(number);
            }
        }

        for(int i=0;i<numbers.size();i++){
            Long num1 = numbers.get(i);
            
            if(num1==0){//한쪽이 0인 경우
                if(map.get(num1)>2){//0+0 에 대해
                    answer+=map.get(num1);
                    map.replace(num1, 0);
                }

                for(int j=i+1;j<numbers.size();j++){
                    Long num2 = numbers.get(j);

                    if(map.get(num2)>1){
                        answer+=map.get(num2);
                        map.replace(num2, 0);
                    }
                }
            }
            else{//한쪽이 0이 아닌 경우
                if(map.get(num1)>=2&&map.containsKey(num1*2)){//자신이 여러개 인경우
                    answer+=map.get(num1*2);
                    map.replace(num1*2,0);
                }

                for(int j=i+1;j<numbers.size();j++){//다른 수를 반복문을 통해 찾는다
                    Long num2 = numbers.get(j);

                    if(num2==0){//그 수가 0이라면(ArrayList 상으로 정렬 X기 때문)
                        if(map.get(num1)>1){
                            answer+=map.get(num1);
                            map.replace(num1, 0);
                        }
                    }
                    else{//양쪽다 0이 아닌 경우
                        if(map.containsKey(num1+num2)){
                            answer+=map.get(num1+num2);
                            map.replace(num1+num2, 0);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
