package com.algorithm;

public class 카카오모빌리티_2022_3 {
}

class Solution_카카오모빌리티_2022_3 {
    int nowYear, nowMonth, nowDay, nowHour, nowMinute, nowSecond, prevDay;
    int[] answer = new int[2];

    public int[] solution(String s, String[] times) {
        String[] split = s.split(":");
        nowYear = Integer.parseInt(split[0]);
        nowMonth = Integer.parseInt(split[1]);
        nowDay = Integer.parseInt(split[2]);
        nowHour = Integer.parseInt(split[3]);
        nowMinute = Integer.parseInt(split[4]);
        nowSecond = Integer.parseInt(split[5]);

        //첫 저축 기준, 1일 1저축 성공 상태 및 저축일 1일
        answer[0] = 1;
        answer[1] = 1;

        for (int i = 0; i < times.length; i++) {//다음 저축 시간 계산
            addTimeAndCheck(times[i]);
        }
        
        return answer;
    }

    void addTimeAndCheck(String time) {//시간 계산 및 확인
        int DD, HH, mm, SS;
        prevDay = nowDay;

        String[] split = time.split(":");
        DD = Integer.parseInt(split[0]);
        HH = Integer.parseInt(split[1]);
        mm = Integer.parseInt(split[2]);
        SS = Integer.parseInt(split[3]);

        //초계산
        nowSecond += SS;
        if (nowSecond >= 60) {
            ++nowMinute;
            nowSecond -= 60;
        }

        //분계산
        nowMinute += mm;
        if (nowMinute >= 60) {
            ++nowHour;
            nowMinute -= 60;
        }

        //시계산
        nowHour += HH;
        if (nowHour >= 24) {
            ++nowDay;
            nowHour -= 24;
        }

        //저축 관련 계산 및 일계산
        nowDay += DD;
        answer[1] += nowDay - prevDay;//추가분 일자 누적 계산
        if (nowDay > prevDay + 1) {//1일 차이를 넘는다면 1일 1저축 실패
            answer[0] = 0;
        }

        if (nowDay > 30) {
            nowMonth += (nowDay - 1) / 30;
            nowDay -= ((nowDay - 1) / 30) * 30;
        }

        //월계산
        if (nowMonth > 12) {
            ++nowYear;
            nowMonth -= 12;
        }
    }
}