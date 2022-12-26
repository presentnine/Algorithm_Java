package com.algorithm;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3, 4, 4, 5, 5};

        System.out.println(findWrongNum(array));
    }

    static String formatting(int num) {
        StringBuilder sb = new StringBuilder();
        int totalLength = 1;
        int temp = num;
        int tempLength;

        while (temp >= 10) {
            ++totalLength;
            temp = temp / 10;
        }

        tempLength = totalLength;

        while (tempLength != 0) {
            if (tempLength % 3 == 0 && tempLength != 0 && tempLength != totalLength) {
                sb.append(',');
            }
            sb.append(num / (int) Math.pow(10, tempLength - 1));
            num = num % (int) Math.pow(10, tempLength - 1);
            --tempLength;
        }

        return sb.toString();
    }

    static boolean checkPattern(String pattern, String words) {
        HashMap<Character, String> charToString = new HashMap<>();
        HashMap<String, Character> stringToChar = new HashMap<>();

        String[] tokens = words.split(" ");

        if (pattern.length() != tokens.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = tokens[i];

            if (charToString.containsKey(c)) {
                String storeWord = charToString.get(c);
                if (!storeWord.equals(word)) {
                    return false;
                }
            } else {
                if (stringToChar.containsKey(word)) {
                    return false;
                } else {
                    charToString.put(c, word);
                    stringToChar.put(word, c);
                }
            }
        }

        return true;
    }

    static int findWrongNum(int[] array) {
        int start = 0, end = array.length - 1, mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (mid % 2 == 1) {
                mid -= 1;
            }

            if (array[mid] == array[mid + 1]) {
                start = mid + 2;
            } else if (array[mid] != array[mid + 1]) {
                end = mid - 2;
            }
        }

        return array[mid];
    }
}


