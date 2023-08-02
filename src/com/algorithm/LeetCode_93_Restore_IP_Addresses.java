package com.algorithm;

//https://leetcode.com/problems/restore-ip-addresses/

import java.util.ArrayList;
import java.util.List;

public class LeetCode_93_Restore_IP_Addresses {
}

class Solution_LeetCode_93_Restore_IP_Addresses {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {//3*4 개의 IP 구성을 넘는 경우
            return result;
        }
        search(s, 0, new StringBuilder(), 0);
        return result;
    }

    void search(String s, int index, StringBuilder sb, int dotCount) {
        if (dotCount == 4) {//4개의 구간을 모두 구성했다면
            if (index >= s.length()) {//모든 숫자 문자열을 다 사용했다면
                result.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }

        for (int i = index; i < Math.min(s.length(), index + 3); i++) {//최대 3개 건너만큼
            String substr = s.substring(index, i + 1);
            int toNum = Integer.parseInt(substr);

            if ((!(substr.length() > 1 && substr.startsWith("0")))
                    && (0 <= toNum && toNum <= 255)) {//부분 문자열이 IP 구간 하나의 조건을 만족한다면 다음 재귀 탐색 진행
                sb.append(substr).append('.');
                search(s, i + 1, sb, dotCount + 1);
                sb.delete(sb.length() - substr.length() - 1, sb.length());
            }
        }
    }
}
