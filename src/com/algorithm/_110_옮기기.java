package com.algorithm;

public class _110_옮기기 {
    public static void main(String[] args) {
        String[] s = new String[]{"1110", "100111100", "0111111010"};
        String[] s1 = new String[]{"1011110","01110","101101111010"};

        Solution_110_옮기기 solution = new Solution_110_옮기기();

        solution.solution(s1);
    }
}

class Solution_110_옮기기 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {//각 문자열들에 대해 변환 적용
            answer[i] = changeString(s[i]);
        }

        return answer;
    }

    String changeString(String string) {
        StringBuilder result = new StringBuilder();//결과용 StringBuilder
        int countOf110 = 0;//문자열 "110" 개수

        if (string.length() <= 3) {//애초에 변환이 필요 없는 길이인 경우
            return string;
        }

//        while (result.indexOf("110") != -1) {//시간 초과를 먹은 알고리즘 과정 1
//            ++countOf110;
//            result.delete(result.indexOf("110"), result.indexOf("110") + 3);
//        }

        char[] remove110 = new char[string.length()];//문자열을 순차대로 담을 char 배열
        remove110[0] = string.charAt(0);
        remove110[1] = string.charAt(1);
        
        int remove110Pos;
        remove110Pos = 1;

        for (int i = 2; i < string.length(); i++) {//스택 방식과 같은 제거 알고리즘
            if (string.charAt(i) == '0') {
                if (remove110Pos >= 1 && remove110[remove110Pos] == '1' && remove110[remove110Pos - 1] == '1') {
                    ++countOf110;
                    remove110Pos -= 2;
                    continue;
                }
            }
            remove110[++remove110Pos] = string.charAt(i);
        }

        for (int i = 0; i <= remove110Pos; i++) {//남은 문자열 생성
            result.append(remove110[i]);
        }

//        while (countOf110 != 0) { //실패한 알고리즘 3과정
//            if (result.toString().length() < 3) {
//                if (result.toString().equals("1") || result.toString().equals("11")) {
//                    result.insert(0, "110");
//                } else if (result.toString().equals("01")) {
//                    result.insert(1, "110");
//                } else {
//                    result.append("110");
//                }
//            } else {
//                int pos = result.indexOf("111");
//
//                if (pos != -1) {
//                    result.insert(pos, "110");
//                } else if (result.substring(result.length() - 2).equals("11")) {
//                    result.insert(result.length() - 2, "110");
//                } else if (result.substring(result.length() - 1).equals("1")) {
//                    result.insert(result.length() - 1, "110");
//                } else {
//                    result.append("110");
//                }
//            }
//            --countOf110;
//        }

        StringBuilder string110 = new StringBuilder();

        for (int i = 0; i < countOf110; i++) {//문자열 110을 미리 연이어 붙여 놓음
            string110.append("110");
        }

        if (result.toString().length() < 3) {//남은 문자열의 길이가 3미만
            if (result.toString().equals("1") || result.toString().equals("11")) {
                result.insert(0, string110);
            } else if (result.toString().equals("01")) {
                result.insert(1, string110);
            } else {
                result.append(string110);
            }
        } else {//남은 문자열의 길이가 3이상
            int pos = result.indexOf("111");

            if (pos != -1) {
                result.insert(pos, string110);
            } else if (result.substring(result.length() - 2).equals("11")) {
                result.insert(result.length() - 2, string110);
            } else if (result.substring(result.length() - 1).equals("1")) {
                result.insert(result.length() - 1, string110);
            } else {
                result.append(string110);
            }
        }

        return result.toString();
    }
}
