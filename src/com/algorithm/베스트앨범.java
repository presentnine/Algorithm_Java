package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 베스트앨범 {
    public static void main() {

    }
}

class Solution_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answerArrayList = new ArrayList<>(); //해답 생성용 ArrayList
        HashMap<String, Integer> genreTotalPlay = new HashMap<>(); //장르 속 노래들의 총 재생 횟수
        PriorityQueue<GenreInfor> genreTotalPlaySort = new PriorityQueue<>(); //장르 재생 우선순위 큐
        HashMap<String, Integer> genreToIndex = new HashMap<>(); //장르 -> 장르 번호 전환용 해시
        ArrayList<PriorityQueue<SongInfor>> songPlayInGenre = new ArrayList<>(); //장르 번호를 이용한 노래 정렬 우선순위 큐
        int genreIndex = 0;//장르 번호 생성용 int

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i]; //장르
            int play = plays[i]; //노래 재생 횟수
            SongInfor songInfor = new SongInfor(i, play); //노래 정보 생성

            if (genreTotalPlay.containsKey(genre)) {//기존 장르인 경우
                genreTotalPlay.replace(genre, genreTotalPlay.get(genre) + play); //장르 총 재생 횟수 추가
                songPlayInGenre.get(genreToIndex.get(genre)).add(songInfor); //장르 속 노래들의 우선 순위 큐에 추가
            } else {//새로운 장르인 경우
                genreTotalPlay.put(genre, play); //새롭게 총 재생 횟수 추가
                genreToIndex.put(genre, genreIndex++); //장르 번호 생성

                songPlayInGenre.add(new PriorityQueue<>()); // 장르 속 노래들의 우선 순위 큐 생성
                songPlayInGenre.get(songPlayInGenre.size() - 1).add(songInfor); //현 노래 정보 추가
            }
        }

        for (Map.Entry<String, Integer> element : genreTotalPlay.entrySet()) {//전체 장르 정보를 돌며 우선순위 큐에 추가
            GenreInfor genreInfor = new GenreInfor(element.getKey(), element.getValue());

            genreTotalPlaySort.add(genreInfor);
        }

        while (!genreTotalPlaySort.isEmpty()) { //장르 재생 횟수 최다 순서대로
            GenreInfor genreInfor = genreTotalPlaySort.poll();
            int genreNum = genreToIndex.get(genreInfor.genre); //장르 번호 get
            int index = 0; //해답 ArrayList에 옮길 노래 개수
            PriorityQueue<SongInfor> songPlay = songPlayInGenre.get(genreNum); //해당 장르 속 노래들의 우선순위 큐

            while (!songPlay.isEmpty() && index < 2) { //해답에 노래 추가
                SongInfor songInfor = songPlay.poll();
                answerArrayList.add(songInfor.songNum);
                ++index;
            }
        }

        int[] answer = new int[answerArrayList.size()]; //Integer ArrayList -> int answer 배열
        for (int i = 0; i < answerArrayList.size(); i++) {
            answer[i] = answerArrayList.get(i);
        }

        return answer;
    }

    class SongInfor implements Comparable<SongInfor>{ //노래 정보
        int songNum, play;

        public SongInfor(int songNum, int play) {
            this.songNum = songNum;
            this.play = play;
        }

        @Override
        public int compareTo(SongInfor o) {
            if (this.play > o.play) {
                return -1;
            } else if (this.play == o.play) {
                if (this.songNum < o.songNum) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

    class GenreInfor implements Comparable<GenreInfor> {//장르 정보
        String genre;
        int totalPlay;

        public GenreInfor(String genre, int totalPlay) {
            this.genre = genre;
            this.totalPlay = totalPlay;
        }

        @Override
        public int compareTo(GenreInfor o) {
            if (this.totalPlay > o.totalPlay) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}