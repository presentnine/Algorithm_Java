package com.algorithm;

import java.util.Stack;

public class 표_편집 {
    public static void main(String[] args) {
        int n =8, k=2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
//        Solution s = new Solution();
//        System.out.println("s.solution(n,k,cmd) = " + s.solution(n, k, cmd));
    }

    class Solution {
        public String solution(int n, int k, String[] cmd) {
            StringBuilder answer = new StringBuilder();
            int result[] = new int[n];
            int pos = k, lastPos = n - 1;
            Stack<Integer> s = new Stack<>();

            for (int i = 0; i < cmd.length; i++) {
                switch (cmd[i].charAt(0)) {
                    case 'D':
                        for (int j = 0; j < Integer.parseInt(cmd[i].substring(2));)
                            if (result[++pos] == 0)
                                ++j;

                        break;
                    case 'U':
                        for (int j = 0; j < Integer.parseInt(cmd[i].substring(2));)
                            if (result[--pos] == 0)
                                ++j;

                        break;
                    case 'C':
                        s.push(pos);
                        result[pos] = -1;

                        if (pos == lastPos) {
                            while (result[--pos] != 0);
                            lastPos = pos;
                        } else {
                            while (result[++pos] != 0);
                        }
                        break;
                    case 'Z':
                        int recovery = s.pop();
                        result[recovery] = 0;

                        if (lastPos < recovery)
                            lastPos = recovery;

                        break;
                }
            }

            for (int i = 0; i < n; i++) {
                if(result[i]==0)
                    answer.append('O');
                else
                    answer.append('X');
            }

            return answer.toString();
        }
    }
}

