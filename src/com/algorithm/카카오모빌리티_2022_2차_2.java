package com.algorithm;

import java.util.TreeSet;

public class 카카오모빌리티_2022_2차_2 {
    public static void main(String[] args) {

        /** 입력값 가정 **/
        int n = 3;
        int[] arr = {8, 2, 3, 14, 5, 19};
        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[] arr) {
        //최솟값 정답
        int answer = Integer.MAX_VALUE;

        //배열 길이
        int length = arr.length;

        //n , 조건보다 작으면 답 없음.
        if (length < n) return -1; // 답 없음

        //트리셋
        TreeSet<Integer> set = new TreeSet<>();

        // 인덱스 차이 n이상
        for (int i = n; i < length; i++) {

            // i -n 주의 차이만큼
            set.add(arr[i - n]);

            //비교할 대상
            int now = arr[i];
            //ceiling 함수에서 null이 나올수 있기때문에 wrapper클래스로 싼거임
            // ceiling : 제공된 값보다 크거나 같은 값 중 가장 작은 값 (인자값 포함)
            Integer ceiling = set.ceiling(now);


            // 8, 2, 3, 14, 5, 19
            // 대상이 9  라면  floor 8 ceiling 14

            //null이면 안되니까
            if (ceiling != null) {
                //차이 절대값
                answer = Math.min(answer, Math.abs(now - ceiling));
            }

            //floor 함수에서 null이 나올수 있기때문에 wrapper클래스로 싼거임
            // floor : 제공된 값과 같거나 작은 값 중 가장 큰 값 (인자값 포함)
            Integer floor = set.floor(now);

            //null이면 안되니까
            if (floor != null) {
                //차이 절대값
                answer = Math.min(answer, Math.abs(now - floor));
            }
        }

        return answer;
    }

}

class Solution_카카오모빌리티_2022_2차_2 {
    public int solution(int n, int[][] edges, int[] users, int d, int limit) {
        int answer = 0;
        return answer;
    }
}