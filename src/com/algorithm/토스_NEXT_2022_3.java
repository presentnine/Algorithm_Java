package com.algorithm;

public class 토스_NEXT_2022_3 {
    public static void main(String[] args) {
        Solution_토스_NEXT_2022_3 s = new Solution_토스_NEXT_2022_3();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        System.out.println(s.solution(k, dungeons));
    }
}
class Solution_토스_NEXT_2022_3 {
    int answer = -1;

    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        int result[] = new int[n];
        boolean visited[] = new boolean[n];

        permutation(result, visited, 0, n, n, k, dungeons);

        return answer;
    }

    void permutation(int[] result, boolean visited[], int index, int n, int r, int k, int[][] dungeons) {
        if (index == r) {
            dungeonsTour(result, k, dungeons);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[index] = i;
                permutation(result, visited, index + 1, n, r, k, dungeons);
                visited[i] = false;
            }
        }
    }

    void dungeonsTour(int[] result, int k, int[][] dungeons) {
        int index = 0, count = 0;
        while (k > 0 && index < result.length) {
            if (k >= dungeons[result[index]][0]) {
                k -= dungeons[result[index]][1];
                ++index;
                ++count;
            } else {
                break;
            }
        }

        answer = Math.max(answer, count);
    }
}
