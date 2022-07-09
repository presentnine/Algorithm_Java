package com.algorithm;

import java.io.*;
import java.util.*;

public class 카카오_엔터프라이즈_여름_인턴_2022_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] penguins = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int minAnswer=0, maxAnswer=0;

        for(int i=0;i<3;i++){
            penguins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(penguins);

        if(!(penguins[0]+1==penguins[1]&&penguins[1]+1==penguins[2])){
            if(penguins[0]+2==penguins[1] || penguins[1]+2==penguins[2]){
                minAnswer=1;
            }else{
                minAnswer=2;
            }

            int longTerm = Math.max(penguins[1]-penguins[0], penguins[2]-penguins[1]);
            maxAnswer = longTerm-1;
        }

        System.out.println(minAnswer+"\n"+maxAnswer);

    }
}
