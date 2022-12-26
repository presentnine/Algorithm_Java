package com.algorithm;

import java.util.regex.Pattern;

public class 라인_2022_하반기_2 {
}

class Solution_라인_2022_하반기_2 {
    public String solution(int k, String[] dic, String chat) {
        StringBuilder answer = new StringBuilder();

        String[] tokens = chat.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            if (isSlang(k, dic, tokens[i])) {//비속어 O
                for (int j = 0; j < tokens[i].length(); j++) {
                    answer.append('#');
                }
            } else {//비속어 X
                answer.append(tokens[i]);
            }

            if (i != tokens.length - 1) {//공백 추가
                answer.append(" ");
            }
        }

        return answer.toString();
    }

    boolean isSlang(int k, String[] dic, String word) {//비속어 판별
        String pattern = createPattern(k, word);

        for (int i = 0; i < dic.length; i++) {
            if (Pattern.matches(pattern, dic[i])) {
                return true;
            }
        }

        return false;
    }

    String createPattern(int k, String word) {//패턴 생성
        StringBuilder sb = new StringBuilder();
        sb.append('^');

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sb.append(c);

            if (c == '.') {
                sb.append("{1,");
                sb.append(k);
                sb.append("}");
            }
        }
        sb.append('$');

        return sb.toString();
    }
}