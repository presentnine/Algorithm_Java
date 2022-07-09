package com.algorithm;

import java.util.Arrays;

public class 셔틀버스 {
    public static void main(String[] args) {
        int n = 2, t = 1, m = 2;
        String timetable[] = new String[]{"09:00", "09:00", "09:00", "09:00"};

//        System.out.println(new Solution().solution(n, t, m, timetable));
    }

    class Solution {
        public String solution(int n, int t, int m, String[] timetable) {
            String answer = "";
            Arrays.sort(timetable);
            int timetableIndex = 0;
            String busTime = calTime("09:00", -t);

            for (int i = 0; i < n; i++) {
                busTime = calTime(busTime, t);
                int passenger = 0;

                while (passenger < m //현재 총 탑승객이 수용 인원보다 적거나
                        && timetableIndex < timetable.length //timetable내에서
                        && timetable[timetableIndex].compareTo(busTime) <= 0) { //버스 타임보다 일찍이거나
                    ++passenger;
                    ++timetableIndex;
                }

                if (i == n - 1) { //마지막 버스라면
                    if (passenger < m) {//버스에 모두 타고도 남는 상황
                        answer = busTime;
                    } else {//버스에 다 못타는 상황에는 마지막 사람보다 1분 빠르게 도착
                        answer = calTime(timetable[timetableIndex - 1], -1);
                    }
                }
            }

            return answer;
        }

        private String calTime(String time, int changeMinute) {
            String[] split = time.split(":");
            int hour = Integer.parseInt(split[0]), minute = Integer.parseInt(split[1]);
            String resultHour, resultMinute;

            minute += changeMinute;

            if (minute >= 60) {
                hour += 1;
                minute -= 60;
            } else if (minute < 0) {
                hour -= 1;
                minute += 60;
            }

            if (hour < 10) {
                resultHour = "0" + hour;
            } else {
                resultHour = hour + "";
            }

            if (minute < 10) {
                resultMinute = "0" + minute;
            } else {
                resultMinute = minute + "";
            }

            return resultHour + ":" + resultMinute;
        }
    }
}

