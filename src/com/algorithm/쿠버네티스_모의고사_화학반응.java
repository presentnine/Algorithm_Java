package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 쿠버네티스_모의고사_화학반응 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> answers = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            double G = Double.parseDouble(st.nextToken());
            int[] mats = new int[N];
            int answer;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mats[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(mats);

            for (int j = N - 1; j >= 2; j--) {
                if (mats[j] % 50 == 0) {
                    continue;
                }
                int amount;

                if (j == N - 1) {
                    amount = 50 * (mats[j] / 50 + 1) - mats[j];
                } else {
                    amount = mats[j + 1] - mats[j];
                }

                if (amount == 0) {
                    continue;
                }

                for (int k = 0; k <= j; k++) {
                    mats[k] += amount;
                }

                G -= amount * (double) (j + 1) / 3.0;

                if (G <= 0) {
                    break;
                }
            }

            if (mats[N - 1] % 50 != 0) {
                answer = mats[N - 1] / 50 + 1;
            } else {
                answer = mats[N - 1] / 50;
            }

            int extra = 0;
            if (G > 0) {
                while ((double) N / 3.0 * ++extra * 50 < G) ;
            }

            answer += extra;
            answers.add(answer);
        }

        for (int i = 1; i <= T; i++) {
            System.out.println("Case #" + i);
            System.out.println(answers.get(i - 1));
        }
    }
}
