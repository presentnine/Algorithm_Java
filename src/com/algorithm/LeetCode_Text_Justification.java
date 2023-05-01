package com.algorithm;

//https://leetcode.com/problems/text-justification/

import java.util.LinkedList;
import java.util.List;

public class LeetCode_Text_Justification {
}

class Solution_LeetCode_Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new LinkedList<>(), candidates = new LinkedList<>();
        int totalWordLength = words[0].length();
        candidates.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (totalWordLength + candidates.size() + words[i].length() <= maxWidth) {//단어 추가 가능
                candidates.add(words[i]);
                totalWordLength += words[i].length();
            } else {//더 이상의 단어 추가가 불가능한 경우 
                answer.add(formatting(candidates, totalWordLength, maxWidth));//이전까지의 목록을 바탕으로 문자열 생성

                //새로 초기화
                candidates = new LinkedList<>();
                candidates.add(words[i]);
                totalWordLength = words[i].length();
            }
        }

        //마지막 줄 포맷팅
        StringBuilder formatResult = new StringBuilder(candidates.get(0));

        for (int i = 1; i < candidates.size(); i++) {
            formatResult.append(" ").append(candidates.get(i));
        }

        formatResult.append(" ".repeat(maxWidth - totalWordLength - candidates.size() + 1));
        answer.add(formatResult.toString());

        return answer;
    }

    String formatting(List<String> candidates, int totalWordLength, int maxWidth) {
        StringBuilder formatResult = new StringBuilder(candidates.get(0));

        if (candidates.size() == 1) {//포함 단어가 1개라면
            formatResult.append(" ".repeat(maxWidth - totalWordLength));
        } else {
            int commonSpaceLength = (maxWidth - totalWordLength) / (candidates.size() - 1);//공통적으로 가져야 하는 공백 크기
            int additionalSpace = maxWidth - totalWordLength - (commonSpaceLength * (candidates.size() - 1));//추가적인 나머지 공백

            for (int i = 1; i < candidates.size(); i++) {
                if (additionalSpace != 0) {//추가적인 공백이 있다면 공통 크기 공백+1
                    formatResult.append(" ".repeat(commonSpaceLength + 1)).append(candidates.get(i));
                    --additionalSpace;
                } else {//없다면 공통 크기 공백만
                    formatResult.append(" ".repeat(commonSpaceLength)).append(candidates.get(i));
                }
            }
        }

        return formatResult.toString();//문자열 반환
    }
}