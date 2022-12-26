package com.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오_2022_하반기_6 {
}

class Solution_카카오_2022_하반기_6 {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        HashMap<String, String> hashMap = new HashMap<>();
        Queue<Infor> q = new LinkedList<>();

        int dist = Math.abs(x - r) + Math.abs(y - c);

        if ((dist % 2 == 0 && k % 2 == 1) || (dist % 2 == 1 && k % 2 == 0)) {
            return "impossible";
        }

        q.add(new Infor(x, y, 0, ""));

        while (!q.isEmpty()) {
            Infor now = q.poll();

            if (now.r < 1 || now.r > n || now.c < 1 || now.c > m || now.moveCount > k) {
                continue;
            }

            if (Math.abs(now.r - r) + Math.abs(now.c - c) > k - now.moveCount) {
                continue;
            }

            String key = now.r + "/" + now.c + "/" + now.moveCount;
            if (hashMap.containsKey(key) && compare(hashMap.get(key), now.move)) {
                continue;
            }

            if (hashMap.containsKey(key)) {
                hashMap.replace(key, now.move);
            } else {
                hashMap.put(key, now.move);
            }

            q.add(new Infor(now.r + 1, now.c, now.moveCount + 1, now.move + "d"));
            q.add(new Infor(now.r, now.c - 1, now.moveCount + 1, now.move + "l"));
            q.add(new Infor(now.r, now.c + 1, now.moveCount + 1, now.move + "r"));
            q.add(new Infor(now.r - 1, now.c, now.moveCount + 1, now.move + "u"));
        }

        if (!hashMap.containsKey(r + "/" + c + "/" + k)) {
            return "impossible";
        } else {
            return hashMap.get(r + "/" + c + "/" + k);
        }
    }

    boolean compare(String a, String b) {
        int lessLength = Math.min(a.length(), b.length());

        for (int i = 0; i < lessLength; i++) {
            if (a.charAt(i) < b.charAt(i)) {
                return true;
            } else if (a.charAt(i) > b.charAt(i)) {
                return false;
            }
        }

        if (a.length() <= b.length()) {
            return true;
        } else {
            return false;
        }
    }

    class Infor{
        int r, c, moveCount;
        String move;

        public Infor(int r, int c, int moveCount, String move) {
            this.r = r;
            this.c = c;
            this.moveCount = moveCount;
            this.move = move;
        }
    }
}