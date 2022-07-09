package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쿠버네티스_모의고사_실내온도 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), prevTemperature = -1;
        long totalTime = 0, totalCalResult = 0;
        String prevTime = "";
        double answer;

        for (int i = 0; i < N; i++) {
            String log = br.readLine();
            String[] result1 = log.split(" ");
            String[] result2 = result1[1].split("-");

            String time = result1[0];

            if (result2.length == 2) {
                long term = calSecond(time) - calSecond(prevTime);

                if (result2[0].equals("SET")) {//SET
                    totalTime += term;
                    totalCalResult += prevTemperature * term;

                    prevTemperature = Integer.parseInt(result2[1]);
                    prevTime = time;
                } else {//TURN OFF
                    totalTime += term;
                    totalCalResult += prevTemperature * term;
                }
            } else {//TURN ON 명령어
                prevTime = time;
                prevTemperature = Integer.parseInt(result2[2]);
            }
        }
        answer = Math.round((totalCalResult * 10) / (double) totalTime) / 10.0;
        System.out.println(answer);
    }

    public static long calSecond(String time) {
        String[] result = time.split(":");
        int h = Integer.parseInt(result[0]), m = Integer.parseInt(result[1]), s = Integer.parseInt(result[2]);

        return 3600 * h + 60 * m + s;
    }
}
