package com.algorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class 추석트래픽 {
    public static void main(String[] args) throws Exception{
        String lines[] = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};

        System.out.println(Solution.solution(lines));
    }

    static class Solution {
        public static int solution(String[] lines) throws Exception {
            int answer = 0;
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");//문자열 처리용 포맷

            Date ends[] = new Date[lines.length];//응답 완료 시간
            Date starts[] = new Date[lines.length];//응답 시작 시간

            for (int i = 0; i < lines.length; i++) {
                String word[] = lines[i].split(" ");//일자, 시간, 처리시간
                //처리시간 계산
                String processingTime = word[2].substring(0, word[2].length() - 1);
                long milliSec = (long) (Float.parseFloat(processingTime) * 1000);
                //응답 완료, 시작 시간 계산
                Date endTime = format.parse(word[1]);
                Date startTime = new Date(endTime.getTime() - milliSec + 1);

                ends[i] = endTime;
                starts[i] = startTime;
            }

            for (int i = 0; i < ends.length; i++) {//각 처리 시간에 대해 시작, 완료 시간에서 계산
                int throughput1 = 0, throughput2 = 0;
                for (int j = 0; j < ends.length; j++) {
                    if ((starts[j].getTime() - ends[i].getTime() < 1000 && starts[j].getTime() - ends[i].getTime() >= 0)
                            || (ends[j].getTime() - ends[i].getTime() < 1000 && ends[j].getTime() - ends[i].getTime() >= 0)
                            || (starts[j].getTime() <= ends[i].getTime() && ends[j].getTime() >= ends[i].getTime()))
                        throughput1++;

                    if ((starts[j].getTime() - starts[i].getTime() < 1000 && starts[j].getTime() - starts[i].getTime() >= 0)
                            || (ends[j].getTime() - starts[i].getTime() < 1000 && ends[j].getTime() - starts[i].getTime() >= 0)
                            || (starts[j].getTime() <= starts[i].getTime() && ends[j].getTime() >= starts[i].getTime()))
                        throughput2++;
                }
                answer = Math.max(answer, throughput1);
                answer = Math.max(answer, throughput2);
            }

            return answer;
        }
    }
}
