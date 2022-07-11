package com.algorithm;

//https://leetcode.com/problems/jump-game/
public class LeetCode_Jump_Game {

}

class Solution_LeetCode_Jump_Game {
    public boolean canJump(int[] nums) {
        boolean[] possible = new boolean[nums.length];//가능성 체크 배열
        possible[nums.length - 1] = true;//마지막은 true

        for (int i = nums.length - 2; i >= 0; i--) {//끝에서부터 앞으로
            int stepCount = nums[i];

            for (int j = i + 1; j <= i + stepCount && j < nums.length; j++) {//주어진 횟수만큼
                if (possible[j]) {//앞에 true가 있다면 현재도 true로 변경
                    possible[i] = true;
                    break;
                }
            }
        }

        return possible[0];//시작부분 반환
    }
}