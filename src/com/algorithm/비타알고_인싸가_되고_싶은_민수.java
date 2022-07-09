package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비타알고_인싸가_되고_싶은_민수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if (b - a > 0) {//차이가 1이상이면 당연히 2
            answer = 2l;
        } else {//둘이 같으면 해당 숫자의 가장 작은 약수 계산
            long sqrt = (long) Math.sqrt(a);

            for (long i = 2; i <= sqrt; i++) {
                if (a % i == 0) {
                    answer = i;
                    break;
                }
            }

            if (answer == 0) {//소수라면 본인 숫자를 답으로
                answer = a;
            }
        }

        System.out.println(answer);
    }
}
