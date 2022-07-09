package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P4195 {

    static int T, F, nodeNum;
    static int[] par = new int[200000]; //집합 부모 노드 배열
    static int[] groupSize = new int[200000]; //집합 사이즈(개수)
    static HashMap<String, Integer> map; //이름 인덱스화
    static StringBuilder answer = new StringBuilder(); //출력
    static String[] names = new String[2];
    static int[] nodes = new int[2];

    public static void main1(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());

        for(int i=0;i<T;i++){
            F = Integer.parseInt(bf.readLine());

            Arrays.fill(par, -1);
            Arrays.fill(groupSize, 0);

            nodeNum = 0;
            map = new HashMap<>();

            for(int j=0;j<F;j++){
                StringTokenizer st = new StringTokenizer(bf.readLine());

                names[0] = st.nextToken();
                names[1] = st.nextToken();

                for(int k=0;k<2;k++){//각 이름 입력
                    if(!map.containsKey(names[k])){//기존에 없던 이름이라면
                        map.put(names[k], nodeNum);//인덱스화
                        groupSize[nodeNum] = 1;
                        nodes[k]=nodeNum;//어짜피 최상단 노드는 자기 자신
                        ++nodeNum;
                    }
                    else{//기존에 있던 이름이면
                        nodes[k] = findPar(map.get(names[k]));//이름이 속한 집합 최상단 노드 찾기
                    }
                }

                merge(nodes[0], nodes[1]);//두 집합 merge

                answer.append(groupSize[nodes[1]] + "\n");//그룹사이즈 출력

            }
        }

        System.out.println(answer);
    }

    static int findPar(int node){//집합 최상단 노드 반환
        if(par[node]==-1)
            return node;

        return par[node] = findPar(par[node]);
    }

    static void merge(int node1, int node2) {//두 집합 합치기
        if(node1!=node2){
            par[node1]=node2;
            groupSize[node2] += groupSize[node1];
        }
    }
}
