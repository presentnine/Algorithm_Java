package com.algorithm;

public class 단어_변환 {
    public static void main(String[] args) {
        
    }
}

class Solution_단어_변환 {
    boolean[] visited;//dfs 탐색 여부 배열
    int answer = 99;

    public int solution(String begin, String target, String[] words) {
        if (!checkTarget(target, words)) //words에 target이 없으면 0 반환
            return 0;

        visited = new boolean[words.length]; //dfs 탐색 여부 배열 초기화

        dfs(begin, target, 0, words); //begin 단어를 시작으로 dfs 탐색

        if (answer == 99) //답이 없으면 0 반환
            return 0;

        return answer;
    }

    private boolean checkTarget(String target, String[] words) {//target과 동일한 단어 존재 여부 확인
        for (String word : words)
            if (word.equals(target))
                return true;

        return false;
    }

    private void dfs(String word, String target, int count, String[] words) {
        if (word.equals(target)){
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                if (countDiff(word, words[i]) == 1) {
                    visited[i] = true;
                    dfs(words[i], target, count + 1, words);
                    visited[i] = false;
                }
            }
        }
    }

    private int countDiff(String a, String b) {//두 단어간 알파벳 차이 반환
        int diff = 0;

        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i))
                ++diff;

        return diff;
    }
}