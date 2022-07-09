package com.algorithm;


public class 광고_삽입 {
    public static void main(String[] args) {
        String play_time = "02:03:55", adv_time = "00:14:15";
        String[] logs =
                {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        Solution_광고_삽입 s = new Solution_광고_삽입();
        System.out.println(s.solution(play_time, adv_time, logs));
    }
}

class Solution_광고_삽입 {
    long[] viewsAcc; //조회 수 누적값

    public String solution(String play_time, String adv_time, String[] logs) {
        StringBuilder answer = new StringBuilder();
        int playTimeSec = convertToSec(play_time), advTimeSec = convertToSec(adv_time), answerSec;//시간 변환
        long maxViews;

        viewsAcc = new long[playTimeSec + 1]; //누적값 배열 초기화

        for (int i = 0; i < logs.length; i++) { //log 분해 후 위치 표시
            String[] split = logs[i].split("-");
            int startSec = convertToSec(split[0]);
            int endSec = convertToSec(split[1]);

            ++viewsAcc[startSec + 1];

            if (endSec + 1 < viewsAcc.length) {
                --viewsAcc[endSec + 1];
            }
        }

        int nowViewer = (int) viewsAcc[0]; //해당 시간의 시청자

        for (int i = 1; i < viewsAcc.length; i++) { //누적값 배열 채우기
            nowViewer += viewsAcc[i];
            viewsAcc[i] = viewsAcc[i - 1] + nowViewer;
        }

        maxViews = viewsAcc[advTimeSec];//0초에서 +광고 시간 만큼을 답으로 미리 초기화
        answerSec = 0;

        for (int time = 1; time <= playTimeSec - advTimeSec; time++) {//혀용 범위 내에서 해당 시간대의 총 조회수 계산
            long views = viewsAcc[time + advTimeSec] - viewsAcc[time];

            if (views > maxViews) {//조회수가 더 많다면 (답이라면)
                answerSec = time;
                maxViews = views;
            }
        }

        //답 반환용 절차 (시, 분, 초 계산 및 문자열 형태 맞추기)
        int answerHour = answerSec / 3600;
        int answerMinute = (answerSec % 3600) / 60;
        int answerSecond = answerSec - answerHour * 3600 - answerMinute * 60;

        if (answerHour < 10) {
            answer.append("0");
        }
        answer.append(answerHour + ":");

        if (answerMinute < 10) {
            answer.append("0");
        }
        answer.append(answerMinute + ":");

        if (answerSecond < 10) {
            answer.append("0");
        }
        answer.append(answerSecond);

        return answer.toString();
    }

    int convertToSec(String time) {//주어진 시간 문자열 -> 초로 변환
        int h, m, s;

        String[] split = time.split(":");

        h = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        s = Integer.parseInt(split[2]);

        return 3600 * h + 60 * m + s;
    }
}
