package com.algorithm;

import java.util.regex.Pattern;

public class 불량_사용자 {
    public static void main(String[] args) {
        String[] user_id = new String[]
                {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = new String[]
                {"fr*d*", "*rodo", "******", "******"};

        Solution_불량_사용자 s = new Solution_불량_사용자();

        System.out.println(s.solution(user_id, banned_id));
    }
}

class Solution_불량_사용자 {
    String[] user_id, banned_id;
    int answer = 0;

    public int solution(String[] user_id, String[] banned_id) {
        for (int i = 0; i < banned_id.length; i++) {//정규표현식에 맞게 *을 .으로 변경
            banned_id[i] = banned_id[i].replace('*', '.');
        }

        this.user_id = user_id;
        this.banned_id = banned_id;

        boolean[] visited = new boolean[user_id.length];

        combination(visited, 0, user_id.length, banned_id.length);

        return answer;
    }

    private void combination(boolean[] visited, int start, int n, int r) {//리스트 중 유저 아이디 조합 생성
        if (r == 0) {
            String[] userIds = new String[banned_id.length];

            for (int i = 0, j = 0; i < visited.length; i++) {
                if(visited[i]){
                    userIds[j++] = user_id[i];
                }
            }

            if(validate(userIds, banned_id.length))//검증 확인
                ++answer;

        } else {
            for (int i = start; i < n; i++) {
                visited[i] = true;
                combination(visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    private boolean validate(String[] userIds, int r){//주어진 조합이 banned_id에 맞는 지 확인
        int[] list = new int[r];

        for (int i = 0; i < r; i++)
            list[i] = i;

        do {//순열을 통해 모든 경우의 수 체크
            int matchCount = 0;

            for (int i = 0; i < banned_id.length; i++) {
                if (Pattern.matches(banned_id[i], userIds[list[i]]))
                    ++matchCount;
                else
                    break;
            }

            if (matchCount == r)//사용자 목록이 모두 banned_id와 매칭되면 true 반환
                return true;

        } while (next_permutation(list));

        return false;//매칭 안되는 걸로 false 반환
    }

    private boolean next_permutation(int[] list) {//다음 순서의 순열로 리스트 교체
        int i = list.length - 1;
        int j = list.length - 1;

        while (i > 0 && list[i - 1] >= list[i])
            --i;

        if (i <= 0)
            return false;

        while (list[i - 1] > list[j])
            --j;

        swap(list, i - 1, j);

        j = list.length - 1;
        for (; i < j; ++i, --j)
            swap(list, i, j);

        return true;
    }

    private void swap(int[] list, int i, int j) {//swap 함수
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}