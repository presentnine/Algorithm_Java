package com.algorithm;

//https://leetcode.com/problems/3sum/

import java.util.*;

public class LeetCode_3Sum {

}

class Solution_LeetCode_3Sum {
    List<List<Integer>> answer = new ArrayList<>();
    HashSet<String> answerHashSet = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {//시작부터 끝-2까지
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {//결과가 0이라면
                    if (!answerHashSet.contains(nums[i] + "-" + nums[j] + "-" + nums[k])) {//중복이 없다면
                        answerHashSet.add(nums[i] + "-" + nums[j] + "-" + nums[k]);
                        answer.add(List.of(nums[i], nums[j], nums[k]));
                    }
                    ++j;
                    --k;
                } else if (sum > 0) {//합이 0초과
                    --k;
                } else {//합이 0미만
                    ++j;
                }
            }
        }

        return answer;
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        combination(nums, 0, 0);
//        return answer;
//    }
//
//    void combination(int[] nums, int arrIndex, int index) {
//        if (arrIndex == 3) {
//            if (nums[arr[0]] + nums[arr[1]] + nums[arr[2]] == 0
//                    && !answerSet.contains(nums[arr[0]] + "-" + nums[arr[1]] + "-" + nums[arr[2]])) {
//                answerSet.add(nums[arr[0]] + "-" + nums[arr[1]] + "-" + nums[arr[2]]);
//
//                List<Integer> temp = new ArrayList<>();
//
//                temp.add(nums[arr[0]]);
//                temp.add(nums[arr[1]]);
//                temp.add(nums[arr[2]]);
//
//                answer.add(temp);
//            }
//
//            return;
//        }
//
//        for (int i = index; i < nums.length; i++) {
//            arr[arrIndex] = i;
//            combination(nums, arrIndex + 1, i + 1);
//        }
//    }
}
