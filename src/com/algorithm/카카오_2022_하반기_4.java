package com.algorithm;

import java.util.ArrayList;

public class 카카오_2022_하반기_4 {
    public static void main(String[] args) {
        Solution_카카오_2022_하반기_4 s = new Solution_카카오_2022_하반기_4();
        long[] numbers = {100000000000000l};
        s.solution(numbers);
    }
}

class Solution_카카오_2022_하반기_4 {
    public int[] solution(long[] numbers) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            String binary = decimalToBinary(numbers[i]);
            System.out.println(binary);

            if (check(binary)) {
                temp.add(1);
            } else {
                temp.add(0);
            }
        }

        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }

    String decimalToBinary(long number) {
        StringBuilder sb = new StringBuilder();
        long temp = number;

        while (temp != 0) {
            sb.append(temp % 2);
            temp /= 2;
        }

        int length = sb.length();
        int squared = 0;

        while (length > (int) Math.pow(2, squared) - 1) {
            ++squared;
        }

        for (int i = 0; i < ((int) Math.pow(2, squared)) - 1 - length; i++) {
            sb.append(0);
        }

        return sb.reverse().toString();
    }

    boolean check(String binary) {
        if (binary.length() == 1) {
            return true;
        }

        int subLength = binary.length() / 2;

        char leftRoot = binary.charAt(subLength / 2);
        char root = binary.charAt(subLength);
        char rightRoot = binary.charAt(subLength + subLength / 2 + 1);
        String left = binary.substring(0, subLength);
        String right = binary.substring(subLength + 1, 2 * subLength + 1);

        if (root == '1') {
            return check(left) && check(right);
        } else {
            if (leftRoot == '0' && rightRoot == '0') {
                return check(left) && check(right);
            } else {
                return false;
            }
        }
    }
}