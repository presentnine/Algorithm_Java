package com.algorithm;

public class 라인4 {
    public static void main(String[] args) {
        int[] arr = {6, 2, 2, 6};
        int[] brr = {4, 4, 4, 4};

        Solution_라인4 s = new Solution_라인4();
        s.solution(arr, brr);

    }
}

class Solution_라인4 {
    int answer = 0, length;
    int[] arrIndexes, brrIndexes;
    public int solution(int[] arr, int[] brr) {
        length = arr.length;
        arrIndexes = new int[length];
        brrIndexes = new int[length];
        arrIndexes[0] = arr[0];
        brrIndexes[0] = brr[0];

        for(int i=1;i<length;i++){
            arrIndexes[i] = arrIndexes[i-1]+arr[i];
            brrIndexes[i] = brrIndexes[i-1]+brr[i];
        }

        for(int i=0;i<length;i++){
            System.out.print(arrIndexes[i]+" ");
        }

        System.out.println();

        for(int i=0;i<length;i++){
            System.out.print(brrIndexes[i]+" ");
        }

        control(0);

        System.out.println();

        for(int i=0;i<length;i++){
            System.out.print(arrIndexes[i]+" ");
        }

        System.out.println();

        for(int i=0;i<length;i++){
            System.out.print(brrIndexes[i]+" ");
        }

        return answer;
    }

    void control(int pos){
        if(pos>=length-1){
            return;
        }

        if(brrIndexes[pos]>=arrIndexes[pos+1]){
            control(pos+1);
        }

        if(arrIndexes[pos] != brrIndexes[pos]){
            arrIndexes[pos] = brrIndexes[pos];
            ++answer;
            control(pos+1);
        }else {
            control(pos+1);
        }
    }
}
