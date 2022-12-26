package com.algorithm;

import java.util.ArrayList;

public class 네이버파이낸셜_2022_하반기_인턴_1 {
    ArrayList<Integer>[] result;

    public static void main(String[] args) {
    }
}

class Solution_네이버파이낸셜_2022_하반기_인턴_1{
    int a, c = Integer.MAX_VALUE;
    ArrayList<Integer>[] result;

    void sol(){
        result = new ArrayList[4];

        for (int i = 0; i < 4; i++) {
            result[i] = new ArrayList<>();
        }


    }

    public Solution_네이버파이낸셜_2022_하반기_인턴_1(int a, int c) {
        this.a = a;
        this.c = c;
    }
}