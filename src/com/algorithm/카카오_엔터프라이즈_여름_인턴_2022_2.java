package com.algorithm;

import java.io.*;
import java.util.*;

public class 카카오_엔터프라이즈_여름_인턴_2022_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rowH=0, colH=0, rowR=0, colR=0, rowM=0, colM=0, answer;

        for(int i=0;i<10;i++){
            String s = br.readLine();

            for(int j=0;j<10;j++){
                char c = s.charAt(j);

                if(c=='H'){
                    rowH = i;
                    colH = j;
                }else if(c=='R'){
                    rowR = i;
                    colR = j;
                }else if(c=='M'){
                    rowM=i;
                    colM=j;
                }
            }
        }

        if(colH==colR&&colR==colM){
            if((rowH<rowR && rowR<rowM)||(rowM<rowR && rowR<rowH)){
                answer = Math.abs(rowM-rowH)+1;
            }else{
                answer = Math.abs(rowM-rowH)-1;
            }
        }else if(rowH==rowR&&rowR==rowM){
            if((colH<colR && colR<colM)||(colM<colR && colR<colH)){
                answer = Math.abs(colM-colH)+1;
            }else{
                answer = Math.abs(colM-colH)-1;
            }
        }else{
            answer = Math.abs(colM-colH)+Math.abs(rowM-rowH)-1;
        }

        System.out.println(answer);
    }
}
